package No717;

/**
 * @author ChrisPeng
 * @date 2022/2/20 12:00
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = {1,0,0};
        boolean b = solution.isOneBitCharacter(bits);
        System.out.println(b);
    }
}

class Solution{
    public boolean isOneBitCharacter(int[] bits){
        int start = 0;
        while (start < bits.length - 1){
            if (bits[start] == 0)
                start ++;
            else
                start += 2;
        }
        return start == bits.length - 1;
    }
}
