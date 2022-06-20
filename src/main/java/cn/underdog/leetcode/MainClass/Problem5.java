package cn.underdog.leetcode.MainClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Problem5 {

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e',}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"eat", "oath"};
        List<String> stringList = findWords(board, words);
        System.out.println(stringList);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        int length = board.length;
        List<String> list = new ArrayList<>();

        for (int t = 0; t < words.length; t++) {
            char[] chars = words[t].toCharArray();
            for (int i = 0; i < length; i++)
                for (int j = 0; j < board[i].length; j++)
                    Out:
                            for (int u = 0; u < chars.length; u++) {
                                if (Objects.equals(board[i][j], chars[u])) {
                                    u++;
                                    if (i != 0) {
                                        // findWordsDGS(board,chars,i,j,u);
                                        if (Objects.equals(board[i - 1][j], chars[u])) {
                                            u++;
                                            System.out.println(u);
                                        }
                                    }
                                    if (i + 1 != length) {
                                        // findWordsDGX(board,chars,i,j,u);
                                        if (Objects.equals(board[i + 1][j], chars[u])) {
                                            u++;
                                            System.out.println(u);
                                        }
                                    }
                                    if (j != 0) {
                                        // findWordsDGZ(board,chars,i,j,u);
                                        if (Objects.equals(board[i][j - 1], chars[u])) {
                                            u++;
                                            System.out.println(u);
                                        }
                                    }
                                    if (j + 1 != board[i].length) {
                                        // findWordsDGY(board,chars,i,j,u);
                                        if (Objects.equals(board[i][j + 1], chars[u])) {
                                            u++;
                                            System.out.println(u);
                                        }
                                    }
                                }
                                else
                                    break Out;
                            }
            list.add(words[t]);
        }
        return list;
    }

    private static void findWordsDGY(char[][] board, char[] chars, int i, int j, int u) {
        if (Objects.equals(board[i][j], chars[u])) {

        }
    }

    private static void findWordsDGZ(char[][] board, char[] chars, int i, int j, int u) {

    }


    private static void findWordsDGX(char[][] board, char[] chars, int i, int j, int u) {

    }

    private static void findWordsDGS(char[][] board, char[] chars, int i, int j, int u) {

    }
}
