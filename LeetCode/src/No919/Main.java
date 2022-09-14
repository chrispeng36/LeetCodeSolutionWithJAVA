package No919;

import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 2022/7/26 11:13
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode() {}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CBTInserter{
    TreeNode tree;
    public CBTInserter(TreeNode root) {
        tree = root;
    }

    public int insert(int val) {
        int result = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (! queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                //满二叉树
                if (temp.left == null && temp.right == null){
                    //插左边
                    temp.left = new TreeNode(val);
                    result = temp.val;
                    //找到结束所有循环
                    while (! queue.isEmpty())
                        queue.poll();
                    break;
                }
                //完全二叉树
                if (temp.right == null){
                    //插右边
                    temp.right = new TreeNode(val);
                    result = temp.val;
                    //找到结束所有循环
                    while (! queue.isEmpty())
                        queue.poll();
                    break;
                }
                //左子树不为空
                if (temp.left != null)
                    queue.offer(temp.left);
                //右子树不为空
                if (temp.right != null)
                    queue.offer(temp.right);
            }
        }
        return result;
    }

    public TreeNode get_root() {
        return tree;
    }
}