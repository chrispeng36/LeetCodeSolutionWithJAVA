package WeekendContests.No310.No6176;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 9/11/2022 10:32 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                if (o2.getValue() == o1.getValue()){
                    //此时取最小的偶数
                    return o1.getKey() - o2.getKey();
                }else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        return entries.get(0).getKey();
    }
}
