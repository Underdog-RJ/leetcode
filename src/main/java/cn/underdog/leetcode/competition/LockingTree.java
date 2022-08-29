package cn.underdog.leetcode.competition;

import java.util.*;

class LockingTree {
    /**
     * 祖先拓扑
     */
    List<Integer>[] lists1 = null;
    /**
     * 子孙拓扑
     */
    List<Integer>[] lists2 = null;

    /**
     * 用户：锁
     */
    Map<Integer, Set<Integer>> map = new HashMap<>();

    Map<Integer, Integer> map1 = new HashMap<>();

    public LockingTree(int[] parent) {
        int length = parent.length;
        lists1 = new List[length];
        lists2 = new List[length];
        for (int i = 0; i < lists1.length; i++) {
            lists1[i] = new ArrayList<>();
            lists2[i] = new ArrayList<>();
        }
        for (int i = 1; i < parent.length; i++) {
            lists1[i].add(parent[i]);
            lists2[parent[i]].add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (map1.containsKey(num))
            return false;
        map1.put(num, user);
        Set<Integer> orDefault = map.getOrDefault(user, new HashSet<>());
        orDefault.add(num);
        map.put(user, orDefault);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (map.containsKey(user)) {
            Set<Integer> set = map.get(user);
            if (set.contains(num)) {
                map1.remove(num);
                set.remove(num);
                map.put(user, set);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean upgrade(int num, int user) {
        // 1.判断当前节点是否上锁
        if (map1.containsKey(num)) return false;
        // 2. 判断当前节点的子孙节点是否存在一个加锁，如果有锁则直接解锁
        boolean flagSon = dfsIsSonExistLock(num);
        if (flagSon) return false;
        // 3.判断该节点的祖先节点是否存在村
        boolean flagAncestor = dfsIsAncestors(num);
        if (flagAncestor) return false;
        // 4.当前节点子孙节点解锁
        dfsUnlockSon(num);
        // 5.当前节点加锁
        lock(num, user);
        return true;
    }

    /**
     * 如果当前节点枷锁进行解锁
     * @param num
     */
    private void dfsUnlockSon(int num) {
        // 判断当前节点是否加锁
        if (map1.containsKey(num)) {
            Integer user = map1.get(num);
            map1.remove(num);
            Set<Integer> set = map.get(user);
            set.remove(num);
            map.put(user, set);
        }
        List<Integer> integers = lists2[num];
        for (Integer integer : integers) {
            dfsUnlockSon(integer);
        }
    }

    /**
     * 判断当前节点的祖先节点是否存在锁
     *
     * @param num
     * @return
     */
    private boolean dfsIsAncestors(int num) {
        if (map1.containsKey(num)) return true;
        List<Integer> integers = lists1[num];
        for (Integer integer : integers) {
            boolean child = dfsIsAncestors(integer);
            if (child) return true;
        }
        return false;
    }

    /**
     * 判断孩子是否存在锁
     * @param num
     * @return
     */
    private boolean dfsIsSonExistLock(int num) {
        if (map1.containsKey(num)) return false;
        List<Integer> integers = lists2[num];
        for (Integer integer : integers) {
            boolean child = dfsIsSonExistLock(integer);
            if (!child) return false;
        }
        return true;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */