package No235;

/**
 * @author ChrisPeng
 * @date 2022/3/18 11:08
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(6);
        TreeNode left11 = new TreeNode(2);
        TreeNode left21 = new TreeNode(0);
        TreeNode left22 = new TreeNode(4);
        TreeNode left31 = new TreeNode(3);
        TreeNode left32 = new TreeNode(5);
        TreeNode right11 = new TreeNode(8);
        TreeNode right21 = new TreeNode(7);
        TreeNode right22 = new TreeNode(9);

        root.left = left11;root.right = right11;
        left11.left = left21;left11.right = left22;
        left22.left = left31;left22.right = left32;
        right11.left = right21;right11.right = right22;
        TreeNode node = solution.lowestCommonAncestor(root, left11, right11);
        System.out.println(node.val);
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
     *
     * @param root
     * @param p
     * @param q
     * @return 寻找二叉搜索树的最近公共节点
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) return root;
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null) return root;
//        if (right == null && left != null) return left;
//        else if (right != null && left == null) return right;
//        else
//            return null;

        while (root != null){
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}


