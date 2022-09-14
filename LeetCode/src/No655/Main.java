package No655;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/8/22 9:06
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = calDepth(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        ArrayList<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {//初始化
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(res, root, 0, (n - 1) / 2, height);
        return res;
    }

    private int calDepth(TreeNode root){
        int h = 0;
        if (root.left != null)
            h = Math.max(h, calDepth(root.left) + 1);
        if (root.right != null)
            h = Math.max(h, calDepth(root.right) + 1);
        return h;
    }

    private void dfs(List<List<String>> res, TreeNode root, int r, int c, int height){
        res.get(r).set(c, Integer.toString(root.val));
        if (root.left != null)
            dfs(res, root.left, r + 1, c - (1 << (height - r - 1)), height);
        if (root.right != null)
            dfs(res, root.right, r + 1, c + (1 << (height - r - 1)), height);
    }
}