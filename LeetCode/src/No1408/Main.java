package No1408;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/8/8 14:54
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}