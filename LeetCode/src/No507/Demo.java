package No507;

/**
 * @author ChrisPeng
 * @date 2021/12/31 9:51
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkPerfectNumber(6);
        System.out.println(b);
    }
}

class Solution {
    public boolean checkPerfectNumber(int num) {
        int sumOfdivisions = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0)
                sumOfdivisions += i;
        }
        return sumOfdivisions == num;
    }
}