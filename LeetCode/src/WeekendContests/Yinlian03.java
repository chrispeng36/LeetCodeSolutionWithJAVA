//package WeekendContests;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * @author ChrisPeng
// * @date 2022/3/13 17:49
// */
//public class Yinlian03 {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Solution {
//    public int maxInvestment(int[] product, int limit) {
//        //本质上是贪心算法
//        //每次都挑最大的
//        int res = 0;
//        for (int i = 0; i < product.length; i++) {
//            res += product[i];
//            limit --;
//        }
//        if (limit == 0)
//            return res;
//        Arrays.sort(product);
//        for (int i = 0; i < product.length; i++) {
//            for (int j = 0; j < product[j]; j++) {
//
//            }
//        }
//    }
//}