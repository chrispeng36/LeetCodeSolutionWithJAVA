package No784;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/10/30 12:44
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> ans = new ArrayList<>();
        Queue<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()){
            StringBuilder curr = queue.peek();//取出队列的第一个元素
            if (curr.length() == s.length()){//说明已经找到了一个可行的答案
                ans.add(curr.toString());
                queue.poll();
            }else {
                int pos = curr.length();//开始的位置
                if (Character.isLetter(s.charAt(pos))){
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);//next用来装以后要遍历的字符串
                }
                curr.append(s.charAt(pos));
            }
        }
        return ans;
    }
}
