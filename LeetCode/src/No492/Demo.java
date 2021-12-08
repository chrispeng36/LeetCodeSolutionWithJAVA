package No492;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/10/23 9:11
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.constructRectangle(37);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
class Solution {
    public int[] constructRectangle(int area) {
        //差距尽可能小、a[0]>=a[1]、等于目标面积
        //利用哈希表存吧
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0){
            sqrt --;
        }
        return new int[]{area / sqrt , sqrt};
    }
}