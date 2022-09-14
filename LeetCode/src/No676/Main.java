package No676;

/**
 * @author ChrisPeng
 * @date 2022/7/11 2:00
 */
public class Main {
    public static void main(String[] args) {

    }
}

class MagicDictionary {
    /**
     * 设计一个使用单词列表进行初始化的数据结构
     * 单词列表中的单词互不相同
     * 如果给出一个单词，请判定能否只将这个单词中的一个字母替换成另一个字母
     * 使得所形成的新单词存在于构建的字典中
     */
    static class Trie{
        private boolean isEnd = false;
        private final Trie[] children = new Trie[26];
    }

    private final Trie trie = new Trie();//构建一个全局的前缀树

    public MagicDictionary() {
        //不需要操作其实
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = this.trie;
            for (int wordIndex = 0, wordLength = word.length(); wordIndex < wordLength; wordIndex ++){
                int trieIndex = word.charAt(wordIndex) - 'a';
                if (cur.children[trieIndex] == null)
                    cur.children[trieIndex] = new Trie();
                cur = cur.children[trieIndex];
            }
            cur.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return search(0, searchWord, this.trie, false);
    }

    private boolean search(int searchWordIndex, String searchWord, Trie cur, boolean isChange){
        if (searchWordIndex == searchWord.length())
            return cur.isEnd && isChange;
        boolean canSearch = false;
        int trieIndex = searchWord.charAt(searchWordIndex) - 'a';
        if (cur.children[trieIndex] != null)
            canSearch = search(searchWordIndex + 1, searchWord, cur.children[trieIndex], isChange);
        if ((!canSearch || cur.children[trieIndex] == null) && !isChange){
            for (int i = 0; i < cur.children.length; i++) {
                if (i != trieIndex && cur.children[i] != null){
                    canSearch = search(searchWordIndex + 1, searchWord, cur.children[i], true);
                    if (canSearch)
                        return true;
                }
            }
        }
        return canSearch;
    }
}
