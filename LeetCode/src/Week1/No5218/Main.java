package Week1.No5218;

/**
 * @author ChrisPeng
 * @date 2022/6/19 10:46
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minimumNumbers(1, 1);
        System.out.println(i);
    }
}

class Solution {
    public int minimumNumbers(int num, int k) {
        //每个整数的个位数字为k
        //所有整数之和为num
        //返回多重集的最小大小,多重集可以包含同一个整数

        if (num == 0)
            return 0;
        if (k > num)
            return -1;
        if (num % 2 == 1 && k % 2 == 0)
            return -1;
        //我现在要凑，凑出和为num的
        int s = num % 10;
        if (k == 0){
            //k=0的情况另说
            if (s != 0)
                return -1;
            else
                return 1;
        }
        for (int i = 0; i < 10; i++) {
            if ((s + i * 10) % k == 0 && (s + i * 10) / k != 0)
                return (s + i * 10) / k;
        }
        return -1;
    }
}