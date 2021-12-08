package Mianshi04_04;

import java.rmi.MarshalException;

/**
 * @author ChrisPeng
 * @date 2021/10/25 11:32
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){this.val = x;}
    TreeNode(int x,TreeNode left,TreeNode right){
        this.val = x;
        this.right = right;
        this.left = left;
    }
}

class Solution {
//    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        //平衡树的定义是任何一个节点，其两颗子树的高度差不超过1
        if (root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if (root == null)
            return 0;
        else
            return Math.max(height(root.left),height(root.right)) + 1;
    }
}