package No997;

/**
 * @author ChrisPeng
 * @date 2021/11/9 0:27
 */
public class Demo {
    public static void main(String[] args) {
        int[][] arr ={{1,3},{1,4},{2,3},{2,4},{4,3}};
        Solution solution = new Solution();
        int judge = solution.findJudge(4, arr);
        System.out.println(judge);
    }
}

class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 1)
            return trust[0][1];
        //如果一个人信任了别人，此人的信任值就-1
        //如果一个人被别人信任，那么就信任值+1
        //法官的信任值是n-1
        //其他情况都是判别不出来1的
        int[] trustValues = new int[n + 1];
        //遍历trust数组计算每个人的信任值
        for (int[] ints : trust) {
            trustValues[ints[0]] -- ;
            trustValues[ints[1]] ++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustValues[i] == (n - 1)) return i;
        }
        return -1;
    }
}