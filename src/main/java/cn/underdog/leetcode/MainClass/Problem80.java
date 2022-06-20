package cn.underdog.leetcode.MainClass;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem80 {
    public static void main(String[] args) {
//        System.out.println(integerReplacement(Integer.MAX_VALUE));
        System.out.println(integerReplacement(7));
    }

    // 递归
    /*public static int integerReplacement(int n) {
        return extracted(n, 0);
    }*/
    // 贪心
    public static int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                count++;
                n /= 2;
            } else if (n % 4 == 1) {
                count += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    count += 2;
                    n = 1;
                } else {
                    count += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return count;
    }

    // 记忆化搜索
    static Map<Integer, Integer> memo = new HashMap<>();

    /*public static int integerReplacement(int n) {
        if (n == 1)
            return 0;
        // 如果当前map不包含
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                int n1 = integerReplacement(n / 2);
                int n2 = integerReplacement(n / 2 + 1);
                memo.put(n, 2 + Math.min(n1, n2));
            }
        }
        return memo.get(n);
    }*/

    private static int extracted(long n, int count) {
        // 递归出口，如果n==1时，返回次数
        if (n == 1)
            return count;
        else if (n % 2 == 0) {
            // 如果时偶数，则count++且返回 n/2;
            count++;
            return extracted(n / 2, count);
        } else {
            // 如果是奇数，则进行枚举:n+1,n-1，返回两者中小的一个。
            count++;
            return Math.min(extracted(n + 1, count), extracted(n - 1, count));
        }
    }
}
