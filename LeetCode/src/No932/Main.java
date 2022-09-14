package No932;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/7/21 19:31
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] beautifulArray(int n) {
        //对于每个i<j，都不存在k满足i<k<j
        //A[k] * 2 = A[i] + A[j]
        int[] a = new int[n];
        Arrays.fill(a, 1);
        part(a, 0, n - 1);
        return a;
    }
    private void part(int[] a, int lo, int hi){
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        part(a, lo, mid);
        part(a, mid + 1, hi);
        for (int i = lo; i <= mid; i ++){
            a[i] = 2 * a[i] - 1;
        }
        for (int i = mid + 1; i <= hi; i++){
            a[i] = 2 * a[i];
        }
        return;
    }
}