package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.MainClass.ListNode;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author underdog_rj
 * @date2022/5/321:04
 */
public class D_69 {

    public String capitalizeTitle(String title) {
        String[] strings = title.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 1 || strings[i].length() == 2)
                strings[i] = strings[i].toLowerCase();
            else {
                String tmp = strings[i];
                strings[i] = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
            }
        }
        return String.join(" ", strings);
    }

    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        // 快反指针（找中点偶数）
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转链表 (头插法)
        ListNode nextHead = slow.next;
        ListNode pre = null;
        while (nextHead != null) {
            ListNode tmp = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = tmp;
        }
        while (head != null && pre != null) {
            max = Math.max(max, head.val + pre.val);
            head = head.next;
            pre = pre.next;
        }
        return max;
    }

    public int longestPalindrome(String[] words) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int res = 0;
        boolean flag = false;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {

//        }
//        for (String word : words) {
            String word = iterator.next().getKey();
            // 如果两者相同，则直接查找次数*2，因为两个子没有相同，一定可以组成回文串
            if (word.charAt(0) == word.charAt(1)) {
                Integer integer = map.get(word);
                if (integer % 2 == 0) {
                    res += integer * 2;
                } else {
                    if (!flag) {
                        res += integer * 2;
                        flag = true;
                    } else {
                        res += (integer - 1) * 2;

                    }
                }
            } else {
                String reverse = word.charAt(1) + "" + word.charAt(0);
                if (map.containsKey(reverse)) {
                    Integer integer = map.getOrDefault(word, 0);
                    Integer integer1 = map.getOrDefault(reverse, 0);
                    int tmp = Math.min(integer, integer1);
                    res += tmp * 4;
                    map.remove(reverse);
                }
            }
            map.remove(word);
        }

        return res;
    }
}
