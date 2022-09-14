package No658;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/7/30 15:44
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        int index = binarySearch(arr, x); //二分查找<=x的最大数字下标index
        int i = index == n - 1 ? n - 1 :
                (Math.abs(arr[index] - x) <= Math.abs(arr[index + 1] - x) ? index : index + 1);
        int j = i;
        while (i - 1 >= 0 && j + 1 < n && j - i + 1 < k){
            if (Math.abs(arr[i - 1] - x) <= Math.abs(arr[j + 1] - x))
                i --;
            else
                j ++;
        }
        j = i == 0 ? k - 1 : j; //是否扩展到边缘
        i = j == n - 1 ? n - k : i;
        for (int s = i; s <= j; s++) {
            res.add(arr[s]);
        }
        return res;
    }

    private int binarySearch(int[] nums, int target){//二分查找
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high){
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid;
        }
        return low;
    }
}