package wangyi.Por4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/4/2022 3:04 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//节点数
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> weight_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int node_i = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i + 1);//这里代表的是每个节点
            weight_map.put(i + 1, node_i);//存放权值
            map.put(i + 1, list);
        }

        for (int i = 0; i < n - 1; i++) {
            int start_node = scanner.nextInt();
            int end_node = scanner.nextInt();
            List<Integer> temp_list = map.get(start_node);
            temp_list.add(weight_map.get(end_node));
            if (map.containsKey(end_node) && map.get(end_node).size() > 1){
                for (Integer node : map.get(end_node)) {//把孩子结点中的孩子也加上
                    temp_list.add(weight_map.get(node));
                }
            }
            map.put(start_node, temp_list);
        }
        int res = 0;

        for (Integer integer : map.keySet()) {
            List<Integer> list = map.get(integer);
            int multi = 1;
            for (Integer val : list) {
//                System.out.println(val);
                multi *= weight_map.get(val);
            }
            res += del_count(multi);
        }
        System.out.println(res);
    }
    public static int del_count(int num){
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                res ++;
        }
        return res;
    }
}
