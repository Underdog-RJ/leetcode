package cn.underdog.leetcode.competition;

class Trie {
    private Trie[] children;
    private int isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = 0;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new Trie();
            node = node.children[index];
            node.isEnd++;
        }
    }

    public Integer searchPrefixCount(String prefix) {
        Trie node = this;
        int count = 0;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null)
                return 0;
            node = node.children[index];
            count += node.isEnd;

        }
        return count;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */