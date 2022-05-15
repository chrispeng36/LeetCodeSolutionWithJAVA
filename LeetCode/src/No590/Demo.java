package No590;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/3/12 10:29
 */
public class Demo {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node child11 = new Node(3);
        Node child12 = new Node(2);
        Node child13 = new Node(4);
        Node child21 = new Node(5);
        Node child22 = new Node(6);
        ArrayList<Node> children1 = new ArrayList<>();
        children1.add(child11);children1.add(child12);children1.add(child13);
        ArrayList<Node> children2 = new ArrayList<>();
        children2.add(child21);children2.add(child22);
        root.children = children1;child11.children = children2;
        Solution solution = new Solution();
        List<Integer> list = solution.postorder(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

class Node{
    public int val;
    public List<Node> children;

    public Node(){}

    public Node(int _val){this.val = _val;}

    public Node(int _val, List<Node>_children){
        this.val = _val;
        this.children = _children;
    }
}

//class Solution {
//    ArrayList<Integer> res = new ArrayList<>();
//    public List<Integer> postorder(Node root) {
//        /**
//         * 后序遍历就是先左后右再中间
//         */
//        if (root != null){
//            if (root.children == null)
//                res.add(root.val);
//            else{
//                for (int i = 0; i < root.children.size(); i++) {
//                    postorder(root.children.get(i));
////                    System.out.println("===========================");
//                }
//                res.add(root.val);
//            }
//        }
//        return res;
//    }
//}

/**
 * 下面使用迭代的方式来解决这个问题
 */

class Solution{
    public List<Integer> postorder(Node root){
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;

        LinkedList<Node> l = new LinkedList<>();
        l.add(root);

        while(!l.isEmpty()){
            Node t = l.pollLast();
            if (t.children != null)
                for(Node n : t.children) l.addLast(n);
            res.addFirst(t.val);
        }

        return res;
    }
}