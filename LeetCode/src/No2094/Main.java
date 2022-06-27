package No2094;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/6/3 21:31
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,1,3,0};
        int[] res = solution.findEvenNumbers(arr);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        /**
         * 给定一个整数数组，其中每个元素是0-9
         * 找出满足以下条件的整数：
         * 该整数由digits中的三个元素按照任意顺序依次连接而成
         * 该整数不含前导0
         * 该整数是一个偶数
         */
        //统计0-9各个数字出现的次数
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit] ++;
        }
        // 百位、十位、个位按各自规则不重不漏的进行数字选取
        // 各个位置选取之后统计结果减一，完成当前遍历后恢复（统计结果再加一）
        ArrayList<Integer> list = new ArrayList<>();
        //百位按照1-9取存在的数字（保证了顺序且不重复）
        for (int i = 1; i < 10; i++) {
            if (count[i] > 0){
                count[i] --;
                //十位取剩余的0-9中存在的数字（保证了顺序且不重复）
                for (int j = 0; j < 10; j++) {
                    if (count[j] > 0){
                        count[j] --;
                        //个位取剩余存在的偶数（保证了顺序且不重复）
                        for (int k = 0; k < 10; k+=2) {
                            if (count[k] > 0)
                                list.add(i * 100 + j * 10 + k);
                        }
                        count[j] ++;
                    }
                }
                count[i] ++;
            }
        }
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}