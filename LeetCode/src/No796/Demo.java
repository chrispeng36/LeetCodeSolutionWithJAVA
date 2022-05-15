package No796;

/**
 * @author ChrisPeng
 * @date 2022/4/7 9:37
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean rotateString(String s, String goal) {
        s = s + s;
        return s.contains(goal);
    }
}
