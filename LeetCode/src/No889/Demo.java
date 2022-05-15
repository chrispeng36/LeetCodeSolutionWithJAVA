package No889;

/**
 * @author ChrisPeng
 * @date 2022/4/8 10:03
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //根据前序遍历和后序遍历构造二叉树
        return helper(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd){
        if (preStart > preEnd || postStart > postEnd) return null;//越界，说明已经递归到树的末端
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd)//仅剩一个节点，是叶子节点，所以直接返回
            return root;
        int index = 0;//index是数组中最右一个左子树的元素（划分左右子树的边界）
        while (postorder[index] != preorder[preStart + 1])
            index ++;//定位到后序遍历中与下一个节点值相同的点，就是下一个根节点，定位的是post的位置
        //preEnd = preStart + 1 + index - postStart?,这个是左分支的截止点
        root.left = helper(preorder, postorder, preStart + 1, preStart + 1 + index - postStart, postStart, index);
        root.right = helper(preorder, postorder, preStart + 2 + index - postStart, preEnd, index + 1, preEnd - 1);
        return root;
    }
}