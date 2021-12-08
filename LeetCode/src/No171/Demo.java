package No171;

public class Demo {
    public static void main(String[] args) {
//        System.out.println('A' - 'A');
        Solution solution = new Solution();
        int aa = solution.titleToNumber("FXSHRXW");
        System.out.println(aa);
    }
}

class Solution {
    public int titleToNumber(String columnTitle) {
        //给定一个字符串，表示excel表格中的列名称，返回该列名称对应的序列号
        //这个整个就是一个26进制的运算
        int num = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            num = num * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return num;
    }
}