package No1629;

/**
 * @author ChrisPeng
 * @date 2022/1/9 13:00
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9,29,49,50};
        char cbcd = solution.slowestKey(arr, "cbcd");
        System.out.println(cbcd);
    }
}

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char longestChar = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < keysPressed.length(); i++) {
            int tempTime = releaseTimes[i] - releaseTimes[i - 1];
            if (tempTime > maxTime){
                maxTime = tempTime;
                longestChar = keysPressed.charAt(i);
            }else if (tempTime == maxTime && longestChar < keysPressed.charAt(i)){
                maxTime = tempTime;
                longestChar = keysPressed.charAt(i);
            }
        }
        return longestChar;
    }
}
