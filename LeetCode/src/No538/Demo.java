package No538;

/**
 * @author ChrisPeng
 * @date 2022/3/25 11:42
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
    int pre;
    public TreeNode convertBST(TreeNode root) {
        /**
         *
         * 将二叉搜索树转换为累加树
         * 每个节点的新值等于原树中大于或者等于node.val的值之和
         *
         * 节点的左子树仅包含键小于节点键的节点
         * 节点的右子树仅包含键大于节点键的节点
         * 左右子树也必须是二叉搜索树
         */
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