package No1754;

/**
 * @author ChrisPeng
 * @date 2022/12/24 17:21
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String largestMerge(String word1, String word2) {
        if(word1.length() == 0)return word2;
        if(word2.length() == 0)return word1;
        char c1 = word1.charAt(0);
        char c2 = word2.charAt(0);
        return word1.compareTo(word2) > 0?
                c1+largestMerge(word1.substring(1),word2)
                :c2+largestMerge(word1,word2.substring(1));
    }
}