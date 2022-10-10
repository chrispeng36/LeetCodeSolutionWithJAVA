package Ali.Pro1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/22/2022 9:59 AM
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //四个数加起来是偶数的话，那必然是3偶数+1奇数或者3奇数+1偶数
        if (n == 1)
            System.out.println(1);
        if (n == 2)
            System.out.println(-1);
        int[][] dp3 = {{1,3,2},{7,4,6},{9,5,8}};
        LinkedList<int[][]> list = new LinkedList<>();
        int[][] dp1 = {{1}};
        int[][] dp2 = {{}};
        list.add(dp2);//为了对齐序号
        list.add(dp1);
        list.add(dp2);
        list.add(dp3);
        for (int i = 4; i <= n; i++) {
            int[][] temp = list.get(i - 1);
            int[][] add = new int[i][i];
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp.length; k++) {
                    add[j][k] = temp[j][k];
                }
            }
            //填充边缘,上到下，右到左
            for (int j = 0; j < i; j++) {
                add[j][i - 1] = (i - 1) * (i - 1) + 1 +j;
            }
            for (int j = i - 1; j > 0; j--) {
                add[i - 1][i - 1 - j] = (i - 1) * (i - 1) + i + j;
            }
            list.add(add);
        }
        int[][] ints = list.get(n);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
