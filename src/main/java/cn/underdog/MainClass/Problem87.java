package cn.underdog.MainClass;


import cn.underdog.stack.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem87 {
    public static void main(String[] args) {
        Node r = new Node(1);
        Node r1 = new Node(3);
        Node r2 = new Node(2);
        Node r3 = new Node(4);
        List<Node> children = new ArrayList<>();
        children.add(r1);
        children.add(r2);
        children.add(r3);
        r.children = children;
        System.out.println(maxDepth(r));

    }

    public static int maxDepth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        Node p = null;
        // 下一层的第一个
        Node lastHead = root;
        boolean flag = false;
        while (!queue.isEmpty()) {
            p = queue.remove();
            if (lastHead == p)
                count++;
            List<Node> children = p.children;
            if (children != null) {

            }
        }
        return count;
    }
   /* public static int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 0;
        if(root.children!=null){
            for (Node node : root.children) {
                ans = Math.max(ans, maxDepth(node));
            }
        }
        return ans + 1;
    }*/

}
