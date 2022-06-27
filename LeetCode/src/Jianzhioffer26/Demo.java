package Jianzhioffer26;

//import com.sun.source.tree.Tree;

/**
 * @author ChrisPeng
 * @date 2022/1/11 9:33
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(1);
        TreeNode left13 = new TreeNode(2);
        TreeNode right11 = new TreeNode(5);
        root1.left = left11;left11.left = left12;left11.right = left13;root1.right = right11;
        TreeNode root2 = new TreeNode(4);
        TreeNode left21 = new TreeNode(1);
        root2.left = left21;
        Solution solution = new Solution();
        boolean subStructure = solution.isSubStructure(root1, root2);
        System.out.println(subStructure);
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean dfs(TreeNode A,TreeNode B){
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && dfs(A.left,B.left) && dfs(A.right,B.right);
    }
}