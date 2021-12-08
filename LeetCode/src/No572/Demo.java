package No572;

/**
 * @author ChrisPeng
 * @date 2021/10/12 22:21
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(1);
        TreeNode left13 = new TreeNode(2);
        TreeNode right11 = new TreeNode(5);
        root1.left = left11;
        root1.right = right11;
        left11.left = left12;
        left11.right = left13;

        TreeNode root2 = new TreeNode(4);
        TreeNode left21 = new TreeNode(1);
        TreeNode right21 = new TreeNode(2);
        root2.left = left21;
        root2.right = right21;

        Solution solution = new Solution();
        boolean subtree = solution.isSubtree(root1, root2);
        System.out.println(subtree);
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
    public boolean isSametree(TreeNode root, TreeNode subRoot) {
        /**
         * 判断subRoot是否为root的子树
         */
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        //前序遍历
        if (root.val != subRoot.val)
            return false;
        return isSametree(root.left,subRoot.left) && isSametree(root.right,subRoot.right);
    }
    public boolean isSubtree(TreeNode root,TreeNode subRoot){
        if (root == null)
            return false;
        return isSametree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
