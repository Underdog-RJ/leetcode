package cn.underdog.leetcode.competition;

import java.util.*;

public class D_90 {

    public static void main(String[] args) {
        D_90 d_90 = new D_90();
//        d_90.twoEditWords(new String[]{"word", "note", "ants", "wood"}, new String[]{"wood", "joke", "moat"});
//        int count = 0;
//        int t = 1000000000;
//        while (t > 1) {
//            t /= 2;
//            count++;
//        }
//        System.out.println(count);
//        d_90.destroyTargets(new int[]{304415643, 213512562, 667776528, 854523075, 291102158}, 4);
//        d_90.destroyTargets(new int[]{3,7,8,1,1,5}, 2);
        d_90.destroyTargets(new int[]{1, 3, 5, 2, 4, 6}, 2);
    }


    public String oddString(String[] words) {
        String res = "";
        HashMap<String, List<Integer>> map = new HashMap<>();
        int index = 0;
        for (String word : words) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < word.length() - 1; i++) {
                int n = word.charAt(i + 1) - word.charAt(i) - 'a';
                tmp.append(n + "-");
            }
            String cntK = tmp.toString();
            List<Integer> orDefault = map.getOrDefault(cntK, new ArrayList<>());
            orDefault.add(index++);
            map.put(cntK, orDefault);
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                return words[entry.getValue().get(0)];
            }
        }

        return res;
    }


    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        int n = queries[0].length();
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            boolean flag = false;
            for (String s : dictionary) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (query.charAt(j) != s.charAt(j)) {
                        count++;
                    }
                    if (count > 2) {
                        break;
                    }
                }
                if (count <= 2) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                res.add(query);
            }
        }
        return res;
    }


//    public int destroyTargets(int[] nums, int space) {
//        int max = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            max = Math.max(max, num);
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        int res = nums[0];
//        int maxCount = Integer.MIN_VALUE;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            int cntCount = 0;
//            int cnt = 0;
//            while ((key + cnt * space) < max) {
//                int tmp = key + cnt * space;
//                Integer orDefault = map.getOrDefault(tmp, 0);
//                cntCount += orDefault;
//                cnt++;
//            }
//            System.out.println(cnt);
//            if (maxCount < cntCount) {
//                maxCount = cntCount;
//                res = entry.getKey();
//            } else if (maxCount == cntCount) {
//                res = Math.min(res, entry.getKey());
//            }
//        }
//        return res;
//    }


    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int num : nums) {
            int tmp = num % space;
            Map<Integer, Integer> orDefault1 = map.getOrDefault(tmp, new HashMap<>());
            Integer orDefault2 = orDefault1.getOrDefault(num, 0);
            orDefault1.put(num, orDefault2 + 1);
            map.put(tmp, orDefault1);
        }
        TreeMap<Integer, TreeSet<Integer>> t = new TreeMap<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
            Map<Integer, Integer> value = entry.getValue();
            int count = 0;
            TreeSet<Integer> set = new TreeSet<>();
            for (Map.Entry<Integer, Integer> m : value.entrySet()) {
                count += m.getValue();
                set.add(m.getKey());
            }
            TreeSet<Integer> orDefault = t.getOrDefault(count, new TreeSet<>());
            orDefault.addAll(set);
            t.put(count, orDefault);
        }
        return t.lastEntry().getValue().pollFirst();
    }


    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> s = new ArrayDeque<>();
        Deque<Integer> t = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!t.isEmpty() && nums[t.peekLast()] < x) {
                ans[t.pollLast()] = x;
            }
            List<Integer> tmp = new ArrayList<>();
            while (!s.isEmpty() && nums[s.peekLast()] < x) {
                tmp.add(s.pollLast());
            }
            if (tmp.size() != 0) {
                Collections.reverse(tmp);
                t.addAll(tmp);
            }
            s.addLast(i);
        }
        return ans;
    }

}
