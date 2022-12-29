package No2011;

/**
 * @author ChrisPeng
 * @date 2022/12/23 0:28
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0) == '+' || operations[i].charAt(2) == '+') {
                res ++;
            } else if (operations[i].charAt(0) == '-' || operations[i].charAt(2) == '-'){
                res --;
            }
        }
        return res;
    }
}