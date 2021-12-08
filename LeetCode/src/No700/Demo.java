package No700;

/**
 * @author ChrisPeng
 * @date 2021/10/22 22:07
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        //给定二叉搜索树(BST)的根节点和一个值
        //找到节点值等于给定值的节点
        if (root.val == val || root == null)
            return root;
        return root.val > val ? searchBST(root.left,val) : searchBST(root.right,val);
    }
}