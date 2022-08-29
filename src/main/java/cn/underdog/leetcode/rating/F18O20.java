package cn.underdog.leetcode.rating;

import java.math.BigInteger;
import java.util.*;

public class F18O20 {

    public static void main(String[] args) {
        F18O20 f18O20 = new F18O20();
//        f18O20.maxFrequency(new int[]{1, 2, 4}, 4);
//        f18O20.maxFrequency(new int[]{1, 4, 8, 13}, 5);
//        f18O20.maxFrequency(new int[]{3, 9, 6}, 2);
//        f18O20.maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}});
//        f18O20.jump(new int[]{2, 3, 1, 1, 4});
//        f18O20.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3});
//        f18O20.minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5}, new int[][]{{0, 1}, {2, 3}});
//        f18O20.minimumHammingDistance(new int[]{5, 1, 2, 4, 3}, new int[]{1, 5, 4, 2, 3}, new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}});
//        f18O20.canReach("00000001", 1, 10);
//        f18O20.minNumberOperations(new int[]{1, 2, 3, 2, 1});
//        f18O20.minNumberOperations(new int[]{3, 4, 2, 5, 6});
//        f18O20.minNumberOperations(new int[]{3, 1, 1, 2});
//        System.out.println(f18O20.longestPrefix("level"));
//        f18O20.minDeletionSize(new String[]{"xga", "xfb", "yfa"});
//        f18O20.maximumGain("aabbaaxybbaabb", 5, 4);
//        f18O20.canEat(new int[]{10, 11, 42, 42, 49, 14, 44, 33, 13, 49, 32, 19, 48, 36, 25, 38, 32, 45, 30, 21, 13, 45, 39, 12, 12, 25, 26, 18, 35, 28, 1, 31, 14, 16, 38, 49, 26, 33, 39, 39, 7, 31, 20, 8, 49, 36, 6, 1, 32, 2, 35, 10, 31, 37, 13, 43, 26}, new int[][]{{24, 579, 17}, {13, 275, 40}, {38, 432, 75}, {47, 62, 4}, {14, 908, 33}, {19, 1031, 77}, {18, 316, 71}, {54, 1558, 48}, {35, 1403, 19}, {10, 449, 58}, {0, 1258, 94}, {41, 1014, 59}, {33, 932, 15}, {18, 1488, 46}, {51, 630, 89}, {7, 362, 4}, {1, 14, 3}, {0, 1029, 3}, {2, 1454, 63}, {52, 19, 44}, {7, 418, 18}, {42, 1505, 12}, {49, 1188, 92}, {15, 1116, 76}, {47, 668, 40}, {50, 468, 7}, {49, 167, 8}, {51, 316, 94}, {27, 1270, 58}, {1, 158, 66}, {25, 979, 28}, {11, 837, 84}, {27, 1311, 80}, {16, 1148, 77}, {51, 1538, 34}, {19, 120, 70}, {8, 1508, 7}, {24, 1464, 93}, {1, 1448, 44}, {45, 331, 12}, {17, 111, 4}, {6, 332, 19}, {53, 1368, 98}, {23, 609, 85}, {11, 1364, 69}, {54, 1066, 32}, {8, 1566, 30}, {40, 1331, 21}, {16, 1478, 23}, {34, 133, 65}, {17, 1484, 9}, {37, 1150, 65}, {13, 885, 69}, {54, 191, 46}, {21, 105, 22}, {1, 37, 75}, {35, 479, 79}, {37, 905, 89}, {49, 551, 74}, {16, 986, 26}, {21, 1325, 34}, {41, 1520, 67}, {40, 611, 69}, {7, 997, 22}, {32, 1108, 39}, {2, 1549, 59}, {35, 553, 71}, {28, 729, 93}, {15, 357, 11}, {43, 566, 90}, {18, 1213, 87}, {23, 10, 100}, {8, 423, 18}, {19, 1270, 59}, {15, 413, 64}, {44, 765, 76}, {5, 17, 97}, {42, 1228, 10}, {27, 1236, 44}, {5, 411, 46}, {54, 458, 93}, {27, 1148, 33}, {20, 429, 85}, {12, 315, 88}, {56, 446, 26}});
//        f18O20.canEat(new int[]{46, 5, 47, 48, 43, 34, 15, 26, 11, 25, 41, 47, 15, 25, 16, 50, 32, 42, 32, 21, 36, 34, 50, 45, 46, 15, 46, 38, 50, 12, 3, 26, 26, 16, 23, 1, 4, 48, 47, 32, 47, 16, 33, 23, 38, 2, 19, 50, 6, 19, 29, 3, 27, 12, 6, 22, 33, 28, 7, 10, 12, 8, 13, 24, 21, 38, 43, 26, 35, 18, 34, 3, 14, 48, 50, 34, 38, 4, 50, 26, 5, 35, 11, 2, 35, 9, 11, 31, 36, 20, 21, 37, 18, 34, 34, 10, 21, 8, 5}, new int[][]{{80, 2329, 69}, {14, 1485, 76}, {33, 2057, 83}, {13, 1972, 27}, {11, 387, 25}, {24, 1460, 47}, {22, 1783, 35}, {1, 513, 33}, {66, 2124, 85}, {19, 642, 26}, {15, 1963, 79}, {93, 722, 96}, {15, 376, 88}, {60, 1864, 89}, {86, 608, 4}, {98, 257, 35}, {35, 651, 47}, {96, 795, 73}, {62, 2077, 18}, {27, 1724, 57}, {34, 1984, 75}, {49, 2413, 95}, {76, 1664, 5}, {28, 38, 13}, {85, 54, 42}, {12, 301, 3}, {62, 2016, 29}, {45, 2316, 37}, {43, 2360, 28}, {87, 192, 98}, {27, 2082, 21}, {74, 762, 37}, {51, 35, 17}, {73, 2193, 4}, {60, 425, 65}, {11, 1522, 58}, {21, 1699, 66}, {42, 1473, 5}, {30, 2010, 48}, {91, 796, 74}, {82, 2162, 31}, {23, 2569, 65}, {24, 684, 23}, {70, 1219, 51}, {5, 1817, 15}, {81, 2446, 34}, {96, 771, 60}, {49, 1171, 60}, {41, 567, 67}, {39, 799, 59}, {90, 957, 81}, {84, 2122, 27}, {82, 1707, 44}, {11, 1889, 20}, {80, 1697, 83}, {24, 1786, 60}, {90, 1847, 99}, {51, 114, 21}, {44, 466, 85}, {56, 469, 20}, {44, 350, 96}, {66, 1946, 10}, {14, 2470, 12}, {69, 1175, 18}, {98, 1804, 25}, {77, 2187, 40}, {89, 2265, 45}, {19, 2246, 45}, {40, 2373, 79}, {60, 2222, 17}, {37, 385, 5}, {97, 1759, 97}, {10, 903, 5}, {87, 842, 45}, {74, 2398, 66}, {62, 49, 94}, {48, 156, 77}, {76, 2310, 80}, {64, 2360, 95}, {70, 1699, 83}, {39, 1241, 66}, {92, 2312, 21}, {63, 2148, 29}, {95, 594, 74}, {89, 90, 51}, {82, 137, 70}, {54, 301, 97}, {15, 819, 43}, {47, 1402, 60}, {17, 2377, 43}, {50, 1937, 95}, {62, 1174, 74}, {67, 1411, 87}, {39, 1151, 48}});
//        f18O20.canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}});
//        f18O20.canEat(new int[]{7, 11, 5, 3, 8}, new int[][]{{2, 2, 6}, {4, 2, 4}, {2, 13, 1000000000}});
//        f18O20.minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3);
//        f18O20.minSumOfLengths(new int[]{2, 1, 3, 3, 2, 3, 1}, 6);
//        f18O20.maxProductPath(new int[][]{{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}});
//        System.out.println(f18O20.maxProductPath(new int[][]{{4, 3}}));
//        System.out.println((long) Math.pow(4, 15));
//        f18O20.countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed");
//        f18O20.minJumps(new int[]{100, -23, -23, -25, 54, 404, 100, 23, 23, 23, 3, 404});
//        f18O20.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3);
//        System.out.println(1019215872 % 1000000007);

//        f18O20.longestDiverseString(0, 8, 11);


//        f18O20.maxCandies(new int[]{1, 0, 1, 0}, new int[]{7, 5, 4, 100}, new int[][]{{}, {}, {1}, {}}, new int[][]{{1, 2}, {3}, {}, {}}, new int[]{0});
//        f18O20.largestMerge("uuurruuuruuuuuuuuruuuuu", "urrrurrrrrrrruurrrurrrurrrrruu");
//        f18O20.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}});
        f18O20.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}});
//        f18O20.uniquePathsIII(new int[][]{{0,1},{2,0}});

    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && (length - i + stack.size()) > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        int[] res = new int[k];
        while (!stack.isEmpty()) {
            res[--k] = stack.pop();
        }
        return res;
    }

    public long numberOfWeeks(int[] milestones) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int milestone : milestones) {
            map.put(milestone, map.getOrDefault(milestone, 0) + 1);
        }
        long res = 0;
        while (!map.isEmpty()) {
            if (map.size() == 1) {
                Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            }
        }

        return res;
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int max = 1, pre = -1;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        for (int i = 0, j = 0, k; i < buses.length; i++) {
            for (k = capacity; j < passengers.length && passengers[j] <= buses[i] && k > 0; j++, k--) {
                max = pre + 1 != passengers[j] ? passengers[j] - 1 : max;
                pre = passengers[j];
            }
            max = k == 0 || j > 0 && passengers[j - 1] >= buses[i] ? max : buses[i];
        }
        return max;
    }


    private int maxSW = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] targets = new int[26];
        for (char letter : letters) {
            targets[letter - 'a']++;
        }
        dfsMSW(words, 0, targets, score, 0);
        return maxSW;
    }

    private void dfsMSW(String[] words, int startIndex, int[] targets, int[] score, int total) {
        if (startIndex == words.length) {
            maxSW = Math.max(maxSW, total);
            return;
        }
        for (int i = startIndex; i < words.length; i++) {
            String word = words[i];
            int[] clone = targets.clone();
            int sum = 0;
            boolean flag = false;
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                if (clone[index] > 0) {
                    clone[index]--;
                    sum += score[index];
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                targets = clone;
                dfsMSW(words, i + 1, targets, score, total + sum);
                for (int j = 0; j < word.length(); j++) {
                    int index = word.charAt(j) - 'a';
                    targets[index]++;
                }
            }
        }
        maxSW = Math.max(maxSW, total);
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o2[0] - o1[0];
        });
        int length = events.length;
        int[] dp = new int[length];
        dp[0] = events[0][2];
        int max = dp[0];
        for (int i = 1; i < events.length; i++) {
            int tmp = 0;
            int cnt = events[i][2];
            int left = 0, right = i;
            int target = events[i][0];
            while (left <= right) {
                int mid = left + right >> 1;
                if (events[mid][1] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            left = left - 1;
            if (left >= 0 && events[left][1] < events[i][0]) {
                tmp = dp[left];
            }
            dp[i] = Math.max(dp[i - 1], cnt);
            max = Math.max(Math.max(max, dp[i]), cnt + tmp);
        }
        return max;
    }

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            priorityQueue.add(num);
        }
        int[] diff = new int[(int) 1e5];
        for (int[] request : requests) {
            diff[request[0]]++;
            diff[request[1] + 1]--;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        int mod = 1000000007;
        long res = 0;
        Arrays.sort(diff);
        for (int i = diff.length - 1; i >= 0; i--) {
            if (diff[i] != 0) {
                Integer poll = priorityQueue.poll();
                res += (long) poll * diff[i];
                res %= mod;
            } else {
                break;
            }
        }
        return (int) res;
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, windows = 0, res = 1, n = nums.length;
        while (right < n) {
            windows += nums[right];
            while (nums[right] * (right - left + 1) - windows > k) {
                windows -= nums[left];
                left++;
            }
            right++;

            res = Math.max(res, right - left);
        }
        return res;
    }


    public int jump(int[] nums) {
        int cntMax = 0, count = 0;
        int lastMax = 0, n = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] > cntMax) {
                cntMax = i + nums[i];
            }
            if (i == lastMax) {
                count++;
                lastMax = cntMax;
            }
        }
        return count;
    }

    public int minTaps(int n, int[] ranges) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i <= ranges.length; i++) {
            priorityQueue.add(new int[]{Math.max(0, i - ranges[i]), Math.min(n, i + ranges[i])});
        }
        int max = 0, res = 0;
        while (max < n) {
            if (priorityQueue.isEmpty() || priorityQueue.peek()[0] > max) return -1;
            int tmp = max;
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= max) {
                tmp = Math.max(tmp, priorityQueue.poll()[1]);
            }
            if (tmp > max) {
                max = tmp;
                res++;
            }
        }
        return res;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int length = source.length;
        List<Integer>[] edges = new List[length];
        for (int i = 0; i < length; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] allowedSwap : allowedSwaps) {
            edges[allowedSwap[0]].add(allowedSwap[1]);
            edges[allowedSwap[1]].add(allowedSwap[0]);
        }
        boolean[] visited = new boolean[length];
        List<HashSet<Integer>> set = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            if (!visited[i]) {
                set.add(new HashSet<>());
                dfsMinHD(visited, edges, i, set);
            }
        }
        int count = 0;
        for (HashSet<Integer> s : set) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (Integer i : s) {
                map.put(source[i], map.getOrDefault(source[i], 0) + 1);
            }
            for (Integer i : s) {
                if (map.containsKey(target[i])) {
                    map.put(target[i], map.get(target[i]) - 1);
                    if (map.get(target[i]) == 0) {
                        map.remove(target[i]);
                    }
                    count++;
                }
            }
        }
        return source.length - count;
    }

    private void dfsMinHD(boolean[] visited, List<Integer>[] edges, int i, List<HashSet<Integer>> set) {
        if (!visited[i]) {
            visited[i] = true;
            set.get(set.size() - 1).add(i);
            for (Integer integer : edges[i]) {
                dfsMinHD(visited, edges, integer, set);
            }
        }
    }

    /**
     * 记忆化搜索超时
     */
    HashSet<Integer> setCR = new HashSet<>();

    // 超时
//    public boolean canReach(String s, int minJump, int maxJump) {
//        return dfsCR(s, minJump, maxJump, 0);
//    }
    private boolean dfsCR(String s, int minJump, int maxJump, int i) {
        if (i == s.length() - 1) return true;
        if (setCR.contains(i)) return false;
        int left = i + minJump;
        int right = Math.min(i + maxJump, s.length() - 1);
        for (int j = left; j <= right; j++) {
            if (s.charAt(j) == '0') {
                boolean child = dfsCR(s, minJump, maxJump, j);
                if (child) return true;
            }
        }
        setCR.add(i);
        return false;
    }


    /**
     * 差分数组O(n)
     *
     * @param s
     * @param minJump
     * @param maxJump
     * @return
     */
//    public boolean canReach(String s, int minJump, int maxJump) {
//        if (s.charAt(s.length() - 1) == '1') return false;
//        int[] diff = new int[220000];
//        int sum = 0;
//        for (int i = 0; i < s.length(); i++) {
//            sum += diff[i];
//            if (i == 0 || sum > 0 && s.charAt(i) == '0') {
//                diff[i + minJump]++;
//                diff[i + maxJump + 1]--;
//            }
//        }
//        return sum > 0;
//    }

    // 基础dp超时
//    public boolean canReach(String s, int minJump, int maxJump) {
//        int length = s.length();
//        boolean[] dp = new boolean[length];
//        dp[0] = true;
//        for (int i = 0; i < length; i++) {
//            if (dp[i]) {
//                int left = i + minJump;
//                int right = Math.min(i + maxJump, length - 1);
//                for (int j = left; j <= right; j++) {
//                    if (s.charAt(j) == '0') {
//                        dp[j] = true;
//                    }
//                }
//            }
//        }
//        return dp[length - 1];
//    }

    // 添加当前当前能够达到最大值的点
    public boolean canReach(String s, int minJump, int maxJump) {
        int length = s.length();
        boolean[] dp = new boolean[length];
        dp[0] = true;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i]) {
                int left = Math.max(i + minJump, max);
                int right = Math.min(i + maxJump, length - 1);
                for (int j = left; j <= right; j++) {
                    if (s.charAt(j) == '0') {
                        dp[j] = true;
                    }
                    max = Math.max(max, j);
                }
            }
        }
        return dp[length - 1];
    }

    public int minNumberOperations(int[] target) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 0; i < target.length; i++) {
            if (stack.peek() < target[i]) {
                stack.push(target[i]);
            } else if (stack.peek() > target[i]) {
                while (!stack.isEmpty() && stack.peek() > target[i]) {
                    res += stack.pop() - Math.max(target[i], stack.peek());
                }
                stack.push(target[i]);
            }
        }
        res += stack.peek();
        return res;
    }

    public int smallestRepunitDivByK(int k) {
        if ((k & 1) == 0 || k % 5 == 0) return -1;
        int cur = 1, cnt = 1;
        while (cur % k != 0) {
            cur = (cur * 10 + 1) % k;
            cnt++;
        }
        return cnt;
    }

    public String longestPrefix(String s) {
        int[] nextArray = getNextArray(s.toCharArray());
        int n = s.length();
        return s.substring(0, nextArray[n - 1]);
    }

    public int[] getNextArray(char[] ms) {
        int[] next = new int[ms.length];
        int n = ms.length;
        int i = 1;
        int now = 0;
        while (i < n) {
            if (ms[i] == ms[now]) {
                next[i++] = ++now;
            } else if (now > 0) {
                now = next[now - 1];
            } else {
                i++;
            }
        }
        return next;
    }

    public int minDeletionSize(String[] strs) {
        int length = strs[0].length();
        int ans = 0;
        String[] sortedStr = new String[strs.length];
        Arrays.fill(sortedStr, "a");
        for (int i = 0; i < length; i++) {
            String[] clone = sortedStr.clone();
            for (int j = 0; j < strs.length; j++) {
                clone[j] += strs[j].charAt(i);
            }
            if (isSorted(clone)) sortedStr = clone;
            else ans++;

        }
        return ans;
    }

    private boolean isSorted(String[] clone) {
        for (int i = 0; i < clone.length - 1; i++) {
            if (clone[i].compareTo(clone[i + 1]) > 0) return false;
        }
        return true;
    }

    public int maximumGain(String s, int x, int y) {
        int res = 0;
        if (x > y) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == 'a' && s.charAt(i) == 'b') {
                    stack.pop();
                    res += x;
                } else {
                    stack.push(s.charAt(i));
                }
            }
            List<Character> characters = new ArrayList<>(stack);
            stack.clear();
            for (int i = 0; i < characters.size(); i++) {
                if (!stack.isEmpty() && stack.peek() == 'b' && characters.get(i) == 'a') {
                    stack.pop();
                    res += y;
                } else {
                    stack.push(characters.get(i));
                }
            }
        } else {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == 'b' && s.charAt(i) == 'a') {
                    stack.pop();
                    res += y;
                } else {
                    stack.push(s.charAt(i));
                }
            }
            List<Character> characters = new ArrayList<>(stack);
            stack.clear();
            for (int i = 0; i < characters.size(); i++) {
                if (!stack.isEmpty() && stack.peek() == 'a' && characters.get(i) == 'b') {
                    stack.pop();
                    res += x;
                } else {
                    stack.push(characters.get(i));
                }
            }
        }
        return res;
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        boolean[] res = new boolean[n];
        int length = candiesCount.length;
        long[] sum = new long[length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            int dailyCap = queries[i][2];
            res[i] = sum[favoriteType] > favoriteDay && (favoriteType == 0 || sum[favoriteType - 1] < 1L * (favoriteDay + 1) * dailyCap);
        }
        return res;
    }

    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - target)) {
                res++;
                sum = 0;
                set.clear();
                set.add(0);
            } else {
                set.add(sum);
            }
        }

        return res;
    }

    int INF = 100001;

    public int minSumOfLengths1(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = target == arr[0] ? 1 : INF;
        int left = 0, right = 0, sum = 0, res = INF;
        while (right < n) {
            if (right > 0) {
                dp[right] = dp[right - 1];
            }
            sum += arr[right];
            while (sum >= target) {
                if (sum == target) {
                    int len = right - left + 1;
                    dp[right] = Math.min(dp[right], len);
                    if (left > 0) {
                        res = Math.min(res, dp[left - 1] + len);
                    }
                }
                sum -= arr[left++];
            }
            right++;
        }
        return res == INF ? -1 : res;
    }

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] left = dpMSOL(arr, target);
        reverseArray(arr);
        int[] right = dpMSOL(arr, target);
        int res = INF;
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, left[i] + right[n - i - 2]);
        }
        return res >= INF ? -1 : res;
    }

    private void reverseArray(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = tmp;
        }
    }

    private int[] dpMSOL(int[] arr, int target) {
        int length = arr.length, sum = 0;
        int[] ans = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < ans.length; i++) {
            sum += arr[i];
            int sub = sum - target;
            if (map.containsKey(sub)) {
                ans[i] = i - map.get(sub);
            } else {
                ans[i] = INF;
            }
            map.put(sum, i);
        }
        for (int i = 1; i < ans.length; i++) {
            ans[i] = Math.min(ans[i], ans[i - 1]);
        }
        return ans;
    }

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxPath = new long[m][n];
        long[][] minPath = new long[m][n];
        maxPath[0][0] = minPath[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            maxPath[0][i] = minPath[0][i] = grid[0][i] * maxPath[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            maxPath[i][0] = minPath[i][0] = grid[i][0] * maxPath[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxPath[i][j] = Math.max(maxPath[i - 1][j], maxPath[i][j - 1]) * grid[i][j];
                    minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) * grid[i][j];
                } else {
                    maxPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) * grid[i][j];
                    minPath[i][j] = Math.max(maxPath[i - 1][j], maxPath[i][j - 1]) * grid[i][j];
                }
            }
        }
        if (maxPath[m - 1][n - 1] < 0) return -1;
        return (int) (maxPath[m - 1][n - 1] % 1000000007);
    }

    private long maxPP = Integer.MIN_VALUE;

    public int maxProductPath1(int[][] grid) {
        dfsMPP(grid, 0, 0, 1);
        return maxPP < 0 ? -1 : (int) (maxPP % 1000000007);
    }

    private void dfsMPP(int[][] grid, int i, int j, long cnt) {
        if (i >= grid.length || j >= grid[0].length) return;
        cnt *= grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            maxPP = Math.max(maxPP, cnt);
            return;
        }
        // 剪枝处理
        if (cnt == 0) {
            maxPP = Math.max(maxPP, 0);
            return;
        }
        dfsMPP(grid, i + 1, j, cnt);
        dfsMPP(grid, i, j + 1, cnt);
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int length = labels.length();
        boolean[] visited = new boolean[length];
        int[] res = new int[length];
        dfsCST(lists, 0, labels, visited, res);
        return res;
    }

    private int[] dfsCST(ArrayList<Integer>[] lists, int i, String labels, boolean[] visited, int[] res) {
        int[] targets = new int[26];
        if (!visited[i]) {
            visited[i] = true;
            ArrayList<Integer> list = lists[i];
            for (Integer integer : list) {
                int[] child = dfsCST(lists, integer, labels, visited, res);
                for (int j = 0; j < 26; j++) {
                    targets[j] += child[j];
                }
            }
            targets[labels.charAt(i) - 'a']++;
        }
        res[i] = targets[labels.charAt(i) - 'a'];
        return targets;
    }

    // 不对
    public int minJumps1(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length];
        int INF = 100000;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            int tmp = INF;
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    tmp = Math.min(tmp, dp[j] + 1);
                }
            }
            dp[i] = Math.min(dp[i], tmp);
            for (int j = i - 1; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j + 1] + 1);
            }
        }
        return dp[length - 1];
    }

    public int minJumps(int[] arr) {
        int length = arr.length;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            TreeSet<Integer> orDefault = map.getOrDefault(arr[i], new TreeSet<>());
            orDefault.add(i);
            map.put(arr[i], orDefault);
        }
        int[] dp = new int[length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            TreeSet<Integer> treeSet = map.get(arr[cur]);
            for (Integer integer : treeSet) {
                if (dp[integer] == -1) {
                    dp[integer] = dp[cur] + 1;
                    queue.add(integer);
                }
            }
            treeSet.clear();
            if (cur - 1 >= 0 && dp[cur - 1] == -1) {
                dp[cur - 1] = dp[cur] + 1;
                queue.add(cur - 1);
            }
            if (cur + 1 < length && dp[cur + 1] == -1) {
                dp[cur + 1] = dp[cur] + 1;
                queue.add(cur + 1);
            }
        }
        return dp[length - 1];
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        long num1 = 0, num2 = 0, res = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                num1++;
                if (num2 != 0) {
                    map.put(num2, map.getOrDefault(num2, 0l) + 1);
                }
                num2 = 0;
            } else if (nums[i] < left) {
                num2++;
                num1++;
            } else {
                if (num2 != 0) {
                    map.put(num2, map.getOrDefault(num2, 0l) + 1);
                }
                long tmp = (1 + num1) * num1 / 2;
                long t = 0;
                for (Map.Entry<Long, Long> entry : map.entrySet()) {
                    t += entry.getKey() * (entry.getKey() + 1) / 2 * entry.getValue();
                }
                res += tmp - t;
                map.clear();
                num1 = 0;
                num2 = 0;
            }
        }
        if (num2 != 0) {
            map.put(num2, map.getOrDefault(num2, 0l) + 1);
        }
        long tmp = (1 + num1) * num1 / 2;
        long t = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            t += entry.getKey() * (entry.getKey() + 1) / 2 * entry.getValue();
        }
        res += tmp - t;
        return (int) res;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
            double x = (o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1];
            double y = (o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1];
            return -Double.compare(x, y);
        });
        for (int[] aClass : classes) {
            pq.offer(new double[]{aClass[0], aClass[1]});
        }
        while (extraStudents > 0) {
            double[] poll = pq.poll();
            extraStudents--;
            pq.offer(new double[]{poll[0] + 1, poll[1] + 1});
        }
        double res = 0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            double[] poll = pq.poll();
            res += poll[0] / poll[1];
        }
        return res / n;
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        if (a > 0) {
            pq.add(new int[]{0, a});
        }
        if (b > 0) {
            pq.add(new int[]{1, b});
        }
        if (c > 0) {
            pq.add(new int[]{2, c});

        }
        StringBuilder sb = new StringBuilder();
        int pre = -1;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cntK = poll[0];
            int count = poll[1];
            if (pre == cntK) {
                if (pq.isEmpty()) return sb.toString();
                else {
                    int[] poll1 = pq.poll();
                    int tmpK = poll1[0];
                    int tmpC = poll1[1];
                    char tmp = tmpK == 0 ? 'a' : tmpK == 1 ? 'b' : 'c';
                    sb.append(tmp);
                    pre = tmpK;
                    if (tmpC > 1) {
                        pq.add(new int[]{tmpK, tmpC - 1});
                    }
                    pq.add(new int[]{cntK, count});
                }
            } else {
                int max = Math.min(count, 2);
                char tmp = cntK == 0 ? 'a' : cntK == 1 ? 'b' : 'c';
                for (int i = 0; i < max; i++) {
                    sb.append(tmp);
                }
                pre = cntK;
                if (count > 2) {
                    pq.add(new int[]{cntK, count - 2});
                }
            }
        }
        return sb.toString();
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> keySet = new HashSet<>();
        Set<Integer> boxSet = new HashSet<>();
        int res = 0;
        for (int initialBox : initialBoxes) {
            queue.add(initialBox);
            boxSet.add(initialBox);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (status[poll] == 1) {
                if (!visited[poll]) {
                    visited[poll] = true;
                    res += candies[poll];
                    int[] key = keys[poll];
                    int[] containedBox = containedBoxes[poll];
                    for (int k : key) {
                        keySet.add(k);
                    }
                    for (int box : containedBox) {
                        if (status[box] == 1) {
                            queue.add(box);
                        } else {
                            boxSet.add(box);
                        }
                    }
                    Set<Integer> tmp = new HashSet<>(keySet);
                    tmp.retainAll(boxSet);
                    for (Integer integer : tmp) {
                        status[integer] = 1;
                    }
                    queue.addAll(tmp);
                }
            }
        }
        return res;
    }


    public int maxDotProduct1(int[] nums1, int[] nums2) {
        Integer[][] memo = new Integer[nums1.length][nums2.length];
        return dfsMDP(nums1, nums2, 0, 0, memo);
    }

    private int dfsMDP(int[] nums1, int[] nums2, int startIndexI, int startIndexJ, Integer[][] memo) {
        if (startIndexI >= nums1.length || startIndexJ >= nums2.length) {
            return -100001;
        }
        if (null != memo[startIndexI][startIndexJ]) return memo[startIndexI][startIndexJ];
        int ans = nums1[startIndexI] * nums2[startIndexJ];
        int num1 = dfsMDP(nums1, nums2, startIndexI + 1, startIndexJ + 1, memo);
        int num2 = dfsMDP(nums1, nums2, startIndexI, startIndexJ + 1, memo);
        int num3 = dfsMDP(nums1, nums2, startIndexI + 1, startIndexJ, memo);
        ans = Math.max(ans, ans + num1);
        ans = Math.max(ans, num1);
        ans = Math.max(ans, num2);
        ans = Math.max(ans, num3);
        memo[startIndexI][startIndexJ] = ans;
        return ans;
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[][] dp = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int tmp = nums1[i] * nums2[j];
                dp[i][j] = tmp;
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + tmp);
                }
            }
        }
        return dp[l1 - 1][l2 - 1];
    }


    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                int tmpI = i, tmpJ = j;
                while (tmpI < word1.length() && tmpJ < word2.length() && word1.charAt(tmpI) == word2.charAt(tmpJ)) {
                    tmpI++;
                    tmpJ++;
                }
                if (tmpI == word1.length()) {
                    sb.append(word2.charAt(j++));
                } else if (tmpJ == word2.length()) {
                    sb.append(word1.charAt(i++));
                } else if (word1.charAt(tmpI) > word2.charAt(tmpJ)) {
                    sb.append(word1.charAt(i++));
                } else {
                    sb.append(word2.charAt(j++));
                }
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }
        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }
        if (j < word2.length()) {
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }

    int totalUP = 0;

    public int uniquePathsIII(int[][] grid) {
        int startI = 0, startJ = 0;
        int endI = 0, endJ = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    grid[i][j] = 0;
                    set.add(i + "-" + j);
                } else if (grid[i][j] == 2) {
                    endI = i;
                    endJ = j;
                    grid[i][j] = 0;

                } else if (grid[i][j] == 0) {
                    set.add(i + "-" + j);
                }
            }
        }
        dfsUP(grid, startI, startJ, endI, endJ, set);
        return totalUP;
    }

    private void dfsUP(int[][] grid, int startI, int startJ, int endI, int endJ, Set<String> set) {
        if (startI == endI && startJ == endJ && set.size() == 0) {
            totalUP++;
            return;
        }
        if (startI < 0 || startJ < 0 || startI >= grid.length || startJ >= grid[0].length) return;
        if (grid[startI][startJ] == -1) return;
        if (!set.contains(startI + "-" + startJ)) return;
        set.remove(startI + "-" + startJ);
        dfsUP(grid, startI - 1, startJ, endI, endJ, set);
        dfsUP(grid, startI + 1, startJ, endI, endJ, set);
        dfsUP(grid, startI, startJ - 1, endI, endJ, set);
        dfsUP(grid, startI, startJ + 1, endI, endJ, set);
        set.add(startI + "-" + startJ);
    }

    class MyNode {
        int node;
        double score;
    }



    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});
            graph[edges[i][1]].add(new double[]{edges[i][0], succProb[i]});
        }
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2[1], o1[1]));
        queue.add(new double[]{start, 1});
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            double[] head = queue.poll();
            if (head[0] == end) {
                return head[1];
            } else if (!visited[(int) head[0]]) {
                visited[(int) head[0]] = true;
                for (double[] next : graph[(int) head[0]]) {
                    queue.add(new double[]{next[0], head[1] * next[1]});
                }
            }
        }
        return 0;
    }



}
