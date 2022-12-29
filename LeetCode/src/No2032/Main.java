//package No2032;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * @author ChrisPeng
// * @date 2022/12/29 11:25
// */
//public class Main {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums1 = {1, 1, 3, 2};
//        solution.twoOutOfThree(nums1,nums1,nums1)
//    }
//}
//
//class Solution {
//    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            if (! map.containsKey(nums1[i])) {
//                map.put(nums1[i], 1);
//            }
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if (! map.containsKey(nums2[i])) {
//                map.put(nums2[i], 1);
//            } else {
//                map.put(nums2[i], map.get(nums2[i]) + 1);
//            }
//        }
//        for (int i = 0; i < nums3.length; i++) {
//            if (! map.containsKey(nums3[i])) {
//                map.put(nums3[i], 1);
//            } else {
//                map.put(nums3[i], map.get(nums3[i]) + 1);
//            }
//        }
//        for (Integer integer : map.keySet()) {
//            if (map.get(integer) > 1) {
//                res.add(integer);
//            }
//        }
//        return res;
//    }
//}
