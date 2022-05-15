package No450;

/**
 * @author ChrisPeng
 * @date 2022/3/21 9:50
 */
public class test01 {
    public static void main(String[] args) {

    }
}

class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1() {
    }

    public TreeNode1(int val) {
        this.val = val;
    }

    public TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution1{
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return root;//没找到节点
        if (root.val == key){//找到了节点
            if (root.left == null)
                return root.right;//如果节点的左子节点是空的，就返回右子树
            else if (root.right == null)
                return root.left;//如果右子节点为空，就返回左子树
            else {//都不为空，首先找到右子树的最左边的孩子节点，将左子树添加到其上，以右子节点为根节点
                TreeNode cur = root.right;
                while (cur.left != null)
                    cur = cur.left;
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}