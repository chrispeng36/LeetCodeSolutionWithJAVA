package No6018;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ChrisPeng
 * @date 2022/3/6 11:27
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> sonSet = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            //假如map里面没有孩子节点，new
            if (! map.containsKey(descriptions[i][1])){
                TreeNode son = new TreeNode(descriptions[i][1]);
                map.put(descriptions[i][1], son);
            }
            //将孩子添加到set
            sonSet.add(descriptions[i][1]);
            //加入map没有父子，new
            if (! map.containsKey(descriptions[i][0])){
                TreeNode p = new TreeNode(descriptions[i][0]);
                map.put(descriptions[i][0],p);
            }
            TreeNode tmp = map.get(descriptions[i][0]);
            //给父节点添加左孩子或者右孩子，再put
            if (descriptions[i][2] == 1){
                tmp.left = map.get(descriptions[i][1]);
            }else {
                tmp.right = map.get(descriptions[i][1]);
            }
            map.put(descriptions[i][0],tmp);
        }
        //寻找节点
        for (int i = 0; i < descriptions.length; i++) {
            if (! sonSet.contains(descriptions[i][0])){
                return map.get(descriptions[i][0]);
            }
        }
        return null;
    }
}