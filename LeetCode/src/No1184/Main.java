package No1184;

/**
 * @author ChrisPeng
 * @date 2022/7/26 16:46
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //直接顺序遍历和逆序遍历出结果
        if (Math.abs(start - destination) == 1)
            return distance[start];
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        int d1 = 0, d2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= min && i < max)
                d1 += distance[i];
            else
                d2 += distance[i];
        }
        return Math.min(d1, d2);
    }
}