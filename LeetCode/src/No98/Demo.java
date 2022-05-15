package No98;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/3/16 14:51
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(6);
        root.left = left1;root.right = right;
        right.left = right1;right.right = right2;

        Solution solution = new Solution();
        boolean b = solution.isValidBST(root);
        System.out.println(b);
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
    public boolean isValidBST(TreeNode root) {
        //中序遍历是升序的
        //利用栈来实现中序遍历
        if (root == null)
            return true;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        double inorder = -Double.MAX_VALUE;
        while (! stk.isEmpty() || cur != null){
            //中序遍历，先左后中再右
            while (cur != null){
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();;

            if (cur.val >= inorder){
                return false;
            }
            inorder = cur.val;
            cur = cur.right;
        }
        return true;
    }
}

class Solution1 {
    //这里要比较的话，那就必须借助于外部的数据
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}