package No6031;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/13 11:34
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i - j) <= k && nums[j] == key){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}