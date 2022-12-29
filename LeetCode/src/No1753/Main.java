package No1753;

/**
 * @author ChrisPeng
 * @date 2022/12/21 11:08
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximumScore(int a, int b, int c) {
        if (a + b < c) return a + b;
        if (a + c < b) return a + c;
        if (c + b < a) return b + c;
        return (a + b + c) / 2;
    }
}
