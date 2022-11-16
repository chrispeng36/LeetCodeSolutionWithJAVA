package No901;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/10/21 11:10
 */
public class Main {
    public static void main(String[] args) {

    }
}

class StockSpanner {

    // 存储每个股票的值和跨度
    ArrayList<int[]> data;

    public StockSpanner() {
        data = new ArrayList<>();
    }

    public int next(int price) {
        int i = data.size() - 1, res = 1;
        int[] item;
        // 根据每个值的坐标跨度快速统计
        while (i >= 0) {
            item = data.get(i);
            if (item[0] <= price) {
                i -= item[1];
                res += item[1];
            } else break;
        }
        data.add(new int[]{price, res});
        return res;
    }
}
