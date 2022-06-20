package cn.underdog.leetcode.competition;

class TextEditor {

    StringBuilder sb = null;
    int index;

    public TextEditor() {
        sb = new StringBuilder();
        index = 0;
    }

    public void addText(String text) {
        int length = text.length();
        sb.insert(index, text);
        index += length;
    }

    public int deleteText(int k) {
        if (index > k) {
            sb.delete(index - k, index);
            index -= k;
            return k;
        } else {
            int tmp = index;
            sb.delete(0, index);
            index = 0;
            return tmp;
        }
    }

    public String cursorLeft(int k) {
        if (index > k) {
            index -= k;
            int tmp = Math.min(index, 10);
            return sb.substring(index - tmp, index);
        } else {
            index = 0;
            return "";
        }
    }

    public String cursorRight(int k) {
        if (index == sb.length()) {
            int tmp = Math.min(index, 10);
            return sb.substring(index - tmp);
        } else {
            index = Math.min(index + k, sb.length());
            int tmp = Math.min(index, 10);
            return sb.substring(index - tmp, index);
        }
    }
}