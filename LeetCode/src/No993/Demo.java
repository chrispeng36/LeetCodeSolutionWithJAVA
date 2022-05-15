package No993;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/4/13 13:43
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode left3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(5);
        root.left = left1;root.right = left3;
        left1.right = left2;left3.right = left4;
        Solution solution = new Solution();
        boolean cousins = solution.isCousins(root, 5, 4);
        System.out.println(cousins);
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;//空的树不合理
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<Integer, Integer> relations = new HashMap<>();
        while (! queue.isEmpty()){
            int size = queue.size();
            //每层开始遍历前都用下标指示间距
            boolean x_visited = false;
            boolean y_visited = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //层序遍历每次抛出一个节点，切抛出来的节点都是当前层的
                if (node.left != null){
                    queue.add(node.left);
                    relations.put(node.left.val, node.val);
                }
                if (node.right != null){
                    queue.add(node.right);
                    relations.put(node.right.val, node.val);
                }
                if (node.val == x)
                    x_visited = true;
                if (node.val == y)
                    y_visited = true;
            }
            if (x_visited && y_visited){
                //两个都被访问了，说明同一层中有两个元素
                if (relations.get(x) != relations.get(y))
                    return true;
                else
                    return false;
            }else if (x_visited || y_visited){
                //只有一个被访问，那么必然不在同一层中
                return false;
            }
        }
//        System.out.println("================");
        return false;
    }
}
