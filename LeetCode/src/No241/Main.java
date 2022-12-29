package No241;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/12/14 16:25
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    /**
     * 分治法，碰到运算符号时，递归求解前一半的值和后一半的值，
     * 然后根据运算符号求解两者构成的值
     * @param expression
     * @return
     */
    //记录已经计算出来的值，避免重复计算
    public Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        //计算所有的优先级运算结果的返回值
        if (map.containsKey(expression)) return map.get(expression);
        ArrayList<Integer> res = new ArrayList<>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                //出现运算符号
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));

                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+' :
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(expression));
        map.put(expression, res);
        return res;
    }
}
