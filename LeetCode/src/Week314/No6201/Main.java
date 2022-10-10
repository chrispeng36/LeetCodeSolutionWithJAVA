package Week314.No6201;

/**
 * @author ChrisPeng
 * @date 2022/10/9 10:40
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, 2, 0, 3, 1};
        int[] array = solution.findArray(arr);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println(5 ^ 2 ^ 0);
    }
}

class Solution {
    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        int[] helper = new int[pref.length];//存放的是res[0]...res[i]的异或截获
        helper[0] = pref[0];
        res[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = pref[i] ^ helper[i - 1];
            helper[i] = helper[i - 1] ^ res[i];
        }
        return res;
    }
}
