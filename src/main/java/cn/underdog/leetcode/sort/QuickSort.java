package cn.underdog.leetcode.sort;

public class QuickSort {
    public static void main(String[] args) {

    }

    static void QuickSort(int A[],int low ,int high){
        if (low < high) {
            int pivotPos = Partition(A, low, high);
            QuickSort(A,low,pivotPos-1);
            QuickSort(A,pivotPos+1,high);
        }
    }

    public static int Partition(int A[],int low ,int high){
        int pivot = A[low];
        while (low < high) {
            while (low < high && pivot<A[high])
                high--;
            while (low<high && pivot>A[low])
                low++;
        }
        A[low] = pivot;
        return low;
    }


}
