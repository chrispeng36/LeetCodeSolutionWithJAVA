package No504;

/**
 * @author ChrisPeng
 * @date 2022/3/7 8:46
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.convertToBase7(-7);
        System.out.println(s);
//        System.out.println("1"+"2");
    }
}

class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int abNum = Math.abs(num);
        while (abNum > 0){
            int leftNum = abNum % 7;
            sb.append(leftNum);
            abNum /= 7;
        }
        return num > 0 ? sb.reverse().toString() : "-" + sb.reverse().toString();
    }
}