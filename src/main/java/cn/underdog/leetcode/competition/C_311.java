package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class C_311 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(11);
        TreeNode treeNode2 = new TreeNode(13);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        C_311 c_311 = new C_311();
//        c_311.reverseOddLevels(treeNode);
        c_311.sumPrefixScores1(new String[]{"abc", "ab", "bc", "b"});
    }


    public int smallestEvenMultiple(int n) {
        if (n == 1 || n == 2) return 2;
        if (n % 2 == 0) return n;
        int gcd = gcd(2, n);
        return gcd * n;
    }

    public int gcd(int a, int b) {
        return (b == 0 ? a : gcd(b, a % b));
    }


    public int longestContinuousSubstring(String s) {
        int cnt = 1;
        int pre = s.charAt(0) - 'a';
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            int cntK = s.charAt(i) - 'a';
            if (cntK == pre + 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            max = Math.max(max, cnt);
            pre = cntK;
        }
        return max;
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<TreeNode> lists = new ArrayList<>();
        // 从上到下遍历二叉树的每一层
        int count = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                list.add(cur);
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            if ((count & 1) == 1) {
                Collections.reverse(list);
            }
            lists.addAll(list);
            count++;
        }
        int[] arr = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            arr[i] = lists.get(i).val;
        }
        TreeNode tree = createTree(0, arr);
        return tree;

    }

    public TreeNode createTree(int index, int[] arr) {
        if (index >= arr.length) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = arr[index];
        root.left = createTree(index * 2 + 1, arr);
        root.right = createTree(index * 2 + 2, arr);
        return root;
    }


    public int[] sumPrefixScores(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String cntK = word.substring(0, i + 1);
                map.put(cntK, map.getOrDefault(cntK, 0) + 1);
            }
        }
        int n = words.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                String cntK = words[i].substring(0, j + 1);
                count += map.get(cntK);
            }
            res[i] = count;
        }
        return res;
    }

    public int[] sumPrefixScores1(String[] words) {
        int n = words.length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int integer = trie.searchPrefixCount(words[i]);
            res[i] = integer;
        }
        return res;
    }
}
