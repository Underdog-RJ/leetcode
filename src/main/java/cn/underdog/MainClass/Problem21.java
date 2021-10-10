package cn.underdog.MainClass;

import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem21 {
    public static void main(String[] args) {

        List<String> result = findRepeatedDnaSequencesImprove("ACGTACGTACGT");
        result.forEach(System.out::println);



    }

    /**
     * 如果字符串长度小于等于10直接返回null 拿着本次的结果和后面每一种情况进行比较如果相同则添加
     * 暴力解题
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {

        if(s.length()<=10)
            return new LinkedList<>();

        int length=s.length()-10;
        Set<String> result =new HashSet<>();
        for (int i=0;i<=length;i++){
            // 本次验证的字符串
            String currentDna=s.substring(i,i+10);
            for(int j=i+1;j<=length;j++){
                String nextDna=s.substring(j,j+10);
                if(currentDna.equals(nextDna)){
                    result.add(currentDna);
                    break;
                }
            }
        }

        return new LinkedList<>(result);
    }


    /**
     * 引入hash表 解决双重for循环问题，本次的情况全部加入到map集合中，下一种情况时判断map中是否已经存在此种情况，如果存在加+1;
     * 复杂度分析
     *      时间复杂度：O(NL)O(NL)，其中 NN 是字符串 \textit{s}s 的长度，L=10L=10 即目标子串的长度。
     *      空间复杂度：O(NL)O(NL)。
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequencesHash(String s) {

        if(s.length()<=10)
            return new LinkedList<>();
        int length=s.length()-10;
        HashMap<String,Integer> map =new HashMap<>();
        List<String> result = new LinkedList<>();
        for (int i=0;i<=length;i++){
            // 本次验证的字符串
            String currentDna=s.substring(i,i+10);
            map.put(currentDna,map.getOrDefault(currentDna,0)+1);
            if(map.get(currentDna)==2)
                result.add(currentDna);
        }
        return result;
    }


    /**
     * 滑动窗口+哈希表+位运算
     *  以10为大小的滑动窗口
     *  哈希表存储每次出现次数
     *  因为仅仅会出现ACGT四种情况所以用  2 bit 标识 （00，01，10，11） 滑动窗口大小为10 所以可以用低20位标识滑动窗口对应的值
     *  因为int对应的时32位，所以取低20位，判断在hash表中是否存在
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequencesImprove(String s) {

        int L = 10;
        List<String> result = new LinkedList<>();
        if(s.length()<=10)
            return result;
        int length=s.length()-10;
        HashMap<Character,Integer> bin =new HashMap(){{
            put('A',0);
            put('C',1);
            put('G',2);
            put('T',3);
        }};
        // 用x 代表滑动窗口的字母对应的数字
        int x = 0;
        // 先取滑动窗口对应的大小为9
        for (int i = 0; i < L - 1; ++i) {
            int tempX=x<<2;  // 向左移动2位
            int tempX1=bin.get(s.charAt(i));  // 当前i对应的字母的int 类型的和因为 2位表示  上一步向左移动了2位 地位补的都是00 所以做 | 为加法
            x = tempX |tempX1 ;  // 位运算，求出前9个窗口对应的int类型的数字的和大小
        }
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0;i<=length;i++){
            int tempX= (x << 2) | bin.get(s.charAt(i + L - 1)); // 最新窗口对应的数值。
            x =  tempX & ((1 << (L * 2)) - 1); // 保留低20位
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                result.add(s.substring(i, i + L));
            }
        }
        return result;
    }







}
