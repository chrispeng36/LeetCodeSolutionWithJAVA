package No769;

/**
 * @author ChrisPeng
 * @date 2022/10/13 9:54
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxChunksToSorted(int[] arr) {
        //当遍历到第i个位置时，如果可以切分为块，那前i个位置的最大值一定等于i
        //否则，一定有比i小的数划分到后面的块，那排序后，一定不满足升序
        int res = 0, max  = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) res ++;
        }
        return res;
    }
}