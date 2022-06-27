package No508;

//import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/6/19 0:59
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

class Solution {
    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
       if (root == null) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        //求出map中value最大值对应的key
        LinkedList<Integer> res = new LinkedList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == max)
                res.add(i);
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private int helper(TreeNode root, Map<Integer, Integer> map){
        if (root == null)
            return 0;
        //求出当前节点为根的元素和
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int val = left + right + root.val;
        map.put(val, map.getOrDefault(val, 0) + 1);
        max = Math.max(max, map.get(val));
        return val;
    }
}

