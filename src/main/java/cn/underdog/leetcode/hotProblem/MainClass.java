package cn.underdog.leetcode.hotProblem;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
//        mainClass.decodeString("3[a]2[bc]");
//        mainClass.decodeString("3[a2[ca]]");
//        mainClass.decodeString("abc3[cd]xyz");
//        mainClass.decodeString("100[leetcode]");

//        mainClass.generateParenthesis(5);
//        mainClass.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        mainClass.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
//        System.out.println(mainClass.findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
//        System.out.println(mainClass.findUnsortedSubarray2(new int[]{1, 3, 2, 2, 2}));
//        System.out.println(mainClass.findUnsortedSubarray1(new int[]{1, 3, 2, 3, 3}));
//        System.out.println(mainClass.findUnsortedSubarray1(new int[]{5, 4, 3, 2, 1}));
//        System.out.println(mainClass.findUnsortedSubarray1(new int[]{1, 2, 3, 4}));
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     * <p>
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     * <p>
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    /**
     * 当key需要是字母和出现地次数时，可以添加转化为char数组进行排序处理
     * 用hash统计次数
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int index = 0;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strTemp = new String(chars);
            List<String> orDefault = map.getOrDefault(strTemp, new ArrayList<>());
            orDefault.add(strs[index++]);
            map.put(strTemp, orDefault);
        }
       /* List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            List<String> tmp = new ArrayList<>();
            for (Integer integer : value) {
                tmp.add(strs[integer]);
            }
            res.add(tmp);
        }*/
        return new ArrayList<List<String>>(map.values());
    }


    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * <p>
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * <p>
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 30
     * s 由小写英文字母、数字和方括号 '[]' 组成
     * s 保证是一个 有效 的输入。
     * s 中所有整数的取值范围为 [1, 300] 
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/decode-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack();
        // 用count统计，[的数量，数量为0时，
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
                if (s.charAt(i) == '[') {
                    count++;
                }
                // 当数量为0且为字母时，直接添加到结果集
                if (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9 && count == 0) {
                    sb.append(s.charAt(i));
                    stack.pop();
                }
            } else {
                StringBuilder tmp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    tmp.append(stack.pop());
                }
                // 此时一定为[,弹出，并且-1
                stack.pop();
                count--;
                StringBuilder sbNumber = new StringBuilder();
                while (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek - '0' >= 0 && peek - '0' <= 9) {
                        sbNumber.append(stack.pop());
                    } else {
                        break;
                    }
                }
                // 获取本次[ 前面的数字
                int num = Integer.parseInt(sbNumber.reverse().toString());
                // 本次的字符串
                String str = tmp.reverse().toString();
                // 如果此时为0，直接拼接结果集
                if (count == 0) {
                    for (int j = 0; j < num; j++) {
                        sb.append(str);
                    }
                }
                // 如果大于0，说明前面还有数字和[的组合，将本次结果添加到栈中
                else {
                    StringBuilder sbTemp = new StringBuilder();
                    for (int j = 0; j < num; j++) {
                        sbTemp.append(str);
                    }
                    for (int j = 0; j < sbTemp.length(); j++) {
                        stack.add(sbTemp.charAt(j));
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrackingGenerate(list, sb, 0, 0, n);

        return list;
    }

    private void backtrackingGenerate(List<String> list, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrackingGenerate(list, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrackingGenerate(list, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * 输出：true
     * 示例 3：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * 输出：false
     *  
     * <p>
     * 提示：
     * <p>
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @param word
     * @return
     */
    // TODO 参考答案，不是自己做的
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = dfsExist(board, word, i, j, visited, 0);
                if (flag)
                    return true;
            }
        }
        return false;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean dfsExist(char[][] board, String word, int i, int j, boolean[][] visited, int k) {
        if (board[i][j] != word.charAt(k))
            return false;
        else if (k == word.length() - 1)
            return true;
        visited[i][j] = true;
        boolean flag = false;
        for (int[] ints : dir) {
            // 本次的方向
            int newI = i + ints[0], newJ = j + ints[1];
            // 判断是否越界
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                if (!visited[newI][newJ]) {
                    boolean childFlag = dfsExist(board, word, newI, newJ, visited, k + 1);
                    if (childFlag) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return flag;
    }


    /**
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/shortest-unsorted-continuous-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    /**
     * 本题添加了排序，时间复杂度为O(nlog(n))
     * 找到左右两端第一个不满足的值
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] sortArray = new int[nums.length];
        System.arraycopy(nums, 0, sortArray, 0, nums.length);
        Arrays.sort(sortArray);
        int left = 0;
        int right = sortArray.length - 1;
        int leftIndex = -1;
        int rightIndex = -1;
        while (left <= right) {
            if (leftIndex != -1 && rightIndex != -1)
                break;
            if (leftIndex == -1) {
                if (nums[left] != sortArray[left]) {
                    leftIndex = left;
                } else {
                    left++;
                }
            }
            if (rightIndex == -1) {
                if (nums[right] != sortArray[right]) {
                    rightIndex = right;
                } else {
                    right--;
                }
            }
        }
        if (rightIndex > leftIndex) {
            return rightIndex - leftIndex + 1;
        } else {
            return 0;
        }
    }

    /**
     * 从左到右升序，找到第一个不满足的数字的下标
     * 从右到左降序，找到第一个不满足的数字的下标
     * 在下标范围内找到最小最大值，判断最小值在左边插入的位置（寻找右边界） 判断最大值在右边插入的位置（寻找左边界）
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int left = 0;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1])
            left++;
        if (left == nums.length - 1)
            return 0;
        int right = nums.length - 1;
        while (nums[right] >= nums[right - 1])
            right--;
        int leftMin = nums[left];
        int rightMax = nums[right];
        for (int i = left; i <= right; i++) {
            leftMin = Math.min(leftMin, nums[i]);
            rightMax = Math.max(rightMax, nums[i]);
        }
        // 寻找右边界
        int lbound = 0;
        while (lbound <= left) {
            int mid = (lbound + left) / 2;
            if (nums[mid] > leftMin) {
                left = mid - 1;
            } else if (nums[mid] <= leftMin) {
                lbound = mid + 1;
            }
        }
        // 寻找左边界
        int rbound = nums.length - 1;
        while (right <= rbound) {
            int mid = (rbound + right) / 2;
            if (nums[mid] >= rightMax) {
                rbound = mid - 1;
            } else if (nums[mid] < rightMax) {
                right = mid + 1;
            }
        }
        return rbound - lbound + 1;
    }

    /**
     * 单调栈
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        // 从左到右，寻找插入的最小值的位置
        // 单调栈内存储的是下标
        int left = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        int right = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }

    // TODO 不熟练
    public int findUnsortedSubarray3(int[] nums) {
        int min = Integer.MAX_VALUE, left = -1;
        int max = Integer.MIN_VALUE, right = -1;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (min >= nums[length - i - 1]) {
                min = nums[length - i - 1];
            } else {
                left = length - i - 1;
            }
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }


}
