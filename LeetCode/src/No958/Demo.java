package No958;

import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 2022/2/5 23:29
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(5);
        TreeNode right1 = new TreeNode(3);
        TreeNode right11 = new TreeNode(5);

        root.left = left1;root.right = right1;
        left1.left = left11;left1.right = left12;right1.left = right11;

        Solution solution = new Solution();
        boolean b = solution.isCompleteTree(root);
        System.out.println(b);
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
        this.right = right;
        this.left = left;
    }
}

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode cur;
        q.addLast(root);
        while ((cur = q.removeFirst()) != null){
            q.addLast(cur.left);
            q.addLast(cur.right);
        }
        while (! q.isEmpty()){
            if (q.removeLast() != null)
                return false;
        }
        return true;
    }
}