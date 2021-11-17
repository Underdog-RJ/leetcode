package cn.underdog.MainClass;

public class Problem77 {

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,2,3,4,5,6,7,8,9}, 1));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(duration==0)
            return 0;
        int count = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            count += Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }
        count+=duration;
        return count;
    }
}
