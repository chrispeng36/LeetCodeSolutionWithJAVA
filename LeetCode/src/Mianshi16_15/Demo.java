package Mianshi16_15;

/**
 * @author ChrisPeng
 * @date 2022/4/14 23:05
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2];
        char[] s = solution.toCharArray();
        char[] g = guess.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]){
                res[0] ++;
                s[i] = 'x';
                g[i] = 'x';
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'x')
                continue;
            for (int j = 0; j < g.length; j++) {
                if (g[j] == s[i]){
                    res[1] ++;
                    g[j] = 'o';//不能重复计算
                    break;
                }
            }
        }
        return res;
    }
}
