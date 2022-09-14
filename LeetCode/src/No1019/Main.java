package No1019;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/8/11 10:23
 */
public class Main {
    public static void main(String[] args) {

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return null;
        //创建list容器来存储数据
        ArrayList<Integer> list = new ArrayList<>();
        int size = 0;
        while (head != null){
            list.add(head.val);
            size ++;
            head = head.next;
        }
        //创建一个栈，这个栈里面存储的是对应位置的list元素及其之后元素中最大的值
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[size];
        // 3. 在 list 中从右往左遍历，stack 中凡是比 list.get(i) 小的都 pop 出去，
        // 这样 stack 剩下的元素都是比 list.get(i) 更大的元素。
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= list.get(i)){
                stack.pop();
            }
            ans[i] = stack.empty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return ans;
    }
}