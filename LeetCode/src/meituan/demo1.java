package meituan;

/**
 * @author ChrisPeng
 * @date 2022/4/23 16:11
 */
public class demo1 {
    public static void main(String[] args) {
//        int[] arr = {3,2,4,1,5};
//        int[] colors = {1,2,2,3,1};
//        Solution solution = new Solution();
//        boolean b = solution.canSort(5, arr, colors);
//        System.out.println(b);

        Solution1 solution1 = new Solution1();
        int ccjj = solution1.minSwapCounts("CCJJ", 4);
        System.out.println(ccjj);
    }
}

class Solution{
    public boolean canSort(int n, int[] nums, int[] colors){
//        int len = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if ((nums[j] > nums[j + 1]) && (colors[j] != colors[j + 1])){//颜色相同不会交换
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    int color_temp = colors[j];
                    colors[j] = colors[j + 1];
                    colors[j + 1] = color_temp;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1])
                return false;
        }
        return true;
    }
}

class Solution1{
    public int minSwapCounts(String s, int n){
        /**
         * 交替可以是：C,J...
         * J,C...
         * 判断J和C哪个的个数多
         * J多就JC开始
         * C多就C开始
         */
        int res = 0;
        int sum_J = 0, sum_C = 0;
        char a3 = 'J', a4 = 'C';
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'J')
                sum_J ++;
            else
                sum_C ++;
            if (i % 2 == 0){
                a3 = 'J';
                a4 = 'C';
            }else {
                a3 = 'C';
                a4 = 'J';
            }
            if (s.charAt(i) != a3)
                sum1 ++;
            if (s.charAt(i) != a4)
                sum2++;
        }
        if (Math.abs(sum_J - sum_C) >= 2)
            return -1;//不可能的情况
        if (sum_J > sum_C)
            return (sum2 + 1) / 2;
        else if (sum_J < sum_C)
            return (sum1 + 1) / 2;
        res = Math.min(sum1, sum2);
        return (res + 1)/2;
    }
}