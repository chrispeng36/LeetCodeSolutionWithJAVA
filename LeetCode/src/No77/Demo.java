package No77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/4/23 14:41
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combine(4, 2);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}


class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();;//符合条件结果的集合
    ArrayList<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> combine(int n, int k) {
        backtracing(n, k, 1);
//        System.out.println(res.size());
        return res;
    }
    private void backtracing(int n, int k, int startIndex){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
//            res.add(path);
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);//添加节点
            backtracing(n, k, i + 1);//递归，递归是为了纵向遍历
            path.remove(path.size() - 1);//回溯
        }
    }
}