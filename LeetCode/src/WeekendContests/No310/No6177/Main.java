package WeekendContests.No310.No6177;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 9/11/2022 10:47 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.partitionString("a");
        System.out.println(i);
    }
}

class Solution {
    public int partitionString(String s) {
        if (s.length() == 1)
            return 0;
        int start = 0;
        int res = 0;
        while (start < s.length()){
            if (start == s.length() - 1){
                res ++;
                break;
            }
            ArrayList<Character> list = new ArrayList<>();
            list.add(s.charAt(start));
            int i = start + 1;
            while (i < s.length()){
                if (list.contains(s.charAt(i))){
                    res ++;
                    start = i;
                    break;
                }else {
                    list.add(s.charAt(i));
                }
                i ++;
            }
            if (i == s.length()){
                res ++;
                break;
            }
        }
        return res;
    }
}