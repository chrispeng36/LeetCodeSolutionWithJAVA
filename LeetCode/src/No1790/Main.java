package No1790;

/**
 * @author ChrisPeng
 * @date 2022/10/11 14:33
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.areAlmostEqual("bank", "kanb");
        System.out.println(b);
    }
}

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char ch11 = ' ', ch12 = ' ', ch21 = ' ', ch22 = ' ';
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                count ++;
                if (count == 1){
                    ch11 = s1.charAt(i);
                    ch12 = s2.charAt(i);
                }else if (count == 2){
                    ch21 = s1.charAt(i);
                    ch22 = s2.charAt(i);
                }
            }
        }
        if (count > 2) return false;
        if (count == 0) return true;
        if (count == 1) return false;
        return ch11 == ch22 && ch12 == ch21;
    }
}
