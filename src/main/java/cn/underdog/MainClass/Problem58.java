package cn.underdog.MainClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Problem58 {
    public static void main(String[] args) {
        int i = countMaxOrSubsets(new int[]{41, 32, 22, 72, 80, 83, 84, 46, 27, 48, 17, 34, 90, 28, 47, 80});
    }

    public static int countMaxOrSubsets(int[] nums) {
        if(nums.length==1)
            return 1;
        List<Integer> list= new ArrayList<>();
        List<Integer> ans =new ArrayList<>();
        for (int num : nums) {
            list.add(num);
            ans.add(num);
        }
        List<List<Integer>> subsets = subsets(list);
        for (List<Integer> subset : subsets) {
            if(subset.size()>=2){
                int count = subset.get(0);
                for (int i = 1; i < subset.size(); i++) {
                    count = count | subset.get(i);
                }
                ans.add(count);
            }
        }
        int count = 1;
        int last = ans.get(ans.size()-1);
        Collections.sort(ans);
        for (int i = ans.size()-2; i >=0; i--) {
            if(ans.get(i)==last){
                count++;
            }else {
                break;
            }
        }
        return count;
    }


        // TODO 未完成
        public static List<List<Integer>> subsets(List<Integer> nums) {
        if (nums.size() == 0) return Arrays.asList(new ArrayList[]{new ArrayList<Integer>()});
        Integer currentNums = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        List<List<Integer>> res = subsets(nums);
        List<List<Integer>> res2 = new ArrayList<>();
        for (List<Integer> re : res) {
            List<Integer> r = new ArrayList<>();
            if (re.size() != 0) {
                for (Integer integer : re) {
                    r.add(integer);
                }
            }
            res2.add(r);
        }
        int size = res.size();
        for (int i = 0; i < size; i++) {
            List<Integer> integers = res.get(i);
            integers.add(currentNums);
            res2.add(integers);
        }
        return res2;
    }

}
