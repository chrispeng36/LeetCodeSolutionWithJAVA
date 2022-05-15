package No1823;

/**
 * @author ChrisPeng
 * @date 2022/5/4 0:50
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findTheWinner(int n, int k) {
        /**
         * 约瑟夫环的通解：
         * f(N,M)，N个人报数，每报到M时淘汰一个人
         * f表示最终胜利者的编号
         * f(N,M)=(f(N-1,M)+M)%N
         */
        int winner = 1;
        for (int i = 2; i <= n; i++) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }
}