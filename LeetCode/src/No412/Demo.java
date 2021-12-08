package No412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/10/13 0:43
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.fizzBuzz(15);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0){
                list.add(i + "");
            }else if (i % 3 == 0 && i % 5 != 0){
                list.add("Fizz");
            }else if (i % 3 != 0 && i % 5 == 0){
                list.add("Buzz");
            }else {
                list.add("FizzBuzz");
            }
        }
        return list;
    }
}
