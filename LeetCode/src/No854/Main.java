//package No854;
//
//import java.util.ArrayDeque;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author ChrisPeng
// * @date 9/21/2022 9:28 AM
// */
//public class Main {
//    public static void main(String[] args) {
//
//    }
//}
//
////class Solution {
////    public int kSimilarity(String s1, String s2) {
////
////        int n = s1.length();
////        new ArrayDeque<Pair<>>()
////    }
////}
//
//class Solution {
//    public int kSimilarity(String s1, String s2) {
//        /**
//         * 设字符串长度为n，如果当前第i个字符满足s1[i] != s2[i]
//         * 则从s1[i+1, i+2, ...]中选择一个合适的字符s1[j]进行交换
//         * 其中s1[j]=s2[i],每次我们进行交换的时候，可以将字符串s1的前x个字符通过交换使得
//         * s1[0, ..., x - 1] = s2[0,...,x-1]，最终使得s1的所有字符与s2相等即可
//         * 在搜索时，我们需要进行减枝，我们设当前的通过交换后的字符串 s1' 为一个中间状态，
//         * 用哈希表记录这些中间状态，当通过交换时发现当前状态已经计算过，则此时我们可以直接跳过该状态。
//         */
//        int n = s1.length();
//        Queue<Pair<String, Integer>> queue = new ArrayDeque<Pair<String, Integer>>();
//        Set<String> visit = new HashSet<String>();
//        queue.offer(new Pair<String, Integer>(s1, 0));
//        visit.add(s1);
//        int step = 0;
//        while (!queue.isEmpty()) {
//            int sz = queue.size();
//            for (int i = 0; i < sz; i++) {
//                Pair<String, Integer> pair = queue.poll();
//                String cur = pair.getKey();
//                int pos = pair.getValue();
//                if (cur.equals(s2)) {
//                    return step;
//                }
//                while (pos < n && cur.charAt(pos) == s2.charAt(pos)) {
//                    pos++;
//                }
//                for (int j = pos + 1; j < n; j++) {
//                    if (s2.charAt(j) == cur.charAt(j)) {
//                        continue;
//                    }
//                    if (s2.charAt(pos) == cur.charAt(j)) {
//                        String next = swap(cur, pos, j);
//                        if (!visit.contains(next)) {
//                            visit.add(next);
//                            queue.offer(new Pair<String, Integer>(next, pos + 1));
//                        }
//                    }
//                }
//            }
//            step++;
//        }
//        return step;
//    }
//
//    public String swap(String cur, int i, int j) {
//        char[] arr = cur.toCharArray();
//        char c = arr[i];
//        arr[i] = arr[j];
//        arr[j] = c;
//        return new String(arr);
//    }
//}
//
