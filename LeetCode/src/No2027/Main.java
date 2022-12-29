package No2027;

/**
 * @author ChrisPeng
 * @date 2022/12/27 10:49
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumMoves(String s) {
        int index = 0;
        int res = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'O') {
                index ++;
            } else {
                index += 3;
                res ++;
            }
        }
        return res;
    }
}
