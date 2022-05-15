package Mianshi08_06;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/3/29 13:45
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    List<Integer> A;
    List<Integer> C;
    List<Integer> B;
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        this.A = A;
        this.B = B;
        this.C = C;
        move(A,C,A.size());
    }
    private void move(List<Integer> A, List<Integer> C, int n){
        this.A = A;
        this.C = C;
        if (n == 1) {
            Integer num = A.remove(A.size() - 1);
            C.add(num);
        }else {
            move(A,B, n -1);
            //移动A到C
            Integer num = A.remove(A.size() - 1);
            C.add(num);
            move(B,C,n - 1);
        }
    }
}
