package No1343;

/**
 * @author ChrisPeng
 * @date 2022/4/14 17:06
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,2,2,2,5,5,5,8};
        int i = solution.numOfSubarrays(arr, 3, 4);
        System.out.println(i);
    }
}

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        //前缀和求解
        int target = k * threshold;

        int len = arr.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int count = 0;
        for(int i = k; i <= len; i++){
            if(sum[i] - sum[i - k] >= target){
                count++;
            }
        }
        return count;
    }
}
