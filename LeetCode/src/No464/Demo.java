package No464;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/5/22 12:07
 */
public class Demo {
    public static void main(String[] args) {

    }
}

/**
 * 考虑边界的情况，当所有数字全部选完仍无法到达total俩人都无法获胜
 * 当所有的数字和大于等于total，那么有一方可以获胜
 * 在游戏中途，假设已经被使用的数字的集合为 usedNumbers，这些数字的和为currentTotal。
 * 当某方行动时，如果能够在未选择的数字中选出一个i，使得i + currentTotal ≥ desiredTotal,则获胜
 * 否则继续通过搜索来判断获胜方
 * 设计搜索函数dfs，其中usedNumbers可以用一个整数来表示，从低位到高位
 * 第i位为1则表示数字i已经被使用，为0则表示数字i未被使用。如果当前玩家获胜，则返回true
 * 需要使用记忆化的操作来降低时间复杂度

 */
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //尝试暴力的记忆化深度搜索
        if ((maxChoosableInteger * (1 + maxChoosableInteger) >> 1) < desiredTotal)
            return false;
        //判断当前层，也就是当前先手玩家能否获胜，dfs过程中，两个玩家都全力保证自己的每层的选择能获胜
        return dfs(maxChoosableInteger, desiredTotal, 0, 0, new HashMap<>(16));
    }

    /**
     *
     * @param maxChoosableInteger 最大可选值
     * @param desiredTotal 最大值
     * @param usedState 当前使用数字的状态
     * @param curTotal 当前total
     * @param memory 记忆化数组
     * @return 是否胜利
     */
    public boolean dfs(int maxChoosableInteger, int desiredTotal, int usedState, int curTotal, Map<Integer, Boolean> memory){
        //每层的玩家不同，但是目的都是当前层能获胜||下一层不能获胜则当前层能获胜
        Boolean result = memory.get(usedState);
        if (result != null)
            return result;
        result = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            //暴力
            if (((usedState >> i) & 1) == 0){
                if (i + 1 + curTotal >= desiredTotal){
                    //如果当前玩家能获胜
                    result = true;
                    break;
                }else if (! dfs(maxChoosableInteger, desiredTotal, usedState | (1 << i), i + 1 + curTotal, memory)){
                    //如果它的下一个玩家不能获胜，那么当前玩家能够获胜
                    result = true;
                    break;
                }
            }
        }
        memory.put(usedState, result);
        return result;
    }
}