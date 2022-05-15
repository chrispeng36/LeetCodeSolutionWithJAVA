package No682;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/3/26 16:56
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"5","2","C","D","+"};
        int i = solution.calPoints(arr);
        System.out.println(i);
    }
}


class Solution {
    public int calPoints(String[] ops) {
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < ops.length; i++) {
//            if (ops[i].matches("^(0|[1-9][0-9]*|-[1-9][0-9]*)$"))
//                list.add(ops[i]);//数字
//            else if (ops[i].equals("C"))
//                list.remove(list.size() - 1);//C就移除前一个数字
//            else if (ops[i].equals("D"))
//                list.add(Integer.valueOf(list.get(list.size() - 1)) * 2 + "");
//            else if (ops[i].equals("+"))
//                list.add(Integer.valueOf(list.get(list.size() - 1)) + Integer.valueOf(list.get(list.size() - 2)) + "");
//        }
//        int res = 0;
//        for (String s : list) {
//            res += Integer.valueOf(s);
//        }
//        return res;
        //用栈来操作
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C"))
                stk.pop();
            else if (ops[i].equals("D")){
                int a = stk.peek();
                stk.push(2 * a);
            }
            else if (ops[i].equals("+")){
                int a = stk.pop();
                int b = stk.peek();
                stk.push(a);
                stk.push(a + b);
            }
            else
                stk.push(Integer.parseInt(ops[i]));
        }
        int res = 0;
        while (!stk.isEmpty())
            res += stk.pop();
        return res;
    }
}