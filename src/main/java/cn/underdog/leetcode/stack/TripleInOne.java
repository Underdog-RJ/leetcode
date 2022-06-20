package cn.underdog.leetcode.stack;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TripleInOne {

    int[] res = null;
    boolean[] booleans = null;
    int stackSize = 0;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        res = new int[stackSize * 3];
        booleans = new boolean[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        // 判断当前栈是否已满
        int flag = isFull(stackNum);
        if (flag != -1) {
            res[flag] = value;
            booleans[flag] = true;
        }
    }

    public int pop(int stackNum) {
        boolean empty = isEmpty(stackNum);
        if (empty) {
            return -1;
        } else {
            int index = findIndex(stackNum);
            if (index == -1)
                index = stackNum * stackSize + stackSize - 1;
            int resValue = res[index];
            res[index] = 0;
            booleans[index] = false;
            return resValue;
        }
    }

    public int peek(int stackNum) {
        boolean empty = isEmpty(stackNum);
        if (empty) {
            return -1;
        } else {
            int index = findIndex(stackNum);
            if (index == -1)
                index = stackNum * stackSize + stackSize - 1;
            int resValue = res[index];
            return resValue;
        }
    }

    public boolean isEmpty(int stackNum) {
        if(stackSize==0)
            return true;
        int index = stackNum * stackSize;
        return booleans[index] ? false : true;
    }

    public int isFull(int stackNum) {
        int index = stackNum * stackSize;
        int length = index + stackSize;
        int temp = index;
        while (temp < length) {
            if (!booleans[temp])
                return temp;
            else
                temp++;
        }
        return -1;
    }

    public int findIndex(int stackNum) {
        int index = stackNum * stackSize;
        int length = index + stackSize;
        for (int i = length-1; i >=0; i--) {
            if(booleans[i])
                return i;
        }
        return -1;
    }

}
