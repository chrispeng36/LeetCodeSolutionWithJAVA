package week319.No6235;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ChrisPeng
 * @date 2022/11/13 11:32
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
        public int MinimumOperations(TreeNode root)
        {
            int res=0;
            if(root==null)return res;
            ArrayDeque<TreeNode> que=new ArrayDeque<TreeNode>();
            que.addLast(root);
            while(que.size()>0)
            {
                int len=que.size();
                int cur=0;
                TreeNode[] arr= (TreeNode[]) que.toArray();
                for(int i=0;i<len;i++)
                {
                    cur=i;
                    for(int j=i+1;j<len;j++)
                    {
                        if(arr[j].val<arr[cur].val)
                        {
                            cur=j;
                        }
                    }
                    if(i!=cur)
                    {
                        swap(arr[i],arr[cur]);
                        res++;
                    }
                    TreeNode temp=que.poll();
                    if(temp.left!=null)que.add(temp.left);
                    if(temp.right!=null)que.add(temp.right);
                }
            }
            return res;
        }

        void swap(TreeNode left,TreeNode right)
        {
            int temp=left.val;
            left.val=right.val;
            right.val=temp;
        }
}