package No1131;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/12/18 21:31
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {-1,4,5,6};
        int i = solution.maxAbsValExpr(arr1, arr2);
        System.out.println(i);
    }
}

class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        /**
         * 给你两个长度相等的整数数组，返回下面表达式的最大值：
         *
         * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
         *
         * 其中下标 i，j 满足 0 <= i, j < arr1.length。
         */
        int result=0,n=arr1.length;
        int sign[]={1,-1};
        for(int first: sign){
            for(int second: sign){
                int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    int tmp=arr1[i] + first*arr2[i] + second*i;
                    max=Math.max(max,tmp);
                    min=Math.min(min,tmp);
                }
                result =Math.max(result,max-min);
            }
        }
        return result;
    }
}
