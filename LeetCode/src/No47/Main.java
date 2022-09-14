package No47;

import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/7/22 9:19
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //给定一个可包含重复数字序列nums，按照任意顺序返回所有不重复的全排列
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];//该数字是否访问过
        Arrays.sort(nums);//排序
        backtrack(nums, ans, 0, perm);
        return ans;
    }
    private void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm){
        if (idx == nums.length){//填充完了n个位置，将perm放入答案数组中
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //保证在填充第idx个数的时候重复数组只会被填入一次
            //对原数组进行排序，保证相同的数字都相邻
            //每次填入的数一定是这个数所在重复数集合中
            //从左往右第一个未被填过的数字
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])){
                continue;
            }
            perm.add(nums[i]);//添加nums[i]
            vis[i] = true;//nums[i]标记为已访问
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}