package cn.underdog.MainClass;

import java.util.LinkedHashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;

public class LRUCache {
    // 单向链表
   /* private int capacity;
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            // 把当前的key移动到最后
            Integer value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }

    }
    public void put(int key, int value) {
        if (map.size() < this.capacity) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
            map.put(key, value);
        } else {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            } else {
                List<Integer> list = new ArrayList<>(map.keySet());
                Integer integer = list.get(0);
                map.remove(integer);
                map.put(key, value);
            }
        }
    }*/

    // 双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 建立傀儡的头尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // 将当前节点移动到head后面
            addCurrentNodeToHead(cache.get(key));
            return cache.get(key).value;
        } else
            return -1;
    }

    private void addCurrentNodeToHead(DLinkedNode dLinkedNode) {
        // 删除当前节点
        removeCurrentNode(dLinkedNode);
        // 将当前节点移动到head之后
        moveToHeadAfter(dLinkedNode);
    }

    private void moveToHeadAfter(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeCurrentNode(DLinkedNode dLinkedNode) {
        dLinkedNode.prev.next = dLinkedNode.next;
        dLinkedNode.next.prev = dLinkedNode.prev;
        dLinkedNode.next = null;
        dLinkedNode.prev = null;
    }

    public void put(int key, int value) {
        // 如果包含当前节点
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            addCurrentNodeToHead(node);
        } else {
            if (size < capacity) {
                size++;
                DLinkedNode dLinkedNode = new DLinkedNode(key, value);
                cache.put(key, dLinkedNode);
                moveToHeadAfter(dLinkedNode);
            } else {
                DLinkedNode temp = new DLinkedNode(key, value);
                cache.put(key, temp);
                // 删除最后一个节点
                DLinkedNode last = removeLastNode();
                // 从cacha中删除key
                cache.remove(last.key);
                moveToHeadAfter(temp);
            }
        }
    }

    private DLinkedNode removeLastNode() {
        DLinkedNode prev = tail.prev;
        removeCurrentNode(prev);
        return prev;
    }

}
