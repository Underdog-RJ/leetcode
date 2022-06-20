package cn.underdog.leetcode.MainClass;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 * <p>
 * 输入：s = "fviefuro"
 * 输出："45"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem88 {
    public static void main(String[] args) {
//        System.out.println(originalDigits("zero"));
//        System.out.println(originalDigits("owoztneoer"));
//        System.out.println(originalDigits("fviefurofviefuro"));
        System.out.println(originalDigits("egith"));
    }

    public static String originalDigits(String s) {
        int[] nums = new int[10];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'z': {
                    nums[0]++;
                    break;
                }
                case 'o': {
                    nums[1]++;
                    break;
                }
                case 'w': {
                    nums[2]++;
                    break;
                }
                case 'h': {
                    nums[3]++;
                    break;
                }
                case 'u': {
                    nums[4]++;
                    break;
                }
                case 'f': {
                    nums[5]++;
                    break;
                }
                case 'x': {
                    nums[6]++;
                    break;
                }
                case 's': {
                    nums[7]++;
                    break;
                }
                case 'g': {
                    nums[8]++;
                    break;
                }
                case 'i': {
                    nums[9]++;
                    break;
                }
            }
        }
        nums[1] -= nums[0] + nums[2] + nums[4];
        nums[5] -= nums[4];
        nums[7] -= nums[6];
        nums[9] -= nums[5] + nums[6] + nums[8];
        nums[3] -= nums[8];
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != 0) {
                res+=i;
                nums[i]--;
            }
        }

        return res;
    }

}
