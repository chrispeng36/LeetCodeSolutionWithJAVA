package No2048;

/**
 * @author ChrisPeng
 * @date 2022/7/11 16:18
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int nextBeautifulNumber(int n) {
        //如果整数x满足：对于每个数位d
        //这个数位恰好在x中出现了d次，那么整数x就是一个数值平衡数
        //首先需要满足>n
        int num = n + 1;
        //从大于n的数开始判断是否满足组数值平衡的条件
        while (check(num) == false)
            ++ num;
        return num;
    }

    private boolean check(int num){
        //记录0-9的余数
        int[] log = new int[10];
        while (num != 0){
            //求个位的数值
            int temp = num % 10;
            ++ log[temp];
            num /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (log[i] != 0 && log[i] != i)
                return false;
        }
        return true;
    }
}
