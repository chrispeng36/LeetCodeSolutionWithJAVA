package No654;

/**
 * @author ChrisPeng
 * @date 2022/3/15 19:15
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        /**
         * 递归的构建一颗最大二叉树：
         * 创建一个根节点，其值为num中的最大值
         * 递归的在最大值的左边子数组前缀上构建左子树
         * 递归的在最大值右边的子数组后缀上构建右子树
         */
        return helper(nums, 0, nums.length);
    }

    //递归构造节点
    private TreeNode helper(int[] nums, int left, int right){
        if (left >= right) return null;
        int maxValueIndex = left;
        for (int i = left + 1; i < right; ++i){
            if (nums[i] > nums[maxValueIndex]) maxValueIndex = i;
        }

        //当前的根节点就是最大值的节点
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        //构造左子节点
        root.left = helper(nums, left, maxValueIndex);
        //构造右子树
        root.right = helper(nums, maxValueIndex + 1,right);
        return root;
    }
}
