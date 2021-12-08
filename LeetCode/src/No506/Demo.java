package No506;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/10/14 17:37
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5,4,3,2,1};
        String[] ranks = solution.findRelativeRanks(arr);
        for (String rank : ranks) {
            System.out.println(rank);
        }
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
//        //目的是找到前三大的元素
//        int oneMax = Integer.MIN_VALUE;
//        int twoMax = Integer.MIN_VALUE;
//        int thirdMax = Integer.MIN_VALUE;
////        int flag = 0;
//        boolean f = true;
//
//        for (int i = 0; i < score.length; i++) {
//            if (score[i] > oneMax){
////                flag ++;
//                //原先第二大传递给第三大
//                thirdMax = twoMax;
//                //原先最大值传给第二大
//                twoMax = oneMax;
//                //更新最大值
//                oneMax = score[i];
//            }else if (score[i] > twoMax && score[i] < oneMax){
////                flag ++;
//                thirdMax = twoMax;
//                twoMax = score[i];
//            }else if (score[i] > thirdMax && score[i] < twoMax){
//                thirdMax = score[i];
//            }
//        }
//        String[] arr = new String[score.length];
//        for (int i = 0; i < arr.length; i++) {
//            if (score[i] == oneMax){
//                arr[i] = "Gold Medal";
//            }else if (score[i] == twoMax){
//                arr[i] = "Silver Medal";
//            }else if (score[i] == thirdMax){
//                arr[i] = "Bronze Medal";
//            }else {
//                arr[i] = score[i] + "";
//            }
//        }
//        return arr;
        int[] copy = Arrays.copyOf(score, score.length);
        Arrays.sort(score);
        HashMap<Integer, String> map = new HashMap<>();
        String temp;
        for (int i = score.length - 1; i >= 0; i--) {
            if (i == score.length - 1) temp = "Gold Medal";
            else if (i == score.length - 2) temp = "Silver Medal";
            else if (i == score.length - 3) temp = "Bronze Medal";
            else temp = score.length - i + "";
            map.put(score[i], temp);
        }
        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            res[i] = map.get(copy[i]);
        }
        return res;
    }
}