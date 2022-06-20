package cn.underdog.leetcode.MainClass;


/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));

//        ListNode l1=new ListNode(9,new ListNode(9,new ListNode(1)));
//        ListNode l2=new ListNode(1);


        addTwoNumbersD(l1, l2);

    }

    private static ListNode addTwoNumbersD(ListNode l1, ListNode l2) {
        ListNode retV = new ListNode(0);
        ListNode tail = retV;
        int jinwei = 0;
        while (l1 != null && l2 != null) {
            int x1 = l1.val;
            int x2 = l2.val;
            int temp = x1 + x2 + jinwei;
            // 进位每次用过请0
            if (jinwei != 0) {
                jinwei = 0;
            }
            if (temp >= 10) {
                int yushu = temp % 10;
                jinwei = temp / 10;
                tail.next = new ListNode(yushu);
                tail = tail.next;

            } else {
                tail.next = new ListNode(temp);
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int temp = l1.val + jinwei;
            if (jinwei != 0) {
                jinwei = 0;
            }
            if (temp >= 10) {
                int yushu = temp % 10;
                jinwei = temp / 10;
                tail.next = new ListNode(yushu);
                tail = tail.next;
            } else {
                tail.next = new ListNode(temp);
                tail = tail.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int temp = l2.val + jinwei;
            if (jinwei != 0) {
                jinwei = 0;
            }
            if (temp >= 10) {
                int yushu = temp % 10;
                jinwei = temp / 10;
                tail.next = new ListNode(yushu);
                tail = tail.next;
            } else {
                tail.next = new ListNode(temp);
                tail = tail.next;
            }
            l2 = l2.next;
        }
        if (jinwei != 0) {
            tail.next = new ListNode(jinwei);
        }
        return retV.next;
    }


}
