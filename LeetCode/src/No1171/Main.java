package No1171;

import java.util.HashMap;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 8/30/2022 5:10 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution{
    public ListNode removeZeroSumSublists(ListNode head){
        HashMap<Integer, ListNode> sumMap = new HashMap<>();//前缀和->当前节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        int sum = 0;
        sumMap.put(0, dummy);
        while (p != null){
            sum += p.val;
            if (sumMap.containsKey(sum)){
                //如果出现了跟之前一样的结果，说明一定是有中间和为0的情况的
                ListNode node = sumMap.get(sum);
                ListNode del = node.next;
                node.next = p.next;//直接跳过中间的，删除中间和为0的

                int dSum = sum;
                while (del != p){
                    dSum += del.val;
                    sumMap.remove(dSum);//将断开的结点从map中去除
                    del = del.next;
                }
            }else {
                sumMap.put(sum, p);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
