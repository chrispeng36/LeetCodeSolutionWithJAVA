package No1710;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ChrisPeng
 * @date 2022/11/15 9:39
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{5, 10},{2, 5},{4, 7}, {3, 9}};
        int i = solution.maximumUnits(arr, 10);
        System.out.println(i);
    }
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> {
            //装载数量降序排序
            return o2[1] - o1[1];
        });
        int res = 0;
        int boxCount = 0;
        for (int[] boxType : boxTypes) {
            boxCount += boxType[0];
            if (boxCount >= truckSize){
                //那么说明当前加入已经超过了卡车的最大承载
                boxCount -= boxType[0];
                //只能加入truckSize - boxCount
                res += (truckSize - boxCount) * boxType[1];
                break;
            }else {
                //还没有加入
                res += boxType[1] * boxType[0];
            }
        }
        return res;
    }
}
