package No233;

/**
 * @author ChrisPeng
 * @date 9/19/2022 10:18 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countDigitOne(13);
        System.out.println(i);
    }
}

class Solution {
    public int countDigitOne(int n) {
        if (n < 1)
            return 0;
        int len = getLenOfNum(n);
        if (len == 1)
            return 1;
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp;//获取n的最高位数字
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp;//获取最高位为1时有多少数字
        int otherOneNum = first * (len - 1) * (tmp / 10);//在介于n % tmp 到n之间的数字中，除了最高位为1，其余各个数字分别为1的总数和
        return firstOneNum + otherOneNum + countDigitOne(n % tmp);
    }

    private int getLenOfNum(int n){
        int len = 0;
        while (n != 0){
            len ++;
            n /= 10;
        }
        return len;
    }
}
