package cn.underdog.leetcode.competition;


import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class D_91 {
    public static void main(String[] args) {
        D_91 d_91 = new D_91();
//        d_91.mostProfitablePath(new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}}, 3, new int[]{-2, 4, 2, -4, 6});
//        int f = d_91.f(6, 2);
//        System.out.println(f);
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        d_91.minimumOperations(treeNode);
    }

    public int distinctAverages(int[] nums) {
        Set<Double> doubles = new HashSet<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int lnum = nums[l++];
            int rnum = nums[r--];
            doubles.add((lnum + rnum) / 2.0);
        }
        return doubles.size();
    }

    private Integer maxValue = Integer.MIN_VALUE;
    private Integer cntValue = 0;
    Set<Integer> leafs;
    Set<Integer> visited;
    boolean[] visitedA;
    boolean[] visitedB;
    int[] amount;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        this.amount = amount;
        visitedA = new boolean[n];
        visitedB = new boolean[n];
        cntValue = amount[0];

        List<Integer>[] graphs = new List[n];
        Arrays.setAll(graphs, e -> new ArrayList<>());
        leafs = new HashSet<>();
        for (int[] edge : edges) {
            graphs[edge[0]].add(edge[1]);
            graphs[edge[1]].add(edge[0]);
        }
        for (int i = 1; i < n; i++) {
            int size = graphs[i].size();
            if (size <= 1)
                leafs.add(i);
        }
        visited = new HashSet<>();
        visited.add(0);
        visited.add(bob);
        dfs(graphs, 0, bob, 0);
        return maxValue;
    }

    private void dfs(List<Integer>[] graphs, int alice, int bob, int flag) {
        if (flag == 0) {
            visitedA[alice] = true;
            for (Integer integer : graphs[alice]) {
                if (!visitedA[integer]) {
                    dfs(graphs, integer, bob, 1);
                }
            }
        } else if (flag == 1) {
            if (bob != 0) {
                visitedB[bob] = true;
                for (Integer integer : graphs[bob]) {
                    if (!visitedB[integer]) {
                        dfs(graphs, alice, integer, 2);
                    }
                }
            } else {
                if (!visited.contains(alice)) {

                }
            }
        } else {
            if (alice == bob) {
                if (!visited.contains(alice)) {
                    visited.add(alice);
                    cntValue += amount[alice] / 2;
                }
            } else {
                visited.add(bob);
                if (!visited.contains(alice)) {
                    visited.add(alice);
                    cntValue += amount[alice];
                }
            }
            dfs(graphs, alice, bob, 0);
            if (leafs.contains(alice)) {
                maxValue = Math.max(cntValue, maxValue);

            }
            visited.remove(alice);
            if (alice == bob) {
                cntValue -= amount[alice] / 2;
            } else {
                cntValue -= amount[alice];
            }


        }
    }


    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32.00};
    }

    public int subarrayLCM(int[] nums, int k) {

        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int g = 1;
            for (int j = i; j < n; j++) {
                g = f(g, nums[j]);
                if (g == k) res++;
            }
        }

        return res;

    }

    public int f(int a, int b) {
        int c = a % b;
        int d = a * b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return d / b;
    }


    public int minimumOperations(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);
        int res = 0;
        int size = lists.size();
        for (int i = 1; i < size; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = lists.get(i);
            for (int k = 0; k < list.size(); k++) {
                map.put(list.get(k), k);
            }
            List<Integer> tmp = new ArrayList<>(list);
            Collections.sort(tmp);
            int cntN = tmp.size();
            for (int j = 0; j < cntN; j++) {
                int num1 = list.get(j);
                int num2 = tmp.get(j);
                if (num1 != num2) {
                    res++;
                    Integer num2Index = map.get(num2);
                    map.put(num1, num2Index);
                    list.set(num2Index, num1);
                }
            }

        }

        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode p = root;
        TreeNode currentTail = root;
        TreeNode nextTail = root;
        if (p.left != null) nextTail = p.left;
        if (p.right != null) nextTail = p.right;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        List<Integer> integers = new ArrayList<>();
        while (!queue.isEmpty() || p != null) {
            p = queue.poll();
            if (p.left != null) {
                queue.add(p.left);
                nextTail = p.left;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextTail = p.right;
            }
            if (p == currentTail) {
                integers.add(p.val);
                currentTail = nextTail;
                res.add(new ArrayList<>(integers));
                integers.clear();
            } else {
                integers.add(p.val);
            }
            p = null;
        }
        return res;
    }


}
