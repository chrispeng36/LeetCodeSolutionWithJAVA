package chinatel.PRO1;

import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 2022/6/5 19:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int max, s, min;
        int count = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            max = arr[i][0];
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
            s = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == max){
                    a[s] = j;
                    s ++;
                }
            }

            min = max;
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < n; k++) {
                    if (min > arr[k][a[j]])
                        break;
                    if (k == n - 1){
                        System.out.println(i + " " + a[j]);
                        count ++;
                    }
                }
            }
        }
        if (count == 0)
            System.out.println("NONE");
    }
}
