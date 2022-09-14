package No667;

/**
 * @author ChrisPeng
 * @date 9/8/2022 9:32 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}


class Solution{
    public int[] constructArray(int n, int k){
        int[] res = new int[n];
        int i = 0;
        while (i <= k){
            if (i % 2 == 0)
                res[i] = 1 + i / 2;
            else
                res[i] = k + 1 - i / 2;
        }
        while (i < n)
            res[i] = i + 1;
        return res;
    }
}