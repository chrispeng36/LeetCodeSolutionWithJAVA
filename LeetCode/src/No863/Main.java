package No863;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/12/14 11:29
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
    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //若将target当做树的根结点，就能从target出发，找到距离为k的所有节点
        //从根结点root出发，使用深度优先搜索遍历整棵树，同时用哈希表记录每个节点的父节点
        //然后从target出发，使用深度优先搜索遍历整棵树，除了左右孩子之外，还可以顺着父节点向上搜索

        //从root出发DFS，记录每个节点的父节点
        findParents(root);
        //从target出发DFS，寻找所有深度为k的结点
        findAns(target, null, 0, k);
        return ans;
    }

    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) return;
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from)
            findAns(node.left, node, depth + 1, k);
        if (node.right != from)
            findAns(node.right, node, depth + 1, k);
        //避免深度优先搜索时重复访问结点
        if (parents.get(node.val) != from)
            findAns(parents.get(node.val), node, depth + 1, k);
    }
}