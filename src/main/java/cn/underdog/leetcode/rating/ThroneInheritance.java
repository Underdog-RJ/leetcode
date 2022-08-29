package cn.underdog.leetcode.rating;

import java.util.*;

class ThroneInheritance {

    private String kingName = "";

    private Map<String, List<String>> map = new HashMap<>();

    Set<String> death = new HashSet<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> orDefault = map.getOrDefault(parentName, new ArrayList<>());
        orDefault.add(childName);
        map.put(parentName, orDefault);
    }

    public void death(String name) {
        death.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        Successor(kingName, list);
        return list;
    }

    private void Successor(String kingName, List<String> list) {
        List<String> child = map.getOrDefault(kingName, new ArrayList<>());
        if (!death.contains(kingName)) {
            list.add(kingName);
        }
        for (String s : child) {
            Successor(s, list);
        }
    }

}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */