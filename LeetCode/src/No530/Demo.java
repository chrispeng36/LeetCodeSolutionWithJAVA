package No530;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/3/16 17:11
 */
public class Demo {
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
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        while (! stk.isEmpty() || cur != null){
            while (cur != null){
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();;

            if (nodeList.size() >= 1){
                int val = nodeList.get(nodeList.size() - 1).val;
                if (cur.val - val < res)
                    res = cur.val - val;
            }
            nodeList.add(cur);
            cur = cur.right;
        }
        return res;
    }
}

class Solution1{
    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if (root == null)
            return;
        dfs(root.left);
        if (pre == -1)
            pre = root.val;
        else{
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}