package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.MainClass.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author underdog_rj
 * @date2022/5/320:43
 */
public class C_281 {
    public int countEven(int num) {
        int res = 0;
        for (int i = 2; i <= num; i++) {
            String str = String.valueOf(i);
            int tmp = 0;
            for (int j = 0; j < str.length(); j++) {
                tmp += Integer.parseInt(str.charAt(j) + "");
            }
            if((tmp&1)==0)
                res++;
        }

        return res;
    }
    public ListNode mergeNodes(ListNode head) {
        ListNode root = new ListNode();
        ListNode tail = root;
        ListNode p = head.next;
        int tmp = 0;
        while (p != null) {
            if (p.val != 0) {
                tmp += p.val;
            } else {
                ListNode cnt = new ListNode(tmp);
                tmp = 0;
                tail.next = cnt;
                tail = tail.next;
            }
            p = p.next;
        }
        return root.next;
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        char pre = 'Z';
        while (map.size() != 0) {
            Map.Entry<Character, Integer> entry = map.pollLastEntry();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (key == pre) {
                // 查找下一个
                Map.Entry<Character, Integer> integerEntry = map.pollLastEntry();
                if (integerEntry == null)
                    return sb.toString();
                // 之前的放入
                map.put(key, entry.getValue());
                Character key1 = integerEntry.getKey();
                Integer value1 = integerEntry.getValue();
                if (value1 != 1) {
                    map.put(key1, value1 - 1);
                }
                sb.append(key1);
                pre = key1;
            }
            // 如果本次和上次不相同，则直接添加
            else {
                if (value >= repeatLimit) {
                    if (value != repeatLimit) {
                        map.put(key, value - repeatLimit);
                    }
                    for (int i = 0; i < repeatLimit; i++) {
                        sb.append(key);
                    }
                } else {
                    for (int i = 0; i < value; i++) {
                        sb.append(key);
                    }
                }
                pre = key;

            }

        }
        return sb.toString();
    }
}
