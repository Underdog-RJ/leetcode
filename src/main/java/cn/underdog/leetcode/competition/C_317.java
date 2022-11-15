package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class C_317 {


    public static void main(String[] args) {
        C_317 c_317 = new C_317();

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(3);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(4);
        TreeNode t9 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        c_317.treeQueries(t1, new int[]{3, 2, 4, 8});
    }


    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if ((num & 1) == 0 && num % 3 == 0) {
                count++;
                sum += num;
            }
        }

        return count == 0 ? 0 : (int) Math.floor((double) sum / count);
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, List<String[]>> map = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            long view = views[i];
            String[] t = new String[2];
            t[0] = id;
            t[1] = String.valueOf(view);
            List<String[]> orDefault = map.getOrDefault(creator, new ArrayList<>());
            orDefault.add(t);
            map.put(creator, orDefault);
        }
        List<List<String>> list = new ArrayList<>();
        long max = -1;
        for (Map.Entry<String, List<String[]>> entry : map.entrySet()) {
            List<String[]> value = entry.getValue();
            long count = 0;
            String cntMaxId = "";
            long cntMax = -1;
            for (String[] strings : value) {
                String cntK = strings[0];
                long cntV = Long.parseLong(strings[1]);
                if (cntMax < cntV) {
                    cntMax = cntV;
                    cntMaxId = cntK;
                } else if (cntV == cntMax) {
                    cntMaxId = cntK.compareTo(cntMaxId) > 0 ? cntMaxId : cntK;
                }
                count += cntV;
            }
            if (count > max) {
                max = count;
                list.clear();
                List<String> t = new ArrayList<>();
                t.add(entry.getKey());
                t.add(cntMaxId);
                list.add(t);
            } else if (count == max) {
                List<String> t = new ArrayList<>();
                t.add(entry.getKey());
                t.add(cntMaxId);
                list.add(t);
            }
        }
        return list;
    }

//    public long makeIntegerBeautiful(long n, int target) {
//        long l = 0;
//        long r = n;
//        while (l <= r) {
//            long mid = l + r >> 1;
//            long tmp = mid + n;
//            int cntNum = calcInt(tmp);
//            if (cntNum >= target) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        System.out.println(l);
//        return l;
//    }

    public long makeIntegerBeautiful(long n, int target) {
        long tail = 1;
        while (true) {
            long jinwei = (tail - n % tail) % tail;
            long m = n + jinwei;
            long x = n + jinwei;
            long s = 0;
            while (x > 0) {
                s += x % 10;
                x /= 10;
            }
            if (s <= target) {
                return m - n;
            }
            tail *= 10;
        }
    }


    private Map<TreeNode, Integer> height = new HashMap<>();
    private int[] res = null;

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        height.put(null, 0);
        get_height(root);
        res = new int[height.size() + 1];
        dfs(root, -1, 0);
        for (int i = 0; i < queries.length; i++) {
            queries[i] = res[queries[i]];
        }
        return queries;

    }

    private void dfs(TreeNode root, int depth, int rest_h) {
        if (root == null) return;
        depth += 1;
        res[root.val] = rest_h;
        dfs(root.left, depth, Math.max(rest_h, depth + height.get(root.right)));
        dfs(root.right, depth, Math.max(rest_h, depth + height.get(root.left)));
    }

    private int get_height(TreeNode root) {
        if (root == null) return 0;
        int t = 1 + Math.max(get_height(root.left), get_height(root.right));
        height.put(root, t);
        return height.get(root);
    }


}
