package cn.underdog.leetcode.primaryAlgorithm;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 */
public class MyHashSet {

    int val;
    MyHashSet next = null;

    public MyHashSet() {

    }

    public MyHashSet(int val) {
        this.val = val;
    }

    public void add(int key) {
        MyHashSet node = this;
        while (node.next != null) {
            if (node.val == key) {
                return;
            }
            node = node.next;
        }
        node.next= new MyHashSet(key);
    }

    public void remove(int key) {
        MyHashSet tem = new MyHashSet(Integer.MIN_VALUE);
        tem.next = this;
        MyHashSet p = tem;
        MyHashSet r = p;
        while (p != null) {
            if (p.val == key) {
                MyHashSet temp = p.next;
                r.next = p.next;
                p.next = null;
                p = temp;
            } else {
                r = p;
                p = p.next;
            }
        }
    }

    public boolean contains(int key) {
        MyHashSet node = this.next;
        while (node != null) {
            if (node.val == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
