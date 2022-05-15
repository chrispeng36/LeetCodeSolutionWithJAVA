package No429;

import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/3/7 13:43
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = new Node(1);
        Node child11 = new Node(3);
        Node child12 = new Node(2);
        Node child13 = new Node(4);
        ArrayList<Node> child1 = new ArrayList<>();
        child1.add(child11);child1.add(child12);child1.add(child13);
        Node child21 = new Node(5);
        Node child22 = new Node(6);
        ArrayList<Node> child2 = new ArrayList<>();
        child2.add(child21);child2.add(child22);
        root.children = child1;
        child11.children = child2;
        List<List<Integer>> lists = solution.levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

class Node{
    public int val;
    public List<Node> children;

    public Node(){}

    public Node(int _val){this.val = _val;}

    public Node(int _val, List<Node> _children){
        this.val = _val;
        this.children = _children;
    }
}


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tempList.add(node.val);
                if (node.children != null){
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
            }
            res.add(tempList);
        }
        return res;
    }
}