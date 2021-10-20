package cn.underdog.primaryAlgorithm;

import java.util.*;

public class arrays_algorithm {
    public static void main(String[] args) {
        /*int[] intersect = intersect(new int[]{2,1}, new int[]{1,1});
        for (int i : intersect) {
            System.out.println(i);
        }*/

        /*int[] ints = plusOne(new int[]{9,9});
        for (int i : ints) {
            System.out.println(i);
        }*/

//        moveZeroes(new int[]{0,1,0,3,12});
        /*int[] ints = twoSum(new int[]{-10, -1, -18, -19}, -19);
        for (int anInt : ints) {
            System.out.println(anInt);
        }*/
//        removeDuplicates(new int[]{0,0,1, 1,1,1,1, 2,2, 3, 3,4});
//        removeDuplicates(new int[]{0, 0});
//        removeDuplicates(new int[]{1, 1, 2});
//        singleNumber(new int[]{2,2,1,1,3});
        intersection(new int[]{4,9,5},new int[]{9,4,9,8,4});
    }


    public static int removeDuplicates(int[] nums) {

        /*TreeSet<Integer> treeSet= new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        int length = treeSet.size();
        for (int i = 0; i < nums.length; i++) {
            nums[i]= treeSet.pollFirst();
            if (treeSet.size() == 0 || treeSet == null) {
                break;
            }
        }
        return length;*/


        /*for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]>nums[i+1])
                break;
            while (nums[i] == nums[i + 1]) {
                boolean flag = false;
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
                if (!flag)
                    break;
            }
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if(nums[i]>=nums[i+1])
                break;
        }*/

        /**
         * 双指针问题:
         *      如果nums[left]==nums[right]right指针向右移动
         *      如果nums[left]！=nums[right]left,right指针都向右移东
         */
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if(nums[right]!=nums[left])
                nums[++left]=nums[right];
        }
        return ++left;

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        int[] ints = Arrays.stream(nums1).filter(num1 -> Arrays.stream(nums2).anyMatch(num2 -> num1 == num2)).toArray();
        Set<Integer> set = new HashSet<>();
        for (int anInt : ints) {
            set.add(anInt);
        }
        List<Integer> list =new ArrayList<>(set);
        int[] ans = new int[set.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int w = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j])
                j++;
            else if (nums1[i] < nums2[j])
                i++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }

        }
        int[] res = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }
        return res;


    }


    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * <p>
     *  
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        int jinwei = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1 && digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                int tempCount = digits[i] + jinwei;
                if (tempCount > 9 && i != 0) {
                    digits[i] = tempCount - 10;
                } else if (tempCount > 9 && i == 0) {
                    int[] res1 = new int[digits.length + 1];
                    res1[0] = 1;
                    return res1;
                } else {
                    digits[i] = tempCount;
                    return digits;
                }
            }
        }
        return digits;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。\
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
       /* int left = 0;
        int right = nums.length-1;
        int lleft = Integer.MIN_VALUE;
        int lright = Integer.MAX_VALUE;
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i]=nums[i];
        }
        Arrays.sort(nums);

        while (left != right) {
            if(lleft==left&&lright==right){
               return nums;
            }else {
                lleft=left;
                lright=right;
                int mid = left + (right-left +1)/2;
                if (nums[left] + nums[right] > target) {
                    right = mid;
                }else if(nums[left] + nums[right] < target)
                {
                    left=mid;
                }else {
                    break;
                }
            }
        }
        int numX= nums[left];
        int numY= nums[right];

        int[] res =new int[2];
        int w = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]==numX||nums1[i]==numY)
                res[w++]=i;
            if (w == 2) {
                break;
            }
        }*/
        List list = new ArrayList();


        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if(integers.contains(num))
                return true;
            else
                integers.add(num);
        }
        return false;
    }


    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *  输入: [2,2,1]
     * 输出: 1
     *
     *
     * 使用异或运算，将所有值进行异或
     * 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
     * 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了  (异或运算满足交换律)
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        /*HashMap<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                Integer integer = map.get(num);
                map.put(num,integer+1);
            }else {
                map.put(num,1);
            }
        }
        int num = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()==1){
                num = entry.getKey();
            }
        }*/

        int reduce = 0;
        for (int num : nums) {
            reduce =  reduce ^ num;
        }
        return reduce;
    }
}
