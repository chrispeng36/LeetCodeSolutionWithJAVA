package No390;

/**
 * @author ChrisPeng
 * @date 2022/1/2 22:21
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lastRemaining(9);
        System.out.println(i);
    }
}

class Solution {
    public int lastRemaining(int n) {
        // 这种题一看就知道是数学题, 同时应该不能暴力
        // 因此我看评论了, 太妙了
        // 从左到右一定要消除第一个, 此时剩下的数组里的第一个要加一个step
        // 比如1 2 3 4 ... 9, 从左到右消除后第一个是2, 此时的2由first+step=1+1得来, 此时剩下的数是
        // 2 4 6 8, first=2, step=1*2=2, 此时从右往左消除得到的第一个剩下的数first还是2, step=4,
        // 因为剩下了 2 6. 再从左往右消除一定消除第一个, 此时first=first+step=2+4=6, 剩下的数只有1个, 于是返回
        // first   要注意的是, 对于从右往左奇数长度的时候会消除第一个, 因此要考虑
        int first = 1;
        int step = 1;
        int remain = n;
        boolean isLeft = true;
        while (remain > 1) {
            if (isLeft || ((remain & 1) == 1)) {
                first += step;
            }
            isLeft = !isLeft;
            step <<= 1;
            remain >>= 1;
        }
        return first;
    }
}