package No78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/4/14 10:43
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}

class Solution {
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return res;
    }
    private void backTracking(int[] nums, int startIndex){
        /**
         * 回溯的三个步骤：
         * 1. 递归函数参数
         * 全局变量path为子集收集元素，res存放子集集合，backTracking(int[] nums, int startIndex)
         * 2. 回溯过程：backTracking(nums, i + 1);path.removeLast();
         * 3. 递归终止条件
         * 单层递归逻辑代码如下：
         *
         * for (int i = startIndex; i < nums.size(); i++) {
         *     path.push_back(nums[i]);    // 子集收集元素
         *     backtracking(nums, i + 1);  // 注意从i+1开始，元素不重复取
         *     path.pop_back();            // 回溯
         * }
         */
        res.addLast(new ArrayList<>(path));//收集子集，放在终止添加的上面，否则会漏掉自己
        for (int i = startIndex; i < nums.length; i++) {
//            System.out.println("==================================");
            path.addLast(nums[i]);
            backTracking(nums, i + 1);//直到超过长度限制才执行下一条语句
            path.removeLast();
        }
    }
}
