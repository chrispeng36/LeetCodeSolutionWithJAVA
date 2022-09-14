package No652;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 9/5/2022 9:27 AM
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
    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //给定一颗二叉树，返回所有的重复子树
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    private String dfs(TreeNode node){
        if (node == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial))
            repeat.add(seen.get(serial));
        else
            seen.put(serial, node);
        return serial;
    }
}