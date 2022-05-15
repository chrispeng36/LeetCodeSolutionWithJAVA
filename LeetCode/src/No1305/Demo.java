package No1305;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/5/1 16:14
 */
public class Demo {
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return merge(inorderTraversal(root1,new ArrayList<>()),inorderTraversal(root2,new ArrayList<>()));
    }
    public List<Integer> merge(List<Integer> list1,List<Integer> list2){
        List<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i)<=list2.get(j)){
                ans.add(list1.get(i));
                i++;
            }
            else{
                ans.add(list2.get(j));
                j++;
            }
        }
        if(i==list1.size()){for(;j<list2.size();j++){ans.add(list2.get(j));}}
        else{for(;i<list1.size();i++){ans.add(list1.get(i));}}
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode t,List<Integer> ans){
        if(t!=null){
            inorderTraversal(t.left,ans);
            ans.add(t.val);
            inorderTraversal(t.right,ans);
        }
        return ans;
    }
}