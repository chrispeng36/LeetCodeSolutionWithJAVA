package No1448;

/**
 * @author ChrisPeng
 * @date 2021/10/12 16:21
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(1);
        TreeNode right3 = new TreeNode(5);

        root.left = left1;
        left1.left = left2;
        root.right = right1;
        right1.left = right2;
        right1.right = right3;

        Solution solution = new Solution();
        int i = solution.goodNodes(root);
        System.out.println(i);
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
    int count = 0;
    public int goodNodes(TreeNode root) {
        /**
         * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
         *
         * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，
         * 没有任何节点的值大于 X 的值。
         */
        DFS(root,root.val);
        return count;

    }
    public void DFS(TreeNode root,int max){
        if (root == null)
            return;
        int curMax = max;
        if (root.val >= max){
            count++;
            curMax = root.val;
        }
        DFS(root.left,curMax);
        DFS(root.right,curMax);
    }
}