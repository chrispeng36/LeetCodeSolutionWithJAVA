package No875;

/**
 * @author ChrisPeng
 * @date 2022/6/7 1:08
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int) 1e9;
        while (l < r){
            int mid = (l + r) >>> 1;
            if (check(piles, mid, h)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    //速度v吃完这堆香蕉所需的时间
    private boolean check(int[] piles, int v, int h){
        int t = 0;
        for (int p : piles) {
            t += p / v;
            if (p % v != 0) t ++;
            if (t > h) return false;
        }
        return true;
    }
}