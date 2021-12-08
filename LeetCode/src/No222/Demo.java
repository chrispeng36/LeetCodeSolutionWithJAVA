package No222;

/**
 * @author ChrisPeng
 * @date 2021/10/11 10:21
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode left3 = new TreeNode(5);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(6);
        root.left = left1;
        left1.left = left2;
        left1.right = left3;
        root.right = right1;
        right1.left = right2;

        Solution solution = new Solution();
        int i = solution.countNodes(root);
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
    public int countNodes(TreeNode root) {

        if (root != null){
            count ++;
            countNodes(root.left);
            countNodes(root.right);
        }
        return count;
    }
}