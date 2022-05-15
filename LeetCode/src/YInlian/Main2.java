package YInlian;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author ChrisPeng
 * @date 2022/5/15 10:41
 */
public class Main2 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] arr = {4,6};
        int i = solution1.maxConsecutive(2, 9, arr);
        System.out.println(i);
    }
}

class Solution1 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        //包含bottom和top的所有楼层，special[i]表示用于放松的楼层
//        int startPointer = bottom;
//        int res = 0;
//        int i = 0;
//        while (i < special.length){
//            int tempCount = 0;//对于每个间断点都是0开始
//            if (startPointer != special[i]){
//                while (startPointer != special[i] && startPointer <= top){
//                    //一直遍历了
//                    startPointer ++;
//                    tempCount ++;
//                }
//            }else {
//                startPointer ++;
//                i ++;
//            }
//            //跳出循环说明遇到了间断点
//            res = Math.max(res, tempCount);
//        }
//        //此时跳出循环startpointer可能没到顶
//        res = Math.max(top - startPointer + 1, res);
//        return res;
        int res = Math.max(special[0] - bottom, top -special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            res = Math.max(special[i] - special[i - 1] - 1, res);
        }
        return res;
    }
}
