package cn.underdog.leetcode.competition;

import java.util.*;

public class C_296 {

    public static void main(String[] args) {
        C_296 c_296 = new C_296();
//        c_296.arrayChange(new int[]{1000000}, new int[][]{{1000000, 999999}, {999999, 999998}, {999998, 999997}, {999997, 999990}});
  /*      TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        textEditor.deleteText(4); // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        textEditor.cursorRight(3); // 返回 "etpractice"
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        textEditor.cursorLeft(8); // 返回 "leet"
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        textEditor.deleteText(10); // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        textEditor.cursorLeft(2); // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        textEditor.cursorRight(6); // 返回 "practi"
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
        ["TextEditor","addText","deleteText","addText","cursorLeft","addText","deleteText","addText","cursorLeft","deleteText"]
[[],["arnvmumatgmyw"],[5],["zrlufuifuy"],[2],["unh"],[20],["kwwp"],[6],[9]]
        */
        TextEditor textEditor = new TextEditor();
        textEditor.addText("arnvmumatgmyw");
        textEditor.deleteText(5);
        textEditor.addText("zrlufuifuy");
        textEditor.cursorLeft(2);
        textEditor.addText("unh");
        textEditor.deleteText(20);
        textEditor.addText("kwwp");
        textEditor.cursorLeft(6);
        textEditor.deleteText(9);


    }

 /*   public int minMaxGame(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        while (list.size() != 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < list.size(); i += 2) {
                if (((i - 1) & 1) == 0) {
                    tmp.add(Math.min(nums[i - 1], nums[i]));
                } else {
                    tmp.add(Math.max())
                }
            }
        }
    }*/

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if (max - min > k) {
                count++;
                min = nums[i];
                max = nums[i];
            }
        }
        return count;
    }


    /**
     * TODO 复习
     *
     * @param nums
     * @param operations
     * @return
     */
    public int[] arrayChange1(int[] nums, int[][] operations) {
        LinkedHashMap<Integer, Integer> numsMap = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int[] operation : operations) {
            map.put(operation[0], operation[1]);
        }
        // 逻辑错误，此时可能map中已经不存在值了，但是并没有队Mao进行删除操作，所以说可能导致错误的情况
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer integer = entry.getKey();
            Integer value = entry.getValue();
            if (numsMap.containsKey(integer)) {
                Integer index = numsMap.get(integer);
                nums[index] = value;
                numsMap.put(value, index);
                numsMap.remove(integer);
            }
        }
        return nums;
    }


    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int cntKey = operation[0];
            int cntValue = operation[1];
            if (map.containsKey(cntKey)) {
                Integer index = map.get(cntKey);
                nums[index] = cntValue;
                map.put(cntValue, index);
            }
        }
        return nums;

    }


}
