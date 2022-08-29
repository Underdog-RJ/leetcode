package cn.underdog.leetcode.rating;

import java.util.LinkedList;

class CombinationIterator {

    LinkedList<String> nextList = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public CombinationIterator(String characters, int combinationLength) {
        backtrackingCombin(characters, combinationLength, 0);
    }

    private void backtrackingCombin(String characters, int combinationLength, int startIndex) {
        if (sb.length() == combinationLength) {
            nextList.add(sb.toString());
            return;

        }
        for (int i = startIndex; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            backtrackingCombin(characters, combinationLength, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        return nextList.removeFirst();
    }

    public boolean hasNext() {
        return !nextList.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */