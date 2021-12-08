package Mianshi01_05;

/**
 * @author ChrisPeng
 * @date 2021/10/18 19:12
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.oneEditAway("pale", "ple");
        System.out.println(b);
    }
}

class Solution {
    public boolean oneEditAway(String first, String second) {
        int n1 = first.length(), n2 = second.length();
        int flag = Math.abs(n1-n2); // 字符长度差
        int temp = 0;   // 记录字符不同的个数，超过一个则为false
        if (flag > 1) { // 长度差值为1以上则为false
            return false;
        } else if (flag == 0) { // 长度相同只能通过替换操作
            for (int i=0; i<n1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    temp++;
                }
                if (temp > 1) {
                    return false;
                }
            }
            return true;
        } else {    // 字符长度差为1，只能通过插入和删除
            if (n1 == 0 || n2 == 0) {
                return true;
            }
            int i = 0;
            int j = 0;
            while (temp <= 1) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else {
                    temp++;
                    if (n1 > n2) {
                        i++;
                    } else {
                        j++;
                    }
                }
                if ((i >= n1 || j >= n2) && temp <= 1) {
                    return true;
                }
            }
            return false;
        }

    }
}