package No476;

/**
 * @author ChrisPeng
 * @date 2021/10/18 0:06
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Integer.toBinaryString(-1).length());
        int i = solution.findComplement(5);
        System.out.println(i);
    }
}

class Solution {
    public int findComplement(int num) {
        int tempNum = num;
        int num1 = 0;
        while (tempNum > 0){
            tempNum >>= 1;//右移
            num1 = (num1 << 1) + 1;//保证是全为1且与之等长的数
        }
        return num ^ num1;
    }
}