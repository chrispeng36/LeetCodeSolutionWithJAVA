package No6016;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/6 10:32
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.cellsInRange("K1:L2");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution {
    public List<String> cellsInRange(String s) {
        String[] split = s.split(":");
        char col1 = split[0].charAt(0);
        char row1 = split[0].charAt(1);
        char col2 = split[1].charAt(0);
        char row2 = split[1].charAt(1);
        ArrayList<String> res = new ArrayList<>();
        for (int i = col1 - 'A'; i <= col2 - 'A'; i++) {
            String col = (char) (i + 'A') + "";
            for (int j = row1 - '0'; j <= row2 - '0'; j++) {
                String row = (char) (j + '0') +"";
                res.add(col + row);
            }
        }
        return res;
    }
}