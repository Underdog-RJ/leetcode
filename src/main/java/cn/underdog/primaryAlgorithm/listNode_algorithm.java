package cn.underdog.primaryAlgorithm;

import cn.underdog.MainClass.ListNode;


import java.util.LinkedList;
import java.util.Stack;
import java.util.List;

public class listNode_algorithm {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        rotateRight(l1, 10);
//        MyHashSet myHashSet =new MyHashSet();
//        myHashSet.add(1);      // set = [1]
//        myHashSet.add(2);      // set = [1, 2]
//        myHashSet.contains(1); // 返回 True
//        myHashSet.contains(3); // 返回 False ，（未找到）
//        myHashSet.add(2);      // set = [1, 2]
//        myHashSet.contains(2); // 返回 True
//        myHashSet.remove(2);   // set = [1]
//        myHashSet.contains(2); // 返回 False ，（已移除）

//        l1.next=l4;
//        ListNode l3 = new ListNode(2, new ListNode(3, new ListNode(4)));
//        l4.next = l3;
//        l2.next = l3;
//        l1.next = l2;
//        removeElements(null, 1);
    }

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     * <p>
     *  
     * <p>
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * <p>
     * <p>
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public ListNode reverseList(ListNode head) {

        ListNode headNew = null;
        ListNode p = head;
        ListNode r = p;
        while (p != null) {
            r = p.next;
            p.next = headNew.next;
            headNew.next = p;
            p = r;
        }
        return headNew.next == null ? headNew : headNew.next;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode tail = res;

        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val > q.val) {
                ListNode temp = new ListNode(q.val);
                tail.next = temp;
                tail = tail.next;
                q = q.next;
            } else {
                ListNode temp = new ListNode(p.val);
                tail.next = temp;
                tail = tail.next;
                p = p.next;
            }
        }
        if (p != null) {
            tail.next = p;
        }
        if (q != null) {
            tail.next = q;
        }

        return res.next;
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        while (head != null) {
            if (head.val == stack.pop()) {
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new LinkedList<>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * 慢指针每次移动一个位置，快指针每次移动两个位置
     * 如果链表中存在环  则慢指针一定会追上快指针  slow == fast
     * 如果链表中不存环  则fast == null
     *
     * @param head
     * @return
     */
    public boolean hasCycleKM(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * <p>
     * 返回同样按升序排列的结果链表。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            if (p.next != null) {
                // 如果当前值和下一个不相等的话，直接为下一个
                if (p.val != p.next.val) {
                    p = p.next;
                } else {
                    // 如果当前值和下一个相等的话，找出直到和当前值不同的ListNode
                    int currentValue = p.val;
                    ListNode tempNode = p.next;
                    while (tempNode.next != null) {
                        if (tempNode.next.val == currentValue) {
                            tempNode = tempNode.next;
                        } else {
                            break;
                        }
                    }
                    p.next = tempNode.next;
                    tempNode.next = null;
                    if (p == null) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return head;
    }

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * <p>
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * <p>
     * <p>
     * 题目数据 保证 整个链式结构中不存在环。
     * <p>
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Intersected at '2'
     * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
     * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
     * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 这两个链表不相交，因此返回 null 。
     *  
     * <p>
     * 提示：
     * <p>
     * listA 中节点数目为 m
     * listB 中节点数目为 n
     * 0 <= m, n <= 3 * 104
     * 1 <= Node.val <= 105
     * 0 <= skipA <= m
     * 0 <= skipB <= n
     * 如果 listA 和 listB 没有交点，intersectVal 为 0
     * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alength = 0;
        int Blength = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (p != null) {
            p = p.next;
            Alength++;
        }
        while (q != null) {
            q = q.next;
            Blength++;
        }
        p = headA;
        q = headB;
        if (Alength > Blength) {
            int length = Alength - Blength;
            while (p != null && q != null) {
                if (p == q) {
                    return p;
                } else {
                    if (length > 0) {
                        p = p.next;
                        length--;
                    } else {
                        p = p.next;
                        q = q.next;
                    }
                }
            }
            return null;
        } else {
            int length = Blength - Alength;
            while (p != null && q != null) {
                if (p == q) {
                    return p;
                } else {
                    if (length > 0) {
                        q = q.next;
                        length--;
                    } else {
                        p = p.next;
                        q = q.next;
                    }
                }
            }
            return null;
        }
    }

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     * 示例 2：
     * <p>
     * 输入：head = [], val = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode tem = new ListNode(Integer.MIN_VALUE);
        tem.next = head;
        head = tem;
        ListNode p = head;
        ListNode r = p;
        while (p != null) {
            if (p.val == val) {
                ListNode temp = p.next;
                r.next = p.next;
                p.next = null;
                p = temp;
            } else {
                r = p;
                p = p.next;
            }
        }
        return head.next;
    }

    public static int getDecimalValue(ListNode head) {

        if (head == null)
            return 0;
        ListNode p = head;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        String s = sb.reverse().toString();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                double pow = Math.pow(2, i);
                System.out.println(pow);
                res += (int) Math.pow(2, i);
            }
        }
        return res;

    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     * <p>
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1]
     * 输出：[1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        if (head == null)
            return null;
        ListNode p = head;
        ListNode r = head.next;
        while (r != null) {
            ListNode next = r.next;
            ListNode temp = p;
            temp.next = r.next;
            r.next = temp;
            p = next;
            r = p.next;
        }
        return head;
    }

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        if (k == 0)
            return head;
        ListNode p = head;
        ListNode firstHead = head;
        ListNode r = head;
        ListNode temp = head;
        int count = 0;
        ListNode t = head;
        while (t != null) {
            t = t.next;
            count++;
        }
        if (count == 1) {
            return head;
        }
        if (k > count) {
            k = k % count;
        }
        if (k == count || k == 0) {
            return head;
        }
        k = count - k;
        while (k > 0 && p != null) {
            r = temp;
            temp = temp.next;
            k--;
        }

        ListNode nextTail = r;
        ListNode nextHead = r.next == null ? r : r.next;

        ListNode tempR = r;
        while (r != null) {
            p = p.next;
            nextTail = r;
            r = r.next;
        }
        tempR.next = null;
        nextTail.next = firstHead;
        head = nextHead;

        return head;


    }


}
