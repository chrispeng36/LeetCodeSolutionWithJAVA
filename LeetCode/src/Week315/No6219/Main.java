package Week315.No6219;

/**
 * @author ChrisPeng
 * @date 2022/10/16 11:16
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + reverse(i) == num)
                return true;
        }
        return false;
    }

    private int reverse(int num){
        int reverseNum = 0;
        while (num != 0){
            int a = num % 10;
            reverseNum = reverseNum * 10 + a;
            num /= 10;
        }
        return reverseNum;
    }
}
