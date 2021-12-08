package No1447;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/10/18 10:20
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.simplifiedFractions(4);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution {
    public List<String> simplifiedFractions(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (commanDivisor(i,j) == 1){
                    list.add(i + "" + "/" + j);
                }
            }
        }
        return list;
    }
    //判断是否是最简分数
    public static int commanDivisor(int n,int m){
        while (n % m != 0){
            int temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }
}