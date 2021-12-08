package Jianzhioffer32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/10/22 11:29
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode right2 = new TreeNode(15);
        TreeNode right3 = new TreeNode(7);

        root.left = left1;
        root.right = right1;
        right1.right = right3;
        right1.left = right2;

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        for (List<Integer> list : lists) {
            for (Object o : list.toArray()) {
                System.out.println(o);
            }

        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<List<Integer>> node = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        lei(root,0);
        return node;
    }
    public void lei(TreeNode root,int k){
        if (root != null){
            if (node.size() <= k) node.add(new ArrayList<>());
            node.get(k).add(root.val);
            lei(root.left,k + 1);
            lei(root.right,k + 1);
        }
    }
}