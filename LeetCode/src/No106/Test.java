package No106;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/3/14 19:19
 */
public class Test {
    public static void main(String[] args) {

    }
}

class TreeNode1{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode1() {
    }

    public TreeNode1(int val) {
        this.val = val;
    }

    public TreeNode1(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution1{
    int post_idx;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.postorder = postorder;
        this.inorder = inorder;
        //从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;
        //建立(元素，下标)键值对
        int idx = 0;
        for (int i : inorder) {
            map.put(i,idx ++);
        }
        return helper(0, inorder.length - 1);
    }
    public TreeNode helper(int left, int right){
        //如果没有节点构造二叉树了，就返回
        if(left > right)
            return null;
        //选择post_idx为当前子树的根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        //根据root所在的位置分为两个子树
        int index = map.get(root_val);//map中装的是中序遍历的节点
        //下标减一
        post_idx --;
        //构造右子树
        root.right = helper(index + 1, right);
        //构造左子树
        root.left = helper(left, index - 1);
        return root;
    }
}