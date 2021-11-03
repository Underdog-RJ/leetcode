package cn.underdog.MainClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：16
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：24
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：46
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem68 {


    public static void main(String[] args) {
        boolean b = reorderedPowerOf2(46);
        System.out.println(b);

    }


    public static boolean reorderedPowerOf2(int n) {
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (int i = 0; i < 34; i++) {
            String temp = (long) Math.pow(2, i) + "";
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < temp.length(); j++) {
                map.put(temp.charAt(j), map.getOrDefault(temp.charAt(j), 0) + 1);
            }
            list.add(map);
        }
        Map<Character, Integer> res = new HashMap<>();
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); i++) {
            res.put(nStr.charAt(i), res.getOrDefault(nStr.charAt(i), 0) + 1);
        }

        for (Map<Character, Integer> map : list) {
            if (map.equals(res)) {
                return true;
            }
        }
        return false;
    }
}
