package No116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/3/8 0:12
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(){}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}


class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Node tempNode = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tempNode);
        while (! queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                Node node = queue.poll();
                if (size == 1){
                    node.next = null;
                }else {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size --;
            }
        }
        return root;
    }
}


