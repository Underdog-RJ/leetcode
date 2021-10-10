package cn.underdog.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] A = {0,3,4,1,2};
        insert(A);
        Arrays.stream(A).forEach(System.out::println);
        System.out.println(A.toString());
    }

    public static void insert(int A[]){
        int i,j;
        for( i= 2;i<=A.length;i++){
            if(A[i]<A[i-1]){
                A[0]=A[i];
                for (j=i-1;A[j]>A[0];j--){
                    A[j+1]=A[j];
                }
                A[j+1]=A[0];
            }
        }
    }
}
