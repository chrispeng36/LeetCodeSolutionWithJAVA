package No1780;

/**
 * @author ChrisPeng
 * @date 2022/12/9 0:42
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
