package No532;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/6/16 9:45
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,1,4,1,5};
        int pairs = solution.findPairs(arr, 2);
        System.out.println(pairs);
    }
}

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){map.put(nums[i],map.getOrDefault(nums[i],0)+1);}
        int ans=0;
        if(k==0){for(int a:map.keySet()){if(map.get(a)>1){ans++;}}}
        else{for(int a:map.keySet()){if(map.containsKey(a+k)){ans++;}}}
        return ans;
    }
}
