package cn.underdog.MainClass;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Problem54 {
    public static void main(String[] args) {

        topKFrequentHeap(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
//        topKFrequent(new int[]{1},1);
//        topKFrequent(new int[]{-1,-1},1);
    }


    /**
     * 1.先排序
     * 2.用 TreeMap 记录次数和出现次数的数字的集合(treeMap倒叙)
     * 3.在Map 中查找到前k个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        TreeMap<Integer, List<Integer>> maps = new TreeMap<>(Comparator.reverseOrder());
        int last = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (last != nums[i]) {
                if (maps.containsKey(count)) {
                    List<Integer> list = maps.get(count);
                    list.add(nums[i - 1]);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(last);
                    maps.put(count, list);
                }
                last = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (maps.containsKey(count)) {
            List<Integer> list = maps.get(count);
            list.add(last);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(last);
            maps.put(count, list);
        }

        int[] ans = new int[k];
        int index = 0;
        int sum = 0;
        Set<Map.Entry<Integer, List<Integer>>> entries = maps.entrySet();
        OUT:
        for (; sum <= k; ) {
            for (Map.Entry<Integer, List<Integer>> entry : entries) {
                for (Integer integer : entry.getValue()) {
                    ans[index++] = integer;
                    sum++;
                    if (sum == k) {
                        break OUT;
                    }
                }
            }
        }
        return ans;
    }


    public static int[] topKFrequentHeap(int[] nums, int k) {

        HashMap<Integer, Integer> occurrences = new HashMap<>();
        // 遍历nums 用hashtable统计出现的次数
        for (int num : nums)
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);

        // 创建一个正序的队列，求前k个出现次数最多的元素===》》》小根堆；
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 遍历map建立小根堆
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            // 如果当前队列中的元素 == k
            if (queue.size() == k) {
                // 判断对头元素的count小于当前的count时更新为当前的值
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }


}
