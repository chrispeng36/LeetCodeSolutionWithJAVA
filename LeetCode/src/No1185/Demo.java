package No1185;

/**
 * @author ChrisPeng
 * @date 2022/1/3 9:02
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.dayOfTheWeek(31, 8, 2019);
        System.out.println(s);
    }
}

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] benmark = {0,3,2,5,0,3,5,1,4,6,2,4};
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month < 3)
            year -= 1;
        else
            year -= 0;
        return week[(year + year/4 - year/100 + year/400 + benmark[month-1] + day) % 7];
    }
}