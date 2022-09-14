package No33;

/**
 * @author ChrisPeng
 * @date 8/31/2022 3:21 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int l = 0, r = n - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]){//如果[l, mid]是有序的
                if (nums[0] <= target && target < nums[mid])//target在[l, mid]之间，就r-1
                    r = mid - 1;
                else//不是的话就在[mid + 1, r]中间找
                    l = mid + 1;
            }else {//如果[l, mid]不是有序的，那么就说明右边是有序的，无论我们选择哪一个节点，总会出现一边是有序的
                if (nums[mid] < target && target <= nums[n - 1])//target在[mid, n-1]之间
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
