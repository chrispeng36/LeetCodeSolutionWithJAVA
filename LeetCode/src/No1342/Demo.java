package No1342;

/**
 * @author ChrisPeng
 * @date 2022/1/31 11:45
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numberOfSteps(123);
        System.out.println(i);
    }
}

class Solution {
    private int count = 0;
    public int numberOfSteps(int num) {
        if (num == 0)
            return count;
        else if (num % 2 == 0){
            count ++;
            num /= 2;
        }else {
            count ++;
            num -= 1;
        }
//        System.out.println(num);
        numberOfSteps(num);
        return count;
    }
}