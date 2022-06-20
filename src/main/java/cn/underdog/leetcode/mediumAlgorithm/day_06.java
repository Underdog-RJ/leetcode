package cn.underdog.leetcode.mediumAlgorithm;


import cn.underdog.leetcode.entity.TreeNode;
import cn.underdog.leetcode.entity.tree.Node;


import java.util.*;


public class day_06 {
    public static void main(String[] args) {
      /*  TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(0);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;
        treeNode11.left = treeNode2;
        treeNode11.right = treeNode21;
        treeNode21.left = treeNode22;

        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode32 = new TreeNode(1);
        TreeNode treeNode33 = new TreeNode(2);

        treeNode31.left = treeNode32;
        treeNode31.right = treeNode33;*/
      /*  TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        treeNode1.left = treeNode11;
        treeNode11.left = treeNode12;
        treeNode12.left = treeNode2;
        treeNode2.left = treeNode21;
        treeNode2.right = treeNode22;

        TreeNode treeNode31 = new TreeNode(1);
        TreeNode treeNode32 = new TreeNode(1);
        TretreeNode31.left = treeNode32;
        treeNode31.right = treeNode33;eNode treeNode33 = new TreeNode(2);

        */
       /* TreeNode treeNode1 = new TreeNode(-2);
        TreeNode treeNode11 = new TreeNode(-1);
        TreeNode treeNode12 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(-6);
        TreeNode treeNode21 = new TreeNode(-2);
        TreeNode treeNode22 = new TreeNode(3);
        TreeNode treeNode23 = new TreeNode(9);
        TreeNode treeNode24 = new TreeNode(-5);
        TreeNode treeNode25 = new TreeNode(0);
        TreeNode treeNode26 = new TreeNode(7);
        treeNode1.left = treeNode11;*/
       /* treeNode1.right = treeNode12;

        treeNode11.left = treeNode2;
        treeNode11.right = treeNode21;

        treeNode12.left = treeNode22;
        treeNode12.right = treeNode23;

        treeNode2.left =treeNode24;

        treeNode22.left=treeNode25;
        treeNode22.right=treeNode26;*/

        TreeNode treeNode31 = new TreeNode(-2);
        TreeNode treeNode32 = new TreeNode(0);
        TreeNode treeNode33 = new TreeNode(5848);

//        treeNode31.left = treeNode32;
//        treeNode31.right = treeNode33;


//        boolean subtree = isSubtree(treeNode1, treeNode31);
//        System.out.println(subtree);

       /* Node root = new Node(1);
        Node root1 = new Node(2);
        Node root2 = new Node(3);
        Node root3 = new Node(4);
        Node root4 = new Node(5);
        Node root5 = new Node(7);
        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;
        root2.right = root5;


        connect(root);*/
       /* int[][] res = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(res))*/
        ;

//        char[][] res = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
       /* char[][] res = new char[][]{{'X', 'O'}, {'O', 'O'}};
        solveQueue(res);
        System.out.println(res);*/

        permuteUnique(new int[]{1,1,2});
    }

    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
     * <p>
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean l = false;
        boolean r = false;
        if (root != null && subRoot != null) {
            l = isSubtree(root.left, subRoot);
            r = isSubtree(root.right, subRoot);
            if (l || r)
                return true;
            if (root.val == subRoot.val) {
                boolean dfs = dfs(root.left, subRoot.left);
                boolean dfs1 = dfs(root.right, subRoot.right);
                return dfs && dfs1;
            }
        }
        return l || r;
    }

    public static boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null && subRoot != null)
            return false;
        if (root != null && subRoot == null)
            return false;
        if (root.val != subRoot.val)
            return false;
        boolean lflag = dfs(root.left, subRoot.left);
        boolean rflag = dfs(root.right, subRoot.right);
        return lflag && rflag;
    }

    /**
     * 给定一个二叉树
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 初始状态下，所有 next 指针都被设置为 NULL。
     * <p>
     *  
     * <p>
     * 进阶：
     * <p>
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *  
     * <p>
     * 示例：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        if (root == null)
            return null;
        Node p = root;
        Node currentTail = root;
        Node nextTail = root;
        if (root.left != null)
            nextTail = root.left;
        if (root.right != null)
            nextTail = root.right;
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        while (p != null || !queue.isEmpty()) {
            p = queue.remove();
            if (p.left != null) {
                queue.add(p.left);
                nextTail = p.left;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextTail = p.right;
            }
            if (currentTail == p) {
                p.next = null;
                currentTail = nextTail;
            } else {
                Node next = queue.peek();
                p.next = next;
            }
            p = null;
        }
        return root;
    }

    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * <p>
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * <p>
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * <p>
     * 返回矩阵中 省份 的数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     * <p>
     * <p>
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     *
     * @param isConnected
     * @return
     */
    /*public static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfsCircles(isConnected, visited, i, provinces);
                circles++;
            }
        }
        return circles;
    }*/
    public static int findCircleNum(int[][] isConnected) {
        int res = 0;
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                res++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer current = queue.poll();
                    int[] ints = isConnected[current];
                    for (int j = 0; j < ints.length; j++) {
                        if (isConnected[current][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 深度优先
     *
     * @param isConnected
     * @param visited
     * @param i
     * @param provinces
     */
    public static void dfsCircles(int[][] isConnected, boolean[] visited, int i, int provinces) {

        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfsCircles(isConnected, visited, j, provinces);
            }
        }

    }


    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     *  
     * 思路深度优先:
     * 遍历二维数组，如果当前为1则开始遍历，res++ 开始递归，上下左右，递归出口条件：如果当前下表越界，过着当前节点已经访问过了
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
  /*  public static int numIslands(char[][] grid) {
        int res = 0;
        int cow = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ++res;
                    dfsIslands(grid, i, j);
                }
            }
        }
        return res;
    }*/
    // 广度优先
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> queue = new LinkedList<>();
                    res++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] indexs = queue.remove();
                        int r_index = indexs[0];
                        int c_index = indexs[1];
                        if (r_index - 1 >= 0 && grid[r_index - 1][c_index] == '1') {
                            grid[r_index - 1][c_index] = '0';
                            queue.add(new int[]{r_index - 1, c_index});
                        }
                        if (r_index + 1 < row && grid[r_index + 1][c_index] == '1') {
                            grid[r_index + 1][c_index] = '0';
                            queue.add(new int[]{r_index + 1, c_index});
                        }
                        if (c_index - 1 >= 0 && grid[r_index][c_index - 1] == '1') {
                            grid[r_index][c_index - 1] = '0';
                            queue.add(new int[]{r_index, c_index - 1});
                        }
                        if (c_index + 1 < col && grid[r_index][c_index + 1] == '1') {
                            grid[r_index][c_index + 1] = '0';
                            queue.add(new int[]{r_index, c_index + 1});
                        }
                    }
                }
            }
        }
        return res;
    }

    private static void dfsIslands(char[][] grid, int i, int j) {
        int cow = grid.length;
        int col = grid[0].length;
        if (i < 0 || i >= cow || j >= col || j < 0 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfsIslands(grid, i - 1, j);
        dfsIslands(grid, i + 1, j);
        dfsIslands(grid, i, j - 1);
        dfsIslands(grid, i, j + 1);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        dfsAllPath(0, res, graph, deque, graph.length - 1);
        return res;
    }

    private static void dfsAllPath(int i, List<List<Integer>> res, int[][] graph, Deque<Integer> deque, int i1) {

        if (i == i1) {
            res.add(new ArrayList<>(deque));
        }
        int[] ints = graph[i];
        for (int anInt : ints) {
            deque.offerLast(anInt);
            dfsAllPath(anInt, res, graph, deque, i1);
            deque.pollLast();
        }
    }


    private static void dfsPathSourceTarget(int k, List<List<Integer>> res, int[][] graph, List<Integer> current) {
        int[] currentNums = graph[k];
        if (currentNums == null || currentNums.length == 0) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(0);
            tempList.addAll(current);
            res.addAll(Collections.singleton(tempList));
            current.clear();
            return;
        }
        for (int i = 0; i < currentNums.length; i++) {
            int currentNum = currentNums[i];
            current.add(currentNum);
            dfsPathSourceTarget(currentNum, res, graph, current);
        }
    }

    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * 示例 2：
     * <p>
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surrounded-regions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     */
    // 深度优先
    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // 遍历第一列和最后一列
        for (int i = 0; i < row; i++) {
            dfsSolve(board, i, 0, row, col);
            dfsSolve(board, i, col - 1, row, col);
        }
        // 遍历第一行和最后一行(除去四个角已经便利)
        for (int i = 1; i < col - 1; i++) {
            dfsSolve(board, 0, i, row, col);
            dfsSolve(board, row - 1, i, row, col);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfsSolve(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j >= col || j < 0 || board[i][j] != 'O')
            return;
        board[i][j] = 'A';
        dfsSolve(board, i - 1, j, row, col);
        dfsSolve(board, i + 1, j, row, col);
        dfsSolve(board, i, j - 1, row, col);
        dfsSolve(board, i, j + 1, row, col);
    }

    public static void solveQueue(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                queue.add(new int[]{i, 0});
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = 'A';
                queue.add(new int[]{i, col - 1});
            }
        }
        for (int i = 1; i < col - 1; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                queue.add(new int[]{0, i});
            }
            if (board[row - 1][i] == 'O') {
                board[row - 1][i] = 'A';
                queue.add(new int[]{row - 1, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] indexs = queue.remove();
            int r_index = indexs[0];
            int c_index = indexs[1];
            if (r_index - 1 >= 0 && board[r_index - 1][c_index] == 'O') {
                board[r_index - 1][c_index] = 'A';
                queue.add(new int[]{r_index - 1, c_index});
            }
            if (r_index + 1 < row && board[r_index + 1][c_index] == 'O') {
                board[r_index + 1][c_index] = 'A';
                queue.add(new int[]{r_index + 1, c_index});
            }
            if (c_index - 1 >= 0 && board[r_index][c_index - 1] == 'O') {
                board[r_index][c_index - 1] = 'A';
                queue.add(new int[]{r_index, c_index - 1});
            }
            if (c_index + 1 < col && board[r_index][c_index + 1] == 'O') {
                board[r_index][c_index + 1] = 'A';
                queue.add(new int[]{r_index, c_index + 1});
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        List<Integer> current = new ArrayList<>();
        int length = nums.length;
        dfsPermute(length, nums, res, current);
        return res;
    }
    private static void dfsPermute(int length, int[] nums, List<List<Integer>> res, List<Integer> current) {
        if (current.size() == length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(!current.contains(nums[i])){
                current.add(nums[i]);
                dfsPermute(length,nums,res,current);
                current.remove(current.size()-1);
            }
        }
    }


    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        List<Integer> current = new ArrayList<>();
        int length = nums.length;
        dfsPermuteUnique(length, nums, res, current);
        List<List<Integer>> tempRes = new ArrayList<>();
        for (List<Integer> re : res) {
            List<Integer> integers = new ArrayList<>();
            for (Integer integer : re) {
                integers.add(nums[integer]);
            }
            if(!tempRes.contains(integers)){
                tempRes.add(integers);
            }
        }
        return tempRes;
    }
    private static void dfsPermuteUnique(int length, int[] nums, List<List<Integer>> res, List<Integer> current) {
        if (current.size() == length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(!current.contains(i)){
                current.add(i);
                dfsPermuteUnique(length,nums,res,current);
                current.remove(current.size()-1);
            }
        }
    }
}
