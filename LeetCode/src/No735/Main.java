package No735;

import java.util.ArrayDeque;

/**
 * @author ChrisPeng
 * @date 2022/7/13 10:26
 */
public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {//遍历行星数组
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0){
                alive = stack.peek() < -aster;//aster是否存在，记录其是否还没爆炸
                if (stack.peek() <= -aster){
                    stack.pop();//栈顶行星爆炸
                }
            }
            if (alive)
                stack.push(aster);//压入栈中
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--)
            ans[i] = stack.pop();
        return ans;
    }
}