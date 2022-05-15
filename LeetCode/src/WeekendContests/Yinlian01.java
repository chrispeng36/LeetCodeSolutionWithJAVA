package WeekendContests;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/13 17:00
 */
public class Yinlian01 {
    public static void main(String[] args) {

    }
}


class ListNode{
    int val;
    ListNode next;
    ListNode(int x){this.val = x;}
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        //借助另外的容器吧
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer num = list.remove(i);
            if (isPalindromeList(list)) return true;
            else list.add(num);
        }
        return false;
    }
    private boolean isPalindromeList(List<Integer> list){
        int i = 0, j = list.size() - 1;
        while (i < j){
            if (list.get(i) != list.get(j)) return false;
        }
        return true;
    }
}