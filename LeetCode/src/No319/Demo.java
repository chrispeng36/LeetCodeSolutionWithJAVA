package No319;

/**
 * @author ChrisPeng
 * @date 2021/11/15 0:41
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.bulbSwitch(3);
        System.out.println(i);
    }
}

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }
}