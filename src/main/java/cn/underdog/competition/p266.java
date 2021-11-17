package cn.underdog.competition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p266 {
    public static void main(String[] args) {
        countVowelSubstrings("aeiouu");
//        countVowelSubstrings("unicornarihan");
//        System.out.println(countVowelSubstrings("poazaeuioauoiioaouuouaui"));

    }

    public static int countVowelSubstrings(String word) {
        String s = "aeiou";
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < word.length(); j++) {
                if (s.indexOf(word.charAt(j)) < 0)
                    break;
                set.add(word.charAt(j));
                if (set.size() == 5)
                    count++;
            }
        }
        return count;
    }
}
