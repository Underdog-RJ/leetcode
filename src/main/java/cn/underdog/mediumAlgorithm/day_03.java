package cn.underdog.mediumAlgorithm;

import cn.underdog.MainClass.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day_03 {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5))))))));
//        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        deleteDuplicates(null);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        boolean flag = false;
        if (head != null && head.next != null) {
            if (head.val == head.next.val) {
                flag = true;
            }
        }
        ListNode p = head;
        ListNode prev = p;
        while (p != null) {
            if (p.next != null) {
                // 如果当前值和下一个不相等的话，直接为下一个
                if (p.val != p.next.val) {
                    prev = p;
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
                    prev.next = tempNode.next;
                    p = tempNode.next;
                    tempNode.next = null;
                    if (p == null) {
                        break;
                    }
                }
            }else {
                break;
            }
        }
        if (flag == true) {
            head = head.next;
        }

        return head;
    }

}
