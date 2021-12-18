package No1518;

/**
 * @author ChrisPeng
 * @date 2021/12/17 8:31
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numWaterBottles(5, 3);
        System.out.println(i);
    }
}

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange)
            return numBottles;
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange){
            numBottles = numBottles + emptyBottles / numExchange;//换完之后总共能喝到的酒
            emptyBottles = emptyBottles / numExchange + emptyBottles % numExchange;//前面那个是交换得到的酒，后面那个是交换余下的酒，总之是剩余的酒
        }
        return numBottles;
    }
}