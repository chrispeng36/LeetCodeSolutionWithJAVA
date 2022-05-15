package No449;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/5/11 9:41
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;root.right = right;
        Codec codec = new Codec();
        String s = codec.serialize(root);
        System.out.println(s);
        TreeNode node = codec.deserialize("[1,2,3,4,5,6]");
        System.out.println(node.val);
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        serial(root,sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] parts = data.split(",");
        int n = parts.length;
        int[] items = new int[n];
        for(int i =0 ; i < n; i++){
            items[i] = Integer.parseInt(parts[i]);
        }
        return deserial(items,0,n-1);

    }

    public TreeNode deserial(int[] parts, int start, int end){
        TreeNode curr = new TreeNode(parts[start]);
        int index = start;
        while (index+1<parts.length&&parts[index+1]<parts[start]){
            index++;
        }
        if(index>start){
            curr.left = deserial(parts,start+1,index);
        }
        if(index<end){
            curr.right = deserial(parts,index+1,end);
        }
        return curr;
    }

    private void serial(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val);
        sb.append(",");
        serial(root.left,sb);
        serial(root.right,sb);

    }
}

