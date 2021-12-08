package No400;

/**
 * @author ChrisPeng
 * @date 2021/11/30 8:55
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.findNthDigit(13);
        System.out.println(i);
    }
}

class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        int i = 1;
        while (len < n){
            len = 0;
            if (len + (i + "").length() >= n){
                break;
            }else
                len += (i + "").length();
            i ++;
        }
        int minus = n - len;
//        System.out.println((i + "").charAt((i + "").length() - minus) - '0');
        //返回的是倒数第minus个数字
        return  (i + "").charAt((i + "").length() - minus) - '0';
    }
}