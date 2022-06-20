package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class MainCompetition1 {
    public static void main(String[] args) {
        MainCompetition1 c_283 = new MainCompetition1();
//        List<String> list = c_283.cellsInRange("K1:L2");
//        System.out.println(list);
//        long l = c_283.minimalKSum(new int[]{53, 41, 90, 33, 84, 26, 50, 32, 63, 47, 66, 43, 29, 88, 71, 28, 83}, 76);  //3444
//        long l = c_283.minimalKSum(new int[]{5,6}, 6);
//        TreeNode binaryTree = c_283.createBinaryTree(new int[][]{{85, 82, 1}, {74, 85, 1}, {39, 70, 0}, {82, 38, 1}, {74, 39, 0}, {39, 13, 1}});
//        System.out.println(binaryTree);
//        c_283.findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1);
//        c_283.digArtifacts(9, new int[][]{{4, 5, 5, 5}, {5, 1, 7, 1}, {1, 8, 3, 8}, {1, 1, 1, 2}, {0, 5, 3, 5}, {6, 2, 7, 2}, {7, 5, 7, 6}, {6, 4, 6, 6}, {2, 7, 5, 7}, {0, 2, 0, 2}, {7, 7, 8, 8}, {3, 1, 4, 2}, {2, 3, 3, 3}, {5, 3, 7, 3}, {8, 4, 8, 4}, {2, 6, 5, 6}, {8, 1, 8, 2}, {4, 8, 4, 8}, {1, 0, 4, 0}, {6, 8, 6, 8}, {1, 3, 1, 4}, {0, 7, 0, 8}, {0, 3, 0, 4}, {0, 6, 0, 6}}, new int[][]{{0, 3}, {0, 4}, {8, 5}, {8, 6}, {8, 7}, {0, 8}, {8, 8}, {0, 6}, {1, 1}, {1, 8}, {2, 0}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 8}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3, 7}, {4, 0}, {4, 3}, {4, 4}, {4, 6}, {4, 7}, {5, 1}, {5, 2}, {5, 6}, {5, 8}, {6, 0}, {6, 2}, {6, 4}, {6, 5}, {6, 6}, {7, 0}, {7, 1}, {7, 4}, {7, 5}, {7, 7}});
//        c_283.digArtifacts(13, new int[][]{{1, 0, 1, 0}, {0, 9, 0, 12}, {6, 12, 8, 12}, {7, 7, 7, 9}, {9, 3, 12, 3}, {10, 10, 10, 12}, {7, 1, 7, 4}, {10, 6, 12, 6}, {11, 0, 12, 1}, {8, 0, 8, 0}, {0, 2, 0, 2}, {8, 9, 8, 9}, {9, 7, 12, 7}, {6, 8, 6, 9}, {7, 6, 9, 6}, {2, 3, 4, 3}, {9, 10, 9, 12}, {3, 9, 5, 9}, {6, 7, 6, 7}, {11, 9, 11, 11}, {2, 6, 2, 6}, {2, 8, 5, 8}, {5, 10, 5, 12}, {6, 5, 9, 5}, {4, 4, 6, 4}, {6, 10, 6, 11}, {2, 1, 2, 2}, {1, 12, 3, 12}, {1, 3, 1, 3}, {2, 9, 2, 9}, {1, 7, 1, 10}, {5, 2, 5, 3}}
//                , new int[][]{{0, 0}, {0, 1}, {0, 3}, {0, 6}, {0, 8}, {0, 9}, {0, 12}, {2, 0}, {2, 2}, {2, 3}, {2, 4}, {2, 6}, {2, 9}, {2, 10}, {2, 12}, {4, 0}, {4, 4}, {4, 5}, {4, 7}, {4, 8}, {4, 9}, {4, 11}, {4, 12}, {6, 0}, {6, 2}, {6, 3}, {6, 5}, {6, 6}, {6, 7}, {6, 9}, {6, 10}, {8, 0}, {8, 1}, {8, 2}, {8, 4}, {8, 5}, {8, 6}, {8, 8}, {10, 1}, {10, 2}, {10, 3}, {10, 4}, {10, 5}, {10, 6}, {10, 8}, {10, 9}, {10, 10}, {10, 11}, {12, 0}, {12, 1}, {12, 2}, {12, 3}, {12, 4}, {12, 5}, {12, 6}, {12, 8}, {12, 9}, {12, 11}, {1, 2}, {1, 4}, {1, 8}, {1, 9}, {1, 10}, {1, 11}, {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 7}, {3, 8}, {5, 0}, {5, 1}, {5, 2}, {5, 4}, {5, 6}, {5, 12}, {7, 0}, {7, 1}, {7, 3}, {7, 4}, {7, 5}, {7, 7}, {7, 8}, {7, 9}, {7, 10}, {7, 11}, {7, 12}, {9, 1}, {9, 2}, {9, 5}, {9, 6}, {9, 9}, {9, 10}, {9, 11}, {9, 12}, {11, 0}, {11, 1}, {11, 2}, {11, 3}, {11, 5}, {11, 6}, {11, 7}, {11, 8}, {11, 9}, {11, 10}, {11, 12}}
//        );
//        c_283.maximumTop(new int[]{35, 43, 23, 86, 23, 45, 84, 2, 18, 83, 79, 28, 54, 81, 12, 94, 14, 0, 0, 29, 94, 12, 13, 1, 48, 85, 22, 95, 24, 5, 73, 10, 96, 97, 72, 41, 52, 1, 91, 3, 20, 22, 41, 98, 70, 20, 52, 48, 91, 84, 16, 30, 27, 35, 69, 33, 67, 18, 4, 53, 86, 78, 26, 83, 13, 96, 29, 15, 34, 80, 16, 49}
//                , 15);
//        c_283.maximumTop(new int[]{91, 98, 17, 78}, 2);
//        c_283.divideArray(new int[]{3, 3, 2, 2, 2, 2});
//        c_283.halveArray(new int[]{5, 19, 8, 1});
//        c_283.maximumSubsequenceCount("baab", "ab");
//        System.out.println(c_283.maximumSubsequenceCount("hechrqwdlespsmpdrdiyahpviycmakeqdiiqftsutpxgyjuczmgbhjfiarhsjhhcfohovmbdqnjktrrupwqcllayjzsakhjjgmhxhrylrnopkyvycuxozvwdbrikdwcvparbcjjwbikhhwwgidlsaxocwhhuwtufoljqfmokahvicxzqyhlyefzfbmrmcppyftkufdjzsafmxdgrcjrgtxgtfcrvgyswbhiawmgrjanapmgmurcfirqozjormjmloyazdgcofdijaysmauudxfzuuspeyhjoixvtwysoggphnsktlydfaeoxyhjurgqkrwndsonlsujzcrgepwvcbanjfoyxkiywghrdvwafagjveaumsreyxhoscrvwddjhgoremoktepoplihnhvgdnhcdltkfgxwtpvcionqceoddfpsgoacdyxawwxnlwirskybkptwvwxfpyioedrzartrjebzvztvjurdyfwulbnpolfbsalcqmxjlinkhobzkrnmcepryktmxafgqqukdulpbmycpykwdsbqrucnskcrdzjotptvrpludwfuoeqhdqrhylolgbhgrvncoydtkxuohqrlholkcrhpytcjohxcgyajiozujzkrrzxotepkojcqablgxkfxizdupvnuzsxpyziuvgfxrzlzsoghzgozinsjbvplbjrpbznkosslgmuzvgqtqntvgsfzxticuoimwwelmdbntxdrtkfsiunsiclomadqdiiyvgnuffanriibqlvuyklwulvbrlawqlhsadbllfdryxkgnmqskdczfihtdnhdxwesncysqypjpvkhzzeddezuqsezzrdtoscopgghvsfrlgplaz"
//                , "kk"));
//        c_283.countHillValley(new int[]{2, 4, 1, 1, 1, 6, 5});
//        c_283.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR");
//        c_283.maximumBobPoints(729, new int[]{56, 81, 32, 233, 85, 39, 15, 7, 11, 106, 59, 5});
//        c_283.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});
//        c_283.minDeletion(new int[]{1, 1, 2, 3, 5});
//        c_283.minDeletion(new int[]{0, 6, 6, 1, 8, 7});
//        c_283.minDeletion(new int[]{1, 1, 2, 2, 3, 3});

//        c_283.kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, 3);
//        c_283.kthPalindrome(new int[]{2, 4, 6}, 4);
//        c_283.minBitFlips(10, 7);
//        c_283.triangularSum(new int[]{1, 2, 3, 4, 5});
        c_283.numberOfWays("0001100100");
//        c_283.numberOfWays("001101");
//        c_283.convertTime("09:41", "10:34");
//        c_283.maximumCandies(new int[]{5, 8, 6}, 3);
//        c_283.maximumCandies(new int[]{2, 5}, 11);
//        c_283.maximumCandies(new int[]{2, 8, 8}, 2);
    }


    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        String[] alp = new String[26];
        for (int i = 0; i < alp.length; i++) {
            int temp = 65 + i;
            char c = (char) temp;
            alp[i] = c + "";
        }
        char col1 = s.charAt(0);
        Integer row1 = s.charAt(1) - '0';
        char col2 = s.charAt(3);
        Integer row2 = s.charAt(4) - '0';
        int start = col1 - 65;
        int end = col2 - 65;

        for (int i = start; i <= end; i++) {
            for (int j = row1; j <= row2; j++) {
                list.add(alp[i] + j);
            }
        }

        return list;
    }


    /*public long minimalKSum(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int num = set.last();
        long res = 0;
        for (int i = 1; i < num && k > 0; i++) {
            if (!set.contains(i)) {
                res += i;
                k--;
            }
        }
        int last = num;
        while (k > 0) {
            res += ++last;
            k--;
        }
        return res;
    }*/

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0, start = 1;
        for (int i = 0; i < nums.length && k > 0; i++) {
            // 如果数组的最小值大于最开始的值
            if (nums[i] > start) {
                // 计算步长
                int cnt = (int) (nums[i] - start) > k ? k : (int) (nums[i] - start);
                // 高斯加法(首相+末项)*项数/2
                res += (2L * start + cnt - 1) * cnt / 2;
                // 减去步长
                k -= cnt;
            }
            start = nums[i] + 1;
        }
        // 如果此时还大于0
        if (k > 0) {
            res += (2L * start + k - 1) * k / 2;
        }
        return res;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        // 查找根节点
        Set<Integer> setParent = new HashSet<>();
        Set<Integer> setChild = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            setParent.add(descriptions[i][0]);
            setChild.add(descriptions[i][1]);
        }
        // 查找根节点
        setParent.removeAll(setChild);
        Integer next = setParent.iterator().next();
        TreeNode root = new TreeNode(next);
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(next, root);
        for (int[] description : descriptions) {
            int cntParentValue = description[0];
            int cntChildValue = description[1];
            int direction = description[2];
            // 如果两个都不包含
            if (!map.containsKey(cntChildValue) && !map.containsKey(cntParentValue)) {
                TreeNode cntParent = new TreeNode(cntParentValue);
                TreeNode cntChild = new TreeNode(description[1]);
                if (direction == 1) {
                    cntParent.left = cntChild;
                } else {
                    cntParent.right = cntChild;
                }
                map.put(cntParentValue, cntParent);
                map.put(cntChildValue, cntChild);
            }
            // 如果包含父节点不包子节点
            else if (!map.containsKey(cntChildValue) && map.containsKey(cntParentValue)) {
                TreeNode treeNode = map.get(cntParentValue);
                TreeNode child = new TreeNode(description[1]);
                if (direction == 1) {
                    treeNode.left = child;
                } else {
                    treeNode.right = child;
                }
                map.put(cntChildValue, child);
            }

            // 如果不包含父节点包子节点
            else if (map.containsKey(cntChildValue) && !map.containsKey(cntParentValue)) {
                TreeNode cntParent = new TreeNode(cntParentValue);
                if (direction == 1) {
                    cntParent.left = map.get(cntChildValue);
                } else {
                    cntParent.right = map.get(cntChildValue);
                }
                map.put(cntParentValue, cntParent);
            } else {
                TreeNode cntParent = map.get(cntParentValue);
                TreeNode cntChild = map.get(cntChildValue);
                if (direction == 1) {
                    cntParent.left = cntChild;
                } else {
                    cntParent.right = cntChild;
                }
            }
        }
        return root;
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        TreeSet<Integer> setTarget = new TreeSet<>();

        // 遍历找到目下表
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                setTarget.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = setTarget.ceiling(i);
            Integer floor = setTarget.floor(i);
            if (ceiling != null && floor != null) {
                int abs = Math.abs(i - floor);
                if (abs <= k) {
                    set.add(i);
                    continue;
                }
                abs = Math.abs(i - ceiling);
                if (abs <= k) {
                    set.add(i);
                    continue;
                }
            } else if (ceiling != null && floor == null) {
                int abs = Math.abs(i - ceiling);
                if (abs <= k) {
                    set.add(i);
                }
            } else if (ceiling == null && floor != null) {
                int abs = Math.abs(i - floor);
                if (abs <= k) {
                    set.add(i);
                }
            }

        }


        res.addAll(set);

        return res;


    }

    /* public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
         HashSet<List<Integer>> set = new HashSet<>();
         for (int[] i : dig) {
             set.add(List.of(i[0], i[1]));
         }
         int count = 0;
         for (int[] artifact : artifacts) {
             count += digArtifacts(artifact, set);
         }
         return count;
     }

     private int digArtifacts(int[] artifact, HashSet<List<Integer>> set) {
         for (int i = artifact[0]; i <= artifact[2]; i++) {
             for (int j = artifact[1]; j <= artifact[3]; j++) {
                 if (!set.contains(List.of(i, j))) {
                     return 0;
                 }
             }
         }
         return 1;
     }*/
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        HashSet<List<Integer>> set = new HashSet<>();
        for (int[] ints : dig) {
            set.add(List.of(ints[0], ints[1]));
        }
        int count = 0;

        for (int[] artifact : artifacts) {
            boolean flag = false;
            for (int i = artifact[0]; i <= artifact[2]; i++) {
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    if (!set.contains(List.of(i, j))) {
                        flag = true;
                    }
                }
            }
            if (!flag)
                count++;
        }
        return count;

    }

//    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
//        int res = 0;
//        Map<Integer, Set<Integer>> row = new HashMap<>();
//        Map<Integer, Set<Integer>> col = new HashMap<>();
//        for (int[] ints : dig) {
//            int rowItem = ints[0];
//            int colItem = ints[1];
//            Set<Integer> orDefault = row.getOrDefault(rowItem, new TreeSet<>());
//            orDefault.add(colItem);
//            row.put(rowItem, orDefault);
//            Set<Integer> orDefault1 = col.getOrDefault(colItem, new TreeSet<>());
//            orDefault1.add(rowItem);
//            col.put(colItem, orDefault1);
//        }
//        for (int[] artifact : artifacts) {
//            boolean rowFlag = artifact[0] == artifact[2] ? true : false;
//            boolean colFlag = artifact[1] == artifact[3] ? true : false;
//            // 如果是行
//            if (rowFlag && !colFlag) {
//                Set<Integer> orDefault = row.getOrDefault(artifact[0], new TreeSet<>());
//                boolean flag = true;
//                for (int i = artifact[1]; i <= artifact[3]; i++) {
//                    boolean contains = orDefault.contains(i);
//                    if (!contains) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    res++;
//
//                }
//            } else if (!rowFlag && colFlag) {
//                Set<Integer> orDefault = col.getOrDefault(artifact[1], new TreeSet<>());
//                boolean flag = true;
//                for (int i = artifact[0]; i <= artifact[2]; i++) {
//                    boolean contains = orDefault.contains(i);
//                    if (!contains) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    res++;
//
//                }
//            } else if (rowFlag && colFlag) {
//                if (row.containsKey(artifact[0])) {
//                    boolean contains = row.get(artifact[0]).contains(artifact[1]);
//                    if (contains) {
//                        res++;
//                        continue;
//                    }
//                }
//
//                if (col.containsKey(artifact[1])) {
//                    boolean contains = col.get(artifact[1]).contains(artifact[0]);
//                    if (contains) {
//                        res++;
//                        continue;
//                    }
//                }
//
//            } else {
//
//            }
//        }
//
//
//        return res;
//
//    }

    public boolean equals(int[] a, int[] a2) {
        if (a == a2) return true;
        if (a == null || a2 == null) return false;
        int length = a.length;
        if (a2.length != length) return false;
        for (int i = 0; i < length; i++)
            if (a[i] != a2[i]) return false;
        return true;
    }

    public int maximumTop(int[] nums, int k) {
        int length = nums.length;
        if (length == 1 && k % 2 == 1)
            return -1;
        if (k == 0)
            return nums[0];
        if (k == 1)
            return nums[1];
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }
        // 如果k大于数组的长度，则直接返回最大值
        if (k > length) {
            return max[length - 1];
        } else if (k == length) {
            return max[length - 2];
        } else {
            int currentMax = max[k - 2];
            int current = nums[k];
            current = Math.max(current, currentMax);
            return current;
        }
    }

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0) + 1;
            map.put(num, orDefault);
        }
        int length = nums.length;
        int half = length / 2;

        int size = map.size();
        if (size > half) {
            return false;
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            count += value / 2;
        }
        return count == half;
    }

    public int halveArray(int[] nums) {
        PriorityQueue<Double> treeSet = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else if (o1 > o2) {
                    return -1;
                } else
                    return 1;
            }
        });
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            treeSet.add((double) nums[i]);
        }
        double half = sum / 2;
        int total = 0;
        while (half < sum) {
            Double aDouble = treeSet.poll();
            double tmp = aDouble / 2;
            treeSet.add(tmp);
            sum -= tmp;

            total++;
        }
        return total;


    }
    //496

   /* public long maximumSubsequenceCount(String text, String pattern) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            TreeSet<Integer> orDefault = map.getOrDefault(text.charAt(i), new TreeSet<>());
            orDefault.add(i);
            map.put(text.charAt(i), orDefault);
        }
        TreeSet<Integer> s1 = map.getOrDefault(pattern.charAt(0), new TreeSet<>());
        TreeSet<Integer> s2 = map.getOrDefault(pattern.charAt(1), new TreeSet<>());
        if (s1.size() == 0 && s2.size() == 0)
            return 0;
        if (s1.size() == 0 && s2.size() != 0)
            return s2.size();
        if (s2.size() != 0 && s2.size() == 0)
            return s1.size();
        if (pattern.charAt(0) == pattern.charAt(1)) {
            long size = map.get(pattern.charAt(0)).size();
            if (size % 2 == 0) {
                return (size + 1) * (size / 2);
            } else {
                return size * (size + 1) / 2;
            }
        }
        // 添加第一个在左边
        long tmp = s2.size();
        Iterator<Integer> iterator = s1.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            int size = s2.tailSet(next).size();
            tmp += size;
        }
        Iterator<Integer> iterator1 = s1.iterator();
        long tmp1 = s1.size();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            int size = s2.tailSet(next).size();
            tmp1 += size;
        }


        return Math.max(tmp1, tmp);
    }*/

    public long maximumSubsequenceCount(String text, String pattern) {
        char first = pattern.charAt(0);
        char last = pattern.charAt(1);
        // 在左侧添加0
        long countA = first == last ? 0 : 1;
        long resA = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == first) {
                countA++;
            }
            if (text.charAt(i) == last) {
                resA += countA;
            }
        }
        // 在右侧添加1
        long resB = 0;
        long tmpA = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == first) {
                tmpA++;
            }
            if (text.charAt(i) == last) {
                resB += tmpA;
            }
        }
        resB = last == first ? resB : resB + tmpA;
        return Math.max(resA, resB);
    }

    /*public long maximumSubsequenceCount(String text, String pattern) {
        long countA = 0;
        long countB = 0;
        char first = pattern.charAt(0);
        char last = pattern.charAt(1);
        long res = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == first) {
                countA++;
            }
            if (text.charAt(i) == last) {
                countB++;
                res += countA;
            }
        }
        return first == last ? res : Math.max(res + countA, res + countB);
    }*/


    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int current = nums[i];
            int right = i + 1;
            int left = i - 1;
            // 计算右边不等于i
            while (right < nums.length && current == nums[right]) {
                right++;
                i = right - 1;
            }
            while (left >= 0 && current == nums[left]) {
                left--;
            }
            if (left < 0 || right >= nums.length)
                continue;
            if (nums[left] < current && current > nums[right])
                count++;
            if (nums[left] > current && nums[right] > current)
                count++;
        }

        return count;
    }

    public int countCollisions(String directions) {
        int res = 0;
        int length = directions.length();
        StringBuilder sb = new StringBuilder(directions);
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) == 'S')
                continue;
            else if (sb.charAt(i) == 'R') {
                if (i + 1 == length) {
                    continue;
                }
                if (sb.charAt(i + 1) == 'L') {
                    res += 2;
                    sb.setCharAt(i + 1, 'S');
                } else if (sb.charAt(i + 1) == 'S') {
                    res++;
                } else {
                    int next = i + 1;
                    int total = 1;
                    while (next < length && sb.charAt(next) == 'R') {
                        sb.setCharAt(next, 'S');
                        next++;
                        total++;
                    }
                    i += total;
                    if (next == length)
                        continue;
                    if ('L' == sb.charAt(next))
                        res += total + 1;
                    else
                        res += total;
                    sb.setCharAt(next, 'S');

                }
            } else {
                if (i == 0) {
                    continue;
                } else {
                    if (sb.charAt(i - 1) == 'S') {
                        res++;
                        sb.setCharAt(i, 'S');
                    }
                }
            }
        }

        return res;

    }

    // 想成了背包问题===》》求出密度最高的，可以算出可行解，但不是最优解。
   /* public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] res = new int[12];
        double[] midu = new double[12];
        int total = 0;
        for (int i = 0; i < aliceArrows.length; i++) {
            total += aliceArrows[i] == 0 ? 0 : i;
            int aliceArrow = aliceArrows[i];
            midu[i] = (1 - (aliceArrow + 1) / (double) numArrows) * i;
        }
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1])
                    return 0;
                if (o1[1] > o2[1])
                    return -1;
                else
                    return 1;
            }
        });
        for (int i = 0; i < midu.length; i++) {
            double[] doubles = new double[2];
            doubles[0] = i;
            doubles[1] = midu[i];
            priorityQueue.add(doubles);
        }
        int b = numArrows;
        while (b > 0) {
            double[] poll = priorityQueue.poll();
            double v = poll[0];
            int index = (int) v;
            int a = aliceArrows[index] + 1;
            res[index] = a;
            b -= a;
        }
        return res;
    }*/
    int globalMax = 0;
    int[] res = new int[12];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] currentNum = new int[12];
        dfs(numArrows, aliceArrows, 11, 0, currentNum);
        return res;
    }

    private void dfs(int numArrows, int[] aliceArrows, int index, int currentTotal, int[] currentNum) {
        // 递归出口，如果当前的箭全部射出，则循环结束
        if (numArrows == 0 || index == -1) {
            if (index == -1) {
                currentNum[0] += numArrows;
            }
            if (currentTotal > globalMax) {
                globalMax = currentTotal;
                System.arraycopy(currentNum, 0, res, 0, 12);
            }
            return;
        }
        for (int i = index; i >= 0; i--) {
            // 判断Bob想要赢下当前的靶
            int cntAlice = aliceArrows[i];
            // 能够赢下
            if (numArrows - 1 >= cntAlice) {
                currentTotal += i;
                numArrows -= (cntAlice + 1);
                currentNum[i] = cntAlice + 1;
                dfs(numArrows, aliceArrows, i - 1, currentTotal, currentNum);
                numArrows += (cntAlice + 1);
                currentNum[i] = 0;
                currentTotal -= i;
            }
        }
        if (index == 0) {
            currentNum[0] += numArrows;
        }
        if (currentTotal > globalMax) {
            globalMax = currentTotal;
            System.arraycopy(currentNum, 0, res, 0, 12);
        }

    }


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> tmp1 = new HashSet<>(set1);

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        Set<Integer> tmp2 = new HashSet<>(set2);
        set1.removeAll(set2);
        set2.removeAll(tmp1);
        res.add(new ArrayList<>(set1));
        res.add(new ArrayList<>(set2));
        return res;

    }

    public int minDeletion(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i - count) % 2 != 0)
                continue;
            if (nums[i] == nums[i + 1])
                count++;
        }
        int length = nums.length;
        if (length % 2 == 0) {
            if (count % 2 == 0) {
                return count;
            } else {
                return count + 1;
            }
        } else {
            if (count % 2 == 0) {
                return count + 1;
            } else {
                return count;
            }
        }

    }


    /**
     * 回文数找规律
     * 那n=5举例(回文数顺序)
     * 10001，10101，10201，10201，10301，10501，10601，10701，10801，10901，11011...99999
     * 可以发现可以通过回文数的一般来构造，并且时递增的(100-999)
     * n=6举例
     * 100001,101101,102201,103301,104401...999999
     * 可以发现也是通过一半来构造的，并且递增的(100-999)
     * 奇数和偶数构造的方法不同，但是都是递增顺序的
     *
     * @param queries
     * @param intLength
     * @return
     */
    public long[] kthPalindrome(int[] queries, int intLength) {
        int total = queries.length;
        long[] res = new long[total];
        long min = (long) Math.pow(10, (intLength + 1) / 2 - 1);
        long max = (long) Math.pow(10, (intLength + 1) / 2) - 1;
        boolean flag = false;
        if (intLength % 2 == 0) {
            flag = true;
        }
        for (int i = 0; i < queries.length; i++) {
            // 计算回文数左边
            long halfPalindrome = min + queries[i] - 1;
            // 如果当前偏移量大于最大值则直接返回-1
            if (halfPalindrome > max) {
                res[i] = -1;
                continue;
            }
            // 如果当前时偶数直接反转并且拼接
            StringBuilder sb = new StringBuilder(String.valueOf(halfPalindrome));
            if (flag) {
                res[i] = Long.parseLong(sb.toString() + sb.reverse().toString());
            } else {
                String str = sb.toString();
                str = str.substring(0, str.length() - 1);
                StringBuilder sb1 = new StringBuilder(str);
                res[i] = Long.parseLong(sb.toString() + sb1.reverse().toString());
            }
        }
        return res;
    }

    /**
     * 暴力求解：超时
     * 1.求出区间
     * 2.求出区间的回文数
     * 3.从queries中定位
     *
     * @param
     * @param
     * @return
     */
   /* public long[] kthPalindrome(int[] queries, int intLength) {
        long start = (long) Math.pow(10, intLength - 1);
        long end = (long) Math.pow(10, intLength) - 1;
        List<Long> list = palindromeF(start, end);
        int listLength = list.size();
        int length = queries.length;
        long[] res = new long[length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = queries[i] > listLength ? -1 : list.get(queries[i] - 1);
        }
        return res;
    }*/
    private List<Long> palindromeF(long start, long end) {
        List<Long> list = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            // 判断是不是回文数字
            if (isPalindrome(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isPalindrome(long i) {
        String str = String.valueOf(i);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    public int minBitFlips(int start, int goal) {
        String startStr = Integer.toBinaryString(start);
        String goalStr = Integer.toBinaryString(goal);
        int leng1 = startStr.length();
        int leng2 = goalStr.length();
        if (leng1 > leng2) {
            int tmp = leng1 - leng2;

            for (int i = 0; i < tmp; i++) {
                goalStr = "0" + goalStr;
            }

        } else if (leng1 < leng2) {
            int tmp = leng2 - leng1;
            for (int i = 0; i < tmp; i++) {
                startStr = "0" + startStr;
            }
        }
        int total = startStr.length();
        int res = 0;
        for (int i = 0; i < total; i++) {
            if (startStr.charAt(i) != goalStr.charAt(i))
                res++;
        }

        return res;

    }


    public int triangularSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < list.size() - 1; j++) {
                int count = (list.get(j) + list.get(j + 1)) % 10;
                tmp.add(count);
            }
            list.clear();
            list.addAll(tmp);
        }
        return list.get(0);

    }

  /*  public long numberOfWays(String s) {
        long res = 0;
        // 选取两个0和一个1
        int left = 0;
        int right = s.length() - 1;
        // 统计第一次出现的0
        while (s.charAt(left) != '0') {
            left++;
        }
        while (s.charAt(right) != '0') {
            right--;
        }
        int count = 0;
        for (int i = left; i < right; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        res += count;

        while (left < right) {
            // 统计区间1的数量
            while (s.charAt(left++) == '1' && left < right) {
                count--;
            }
            if (left < right) {
                res += count;
                left++;
            }
        }

        left = 0;
        right = s.length() - 1;
        count = 0;

        // 统计第一次出现的1
        while (s.charAt(left) != '1') {
            left++;
        }
        while (s.charAt(right) != '1') {
            right--;
        }
        for (int i = left; i < right; i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        res += count;
        while (left < right) {
            // 统计区间1的数量
            while (s.charAt(left++) == '0' && left < right) {
                count--;
            }
            if (left < right) {
                res += count;
                left++;
            }
        }

        return res;

    }*/


    /**
     * 用前缀和的思路
     * 随机挑选且不重复（只有0/1）==》则有两者情况满足条件 010 101
     * 1.当前位置为0时，求出左边，和右边1的个数，进行相乘
     * 2.当前位置为1时，求出左边，和右边0的个数，进行相乘
     * 将两个数相加之后就可以得到结果
     *
     * @param s
     * @return
     */
    /*public long numberOfWays(String s) {
        int length = s.length();
        int[] l2r0 = new int[length];
        int[] l2r1 = new int[length];
        if (s.charAt(0) == '0') {
            l2r0[0] = 1;
        } else {
            l2r1[0] = 1;
        }
        // 从左到右遍历
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                l2r0[i] = l2r0[i - 1] + 1;
                l2r1[i] = l2r1[i - 1];
            } else {
                l2r1[i] = l2r1[i - 1] + 1;
                l2r0[i] = l2r0[i - 1];
            }
        }
        int[] r2l0 = new int[length];
        int[] r2l1 = new int[length];
        if (s.charAt(length - 1) == '0') {
            r2l0[length - 1] = 1;
        } else {
            r2l1[length - 1] = 1;
        }
        // 从右到左遍历
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                r2l0[i] = r2l0[i + 1] + 1;
                r2l1[i] = r2l1[i + 1];
            } else {
                r2l1[i] = r2l1[i + 1] + 1;
                r2l0[i] = r2l0[i + 1];
            }
        }
        long count = 0;
        for (int i = 1; i < length - 1; i++) {
            // 如果当前的值为0,求出前面和后面1的数量
            if (s.charAt(i) == '0') {
                int left = l2r1[i];
                int right = r2l1[i];
                count += left * right;
            } else {
                int left = l2r0[i];
                int right = r2l0[i];
                count += left * right;
            }
        }
        return count;
    }*/

    /**
     * 上面的思路太费空间了，思考如何降低空间复杂度
     * 对于每个位置，我们需要前后相反的数量
     * 思考，我们可以应数组统计前面出现的0/1的数量，用i-数量就是剩下的另一个的数量
     * 同时维护一个后缀数组，记录0/1的数量，另外一个后面的算法是 length - i -另外的，或者length -前三者
     *
     * @param s
     * @return
     */
    public long numberOfWays(String s) {
        int length = s.length();
        int[] r2l1 = new int[length];
        long count = 0;
        long one = 0;
        if (s.charAt(length - 1) != '0')
            r2l1[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                r2l1[i] = r2l1[i + 1] + 1;
            } else {
                r2l1[i] = r2l1[i + 1];
            }
        }
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                count += one * r2l1[i];
            } else {
                long pZero = i - one;
                long tZero = length - i - r2l1[i];
                count += pZero * tZero;
                one++;
            }
        }
        return count;
    }


    public int convertTime(String current, String correct) {
        if (correct.equals(current))
            return 0;
        int res = 0;
        String[] split1 = current.split(":");
        String[] split2 = correct.split(":");
        String s1 = split1[0];
        String s2 = split1[1];

        String s3 = split2[0];
        String s4 = split2[1];
        int min = Integer.parseInt(s4) - Integer.parseInt(s2);
        int hour = Integer.parseInt(s3) - Integer.parseInt(s1);
        int tmp = hour * 60;
        if (min > 0) {
            tmp += min;
        } else if (min < 0) {
            tmp += -Integer.parseInt(s2) + Integer.parseInt(s4);
        }
        while (tmp >= 60) {
            res++;
            tmp -= 60;
        }
        while (tmp >= 15) {
            res++;
            tmp -= 15;
        }

        while (tmp >= 5) {
            res++;
            tmp -= 5;
        }
        while (tmp >= 1) {
            res++;
            tmp--;
        }
        return res;
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> lose = new HashMap<>();
        for (int[] match : matches) {
            int tmpW = match[0];
            int tmpL = match[1];
            win.put(tmpW, win.getOrDefault(tmpW, 0) + 1);
            lose.put(tmpL, lose.getOrDefault(tmpL, 0) + 1);
        }
        TreeSet<Integer> winlist = new TreeSet<>();
        TreeSet<Integer> lose1list = new TreeSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : win.entrySet()) {
            Integer key = entry.getKey();
            if (!lose.containsKey(key)) {
                winlist.add(key);
            } else {
                Integer integer = lose.get(key);
                if (integer == 1) {
                    lose1list.add(key);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : lose.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1) {
                lose1list.add(entry.getKey());
            }
        }
        List<Integer> list1 = new ArrayList<>(winlist);
        List<Integer> list2 = new ArrayList<>(lose1list);
        list.add(list1);
        list.add(list2);

        return list;

    }

    /**
     * 用二分，进行折半查找，每次取中间值，用candies中的数组除以当前的mid,看能够分成几个堆，
     * 类级全部满足的情况，如果总和大于K,则表明还有最大值，如果小于k则表明不满足
     *
     * @param candies
     * @param k
     * @return
     */
    public int maximumCandies(int[] candies, long k) {
        long left = 0;
        long right = 10000000;
        while (left < right) {
            long mid = (right + left + 1) / 2;
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

}
