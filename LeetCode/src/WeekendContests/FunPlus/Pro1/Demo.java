package WeekendContests.FunPlus.Pro1;

/**
 * @author ChrisPeng
 * @date 2022/5/1 10:39
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.removeDigit("1231", '1');
        System.out.println(s);
    }
}

class Solution {
    public String removeDigit(String number, char digit) {
        //删除一个digit,还得返回十进制最大的
        //要删除的数字满足的特点应该是：
        //找到该数字，然后该数字后面没有出现该数字的时候，就能
        int len = number.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            if (number.charAt(i) == digit){
                String temp_string = number.substring(0, i) + number.substring(i + 1, len);
                if (res == "" || (temp_string.compareTo(res) > 0)) res = temp_string;
            }
        }
        return res;
    }

}