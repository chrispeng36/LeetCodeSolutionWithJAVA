package No540;

/**
 * @author ChrisPeng
 * @date 2022/5/18 0:49
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,3,7,7,10,11,11};
        int i = solution.singleNonDuplicate(arr);
        System.out.println(i);
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid - 1]){//中点跟左边的相等，则判断除开中点，左边还剩多少
                if ((mid - left) % 2 == 0) right = mid - 2;//如果是还有偶数个，说明左边存在答案值
                else left = mid + 1;//若为奇数，说明右边存在答案
            }else if (nums[mid] == nums[mid + 1]){//中点跟右边相等，判断除开中点，右边还剩几位数
                if ((right - mid) % 2 == 0) left = mid + 2;
                else right = mid - 1;
            }else {
                return nums[mid];
            }
        }
        return nums[right];
    }
}