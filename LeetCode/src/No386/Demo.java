package No386;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/4/18 0:56
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, res);
        }
        return res;
    }

    private static void dfs(int n, int target, List<Integer> list){
        if (target > n) return;
        list.add(target);
        target *= 10;
        for (int i = 0; i < 10; i++) {
            dfs(n, target + i, list);
        }
    }
}
