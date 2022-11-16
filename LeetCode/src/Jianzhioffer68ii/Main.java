package Jianzhioffer68ii;

import com.sun.source.doctree.TextTree;
import com.sun.source.tree.Tree;

/**
 * @author ChrisPeng
 * @date 2022/11/7 19:00
 */
public class Main {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q)
            return root;
        //后序遍历，从低到上
        TreeNode left = lowestCommonAncestor(root.left, p, q);//看左子树里面有没有p或者q
        TreeNode right = lowestCommonAncestor(root.right, p, q);//看右子树里面有没有p或者q
        if (left != null && right != null){
            //一个在左，一个在右
            return root;
        }
        if (left != null){
            //都在左子树
            return left;
        }
        if (right != null){
            //都在右子树
            return right;
        }
        return null;
    }
}