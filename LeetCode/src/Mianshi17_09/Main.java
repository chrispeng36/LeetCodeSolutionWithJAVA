package Mianshi17_09;

/**
 * @author ChrisPeng
 * @date 9/28/2022 12:13 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int getKthMagicNumber(int k) {
        /**
         * 某个满足结果的数，一定是之前的某个resultA*3 或者是 resultB*5 或者是 resultC*7 的结果
         * 并且结果一定是这三个乘积的最小值
         * 因此，只要能够记录 resultA、resultB、resultC 的值，再相互与 3、5、7 相乘，取其中的最小值，就是当前的目标值
         *
         */
        int[] result = new int[k];
        result[0] = 1;
        //定义三个指针分别表示resultA、B、C 的下标
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7] * 7);
            if (resultN % 3 == 0)
                point3 ++;
            if (resultN % 5 == 0)
                point5 ++;
            if (resultN % 7 == 0)
                point7 ++;
            result[i] = resultN;
        }
        return result[k - 1];
    }
}