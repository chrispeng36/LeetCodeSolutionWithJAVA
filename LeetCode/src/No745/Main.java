package No745;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/7/14 10:06
 */
public class Main {
    public static void main(String[] args) {

    }
}

class WordFilter {
    Map<String, Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = words.length - 1; i > 0; i--){
            int n = words[i].length();
            ArrayList<String> pre = new ArrayList<>();
            ArrayList<String> suf = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                pre.add(words[i].substring(0, j));
                suf.add(words[i].substring(n - j));
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    String s = new StringBuilder(pre.get(j)).append(" ").append(suf.get(k)).toString();
                    if (! map.containsKey(s))
                        map.put(s, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(new StringBuilder(pref).append(" ").append(suff).toString(), -1);
    }
}
