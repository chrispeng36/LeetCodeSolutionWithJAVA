package No208;

/**
 * @author ChrisPeng
 * @date 2022/7/14 10:31
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Trie {
    private class TrieNode{
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0, len = word.length(), ch; i < len; i ++) {//遍历所有的字符
            ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null)//从根结点一直匹配字符,如果不包含这个字符
                cur.next[ch] = new TrieNode();//需要新建一个对应该字符的结点
            cur = cur.next[ch];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0, len = word.length(), ch; i < len; i++) {
            ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null)
                return false;
            cur = cur.next[ch];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0, len = prefix.length(), ch; i < len; i++){
            ch = prefix.charAt(i) - 'a';
            if (cur.next[ch] == null)
                return false;
            cur = cur.next[ch];
        }
        return true;
    }
}