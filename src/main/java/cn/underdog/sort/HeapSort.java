package cn.underdog.sort;

import java.util.Collections;

public class HeapSort {
    public static void main(String[] args) {
//        HeapSort(new int[]{0,53,17,78,9,45,65,87,32},9);
        System.out.println(Math.random());
    }

    // 堆排序对应的是完全二叉树，且数组下标从1开始
    static void BuildMapHeap(int[] A, int len) {
        // 建立初始化大根堆  需要调整的次数为数组长度的一般
        for (int i = len / 2; i > 0; i--)
            HeapJust(A, i, len);
    }

    static void HeapJust(int[] A, int k, int len) {

        A[0] = A[k];
        for (int i = k * 2; i <= len; i *= 2) {
            // 将I选择为当前root的最大子节点
            if(i+1<len){
                if (A[i] < A[i + 1])
                    i++;
            }
            if (A[i] <= A[0])
                break;
            else {
                // 交换值
                A[k] = A[i];
                // k 记录最大值的位置
                k = i;
            }
        }
        A[k] = A[0];

    }

    static void HeapSort(int[] A, int len) {
        BuildMapHeap(A, len);
        // n-1堂交换和建堆的过程
        for (int i = len;i>1;i--){
            /**
             * 输出堆顶元素将堆低元素替换为堆顶元素
             */
            HeapJust(A,1,i-1);
        }

    }

}
