package cn.underdog.leetcode.doublePointer;

import cn.underdog.leetcode.monotoneStack.Main;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class MainClass {


    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.reverseOnlyLetters("a-bC-dEf-ghIj");
//        System.out.println(mainClass.nextGreatestLetter(new char[]{'c', 'f', 'j', 'x', 'y', 'z'}, 'y'));
//        System.out.println(mainClass.nextGreatestLetter(new char[]{'e', 'e', 'e', 'k', 'q', 'q', 'q', 'v', 'v', 'y'}, 'q'));
//        System.out.println(mainClass.binaryGap(22));
//        mainClass.findRightInterval(new int[][]{{1, 2}});
//        mainClass.moveZeroes1(new int[]{0, 1, 0, 3, 12});


        mainClass.backspaceCompare1("xywrrmp", "xywrrmu#p");
    }


    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            // 如果左右都是字母，则直接交换
            if (Character.isLetter(leftC) && Character.isLetter(rightC)) {
                sb.setCharAt(left++, rightC);
                sb.setCharAt(right--, leftC);
            }
            // 如果左边不是字母，右边是字母
            else if (!Character.isLetter(leftC) && Character.isLetter(rightC)) {
                left++;
            } else if (Character.isLetter(leftC) && !Character.isLetter(rightC)) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return sb.toString();
    }


    /**
     * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
     * <p>
     * 在比较时，字母是依序循环出现的。举个例子：
     * <p>
     * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[0] < target && target >= letters[letters.length - 1])
            return letters[0];
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else if (letters[mid] < target) {
                left = mid;
            } else
                break;
        }
        int mid = left + (right - left + 1) / 2;
        while (letters[mid] <= target) {
            mid++;
        }
        return letters[mid];
    }

    public int binaryGap(int n) {
        String string = Integer.toBinaryString(n);
        boolean flag = false;
        int left = -1;
        int right = -1;
        int res = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!flag) {
                if (string.charAt(i) == '1') {
                    left = i;
                    right = i;
                    flag = true;
                }
            } else {
                if (string.charAt(i) == '1') {
                    left = right;
                    right = i;
                    res = Math.max(res, right - left);
                }
            }
        }
        return res;
    }


    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int length = intervals.length;
        int[] res = new int[length];
        for (int i = 0; i < intervals.length; i++) {
            // 获取有边界
            int tmp = intervals[i][1];
            Map.Entry<Integer, Integer> integerIntegerEntry = map.ceilingEntry(tmp);
            if (integerIntegerEntry != null) {
                res[i] = integerIntegerEntry.getValue();
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * <p>
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    // 双指针的方法，但是每次重复计算
    public int trap(int[] height) {
        int res = 0;
        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
            int lHeight = height[i];
            int rHeight = height[i];
            for (int j = i + 1; j < length; j++) {
                rHeight = Math.max(rHeight, height[j]);
            }
            for (int u = i - 1; u >= 0; u--) {
                lHeight = Math.max(lHeight, height[u]);
            }
            res += Math.min(lHeight, rHeight) - height[i];
        }
        return res;
    }


    /**
     *
     给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

     不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。



     说明:

     为什么返回数值是整数，但输出的答案是数组呢?

     请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

     你可以想象内部操作如下:

     // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     int len = removeElement(nums, val);

     // 在函数里修改输入数组对于调用者是可见的。
     // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     for (int i = 0; i < len; i++) {
     print(nums[i]);
     }


     示例 1：

     输入：nums = [3,2,2,3], val = 3
     输出：2, nums = [2,2]
     解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     示例 2：

     输入：nums = [0,1,2,2,3,0,4,2], val = 2
     输出：5, nums = [0,1,4,0,3]
     解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    /**
     * 快慢指针
     * 慢指针记录当前插入的位置，快指针用于查询本次是否和目标值一致
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * <p>
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     * <p>
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * <p>
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 判题标准:
     * <p>
     * 系统会用下面的代码来测试你的题解:
     * <p>
     * int[] nums = [...]; // 输入数组
     * int[] expectedNums = [...]; // 长度正确的期望答案
     * <p>
     * int k = removeDuplicates(nums); // 调用
     * <p>
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     * assert nums[i] == expectedNums[i];
     * }
     * 如果所有断言都通过，那么您的题解将被 通过。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int slow = 1;
        int preVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preVal != nums[i]) {
                preVal = nums[i];
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }
        int length = nums.length;
        for (int i = 0; i < length - slow; i++) {
            nums[length - i - 1] = 0;
        }
    }

    // 一次遍历
    public void moveZeroes1(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[slow];
                nums[slow++] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
     *
     * 注意：如果对空文本输入退格字符，文本继续为空。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "ab#c", t = "ad#c"
     * 输出：true
     * 解释：s 和 t 都会变成 "ac"。
     * 示例 2：
     *
     * 输入：s = "ab##", t = "c#d#"
     * 输出：true
     * 解释：s 和 t 都会变成 ""。
     * 示例 3：
     *
     * 输入：s = "a#c", t = "b"
     * 输出：false
     * 解释：s 会变成 "c"，但 t 仍然是 "b"。
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/backspace-string-compare
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    /**
     * 用栈的方式完成
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack1.push(s.charAt(i));
            } else {
                if (stack1.size() != 0) {
                    stack1.pop();
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                stack2.push(t.charAt(i));
            } else {
                if (stack2.size() != 0) {
                    stack2.pop();
                }
            }
        }
        return stack1.equals(stack2);
    }

    /**
     * 双指针
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare1(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipI = 0, skipJ = 0;
        while (i >= 0 || j >= 0) {
            // 计算s本次的位置
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipI++;
                    i--;
                } else if (skipI > 0) {
                    skipI--;
                    i--;
                } else {
                    break;
                }
            }
            // 计算t本次的位置
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipJ++;
                    j--;
                } else if (skipJ > 0) {
                    skipJ--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j))
                    return false;
            } else {
                // 此时必须有一个大于等于0因为如果都小于0应该返回true
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;

        }
        return true;
    }


}
