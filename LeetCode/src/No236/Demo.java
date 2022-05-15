package No236;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/3/17 15:45
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
    /**
     * 给定二叉树找到该树中两个指定节点的最近公共祖先
     * 这个题目考虑的是从下往上遍历
     * 故而用后序遍历，优先遍历叶子节点
     * 每次递归都是查找以root为根节点的树上是否有p和q节点
     * 如果有的话就返回p节点或者q节点，否则就返回null
     * 这样一来，就从左右子树分别进行递归，
     * 即查找左右子树上是否有p节点或者q节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);//遍历左子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);//遍历右子树
        //第一种情况，左右子树上找到了p或者q，那么就直接返回该root
        if (left != null && right != null) return root;
        //第二种情况，左子树没有找到，但是右子树上找到了，说明两个节点必然不存在于左子树上，所以在柚子树上
        if (left == null && right != null) return right;
        else if (left != null && right == null) return left;
        else
            return null;
    }
}