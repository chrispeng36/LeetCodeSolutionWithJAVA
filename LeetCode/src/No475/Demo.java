package No475;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/12/20 8:53
 */
public class Demo {
    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        Solution solution = new Solution();
        int radius = solution.findRadius(houses, heaters);
        System.out.println(radius);
    }
}

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int i = 0;
        for (int house : houses) {
            while (i < heaters.length && heaters[i] < house){
                i ++;//找到处于房屋右侧的热水器
            }
            if (i == 0)
                radius = Math.max(radius,heaters[i] - house);
            else if (i ==heaters.length)
                //最后一个热水器
                return Math.max(radius,Math.min(heaters[i] - house,house - heaters[i - 1]));
            else
                //房屋右侧的热水器和房屋左侧的热水器取最小的哪个
                radius = Math.max(radius,Math.min(heaters[i] - house,house - heaters[i - 1]));
        }
        return radius;
    }
}