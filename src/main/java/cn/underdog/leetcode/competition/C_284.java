package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/320:28
 */
public class C_284 {

    public static void main(String[] args) {
        C_284 c_284 = new C_284();
        c_284.digArtifacts_1(12, new int[][]{{5, 4, 5, 6}, {0, 7, 2, 7}, {8, 1, 10, 1}, {8, 11, 8, 11}, {6, 3, 9, 3}, {0, 8, 2, 8}, {1, 5, 3, 5}, {0, 11, 2, 11}, {7, 5, 7, 5}, {10, 6, 10, 6}, {5, 1, 5, 1}, {4, 10, 7, 10}, {8, 7, 11, 7}, {2, 0, 2, 3}, {3, 6, 3, 8}, {1, 9, 2, 10}, {4, 0, 5, 0}, {7, 6, 9, 6}, {4, 1, 4, 2}, {1, 6, 2, 6}, {9, 0, 11, 0}, {1, 0, 1, 0}, {3, 3, 4, 4}, {7, 9, 8, 9}, {4, 8, 7, 8}, {10, 3, 11, 4}, {1, 4, 2, 4}, {6, 4, 6, 7}, {6, 1, 7, 1}, {4, 7, 4, 7}}
                , new int[][]{{0, 0}, {0, 3}, {0, 4}, {0, 6}, {0, 7}, {0, 9}, {0, 10}, {0, 11}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 9}, {2, 11}, {4, 0}, {4, 1}, {4, 3}, {4, 8}, {4, 10}, {4, 11}, {6, 3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}, {6, 8}, {8, 2}, {8, 4}, {8, 5}, {8, 6}, {8, 7}, {8, 8}, {8, 10}, {10, 0}, {10, 1}, {10, 3}, {10, 4}, {10, 5}, {10, 6}, {10, 7}, {10, 8}, {10, 11}, {1, 0}, {1, 1}, {1, 2}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {1, 10}, {1, 11}, {3, 0}, {3, 2}, {3, 5}, {3, 8}, {3, 9}, {3, 10}, {3, 11}, {5, 0}, {5, 1}, {5, 3}, {5, 4}, {5, 6}, {5, 8}, {5, 9}, {5, 10}, {5, 11}, {7, 0}, {7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 6}, {7, 8}, {7, 9}, {7, 10}, {7, 11}, {9, 0}, {9, 1}, {9, 4}, {9, 7}, {9, 8}, {9, 9}, {9, 10}, {9, 11}, {11, 2}, {11, 4}, {11, 5}, {11, 7}, {11, 8}, {11, 9}, {11, 11}});
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


    public int digArtifacts_1(int n, int[][] artifacts, int[][] dig) {
        Set<String> set = new HashSet<>();
        for (int[] ints : dig) {
            set.add(ints[0] + "-" + ints[1]);
        }
        int res = 0;
        for (int[] artifact : artifacts) {
            int num1 = artifact[0];
            int num2 = artifact[1];
            int num3 = artifact[2];
            int num4 = artifact[3];
            int nTotal = num3 - num1;
            int mTotal = num4 - num2;
            boolean flag = false;
            Out:
            for (int i = 0; i < nTotal + 1; i++) {
                for (int j = 0; j < mTotal + 1; j++) {
                    String str = (num1 + i) + "-" + (num2 + j);
                    if (!set.contains(str)) {
                        flag = true;
                        break Out;
                    }
                }
            }
            if (!flag)
                res++;
        }

        return res;
    }

    public int maximumTop_1(int[] nums, int k) {
        int length = nums.length;
        if (nums.length == 1 && (k & 1) == 1)
            return -1;
        if (k > length + 1)
            k = length+1;
        if (k == 0)
            return nums[0];
        if (k == 1)
            return nums[1];
        int max = Integer.MIN_VALUE;
        // 贪心找到最大值。
        for (int i = 0; i < k - 1; i++) {
            max = Math.max(max, nums[i]);
        }
        // 如果全部删除的结果
        if (k < length) {
            max = Math.max(max, nums[k]);
        }
        return max;
    }
}
