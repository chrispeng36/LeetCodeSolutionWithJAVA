package No648;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * @author ChrisPeng
 * @date 2022/7/7 22:09
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        //dictionary表示词根，sentence表示句子
        //将句子中的所有继承词用词根替换掉
        //如果有继承词有许多可以形成它的词根，则用最短的词根替换它
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    public String findRoot(String word, Trie trie){
        StringBuffer root = new StringBuffer();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#'))
                return root.toString();
            if (! cur.children.containsKey(c))
                return word;
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
}

class Trie{
    Map<Character, Trie> children;

    public Trie(){
        children = new HashMap<Character, Trie>();
    }
}
