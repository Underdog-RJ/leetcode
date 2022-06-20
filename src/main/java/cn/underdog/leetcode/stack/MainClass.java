package cn.underdog.leetcode.stack;

import cn.underdog.leetcode.MainClass.ListNode;
import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
//        String[] ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
//        calPoints(ops);
      /*  Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        List<Node> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        List<Node> list1 = new ArrayList<>();
        list1.add(node6);
        list1.add(node7);
        List<Node> list2 = new ArrayList<>();
        list2.add(node8);
        List<Node> list3 = new ArrayList<>();
        list3.add(node9);
        list3.add(node10);
        List<Node> list4 = new ArrayList<>();
        list4.add(node11);
        List<Node> list5 = new ArrayList<>();
        list3.add(node12);
        List<Node> list6 = new ArrayList<>();
        list6.add(node13);
        List<Node> list7 = new ArrayList<>();
        list7.add(node14);
        root.children = list;
        node2.children = list1;
        node3.children = list2;
        node4.children = list3;
        node7.children = list4;
        node8.children = list5;
        node9.children = list6;
        node11.children = list7;
        postorder(root);*/

//        TripleInOne tripleInOne = new TripleInOne(0);
//        tripleInOne.push(0, 1);
//        tripleInOne.push(0, 2);
//        tripleInOne.push(0, 3);
//        System.out.println(tripleInOne.pop(0));
//        System.out.println(tripleInOne.pop(0));
//        System.out.println(tripleInOne.pop(0));
//        System.out.println(tripleInOne.peek(0));
        MainClass mainClass = new MainClass();
//        mainClass.removeDuplicates("abbaca");
        mainClass.evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     * <p>
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     * <p>
     * 输入：s = "{[]}"
     * 输出：true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty() ? true : false;
    }


    /**
     * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
     * <p>
     * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
     * <p>
     * 整数 x - 表示本回合新获得分数 x
     * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
     * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * 请你返回记录中所有得分的总和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：ops = ["5","2","C","D","+"]
     * 输出：30
     * 解释：
     * "5" - 记录加 5 ，记录现在是 [5]
     * "2" - 记录加 2 ，记录现在是 [5, 2]
     * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
     * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
     * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
     * 所有得分的总和 5 + 10 + 15 = 30
     * 示例 2：
     * <p>
     * 输入：ops = ["5","-2","4","C","D","9","+","+"]
     * 输出：27
     * 解释：
     * "5" - 记录加 5 ，记录现在是 [5]
     * "-2" - 记录加 -2 ，记录现在是 [5, -2]
     * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
     * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
     * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
     * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
     * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
     * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
     * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/baseball-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if (op.equals("+")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int res = num1 + num2;
                stack.push(num2);
                stack.push(num1);
                stack.push(res);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                Integer peek = stack.peek();
                stack.push(peek * 2);
            } else {
                stack.add(Integer.parseInt(op));
            }

        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                list.add(p.val);
                List<Node> children = p.children;
                if (children == null || children.size() == 0) {
                    p = null;
                } else {
                    p = children.get(0);
                    children.remove(0);
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                }
            } else {
                p = stack.pop();
            }
        }
        return list;
    }


    /**
     * 给定一个 N 叉树，返回其节点值的 后序遍历 。
     * <p>
     * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * <p>
     *  
     * <p>
     * 进阶：
     * <p>
     * 递归法很简单，你可以使用迭代法完成此题吗?
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[5,6,3,2,4,1]
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
     * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思路：
     * 用 p 代表当前遍历的元素 r 代表已经访问过的元素
     *
     * @param root
     * @return
     */
    public static List<Integer> postorder(Node root) {

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node r = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                // 如果当前节点不为空直接添加
                stack.add(p);
                List<Node> children = p.children;
                // 如果当前节点的子节点为空的话，证明需要访问当前节点
                if (children == null || children.size() == 0) {
                    list.add(p.val);
                    stack.pop();
                    r = p; // r更新为访问过的节点
                    p = null;
                } else {
                    // 如果当前节点包含r => 添加过子孩子，则直接访问
                    if (children.contains(r)) {
                        list.add(p.val);
                        r = p;
                        stack.pop();
                        p = null;
                    }
                    // 如果当前节点不包含r => 未添加过子孩子，添加子孩子
                    else {
                        p = children.get(0);
                        for (int i = children.size() - 1; i > 0; i--) {
                            stack.push(children.get(i));
                        }
                    }
                }
            } else {
                // 如果当前元素为空直接从  弹栈
                p = stack.pop();
            }
        }
        return list;
    }

    /**
     * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [5,1,7]
     * 输出：[1,null,5,null,7]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;

        Queue<Integer> integers = new LinkedList<>();
        InOrder(root, integers);
        root = null;
        if (!integers.isEmpty()) {
            root = new TreeNode(integers.poll());
        }
        TreeNode p = root;
        while (!integers.isEmpty()) {
            TreeNode temp = new TreeNode(integers.poll());
            p.right = temp;
            p = temp;
        }
        return root;

    }

    private void InOrder(TreeNode root, Queue<Integer> integers) {
        if (root != null) {
            InOrder(root.left, integers);
            integers.add(root.val);
            InOrder(root.right, integers);
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            queue.add(head.val);
            head = head.next;
        }
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }
        return true;
    }

    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }


    /**
     * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
     * <p>
     * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
     * <p>
     * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：prices = [8,4,6,2,3]
     * 输出：[4,2,4,2,3]
     * 解释：
     * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
     * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
     * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
     * 商品 3 和 4 都没有折扣。
     * 示例 2：
     * <p>
     * 输入：prices = [1,2,3,4,5]
     * 输出：[1,2,3,4,5]
     * 解释：在这个例子中，所有商品都没有折扣。
     * 示例 3：
     * <p>
     * 输入：prices = [10,1,1,6]
     * 输出：[9,0,1,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        // 暴力求解
      /*  for (int i = 0; i < prices.length - 1; i++) {
            int gap = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int current = prices[i];
                if (prices[j] <= current) {
                    gap =prices[j];
                    break;
                }
            }
            res[i]=prices[i]-gap;
        }
        res[prices.length-1]=prices[prices.length-1];*/

        return res;
    }


    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * <p>
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * <p>
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek())
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }

    /**
     * 根据 逆波兰表示法，求表达式的值。
     * <p>
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * <p>
     * 注意 两个整数之间的除法只保留整数部分。
     * <p>
     * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     * 示例 2：
     * <p>
     * 输入：tokens = ["4","13","5","/","+"]
     * 输出：6
     * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
     * 示例 3：
     * <p>
     * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     * 输出：22
     * 解释：该算式转化为常见的中缀算术表达式为：
     * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
