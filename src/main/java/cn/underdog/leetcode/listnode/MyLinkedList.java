package cn.underdog.leetcode.listnode;

import cn.underdog.leetcode.MainClass.ListNode;

public class MyLinkedList {

    ListNode head = null;
    int size = 0;

    public MyLinkedList() {
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        ListNode p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index < 0) {
            index = 0;
        }
        size++;
        /**
         * p为插入的前一个节点
         */
        ListNode p = head;
        while (index > 0 && p != null) {
            p = p.next;
            index--;
        }
        ListNode tmp = new ListNode(val);
        tmp.next = p.next;
        p.next = tmp;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        ListNode p = head;
        while (index > 0 && p != null) {
            p = p.next;
            index--;
        }
        ListNode r = p.next;
        p.next = r.next;
        size--;
    }
}
