package No589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/10 4:55
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Node{
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return res;
    }
}
