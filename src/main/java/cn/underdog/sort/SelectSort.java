package cn.underdog.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] A= {1,4,2,3,5,33,9};
        SelectSort(A,7);
        for (int i : A) {
            System.out.println(i);
        }
    }
    public static void SelectSort(int[] A,int n){
        int i,j;
        for(i=n-1;i>0;i--){
            int max = i;
            for (j=0;j<i;j++){
                if(A[max]<A[j])
                    max=j;
            }
            if(max!=i){
                int temp=A[i];
                A[i]=A[max];
                A[max]=temp;
            }

        }
    }
}
