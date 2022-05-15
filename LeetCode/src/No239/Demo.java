package No239;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/4/18 21:37
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        //给定一个整数数组和大小为k的滑动窗口
//        ArrayList<Integer> list = new ArrayList<>();
//        int len = nums.length;
//        for (int i = 0; i + k <= len; i++) {
//            int max = nums[i];
//            for (int j = i; j < i + k; j++) {
//                if (nums[j] > max)
//                    max = nums[j];
//            }
//            list.add(max);
//        }
//        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
//        return ints;
        //暴力的方法超出了时间限制
        /**
         * 选择维护一个队列的方式，这个队列没有必要维护窗口里面的所有元素
         * 只需要维护有可能称为窗口里最大的元素即可，同时保证队列中的元素的数值是从大到小的
         * 这个队列就是单调队列
         * 单调队列的规则：
         * pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
         * push(value)：如果push的元素value大于入口元素的数值，那么就将队列入口的元素弹出，直到push元素的数值小于等于队列入口元素的数值为止
         */
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            //i为nums下标，是要在[i - k + 1, i]中选择最大值
            //1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (! deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();
            //2.既然是单调队列，就要保证每次放进去的数字比末尾的都大，否则也弹出
            while (! deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offer(i);

            //因为是单调的，当i增长到符合第一个k的范围的时候，每滑动一步都将队列头结点放入结构就行了
            if (i >= k - 1)
                res[idx ++] = nums[deque.peek()];
        }
        return res;
    }
}
