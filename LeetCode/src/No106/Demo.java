package No106;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/3/14 12:43
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
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer,Integer>idx_map = new HashMap<Integer,Integer>();
    public TreeNode helper(int in_left, int in_right){
        //如果这里没有节点构造二叉树了,就结束
        if (in_left > in_right)
            return null;
        //选择post_idx位置的元素作为当前子树的根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        //根据root所在位置分为两个子树
        int index = idx_map.get(root_val);
        //下标减一
        post_idx --;
        //构造右子树
        root.right = helper(index + 1, in_right);
        //构造左子树
        root.left = helper(in_left,index - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //给定中序和后续遍历地结果,返回构造这个二叉树
        /**
         * 后序遍历的数组的最后一个元素就是根节点
         * 可以利用已知的根节点信息在中序的数组中找到根节点所在的下标
         * 然后根据其将中序遍历的数组分成左右两部分,左边是左子树,右边是右子树
         * 针对每个部分可以用同样的方法继续递归下去
         */
        /**
         * 为了高效查找根节点元素在中序遍历数组中的下标，
         * 我们选择创建哈希表来存储中序序列，即建立一个（元素，下标）键值对的哈希表。
         *
         * 定义递归函数 helper(in_left, in_right) 表示当前递归到中序序列中当前子树的左右边界，递归入口为helper(0, n - 1) ：
         *
         * 如果 in_left > in_right，说明子树为空，返回空节点。
         *
         * 选择后序遍历的最后一个节点作为根节点。
         *
         * 利用哈希表 O(1)O(1) 查询当根节点在中序遍历中下标为 index。从 in_left 到 index - 1 属于左子树，从 index + 1 到 in_right 属于右子树。
         *
         * 根据后序遍历逻辑，递归创建右子树 helper(index + 1, in_right) 和左子树 helper(in_left, index - 1)。注意这里有需要先创建右子树，再创建左子树的依赖关系。可以理解为在后序遍历的数组中整个数组是先存储左子树的节点，再存储右子树的节点，最后存储根节点，如果按每次选择「后序遍历的最后一个节点」为根节点，则先被构造出来的应该为右子树。
         */
        this.postorder = postorder;
        this.inorder = inorder;
        //从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;
        //建立(元素,下标)键值对的哈希表
        int idx = 0;
        for (int val : inorder) {
            idx_map.put(val,idx++);
        }
        return helper(0, inorder.length - 1);
    }
}