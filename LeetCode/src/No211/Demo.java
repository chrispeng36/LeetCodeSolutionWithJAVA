package No211;

/**
 * @author ChrisPeng
 * @date 2021/10/19 8:41
 */
public class Demo {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
    }
}

class WordDictionary {
    /**
     * 初始化词典对象
     */
    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    /**
     * 将word添加到词典中
     * @param word
     */
    public void addWord(String word) {
        root.insert(word);
    }

    /**
     * 如果数据结构中存在字符串与word匹配，返回true
     * @param word
     * @return
     */
    public boolean search(String word) {
        return dfs(word,0,root);
    }
    private boolean dfs(String word,int index,Trie node){
        if (index == word.length())
            return node.isEnd();
        char ch = word.charAt(index);
        if (Character.isLetter(ch)){
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            if (child != null && dfs(word,index + 1,child))
                return true;
        }else {
            //由于点号可以表示任何字母，因此需要1对当前节点的所有非空子节点继续搜索下一个字符
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word,index + 1,child))
                    return true;

            }
        }
        return false;
    }
}

//创建字典树类
class Trie{
    private Trie[] children;
    private boolean isEnd;
    public Trie(){
        //字典类中的两个是实例化对象是children数组和isend符号
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * 插入单词到字典树中
     * @param word
     */
    public void insert(String word){
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';//计算是第几个英文字母
            //如果下标是不存在该树的
            //那么就创建一个新的对象,相当于添加1新的节点
            //找到了那么就共享这个节点
            if (node.children[index] == null)
                node.children[index] = new Trie();
            node = node.children[index];
//            System.out.println("==========");
//            System.out.println(index);
        }
        //添加完该word之后指向最后点
        node.isEnd = true;
    }
    public Trie[] getChildren(){
        //返回children数组，里面存储的是字典树类对象数组
        return children;
    }

    public boolean isEnd() {
        //表示是否是最后
        return isEnd;
    }
}