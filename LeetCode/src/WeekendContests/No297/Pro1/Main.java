package WeekendContests.No297.Pro1;

/**
 * @author ChrisPeng
 * @date 2022/6/12 10:29
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,0}, {4, 25}, {5,50}};
        Solution solution = new Solution();
        double v = solution.calculateTax(arr, 2);
        System.out.println(v);
    }
}

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int len = brackets.length;
        if (len == 1)
            return income * brackets[0][0] / 100.0;
//        int prev = brackets[0][0] > income ? income : brackets[0][0];
//        double res = brackets[0][1] * prev / 100.0;
        if (income < brackets[0][0])
            return income * brackets[0][0] / 100.0;
        double res = brackets[0][0] * brackets[0][1] / 100.0;
        for (int i = 1; i < len; i++) {
            if (brackets[i][0] < income)//超过了当前部分，并且超过了下一个部分
                res += brackets[i][1] * (brackets[i][0] - brackets[i - 1][0]) / 100.0;
            else{
                //超过了当前部分，但是没有超过下一个部分
                res += brackets[i][1] * (income - brackets[i - 1][0]) / 100.0;
                break;
            }

        }
        return res;
    }
}
