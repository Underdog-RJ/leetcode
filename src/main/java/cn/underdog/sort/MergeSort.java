package cn.underdog.sort;

public class MergeSort {

    static void merge(int[] A, int low, int mid, int high) {
        int[] B = new int[A.length];  // 当前A左右两个有序，所以先复制有序表，再将两段有序表合成一段有序表
        for (int i = 0; i < A.length; i++)
            B[i] = A[i];
        int i = low;
        int j = mid;
        int k = i;
        for (; i < mid && j < high; i++, j++) {
            if (B[i] >= B[j]) {
                A[k++] = B[j++];
            } else {
                A[k++] = B[i++];
            }
        }
        while (i < low) A[k++] = B[i++];
        while (j < high) A[k++] = B[j++];
    }
    static void mergeSort(int A[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }


}
