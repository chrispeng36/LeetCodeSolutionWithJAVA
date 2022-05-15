package No2028;

/**
 * @author ChrisPeng
 * @date 2022/3/27 10:50
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,5,3};
        int[] ints = solution.missingRolls(arr,5,3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
//        //所有的值求和为mean * (len + n)
//        int totalSum = (rolls.length + n) * mean;
//        for (int i = 0; i < rolls.length; i++) {
//            totalSum -= rolls[i];//存储的是剩余的和
//        }
//        if (totalSum > 6 * n) return new int[0];
//        if (n > totalSum) return new int[0];//下界的不合理
//        //不然的话就是合理的
//        int[] res = new int[n];
//        int idx = 0;
//        //动态的分配一给每一个位置
//        while (totalSum > 0){
//            res[idx % n] ++;
//            totalSum --;
//            idx ++;
//        }
//        return res;
        int m = rolls.length;
        int sum = mean * (n + m);
        int missingSum = sum;
        for (int roll : rolls) {
            missingSum -= roll;
        }
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        int quotient = missingSum / n, remainder = missingSum % n;
        int[] missing = new int[n];
        for (int i = 0; i < n; i++) {
            missing[i] = quotient + (i < remainder ? 1 : 0);
        }
        return missing;
    }
}