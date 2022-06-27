package JianzhiOfferii085;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/5/30 21:57
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        //正整数n代表生成括号的对数，设计一个函数，用于能够生成所有可能的并且有效的括号组合
        String str = "";
        dfs(n, n, str);
        return result;
    }

    public void dfs(int left, int right, String s){
        if (right == 0 && left == 0){
            result.add(new String(s));
            return;
        }
        // 保证不能超过括号对的数量，同时右括号的使用次数不能超过左括号的次数
        if (left < 0 || right < 0 || right < left) {
            return;
        }
        dfs(left-1,right,s+"(");
        dfs(left,right-1,s+")");
    }
}