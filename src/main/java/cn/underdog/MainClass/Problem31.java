package cn.underdog.MainClass;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 不同 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 *输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-out-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings({"all"})
public class Problem31 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,4};
        int[] num2 = new int[]{2,3};
        int[] num3 = new int[]{3,4};
        twoOutOfThree1(num1,num2,num3);
    }

    /**
     anyMatch表示，判断的条件里，任意一个元素成功，返回true

     allMatch表示，判断条件里的元素，所有的都是，返回true

     noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
    public static List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result =new ArrayList<>();
        Set<Integer> num1S=new HashSet<>();
        for (int i : nums1) {
            num1S.add(i);
        }
        Set<Integer> num2S=new HashSet<>();
        for (int i : nums2) {
            num2S.add(i);
        }
        Set<Integer> num3S=new HashSet<>();
        for (int i : nums3) {
            num3S.add(i);
        }

        List<Integer> collect1 = num1S.stream().filter(num1 -> num2S.stream().anyMatch(num2 -> num1 == num2)).collect(Collectors.toList());
        List<Integer> collect2 = num1S.stream().filter(num1 -> num3S.stream().anyMatch(num3 -> num1 == num3)).collect(Collectors.toList());
        List<Integer> collect3 = num2S.stream().filter(num2 -> num3S.stream().anyMatch(num3 -> num2 == num3)).collect(Collectors.toList());
        result.addAll(collect1);
        result.addAll(collect2);
        result.addAll(collect3);
        Set<Integer> temp = new HashSet<>(result);

        List<Integer> res=new ArrayList<>(temp);

        return res;
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
        for (int i : nums2) {
            num2S.add(i);
        }
        Set<Integer> num3S=new HashSet<>();
        for (int i : nums3) {
            num3S.add(i);
        }
        /**
         * retainAll求交集：
         *      num1S.retainAll(num2S);将num1S和num2S的交集保存到num1S中
         */
        num1S.retainAll(num2S);
        result.addAll(num1S);
        num1SS.retainAll(num3S);
        result.addAll(num1SS);
        num2S.retainAll(num3S);
        result.addAll(num2S);
        Set<Integer> temp = new HashSet<>(result);
        List<Integer> res=new ArrayList<>(temp);
        return res;
    }

}
