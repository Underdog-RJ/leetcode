package cn.underdog.sort;

public class BubbleSort {

    public static void main(String[] args) {
            int[] A= {1,4,2,3,5,33,9};
            bubble(A,7);
        for (int i : A) {
            System.out.println(i);
        }

    }

    public static void bubble(int A[],int n){
        for (int i=n-1;i>0;i--){
            boolean flag= false;
            for(int j=0;j<i;j++){
                if(A[j]>A[j+1]){
                    int temp=0;
                    temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag)
                break;
        }
    }
}
