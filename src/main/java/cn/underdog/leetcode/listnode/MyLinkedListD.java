package cn.underdog.leetcode.listnode;

import cn.underdog.leetcode.MainClass.ListNode;

public class MyLinkedListD {
    class ListNode {
        int val;
        ListNode next, prev;

        ListNode(int x) {
            val = x;
        }
    }

    int size;
    ListNode head, tail;

    public MyLinkedListD() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
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
        ListNode tmp = head.next;
        ListNode cnt = new ListNode(val);
        cnt.next = tmp;
        tmp.prev = cnt;
        head.next = cnt;
        cnt.prev = head;
        size++;
    }

    public void addAtTail(int val) {
        ListNode tmp = tail.prev;
        ListNode cnt = new ListNode(val);
        cnt.next = tail;
        tail.prev = cnt;
        tmp.next = cnt;
        cnt.prev = tmp;
        size++;
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
        ListNode cnt = new ListNode(val);
        cnt.next = p.next;
        p.next.prev = cnt;
        cnt.prev = p;
        p.next = cnt;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        ListNode p = head;
        while (index > 0 && p != null) {
            p = p.next;
            index--;
        }
        p.next = p.next.next;
        p.next.prev = p;
        size--;
    }
}
