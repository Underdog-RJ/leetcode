package cn.underdog.leetcode.hashtable;

import java.util.*;

public class TopVotedCandidate {

    /*Map<Integer, List<Integer>> map = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        for (int i = 0; i < persons.length; i++) {
            List<Integer> currentList = map.getOrDefault(persons[i], new ArrayList<>());
            currentList.add(times[i]);
            map.put(persons[i], currentList);
        }
    }

    public int q(int t) {
        TreeMap<Integer, List<int[]>> mapRever = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            int left = 0;
            int right = value.size()-1;
            int mid = 0;
            while (left < right) {
                // mid为下标索引值
                mid = left + (right - left + 1) / 2;
                if (value.get(mid) > t) {
                    right = mid - 1;
                } else if (value.get(mid) <= t) {
                    left = mid;
                }
            }
            if (value.get(mid) == t) {
                mid++;
                List<int[]> orDefault = mapRever.getOrDefault(mid, new ArrayList<>());
                int[] ints = new int[2];
                ints[0] = entry.getKey();
                ints[1] = value.get(mid - 1);
                orDefault.add(ints);
                mapRever.put(mid, orDefault);
            } else {
                if (value.get(left) <= t) {
                    mid = left + 1;
                    List<int[]> orDefault = mapRever.getOrDefault(mid, new ArrayList<>());
                    int[] ints = new int[2];
                    ints[0] = entry.getKey();
                    ints[1] = value.get(left);
                    orDefault.add(ints);
                    mapRever.put(mid, orDefault);
                }
            }

        }
        List<int[]> value = mapRever.firstEntry().getValue();
        if (value.size() == 1)
            return value.get(0)[0];
        else {
            Collections.sort(value, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            return value.get(0)[0];
        }
    }*/

    // k为当前的人，v为次数
    Map<Integer, Integer> map = new HashMap<>();
    // k为当前时间，v为当前时间的票最多的人
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        // 之前的票最多的人的Id
        int maxPeopleId = -1;
        for (int i = 0; i < persons.length; i++) {
            // 更新当前人的数量
            Integer cntPeople = map.getOrDefault(persons[i], 0) + 1;
            map.put(persons[i], cntPeople);
            // 获取之前人的最大数量
            Integer maxPeople = map.getOrDefault(maxPeopleId, 0);
            // 如果之前人的最大数量小于当前人的数量则更新为当前的人
            if (cntPeople >= maxPeople) {
                maxPeopleId = persons[i];
            }
            // 放入当前时间做大的数量
            treeMap.put(times[i], maxPeopleId);
        }
    }

    public int q(int t) {
        return treeMap.floorEntry(t).getValue();
    }


}
