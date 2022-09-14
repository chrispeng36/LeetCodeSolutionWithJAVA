package No324;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/6/28 9:12
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        //重新排列成nums[0] < nums[1] > nums[2] < nums[3]...的顺序
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j --, k --) {
            nums[i] = arr[j];
            if (i + 1 < n)
                nums[i + 1] = arr[k];
        }
    }
}
