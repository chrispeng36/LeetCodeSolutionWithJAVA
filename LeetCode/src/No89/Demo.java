package No89;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/1/8 10:59
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> integers = solution.grayCode(2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println(2 ^ 1);
    }
}

class Solution {
    public List<Integer> grayCode(int n) {
        //返回n位的格雷码序列
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i)
            ret.add(i ^ i>>1);
        return ret;
    }
}