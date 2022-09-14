package No1282;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/8/12 9:20
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.computeIfAbsent(groupSizes[i], k -> new ArrayList<Integer>());
            list.add(i);
        }

        LinkedList<List<Integer>> results = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int groupLength = entry.getKey();
            List<Integer> list = entry.getValue();
            //N个人要分成多少个组
            int count = list.size() / groupLength;
            for (int i = 0, index = 0; i < count; i++) {
                ArrayList<Integer> aResult = new ArrayList<>();
                for (int j = 0; j < groupLength; j++) {
                    aResult.add(list.get(index ++));
                }
                results.add(aResult);
            }
        }
        return results;
    }
}
