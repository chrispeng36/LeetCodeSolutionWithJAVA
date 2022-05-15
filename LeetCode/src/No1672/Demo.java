package No1672;

/**
 * @author ChrisPeng
 * @date 2022/4/14 1:31
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] accounts = {{1,2,3},{3,2,1}};
        int i = solution.maximumWealth(accounts);
        System.out.println(i);
    }
}

class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        int len1 = accounts.length;
        int len2 = accounts[0].length;
        for (int i = 0; i < len1; i++) {
            int tempMax = 0;
            for (int j = 0; j < len2; j++) {
                tempMax += accounts[i][j];
            }
            if (tempMax > res) res = tempMax;
        }
        return res;
    }
}