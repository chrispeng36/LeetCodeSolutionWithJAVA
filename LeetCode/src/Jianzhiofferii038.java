import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/12/29 22:37
 */
public class Jianzhiofferii038 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={73,74,75,71,69,72,76,73};
        int[] ints = solution.dailyTemperatures(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] temp = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]){
                    flag = true;
                    temp[i] = j - i;
                    break;
                }
            }
            if (! flag)
                temp[i] = 0;
        }
        temp[temp.length - 1] = 0;
        return temp;
    }
}