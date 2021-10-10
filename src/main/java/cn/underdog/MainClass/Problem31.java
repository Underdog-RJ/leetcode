package cn.underdog.MainClass;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings({"all"})
public class Problem31 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,1,2,3};
        int[] num2 = new int[]{2,3};
        int[] num3 = new int[]{3};
        twoOutOfThree(num1,num2,num3);
    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        List<Integer> result =new ArrayList<>();

        Set<Integer> num1S=new HashSet<>();
        Set<Integer> num1SS=new HashSet<>();
        for (int i : nums1) {
            num1S.add(i);
            num1SS.add(i);
        }

        Set<Integer> num2S=new HashSet<>();
        Set<Integer> num2SS=new HashSet<>();
        for (int i : nums2) {
            num2S.add(i);
            num2SS.add(i);
        }
        Set<Integer> num3S=new HashSet<>();
        for (int i : nums3) {
            num3S.add(i);
        }

//        List<Integer> collect1 = num1S.stream().filter(num1 -> num2S.stream().allMatch(num2 -> num1 == num2)).collect(Collectors.toList());
//        List<Integer> collect2 = num1S.stream().filter(num1 -> num3S.stream().allMatch(num3 -> num1 == num3)).collect(Collectors.toList());
//        List<Integer> collect3 = num2S.stream().filter(num2 -> num3S.stream().allMatch(num3 -> num2 == num3)).collect(Collectors.toList());

            num1S.retainAll(num2S);
            result.addAll(num1S);
            num1SS.retainAll(num3S);
            result.addAll(num1SS);
            num2S.retainAll(num3S);
            result.addAll(num2S);

            System.out.println(num1S);
         System.out.println(num2S);
//        result.addAll(collect1);
//        result.addAll(collect2);
//        result.addAll(collect3);

        Set<Integer> temp = new HashSet<>(result);

        List<Integer> res=new ArrayList<>(temp);

        return res;
    }

}
