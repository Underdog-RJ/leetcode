package cn.underdog.leetcode.listnode;

import cn.underdog.leetcode.MainClass.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MainClass {


    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
      /*  ListNode[] listNodes = new ListNode[3];
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(4);
        ListNode t3 = new ListNode(5);
        ListNode t4 = new ListNode(1);
        ListNode t5 = new ListNode(3);
        ListNode t6 = new ListNode(4);
        ListNode t7 = new ListNode(2);
        ListNode t8 = new ListNode(6);
        t1.next = t2;
        t2.next = t3;
        listNodes[0] = t1;
        t4.next = t5;
        t5.next = t6;
        listNodes[1] = t4;
        t7.next = t8;
        listNodes[2] = t7;*/
//        ListNode t1 = new ListNode(3);
//        ListNode t2 = new ListNode(2);
//        ListNode t3 = new ListNode(0);
//        ListNode t4 = new ListNode(4);
//        t1.next = t2;
//        t2.next = t3;
//        t3.next = t4;
//        t4.next = t2;
//        mainClass.detectCycle(t1);
       /* MyLinkedListD linkedList = new MyLinkedListD();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3*/
        MyLinkedListD linkedList = new MyLinkedListD();
        linkedList.addAtHead(5);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        linkedList.get(1); //2           //返回2
        linkedList.addAtHead(6);
        linkedList.addAtTail(2);
        linkedList.get(3);//2
        linkedList.addAtTail(1);
        linkedList.get(5);
        linkedList.addAtHead(2);
        linkedList.get(2);
        linkedList.addAtHead(6);


    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * <p>
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode r = res;
        ListNode p = list1;
        ListNode q = list2;
        while (p != null && q != null) {
            if (p.val > q.val) {
                ListNode tmp = new ListNode(q.val);
                r.next = tmp;
                r = tmp;
                q = q.next;
            } else {
                ListNode tmp = new ListNode(p.val);
                r.next = tmp;
                r = tmp;
                p = p.next;
            }
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return res.next;
    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * <p>
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：lists = [[]]
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param lists
     * @return
     */
    /**
     * 时间复杂度过高
     * O(n*n)每次遍历找到最小值
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode r = res;
        while (true) {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;
                if (min > lists[i].val) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (index == -1)
                break;
            ListNode cntList = lists[index];
            ListNode tmp = new ListNode(cntList.val);
            cntList = cntList.next;
            lists[index] = cntList;
            r.next = tmp;
            r = tmp;
        }
        return res.next;
    }

    /**
     * 使用优先队列，存储每次的最小值
     * O(log(n)*n)使用小根堆找到最小值
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode r = res;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode list : lists) {
            if (list == null)
                continue;
            priorityQueue.add(list);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode cntMin = priorityQueue.poll();
            ListNode tmp = new ListNode(cntMin.val);
            if (cntMin.next != null) {
                cntMin = cntMin.next;
                priorityQueue.add(cntMin);
            }
            r.next = tmp;
            r = tmp;
        }

        return res.next;
    }


    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *  
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 104]
     * -105 <= Node.val <= 105
     * pos 为 -1 或者链表中的一个 有效索引 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    /**
     * 快慢指针，快指针每次移动2个位置，慢指针每次移动一个位置，
     * 当两个指针相等时存在环。如果快指针为null则不存在环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null)
                return false;
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 不允许修改 链表。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     *  
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围在范围 [0, 104] 内
     * -105 <= Node.val <= 105
     * pos 的值为 -1 或者链表中的一个有效索引
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 设从起点到环点为x，从环点到相遇点为y,从相遇点到环点为z
     * 则当两点相遇时slow走了x+y,quick走了x+y +n(y+z) n为quick绕环走的次数
     * 因为quick = 2slow
     * 说一说 2(x+y) = x+y +n*(y+z)
     * 转化为 x=(n-1)(y+z) +z 此时n一定大于等于1，不可能在在同一圈相遇
     * 当n-1等于1是x=z也就是说从相遇点，到环点的距离和从起点到环点的距离相同
     * ps:当quick指针是每次走2slow指针每次走1如果存在环，这一定会相遇
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                slow = head;
                while (slow != quick) {
                    slow = slow.next;
                    quick = quick.next;
                }
                return slow;
            }
        }
        return null;
    }


    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && n >= 0) {
            quick = quick.next;
            n--;
        }
        /**
         * 当快指针为null 并且n==0时，此时删除的一定是头节点
         */
        if (quick == null && n >= 0)
            return head.next;
        /**
         * 找到对应的位置的点
         */
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        ListNode tmp = slow.next;
        slow.next = tmp.next;
        return head;
    }

    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * <p>
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     * <p>
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/middle-of-the-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *  
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
     * <p>
     * 提示：
     * <p>
     * 列表中的节点数目在范围 [0, 104] 内
     * 1 <= Node.val <= 50
     * 0 <= val <= 50
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-linked-list-elements
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                ListNode tmp = p.next;
                p.next = tmp.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    /**
     * 头插法，反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummp = new ListNode(-1);
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummp.next;
            dummp.next = head;
            head = tmp;
        }
        return dummp.next;
    }


    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
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
     * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummp = new ListNode(-1);
        dummp.next = head;
        ListNode p = head;
        while (p.next != null && p.next.next != null) {
            ListNode t1 = p.next;
            ListNode t2 = p.next.next;
            p.next=t2;
            t1.next = t2.next;
            t2.next=t1;
            p=t1;
        }

        return dummp.next;
    }


}
