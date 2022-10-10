package No672;

/**
 * @author ChrisPeng
 * @date 9/15/2022 9:46 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0){
            //不按开关
            return 1;
        }else if (n == 1){
            //当n == 1，开关1,3,4对其造成影响，只有开和关两种状态
            return 2;
        }else if (n == 2){
            //当n==2时，按照推理111的状态推理11，按一次有三种，按两次及以上有4种
            return presses == 1 ? 3 : 4;
        }else {
            //当n >= 3，按一次有4种，按两次有7种，3次及以上有8种
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }
}