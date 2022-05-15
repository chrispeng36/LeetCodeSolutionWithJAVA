package No762;

/**
 * @author ChrisPeng
 * @date 2022/4/5 15:19
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countPrimeSetBits(int left, int right) {
        //计算闭区间left到right之间的置位位数为质数的整数个数
        boolean[] flag = new boolean[33];//整数最多有32个1
        for (int i = 2; i <= 32; i++) {
            flag[i] = isPrimeNum(i);
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            int count = Integer.bitCount(i);
            if (flag[count])
                res ++;
        }
        return res;
    }

    private boolean isPrimeNum(int i){
        for (int j = i == 2 ? 3 : 2; j < Math.sqrt(i) + 1; j++)
            if (i % j == 0) return false;
        return true;
    }
}