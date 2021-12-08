package No559;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/11/22 23:52
 */
public class Demo {
    public static void main(String[] args) {
//        Node root = new Node(1);
//        Node depth11 = new Node(2);
//        Node depth12 = new Node(3);
//        Node depth13 = new Node(4);
//        Node depth14 = new Node(5);
//        ArrayList<Node> children1 = new ArrayList<>();
//        children1.add(depth11);children1.add(depth12);children1.add(depth13);children1.add(depth14);
//        Node depth21 = new Node(6);
//        Node depth22 = new Node(7);
//        Node depth23 = new Node(8);
//        Node depth24 = new Node(9);
//        Node depth25 = new Node(10);
//        ArrayList<Node> children2 = new ArrayList<>();
//        children2.add(depth21);children2.add(depth22);
//        ArrayList<Node> children3 = new ArrayList<>();
//        children3.add(depth24);children3.add(depth25);
//        Node depth31 = new Node(11);
//        Node depth32 = new Node(12);
//        Node depth33 = new Node(13);
//        Node depth41 = new Node(14);
//        root.children = children1;
//        depth12.children = children2;
//        depth14.children = children3;
////        ArrayList<Node> children4 = new ArrayList<>();
//        depth22.children = Arrays.stream(new Node[]{depth31}).toList();
//        depth23.children = Arrays.stream(new Node[]{depth32}).toList();
//        depth24.children = Arrays.stream(new Node[]{depth33}).toList();
//        depth31.children = Arrays.stream(new Node[]{depth41}).toList();
//        Solution solution = new Solution();
//        int i = solution.maxDepth(root);
//        System.out.println(i);
        Node root = new Node(1);
        Node child1 = new Node(3);
        Node child2 = new Node(2);
        Node child3 = new Node(4);
        Node child4 = new Node(5);
        Node child5 = new Node(6);
        ArrayList<Node> child = new ArrayList<>();
        child.add(child1);child.add(child2);child.add(child3);
        root.children = child;
        ArrayList<Node> child11 = new ArrayList<>();
        child11.add(child4);child11.add(child5);
        child1.children = child11;
        Solution solution = new Solution();
        int i = solution.maxDepth(root);
        System.out.println(i);


    }
}

class Node{
    public int val;
    public List<Node> children;

    public Node(){}
    public Node(int _val){
        this.val = _val;
    }
    public Node(int _val,List<Node> _children){
        this.val = _val;
        this.children = _children;
    }
}

class Solution {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.children == null)
            return 1;

        int[] arr = new int[root.children.size()];
        int i = 0;
        for (Node child : root.children) {
            arr[i] = maxDepth(child) + 1;
            i ++;
        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}