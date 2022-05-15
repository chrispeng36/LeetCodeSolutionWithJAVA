package No606;

/**
 * @author ChrisPeng
 * @date 2022/3/19 14:36
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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        if(root == null)
            return "";
        sb.append(root.val);
        if(root.right!=null){
            pre(root.left);
            pre(root.right);
        }
        else if(root.left !=null)
            pre(root.left);
        return sb.toString();
    }
    public void pre(TreeNode root){
        sb.append("(");
        if(root != null){
            sb.append(root.val);
            if(root.left == null && root.right == null){
                sb.append(")");
                return;
            }
        }
        else{
            sb.append(")");
            return;
        }
        pre(root.left);
        if(root.right !=null)
            pre(root.right);
        sb.append(")");
    }
}
