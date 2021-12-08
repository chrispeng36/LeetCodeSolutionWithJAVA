package No496;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/10/26 8:55
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        int[] ints = solution.nextGreaterElement(num1, num2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //是要从num2对应位置右边开始找的
        //首先用哈希表装元素对应的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        int[] num3 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
//            boolean flag = false;
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]){
                    num3[i] = nums2[j];
                    break;
                }
                num3[i] = -1;
            }
        }
        return num3;
    }
}