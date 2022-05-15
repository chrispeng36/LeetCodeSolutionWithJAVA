package No2024;

/**
 * @author ChrisPeng
 * @date 2022/3/29 9:49
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxConsecutiveAnswers("TTFF", 2);
        System.out.println(i);
    }
}

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey,k,'T'),maxConsecutiveChar(answerKey, k, 'F'));
    }
    public int maxConsecutiveChar(String answerKey, int k, char ch){
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right= 0, sum = 0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k)
                sum -= answerKey.charAt(left ++) != ch ? 1 : 0;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}