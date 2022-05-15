package No868;

/**
 * @author ChrisPeng
 * @date 2022/4/24 10:16
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.binaryGap(22);
        System.out.println(i);
    }
}

/**
 * 使用一个循环从n二进制表示的低位开始进行遍历，并找出所有的1
 * 用变量last记录上一个找到1的位置
 * 如果当前在第i位找到了1，那么就用i-last更新答案，再将last更新为i即可
 */
class Solution {
    public int binaryGap(int n) {
        int res = 0;
        int cur = 0, last = -1;
        for (int i = 0; i < 32; i++) {
            //右移
            if (((n >> i) & 1) != 0){//获取最低位，判断是否为1，获取的是第i个二进制位
                if (last == -1){//判断是否第一次遇到1
                    last = i;
                    cur = i;
                }else {//双指针不断更新相邻的长度
                    last = cur;
                    cur = i;
                    res = Math.max(res, cur - last);
                }
            }

        }
        return res;
    }
}