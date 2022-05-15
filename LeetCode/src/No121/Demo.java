package No121;

/**
 * @author ChrisPeng
 * @date 2022/4/10 1:56
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 使用分治法求解该问题
         */
        if (prices.length <= 1) return 0;
        int[] subArr = new int[prices.length - 1];
        for (int i = 1; i < subArr.length; i++) {
            subArr[i] = prices[i] - prices[i - 1];
        }
        int sum = findMaxArray(subArr, 0, subArr.length - 1);
        return sum > 0 ? sum : 0;
    }

    private int findMaxCrossMid(int[] arr, int low,int mid, int high){
        int max = Integer.MIN_VALUE;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = mid; i <= high; i++) {
            rightSum += arr[i];
            if (rightSum > max) max = rightSum;
        }
        leftSum = max = max > 0 ? max : 0;
        for (int i = mid - 1; i >= low; i--) {
            leftSum += arr[i];
            if (leftSum > max) max = leftSum;
        }
        return max;
    }

    private int findMaxArray(int[] arr, int low, int high){
        if (low >= high) return arr[low];
        int mid = low + (high - low) / 2;
        int left = findMaxArray(arr, low, mid);
        int right = findMaxArray(arr, mid + 1, high);
        int cross = findMaxCrossMid(arr, low, mid, high);
        return Math.max(left, Math.max(right, cross));
    }

}
