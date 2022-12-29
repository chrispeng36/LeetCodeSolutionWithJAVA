package No1759;

/**
 * @author ChrisPeng
 * @date 2022/12/26 10:27
 */
public class Main {
        public static void main(String[] args) {
                Solution solution = new Solution();
                int i = solution.countHomogenous("abbcccaa");
                System.out.println(i);
        }
}

class Solution {
        int INF = 1000000000 + 7;
        public int countHomogenous(String s) {
                //如果是有n个完全一样的话，那么总共的个数就是n * (n + 1) / 2
                int len = s.length();
                int i = 0;
                long res = 0;
                while (i < len) {
                        int j = i;
                        while (j < len) {
                                if (s.charAt(j) != s.charAt(i)) {
                                        break;
                                }
                                j ++;
                        }
                        //跳出来的地方是第一个不相同的字符串的地方
                        res = (res + (j - i) * (j - i + 1) / 2 % INF) % INF;
                        i = j;
                }
                return (int) res;
        }
}

