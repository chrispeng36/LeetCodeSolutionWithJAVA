package Jianzhioffer34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/10/12 20:29
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(11);
        TreeNode left3 = new TreeNode(7);
        TreeNode left4 = new TreeNode(2);
        TreeNode right1 = new TreeNode(8);
        TreeNode right2 = new TreeNode(13);
        TreeNode right3 = new TreeNode(4);
        TreeNode right4 = new TreeNode(5);
        TreeNode right5 = new TreeNode(1);

        root.left = left1;root.right = right1;
        left1.left = left2;left2.left = left3;left2.right = left4;
        right1.left = right2;right1.right = right3;
        right3.left = right4;right3.right = right5;

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathSum(root, 22);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
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

class Solution{
    private List<List<Integer>> pathList = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target){
        //给定一棵二叉树和一个整数目标，找出所有的从根结点到叶子结点的路径总和等于目标的
        if (root == null) return pathList;
        dfs(root, 0, target);
        return pathList;
    }

    private void dfs(TreeNode cur, int sum, int target){
        /**
         * 存在一个问题就是
         * 每次以为回溯的地方会删除两个
         * path也不能用全局变量，不然后来回溯的时候就会被改变了
         */
        if (cur == null){//到达了叶子结点
            return;//终止条件，说明找到了叶子结点
        }
        sum += cur.val;//遍历当前的节点
        path.add(cur.val);
        if (cur.left == null && cur.right == null){
            if (sum == target)
                pathList.add(path);
        }
        dfs(cur.left, sum, target);
        dfs(cur.right, sum, target);
        path.remove(path.size() - 1);
        sum -= cur.val;
    }
}
