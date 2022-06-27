package No95;

//import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/6/1 19:19
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

class Solution{
    public List<TreeNode> generateTrees(int n){
        //给定一个整数，生成并返回所有由n个结点且结点值从1-n互不相同的二叉搜索树
        //二叉搜索树的左子节点要比其小，右子结点比根结点大
        /**
         * 假设枚举的根结点的值为i，
         * 那么左子树的集合就是[1,...,i - 1]
         * 右子树的集合就是[i + 1, ..., n]
         * 左子树和右子树相较于生成问题就是一个序列长度缩小的子问题，那么考虑回溯的算法
         * 定义generateTree(start, end)表示当前值的集合为[start, end]
         * 考虑枚举[start, end]中的值i为当前二叉搜索树的根
         * 递归调用[start, i - 1], [i + 1, end]这两部分，可以获得所有可行的左子树和右子树
         * 最后一步就是从可行左子树中选一颗，可行右子树选取一颗拼接到根结点上
         */
        if (n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end){
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }
        //枚举可行的根结点
        for (int i = start; i <= end; i++) {
            //获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            //获取所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            //从左子树集合中选出一颗左子树，从右子树中选出一颗右子树，拼接到根结点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = left;
                    curTree.right = right;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }
}