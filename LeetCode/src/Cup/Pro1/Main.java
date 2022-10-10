package Cup.Pro1;

/**
 * @author ChrisPeng
 * @date 9/24/2022 3:28 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {21, 18, 18, 18, 31};
        int[] arr2 = {34, 32, 16, 16, 17};
        int i = solution.temperatureTrend(arr1, arr2);
        System.out.println(i);
    }
}

class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int len = temperatureA.length;
        int[] changeA = new int[len];
        int[] changeB = new int[len];
        for (int i = 1; i < len; i++) {
            changeA[i] = temperatureA[i] - temperatureA[i - 1];
            changeB[i] = temperatureB[i] - temperatureB[i - 1];
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (changeA[i] * changeB[i] > 0 || changeA[i] == changeB[i]){
                int temp = 1;
                for (int j = i + 1; j < len; j++) {
                    if (changeA[j] * changeB[j] > 0 || changeA[j] == changeB[j])
                        temp ++;
                    else
                        break;
                }
                if (temp > res) res = temp;
            }
        }
        return res;
    }
}