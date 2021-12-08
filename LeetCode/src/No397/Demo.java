package No397;

/**
 * @author ChrisPeng
 * @date 2021/11/19 9:14
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.integerReplacement(8);
        System.out.println(i);
    }
}

class Solution {
    public int integerReplacement(int n) {
        /**
         * 末尾两个数等于3的话就数字+1
         * 最后一位为1的话就减
         * 否则除以2
         */
        long temp = n;
        int count = 0;
        while (temp != 1){
            if ((temp & 3) == 3 && temp != 3)
                temp ++;
            else if ((temp & 1) == 1)
                temp --;
            else
                temp = temp >> 1;
            count ++;
        }
        return count;
    }
}