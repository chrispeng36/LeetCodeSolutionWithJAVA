package No106;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/3/15 9:54
 */
public class test01 {
    public static void main(String[] args) {

    }
}

class TreeNode2{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode2() {
    }

    public TreeNode2(int val) {
        this.val = val;
    }

    public TreeNode2(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution2{
    int post_idx;
    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder){
        //首先后续遍历定位到最后一个元素
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for (int i : inorder) {
            map.put(i,idx);//将中序遍历的装入哈希表中
        }
        return helper(0,inorder.length - 1);
    }

    public TreeNode helper(int left, int right){
        //如果没有节点就结束构造二叉树
        if (left > right)
            return null;
        //选择post_idx位置来开始
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        //根据root所在的位置分为两个子树
        int index = map.get(root_val);
        //下标减一
        post_idx --;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }
}