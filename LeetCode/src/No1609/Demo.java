package No1609;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2021/12/25 22:05
 */
public class Demo {
    public static void main(String[] args) {

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
    public boolean isEvenOddTree(TreeNode root) {
        boolean even = true;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()){
            int prev = even ? 0 : 1000000;
            for (int i = 0, n = q.size(); i < n; ++i) {
                TreeNode node = q.pollFirst();
                if (even && (prev >= node.val || node.val % 2 == 0)) {
                    return false;
                }
                if (!even && (prev <= node.val || node.val % 2 == 1)) {
                    return false;
                }
                prev = node.val;
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            }
            even = !even;
        }
        return true;
    }
}