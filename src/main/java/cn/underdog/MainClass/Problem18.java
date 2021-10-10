package cn.underdog.MainClass;

/**
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 *
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 *
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/destination-city
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class Problem18 {

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();

        List<String> list1= new ArrayList<>();
        list1.add("B");
        list1.add("C");

        List<String> list2= new ArrayList<>();
        list2.add("D");
        list2.add("B");

        List<String> list3= new ArrayList<>();
        list3.add("C");
        list3.add("A");

        result.add(list1);
        result.add(list2);
        result.add(list3);

        String s = destCity(result);
        System.out.println(s);

    }

    public static String destCity(List<List<String>> paths) {

        HashMap<String,List<Integer>> maps=new HashMap<>();

        for (List<String> path : paths) {
            for (int i = 0; i < path.size(); i++) {
                boolean flag = maps.containsKey(path.get(i));
                if(flag){
                    List<Integer> list = maps.get(path.get(i));
                    list.add(i);
                }else {
                    List<Integer> list=new ArrayList();
                    list.add(i);
                    maps.put(path.get(i),list);
                }
            }
        }

        String result="";
        Set<Map.Entry<String, List<Integer>>> entries = maps.entrySet();
        for (Map.Entry<String, List<Integer>> entry : entries) {
            if(entry.getValue().size()==1){
                Integer integer = entry.getValue().get(0);
                if(integer.equals(1)){
                    result=entry.getKey();
                }
            }
        }

        return result;
    }
}
