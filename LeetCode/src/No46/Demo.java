package No46;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/12/14 9:44
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        List<List<Integer>> list = solution.permute(arr);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}


class Solution {
    //存储全排列的所有结果
    List<List<Integer>> res = new LinkedList<>();
    //主函数，输入一组不重复的数字，返回其全排列
    public List<List<Integer>> permute(int[] nums) {
        //给定一个不含重复数字的数组nums，返回其所有可能的全排列
        /**
         * 回溯算法，本质上是维持一颗多叉树，
         * 需要遍历多叉树获取所有的结果
         */
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;

    }
    /*回溯算法框架0*/
    void backtrack(int[] nums,LinkedList<Integer> track){
        //到达叶子节点，将路径装入到结果列表
        if (track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择,如果track包含，则跳过
            if (track.contains(nums[i]))
                continue;
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums,track);//前面那个return是返回到这里
            //取消选择，把叶子节点删除
            track.removeLast();
        }
    }
}