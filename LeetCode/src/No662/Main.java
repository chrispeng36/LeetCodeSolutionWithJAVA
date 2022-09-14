package No662;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 8/27/2022 4:33 PM
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
    private int maxW = 0;
    public int widthOfBinaryTree(TreeNode root) {
        /**
         * 假设满二叉树表示成数组序列，根结点所在的位置为1，
         * 位于i节点的左右子结点的index为2*i和2*i+1
         * 用一个list保存每层的左端点，在dfs过程中记录每个节点的index及其所在层level
         * 如果level > list.size()说明当前节点就是新一层的最左节点，将其加入list中
         * 否则判断当前节点的index减去list中对应层的最左节点的index的宽度是否大于最大宽度并更新
         */
        dfs(root, 1, 1, new ArrayList<>());
        return maxW;
    }

    private void dfs(TreeNode r, int level, int index, List<Integer> left){
        if (r == null) return;
        if (level > left.size())
            left.add(index);
        maxW = Math.max(maxW, index - left.get(level - 1) + 1);
        dfs(r.left, level + 1, index * 2, left);
        dfs(r.right, level + 1, index * 2 + 1, left);
    }
}
