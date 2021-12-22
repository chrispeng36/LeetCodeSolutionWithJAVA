package Jianzhioffer082;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/12/19 10:40
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = solution.combinationSum2(arr, 8);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //使用回溯算法
        int n = candidates.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,n,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public void dfs(int[] candidate, int n, int idx, int target, List<Integer> list, List<List<Integer>> ans){
        if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (candidate[i] > target){
                //剪枝
                break;
            }
            if (i > idx && candidate[i] == candidate[i - 1]){
                //剪枝，避免重复
                //因为前面那个同样的数都已经经历过dfs，再拿同样的数dfs就会得到重复的答案
                continue;
            }
            list.add(candidate[i]);
            dfs(candidate,n,i+1,target - candidate[i],list,ans);;
            list.remove(list.size() - 1);
        }
    }
}