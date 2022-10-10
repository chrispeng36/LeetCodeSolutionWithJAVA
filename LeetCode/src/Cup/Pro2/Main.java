//package Cup.Pro2;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// * @author ChrisPeng
// * @date 9/24/2022 3:46 PM
// */
//public class Main {
//    public static void main(String[] args) {
//        int[][] arr = {{0, 3}, {1, 0}, {1, 3}, {2, 0}, {3, 0}, {3, 2}};
//        Solution solution = new Solution();
//        int i = solution.transportationHub(arr);
//        System.out.println(i);
//    }
//}
//
//class Solution {
//    public int transportationHub(int[][] path) {
//        /**
//         * 1. 该点是所有其他点的target
//         * 2. 该点不作为source
//         * 这样的点要有的话也只有一个吧？
//         * 首先我得统计节点的个数
//         */
//        int len = path.length;
//        ArrayList<Integer> nodes = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            if (!nodes.contains(path[i][0])) nodes.add(path[i][0]);
//            if (!nodes.contains(path[i][1])) nodes.add(path[i][1]);
//        }
//        int nodes_count = nodes.size();
//        int[][] adjacency = new int[nodes_count][nodes_count];
//        for (int i = 0; i < len; i++) {
//            int row = path[i][0], col = path[i][1];
//            adjacency[row][col] = -1;//表示从这个节点出
//            adjacency[col][row] = 1;//表示进入这个节点
//        }
//        for (int i = 0; i < nodes_count; i++) {
//
//        }
//    }
//}