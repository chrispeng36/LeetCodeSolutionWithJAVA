package No1869;

/**
 * @author ChrisPeng
 * @date 2021/10/14 0:13
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkZeroOnes("1101");
        System.out.println(b);
    }
}

class Solution {
    public boolean checkZeroOnes(String s) {
        int curOne = 0,maxOne = 0;
        int curZero = 0,maxZero = 0;
        for (char c : s.toCharArray()) {
            if (c == '1'){
                curOne ++;
                curZero = 0;
            }
            if (c == '0'){
                curZero ++;
                curOne = 0;
            }
            maxOne = Math.max(maxOne,curOne);
            maxZero = Math.max(maxZero,curZero);
        }
        return maxOne > maxZero;
    }
}
