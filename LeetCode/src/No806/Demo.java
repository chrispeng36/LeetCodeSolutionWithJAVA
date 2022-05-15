package No806;

/**
 * @author ChrisPeng
 * @date 2022/4/12 8:58
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] res = solution.numberOfLines(widths, "bbbcccdddaaa");
        for (int re : res) {
            System.out.println(re);
        }
    }
}

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        if (s.length() == 0){
            int[] res = {0,0};
            return res;
        }
        int tempCount = 0;//用来计数占了多少个单位,统计最后一行占的数目
        int rows = 1;
        for (int i = 0; i < s.length(); i++) {
            tempCount += widths[s.charAt(i) - 'a'];
            if (tempCount > 100){
                tempCount = widths[s.charAt(i) - 'a'];
                rows ++;
            }
        }
        int[] res = {rows, tempCount};
        return res;
    }
}
