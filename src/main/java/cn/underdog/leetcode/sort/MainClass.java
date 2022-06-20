package cn.underdog.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        List<String> timePoints = new ArrayList<>();
        timePoints.add("05:31");
        timePoints.add("22:08");
        timePoints.add("00:35");
//        timePoints.add("21:59");
//        timePoints.add("21:58");
//        timePoints.add("21:39");
//        timePoints.add("00:00");
        System.out.println(mainClass.findMinDifference(timePoints));


    }

    public int findMinDifference(List<String> timePoints) {
        final boolean[] flag = {false};
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {
                    flag[0] = true;
                    return 0;
                }
                if (o1.equals("00:00") && !o2.equals("00:00"))
                    return 1;
                if (!o1.equals("00:00") && o2.equals("00:00"))
                    return -1;
                String[] split1 = o1.split(":");
                String[] split2 = o2.split(":");
                int i1 = Integer.parseInt(split1[0]);
                int i2 = Integer.parseInt(split1[1]);
                int i3 = Integer.parseInt(split2[0]);
                int i4 = Integer.parseInt(split2[1]);
                if (i1 > i3)
                    return 1;
                if (i1 < i3)
                    return -1;
                if (i1 == i3) {
                    if (i2 > i4)
                        return 1;
                    else
                        return -1;
                }
                return 0;
            }
        });

        if (flag[0]) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            String s1 = timePoints.get(i);
            String s2 = timePoints.get(i + 1);
            String[] split1 = s1.split(":");
            String[] split2 = s2.split(":");
            int i1 = Integer.parseInt(split1[0]);
            int i2 = Integer.parseInt(split1[1]);
            int i3 = Integer.parseInt(split2[0]);
            int i4 = Integer.parseInt(split2[1]);
            if (s2.equals("00:00")) {
                i3 = 23;
                i4 = 60;
            }
            int hour = (i3 - i1) * 60;
            int current = hour + i4 - i2;
            if (current < min) {
                min = current;
            }
        }
        // 计算首位
        String s1 = timePoints.get(0);
        String s2 = timePoints.get(timePoints.size() - 1);
        String[] split1 = s1.split(":");
        String[] split2 = s2.split(":");
        int i1 = Integer.parseInt(split1[0]);
        int i2 = Integer.parseInt(split1[1]);
        int i3 = Integer.parseInt(split2[0]);
        int i4 = Integer.parseInt(split2[1]);
        // TODO 比较首位
        return min;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }


}
