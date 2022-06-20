package cn.underdog.leetcode.dfs;
import java.util.List;
/**
 * @author underdog_rj
 * @date2022/3/2415:25
 */

public class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
}
