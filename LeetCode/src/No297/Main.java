package No297;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/10/18 15:52
 */
public class Main {
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

//class Codec {
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null) return "";
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        StringJoiner sj = new StringJoiner(",");
//        queue.add(root);
//        sj.add(Integer.toString(root.val));
//        while (!queue.isEmpty()){
//            TreeNode head = queue.remove();
//            if (head.left != null){
//                queue.add(head.left);
//                sj.add(Integer.toString(head.left.val));
//            }else sj.add("null");
//            if (head.right != null){
//                queue.add(head.right);
//                sj.add(Integer.toString(head.right.val));
//            }else sj.add("null");
//        }
//        return sj.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.length() == 0) return null;
//        String[] nodes = data.split(",");
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//        queue.add(root);
//        int idx = 1, n = nodes.length;
//        while (idx < n){
//            TreeNode head = queue.remove();
//            if (!nodes[idx].equals("null")){
//                TreeNode left = new TreeNode(Integer.parseInt(nodes[idx]));
//                head.left = left;//left直接挂到head
//                queue.add(left);
//            }
//            idx ++;
//            if (idx < n && !nodes[idx].equals("null")){
//                TreeNode right = new TreeNode(Integer.parseInt(nodes[idx]));
//                head.right = right;
//                queue.add(right);
//            }
//            idx ++;
//        }
//        return root;
//    }
//}

class Codec{
    public String serialize(TreeNode root){
        StringBuilder res = ser_help(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder ser_help(TreeNode root, StringBuilder str){
        if (root == null){
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = ser_help(root.left, str);
        str = ser_help(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data){
        String[] str_word = data.split(",");
        LinkedList<String> list_word = new LinkedList<>(Arrays.asList(str_word));
        return deser_help(list_word);
    }

    public TreeNode deser_help(List<String> li){
        if (li.get(0).equals("null")){
            li.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.parseInt(li.get(0)));
        li.remove(0);
        res.left = deser_help(li);
        res.right = deser_help(li);
        return res;
    }
}