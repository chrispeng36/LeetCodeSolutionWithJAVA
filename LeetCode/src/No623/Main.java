package No623;

/**
 * @author ChrisPeng
 * @date 2022/8/5 15:05
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;
        if (depth == 1){
            //深度为1，新建一个root，将原来的root作为其left
            return new TreeNode(val, root, null);
        }
        if (depth == 2){
            //当depth为2需要在root下新增两个结点left和right
            //并把原左子节点作为left的左子节点，原来的右子结点作为right的右子结点
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        }else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }
}