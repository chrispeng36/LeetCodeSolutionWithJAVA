package No124;

/**
 * @author ChrisPeng
 * @date 9/29/2022 11:06 AM
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
    private int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /**
         * 对于任意一个结点，如果最大路径和包含该结点，那么只有两种情况：
         * 1. 其左右子树中所构成的和路径值较大的那个加上该结点的值后向父节点回溯构成
         * 2. 左右子树都在最大路径中，加上该结点的值构成了最终的最大路径
         */
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r){
        if (r == null) return 0;
        //如果子树路径和为负则应当置为0，表示最大路径不包含子树
        int left = Math.max(0, getMax(r.left));//0是不包含，getmax是包含
        int right = Math.max(0, getMax(r.right));
        //判断在该结点包含左右子树的路径和是否大于当前最大路径和
        ret = Math.max(ret, r.val + left + right);
        return Math.max(left, right) + r.val;
    }
}
