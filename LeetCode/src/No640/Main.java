package No640;

/**
 * @author ChrisPeng
 * @date 2022/8/10 0:38
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solveEquation(String equation) {
        int factor = 0, val = 0;//factor表示变量的系数，val表示常量值
        int index = 0, n = equation.length();
        int sign1 = 1;//初始默认sign1=1
        while (index < n){
            if (equation.charAt(index) == '='){
                sign1 = -1;//等式右边的系数为-1
                index ++;
                continue;//跳过等于号
            }
            int sign2 = sign1;//sign2表示项的符号
            int number = 0;//number表示数值
            boolean valid = false;//记录number是否有效
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+'){
                //去掉前面的符号
                sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                index ++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))){
                number = number * 10 + (equation.charAt(index) - '0');//记录所有的数字
                index ++;
                valid = true;
            }

            if (index < n && equation.charAt(index) == 'x'){
                //变量
                factor += valid ? sign2 * number : sign2;
                index ++;
            }else {
                //数值
                val += sign2 * number;
            }
        }
        if (factor == 0)
            return val == 0 ? "Infinite solutions" : "No solution";
        return "x=" + (-val / factor);
    }
}