package Huawei.Demo1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author ChrisPeng
 * @date 9/21/2022 7:04 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//某天运行的单位时间数N
        int[] records = new int[N];//每单位时间产生的日志数量
        int sum = 0;//日志总条数
        for (int i = 0; i < N; i++) {
            records[i] = scanner.nextInt();
            sum += records[i];
        }
        int total = scanner.nextInt();//一天可以保存的日志
        if (total > sum)
            System.out.println(-1);
        //使用贪心的策略？
        Arrays.sort(records);
        int res = -1;
        for (int i = records[N - 1]; i >= 0; i--) {
            int temp_sum = 0;
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                temp_sum += records[j] <= i ? records[j] : i;
                if (temp_sum > total){
                    flag = false;
                    break;
                }
            }
            if (flag){
                res = i;
                break;//说明找到了那个最大的
            }
        }
        System.out.println(res);
    }
}


