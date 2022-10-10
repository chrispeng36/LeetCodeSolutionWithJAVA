package Zhongxing;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/16/2022 7:38 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int rows_count = scanner.nextInt();
        if (rows_count < 2)
            System.out.println(str);//直接输出就ok
        int len = Math.min(str.length(), rows_count);
        String[] rows = new String[len];//最多是由这么多行
        for (int i = 0; i < len; i++) {
            rows[i] = "";
        }
        int cur = 0;
        boolean go_down = false;
        for (int i = 0; i < str.length(); i++) {
            rows[cur] += str.substring(i, i + 1);
            if (cur == 0 || cur == rows_count - 1)
                go_down = !go_down;//掉方向
            cur += go_down ? 1 : -1;//向上或者继续向下
        }
        String changed = "";
        for (String row : rows) {
            changed += row;
        }
        System.out.println(changed);
    }
}
