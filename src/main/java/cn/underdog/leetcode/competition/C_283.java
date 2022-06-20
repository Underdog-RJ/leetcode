package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/320:33
 */
public class C_283 {

    public static void main(String[] args) {
        C_283 c_283 = new C_283();
//        c_283.minimalKSum_1(new int[]{1, 4, 25, 10, 25}, 2);
//        c_283.minimalKSum_1(new int[]{5, 6}, 6);
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(20);
        TreeNode treeNode2 = new TreeNode(80);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(17);
        TreeNode treeNode5 = new TreeNode(19);


//        c_283.createBinaryTree_1(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
        c_283.createBinaryTree_1(new int[][]{{1, 2, 1}, {2, 3, 0}, {3, 4, 1}});
    }

    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        String[] alp = new String[26];
        for (int i = 0; i < alp.length; i++) {
            int temp = 65 + i;
            char c = (char) temp;
            alp[i] = c + "";
        }
        char col1 = s.charAt(0);
        Integer row1 = s.charAt(1) - '0';
        char col2 = s.charAt(3);
        Integer row2 = s.charAt(4) - '0';
        int start = col1 - 65;
        int end = col2 - 65;

        for (int i = start; i <= end; i++) {
            for (int j = row1; j <= row2; j++) {
                list.add(alp[i] + j);
            }
        }

        return list;
    }

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0, start = 1;
        for (int i = 0; i < nums.length && k > 0; i++) {
            // 如果数组的最小值大于最开始的值
            if (nums[i] > start) {
                // 计算步长
                int cnt = (int) (nums[i] - start) > k ? k : (int) (nums[i] - start);
                // 高斯加法(首相+末项)*项数/2
                res += (2L * start + cnt - 1) * cnt / 2;
                // 减去步长
                k -= cnt;
            }
            start = nums[i] + 1;
        }
        // 如果此时还大于0
        if (k > 0) {
            res += (2L * start + k - 1) * k / 2;
        }
        return res;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        // 查找根节点
        Set<Integer> setParent = new HashSet<>();
        Set<Integer> setChild = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            setParent.add(descriptions[i][0]);
            setChild.add(descriptions[i][1]);
        }
        setParent.removeAll(setChild);
        Integer next = setParent.iterator().next();
        TreeNode root = new TreeNode(next);
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(next, root);
        for (int[] description : descriptions) {
            int direction = description[2];
            int cntParentValue = description[0];
            int cntChildValue = description[1];
            // 如果两个都不包含
            if (!map.containsKey(cntChildValue) && !map.containsKey(cntParentValue)) {
                TreeNode cntParent = new TreeNode(cntParentValue);
                TreeNode cntChild = new TreeNode(description[1]);
                if (direction == 1) {
                    cntParent.left = cntChild;
                } else {
                    cntParent.right = cntChild;
                }
                map.put(cntParentValue, cntParent);
                map.put(cntChildValue, cntChild);
            }
            // 如果包含父节点不包子节点
            else if (!map.containsKey(cntChildValue) && map.containsKey(cntParentValue)) {
                TreeNode treeNode = map.get(cntParentValue);
                TreeNode child = new TreeNode(description[1]);
                if (direction == 1) {
                    treeNode.left = child;
                } else {
                    treeNode.right = child;
                }
                map.put(cntChildValue, child);
            }

            // 如果不包含父节点包子节点
            else if (map.containsKey(cntChildValue) && !map.containsKey(cntParentValue)) {
                TreeNode cntParent = new TreeNode(cntParentValue);
                if (direction == 1) {
                    cntParent.left = map.get(cntChildValue);
                } else {
                    cntParent.right = map.get(cntChildValue);
                }
                map.put(cntParentValue, cntParent);
            } else {
                TreeNode cntParent = map.get(cntParentValue);
                TreeNode cntChild = map.get(cntChildValue);
                if (direction == 1) {
                    cntParent.left = cntChild;
                } else {
                    cntParent.right = cntChild;
                }
            }
        }
        return root;

    }


    public long minimalKSum_1(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        int length = nums.length;
        int start = 1;
        for (int i = 0; i < length && k > 0; i++) {
            if (nums[i] > start) {
                // 计算步长
                int tmp = nums[i] - start;
                if (tmp > k) {
                    tmp = k;
                }
                res += (2L * start + tmp - 1) * tmp / 2;
                k -= tmp;
            }
            start = nums[i] + 1;
        }
        if (k > 0) {
            res += (2L * start + k - 1) * k / 2;
        }
        return res;
    }


    /**
     * 深度优先遍历
     * 用map存储每个节点的拓扑关系，key为父节点的值，value为孩子的拓扑关系
     * 求出根节点，根节点只可能在数组中第一个位置出现，求第一个和第二个位置的差集为根节点
     * 用existMap存储已经遍历过的节点，key为父节点，value为树结构
     *
     * @param descriptions
     * @return
     */
    public TreeNode createBinaryTree_1(int[][] descriptions) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        HashMap<Integer, TreeNode> existMap = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int[] description : descriptions) {
            int root = description[0];
            List<int[]> orDefault = map.getOrDefault(root, new ArrayList<>());
            orDefault.add(description);
            map.put(root, orDefault);
            set1.add(description[0]);
            set2.add(description[1]);
        }
        // 求根节点
        set1.removeAll(set2);
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (!existMap.containsKey(key)) {
                TreeNode root = new TreeNode(key);
                dfsCreateBinaryTree(map, existMap, key, root);
            }
        }
        Integer rootValue = set1.iterator().next();
        return existMap.get(rootValue);
    }

    private TreeNode dfsCreateBinaryTree(HashMap<Integer, List<int[]>> map, HashMap<Integer, TreeNode> existMap, Integer integer, TreeNode root) {
        if (existMap.containsKey(integer))
            return existMap.get(integer);
        List<int[]> list = map.get(integer);
        for (int[] ints : list) {
            int anInt = ints[1];
            int direction = ints[2];
            TreeNode tmp = new TreeNode(anInt);
            if (!map.containsKey(anInt)) {
                if (direction == 1) {
                    root.left = tmp;
                } else {
                    root.right = tmp;
                }
            } else {
                TreeNode treeNode = dfsCreateBinaryTree(map, existMap, anInt, tmp);
                if (direction == 1) {
                    root.left = treeNode;
                } else {
                    root.right = treeNode;
                }
            }
        }
        existMap.put(integer, root);
        return existMap.get(integer);
    }

    /**
     * 广度优先遍历
     *
     * @param descriptions
     * @return
     */
    public TreeNode createBinaryTree_2(int[][] descriptions) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int[] description : descriptions) {
            set1.add(description[0]);
            set2.add(description[1]);
        }
        set1.removeAll(set2);
        Integer rootValue = set1.iterator().next();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        map.put(rootValue, new TreeNode(rootValue));
        for (int[] description : descriptions) {
            int cntParentValue = description[0];
            int cntChildValue = description[1];
            int direction = description[2];

            // 分四种情况讨论
            // 第一种，不包含父亲和孩子
            if (!map.containsKey(cntChildValue) && !map.containsKey(cntParentValue)) {
                TreeNode root = new TreeNode(cntParentValue);
                TreeNode child = new TreeNode(cntChildValue);
                if (direction == 1) {
                    root.left = child;
                } else {
                    root.right = child;
                }
                map.put(cntChildValue, child);
                map.put(cntParentValue, root);
            }
            // 第二种，只包含孩子，不好含父亲
            else if (map.containsKey(cntChildValue) && !map.containsKey(cntParentValue)) {
                TreeNode root = new TreeNode(cntParentValue);
                TreeNode child = map.get(cntChildValue);
                if (direction == 1) {
                    root.left = child;
                } else {
                    root.right = child;
                }
                map.put(cntParentValue, root);
            }

            // 第三种，只不包含孩子，只有父亲
            else if (!map.containsKey(cntChildValue) && map.containsKey(cntParentValue)) {
                TreeNode root = map.get(cntParentValue);
                TreeNode child = new TreeNode(cntChildValue);
                if (direction == 1) {
                    root.left = child;
                } else {
                    root.right = child;
                }
                map.put(cntChildValue, child);
            } else {
                TreeNode root = map.get(cntParentValue);
                TreeNode child = map.get(cntChildValue);
                if (direction == 1) {
                    root.left = child;
                } else {
                    root.right = child;
                }
            }

        }
        return map.get(rootValue);
    }

}
