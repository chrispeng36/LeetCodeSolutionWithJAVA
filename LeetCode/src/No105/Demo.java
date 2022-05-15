package No105;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/3/15 14:22
 */
public class Demo {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        preOrder(root);
    }
    static void preOrder(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
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

class Solution {
    int pre_idx;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //根据先序遍历和中序遍历来构造一颗二叉树
        this.inorder = inorder;
        this.preorder = preorder;

        this.pre_idx = 0;//先序遍历的根节点是最开始的
        //这里中序遍历是先左后根再右
        //先序遍历是先中后左再右边
        int idx = 0;
        for (int val : inorder) {
            map.put(val,idx ++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int left, int right){
        if (left > right)
            return null;//没有可以添加的节点了
        //选择pre_idx对应的值为当前根节点的值
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        //根据root将树分为左右两个部分
        int index = map.get(root_val);
        //下标加一
        pre_idx ++;
        root.left = helper(left, index - 1);

        root.right = helper(index + 1, right);

        return root;
    }
}