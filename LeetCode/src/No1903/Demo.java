package No1903;

/**
 * @author ChrisPeng
 * @date 2021/12/10 9:54
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.largestOddNumber("35427");
//        System.out.println("52".substring(0,2));
        System.out.println(s);
    }
}

class Solution {
    public String largestOddNumber(String num) {
        /**
         * 给定一个字符串num表示大整数
         * 返回所有非空子字符串的最大的奇数
         */
        int stopPlace = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            System.out.println(num.charAt(i) - '0');
            if ((num.charAt(i) - '0') % 2 == 1){
                stopPlace = i;
                break;
            }
        }
        if (stopPlace == -1)
            return "";
        else
            return num.substring(0,stopPlace + 1);
    }
}
