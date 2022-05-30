package No668;

/**
 * @author ChrisPeng
 * @date 2022/5/18 9:36
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findKthNumber(int m, int n, int k) {
        //m*n乘法表中取值范围为[1, m*n]，使用二分法
        int low = 1, high = m * n + 1;
        while (low < high){
            int mid = (low + high) / 2;
            int cnt = smallNumCount(mid, m, n);//计算乘法表中不大于mid的元素的个数
            if (cnt >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private int smallNumCount(int num, int m, int n){
        int count = 0;
        //对乘法表的每行进行搜索
        for (int i = 0; i <= m; i++) {
            count += Math.min(num / i, n);//num / i表示如果num也在第i行，它存在的列数，一行最多有n列
        }
        return count;
    }
}