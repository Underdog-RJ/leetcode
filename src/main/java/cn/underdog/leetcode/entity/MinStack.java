package cn.underdog.leetcode.entity;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnkq37/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
import java.util.*;

public class MinStack {

    List<Integer> list = null;
    PriorityQueue<Integer> queue = null;
    public MinStack() {
        list=new ArrayList<>();
        queue =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public void push(int val) {
        list.add(val);
        queue.offer(val);
    }

    public void pop() {
        Integer remove = list.remove(list.size() - 1);

    }

    public int top() {
      return list.get(list.size()-1);
    }

    public int getMin() {
       return list.stream().min(Comparator.comparing(item->item.intValue())).get();
    }
}
