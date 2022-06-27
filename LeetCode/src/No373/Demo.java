//package No373;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//
///**
// * @author ChrisPeng
// * @date 2022/1/14 11:10
// */
//public class Demo {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] num1 = {1,7,11};
//        int[] num2 = {2,4,6};
//        List<List<Integer>> lists = solution.kSmallestPairs(num1, num2, 3);
//        for (List<Integer> list : lists) {
//            for (Integer integer : list) {
//                System.out.print(integer);
//            }
//            System.out.println();
//        }
//    }
//}
//
//class Solution {
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> ans = new ArrayList<>();
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
//        for (int i = 0; i < Math.min(nums1.length, k); i++) {
//            pq.add(new int[]{i, 0});
//        }
//        while (k > 0 && !pq.isEmpty()) {
//            int[] idx = pq.poll();
//            ans.add(List.of(nums1[idx[0]], nums2[idx[1]]));
//            if (idx[1] + 1 < nums2.length) {
//                pq.add(new int[]{idx[0], idx[1] + 1});
//            }
//            k--;
//        }
//        return ans;
//    }
//}
