package No538;

/**
 * @author ChrisPeng
 * @date 2022/3/26 20:26
 */
public class test01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left11 = new TreeNode(1);
        TreeNode left21 = new TreeNode(0);
        TreeNode left22 = new TreeNode(2);
        TreeNode left31 = new TreeNode(3);
        TreeNode right11 = new TreeNode(6);
        TreeNode right21 = new TreeNode(5);
        TreeNode right22 = new TreeNode(7);
        TreeNode right31 = new TreeNode(8);

        root.left = left11;root.right = right11;
        left11.left = left21;left11.right = left22;
        left21.right = left31;
        right11.left = right21;right11.right = right22;
        right22.right = right31;

        Solution solution = new Solution();
        TreeNode treeNode = solution.convertBST(root);
        preOrder(treeNode);
    }
    static void preOrder(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}


class TreeNode1{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode1() {
    }

    public TreeNode1(int val) {
        this.val = val;
    }

    public TreeNode1(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution1{
    int pre = 0;
    public TreeNode convertBST(TreeNode root){
        if (root != null){
            //遍历右子树
            convertBST(root.right);

            //遍历顶点
            root.val = root.val + pre;
            pre = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
    }
}