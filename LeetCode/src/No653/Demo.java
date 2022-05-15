package No653;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/21 9:12
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(4);
        TreeNode right1 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);
        root.left = left1;root.right = right1;
        left1.left = left2;left1.right = left2;
        right1.right = right2;

        boolean b = solution.findTarget(root, 28);
        System.out.println(b);
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
    LinkedList<Integer> list = new LinkedList<>();
    public boolean findTarget(TreeNode root, int k) {
        //给定二叉搜索树以及一个目标结果k，返回是否有两个元素之和等于目标结果
        List<Integer> inorder = inorder(root);
        int n = inorder.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - inorder.get(i))){
                return true;
            }
            map.put(inorder.get(i), i);
        }
        return false;
    }
    public List<Integer> inorder(TreeNode root){
        if (root == null)
            return list;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        return list;
    }
}
