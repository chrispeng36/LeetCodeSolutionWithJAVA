package No701.test;

//import com.sun.jdi.ThreadReference;

/**
 * @author ChrisPeng
 * @date 2022/3/20 13:09
 */
public class Demo1 {
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


class Solution{
    public TreeNode insertIntoBST(TreeNode root, int val){
        //将数值插入二叉搜索树
        if (root == null) return new TreeNode(val);
        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null){
            pre = root;
            if (root.val > val)
                root = root.left;
            else if (root.val < val)
                root = root.right;
        }
        //找到最末尾的为空的节点
        if (pre.val > val)
            pre.left = new TreeNode(val);
        else
            pre.right = new TreeNode(val);
        return newRoot;
    }
}
