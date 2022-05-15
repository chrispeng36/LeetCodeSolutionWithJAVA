package No1837;

/**
 * @author ChrisPeng
 * @date 2022/4/7 22:23
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.sumBase(34, 6);
        System.out.println(i);
    }
}

class Solution {
    public int sumBase(int n, int k) {
        if (n < k)
            return n;
        int res = 0;
        while (n >= k){
            res += n % k;
            n /= k;
        }
        res += n;
        return res;
    }
}