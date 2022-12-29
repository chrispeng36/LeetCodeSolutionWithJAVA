package No1028;

import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 2022/12/28 10:59
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode {
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

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        //存储当前节点的路径
        LinkedList<TreeNode> path = new LinkedList<>();
        //存储字符串中的位置
        int pos = 0;
        while (pos < traversal.length()) {
            //获取当前层数
            int level = 0;
            while (traversal.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            //获取节点值
            int value = 0;
            while (pos < traversal.length() && Character.isDigit(traversal.charAt(pos))) {
                value = value * 10 + (traversal.charAt(pos) - '0');;
                ++pos;
            }
            //构造当前节点
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                //如果当前节点的深度 == 当前路径长度 （前一个节点就是当前节点的父节点）
                if (! path.isEmpty()) {
                    //如果当前节点不是第一个节点，那么前一个节点的左子节点为当前节点
                    path.peek().left = node;
                }
            } else {
                //如果当前节点的深度 != 当前路径长度（前一个节点不是当前节点的父节点）
                while (level != path.size()) {
                    //通过queue弹出其他子结点，找到当前节点的父节点
                    path.pop();
                }
                //找到父节点，因为此时左子节点已经确定，所以赋值给右子结点
                path.peek().right = node;
            }
            path.push(node); //放入queue中
        }
        //全部弹出，只剩根节点
        while (path.size() > 1) path.pop();
        //返回根
        return path.peek();
    }
}
