package cn.underdog.leetcode.competition;

import java.util.*;

public class D_80 {

    public static void main(String[] args) {
        D_80 d_80 = new D_80();
//        d_80.strongPasswordCheckerII("IloveLe3tcode!");
//        d_80.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7);
//        d_80.matchReplacement("f178d2vdlwpycfmqgzd55fvfyamxx3owptoik8q52uy5ssteeboauki5x3zcl4gax53lurcpvs2jdju14a9115dk9q8adb7j31a07leiy4af57szw4xqwdnpcq8qj5nrkeb30lasl80kewhn987fvorke2rwg98bntfu2cxwkte509h8iweq85s3l47ayywf8dgesoy23e4qpjmrosmh0za6heoxd6fp8onv2dgumk6vkxy72cjwzkq139qecvnvihczb29uhsv0be7ftuxtzjetgfej0ijmnoej627z0vad5ghu22hnzhpyfasuy5l9kub2bmye2qxa4k4lnt15l7i916rilgbhbcifpjn3", "iu14at1j5dk9a8a3bzj3jb07leiycb0qzszw4xqr35omawaj5nzkjv3flb6l8fuerhnt8z0v1zkj2zwgt8vno0u2c1wuoj5f9hwireq8qs3ac7ay9wfw3sj61y23e4aojpz1"
//                , new char[][]{{'r', '4'}, {'z', 'r'}, {'5', 'c'}, {'t', 'y'}, {'f', '0'}, {'3', '8'}, {'7', '1'}, {'j', '1'}, {'s', 'u'}, {'o', 'e'}, {'f', 'l'}, {'7', 'g'}, {'5', 'x'}, {'o', 'd'}, {'k', 'u'}, {'x', 'w'}, {'z', 'c'}, {'8', 'j'}, {'s', 'x'}, {'j', 'p'}, {'9', '8'}, {'h', 'k'}, {'o', 'p'}, {'w', '8'}, {'i', 'j'}, {'c', 's'}, {'r', '5'}, {'1', 'x'}, {'i', 'k'}, {'u', 's'}, {'q', 'm'}, {'j', 'l'}, {'k', 'e'}, {'i', '4'}, {'a', 'q'}, {'1', '3'}, {'d', 'i'}, {'w', 'a'}, {'0', '3'}, {'4', 'v'}, {'p', 'm'}, {'s', 'c'}, {'c', 'i'}, {'e', 'w'}, {'m', 'f'}, {'0', 'f'}, {'6', 'w'}, {'i', 'v'}, {'z', '7'}, {'8', 'a'}, {'o', 'c'}, {'a', 'l'}, {'s', 'g'}, {'r', 'b'}, {'o', 't'}, {'n', 'a'}, {'v', 'c'}, {'5', 'n'}, {'i', 'c'}, {'p', 'd'}, {'9', 'y'}, {'u', 'k'}, {'j', 'e'}, {'3', 'd'}, {'q', '5'}, {'m', 'c'}, {'1', 'o'}, {'r', 'w'}, {'u', '6'}, {'b', 'a'}, {'t', '9'}, {'6', 's'}, {'v', 'b'}, {'1', 'i'}, {'c', '4'}});
        d_80.countSubarrays(new int[]{2, 1, 4, 3, 5}, 10);
    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8)
            return false;
//        !@#$%^&*()-+
        Set<Character> set = new HashSet<>(Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        for (int i = 0; i < password.length(); i++) {
            if (!flag1) {
                if (set.contains(password.charAt(i))) {
                    flag1 = true;
                }
            }
            if (!flag2) {
                if (Character.isLowerCase(password.charAt(i))) {
                    flag2 = true;
                }
            }
            if (!flag3) {
                if (Character.isUpperCase(password.charAt(i))) {
                    flag3 = true;
                }
            }
            if (!flag4) {
                if (Character.isDigit(password.charAt(i))) {
                    flag4 = true;
                }
            }
        }
        if (!flag1 || !flag2 || !flag3 || !flag4)
            return false;
        int pre = password.charAt(0);
        for (int i = 1; i < password.length(); i++) {
            int cnt = password.charAt(i);
            if (pre == cnt)
                return false;
            pre = cnt;
        }
        return true;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int length = spells.length;
        int[] res = new int[length];
        for (int i = 0; i < spells.length; i++) {
            int left = 0, right = potions.length - 1;
            while (left <= right) {
                int mid = left + right >> 1;
                long tmp = (long) potions[mid] * spells[i];
                if (tmp < success) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res[i] = potions.length - left;
        }
        return res;
    }

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for (char[] mapping : mappings) {
            Set<Character> orDefault = map.getOrDefault(mapping[0], new HashSet<>());
            orDefault.add(mapping[1]);
            map.put(mapping[0], orDefault);
        }
        for (int i = 0; i <= s.length() - sub.length(); i++) {
            boolean flag = false;
            for (int j = 0, index = i; j < sub.length() && index < s.length(); j++, index++) {
                if (s.charAt(index) != sub.charAt(j)) {
                    if (map.containsKey(sub.charAt(j))) {
                        Set<Character> set = map.get(sub.charAt(j));
                        if (!set.contains(s.charAt(index))) {
                            flag = true;
                            break;
                        }
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }

    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int left = 0;
        for (int i = 1; i <= nums.length; i++) {
            while ((long) ((i - left) * (preSum[i] - preSum[left])) >= k) {
                left++;
            }
            res += (i - left);
        }
        return res;
    }


}
