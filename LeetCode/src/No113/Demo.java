package No113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/13 12:46
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        /**
//         * 给定一个二叉树和一个目标和
//         * 找到所有从根节点到叶子节点路径总和等于给定目标和的路径
//         */
//        ArrayList<List<Integer>> res = new ArrayList<>();
//        if (root == null)
//            return res;
//        LinkedList<Integer> path = new LinkedList<>();
//        preorderdfs(root, targetSum, res, path);
//        return res;
//    }
//
//    public void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path){
//        path.add(root.val);
//        //遇到了叶子节点
//        if (root.left == null && root.right == null){
//            if (targetSum - root.val == 0)
//                res.add(new ArrayList<>(path));
//            return;
//        }
//
//        if (root.left != null){
//            preorderdfs(root.left, targetSum - root.val, res, path);
//            path.remove(path.size() - 1);//回溯
//        }
//        if (root.right != null){
//            preorderdfs(root.right, targetSum - root.val, res,path);
//            path.remove(path.size() - 1);//回溯
//        }
//    }

    List<List<Integer>> result;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        result = new LinkedList<>();
        path = new LinkedList<>();
        travelsal(root,targetSum);
        return result;
    }
    private void travelsal(TreeNode root, int count){
        if (root == null) return;
        path.offer(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0)
            result.add(new LinkedList<>(path));
        travelsal(root.left, count);
        travelsal(root.right,count);
        path.removeLast();
    }
}