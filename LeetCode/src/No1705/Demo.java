package No1705;

import java.util.PriorityQueue;

/**
 * @author ChrisPeng
 * @date 2021/12/24 16:22
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] apples = {1,2,3,5,2};
        int[] days = {3,2,1,4,2};
        int i = solution.eatenApples(apples, days);
        System.out.println(i);
    }
}

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        /**
         * 苹果树第i天长出apples[i]个苹果，这些苹果将在days[i]天后腐烂
         * 每天最多吃一个苹果
         * 返回可以吃掉的最大的苹果数
         */
        /**
         * 第一个阶段，由于每天树上都可能长出苹果，因此要对每一天分别计算是否能迟到苹果，并恒心优先队列
         * 1.将优先队列中的所有腐烂的日期小于等于当前日期的元素取出，这些元素表示已经腐烂的水果，不能吃
         * 2.根据days和apples的当前元素计算当天长出的苹果的腐烂日期和数量，如果数量大于0，则将腐烂日期和数量加入优先队列
         * 3.如果优先队列不为空，则当天可以吃1个苹果，将优先队列的首元素减去1，如果首元素的数量变为0则将队首元素取出
         *
         * 第二个阶段，树上不会长出苹果了，因此只要考虑能吃到的苹果的数量。由于优先队列中的每个元素的数量可能很大
         * 因此需要根据当前日期和优先队列中的队首元素的腐烂日期和数量计算能吃到的苹果数量。
         * 假设当前日期是第 i 天，首先将优先队列中的所有腐烂日期小于等于 i 的元素取出，如果优先队列不为空，则根据优先队列的队首元素计算能吃到的苹果数量。
         * 假设优先队列的队首元素的腐烂日期是 x，数量是 y，其中 x > i，则有 y 个苹果，距离腐烂还有 x - i 天，
         * 因此能吃到的苹果数量是 curr = min(x - i,y)。将优先队列的队首元素 (x, y)取出并将日期增加curr，
         * 重复上述操作直到优先队列为空，即可得到吃苹果的最大数目。。
         */

        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        int n = apples.length;
        int i = 0;
        while (i < n){
            while (!pq.isEmpty() && pq.peek()[0] <= i){
                pq.poll();
            }
            int rottenDay = i + days[i];
            int count = apples[i];
            if (count > 0){
                pq.offer(new int[]{rottenDay,count});
            }
            if (!pq.isEmpty()){
                int[] arr = pq.peek();
                arr[1] --;
                if (arr[1] == 0)
                    pq.poll();
                ans ++;
            }
            i ++;
        }
        while (!pq.isEmpty()){
            while (!pq.isEmpty() && pq.peek()[0] <= i)
                pq.poll();
            if (pq.isEmpty())
                break;
            int[] arr = pq.poll();
            int curr = Math.min(arr[0] - i, arr[1]);
            ans += curr;
            i += curr;
        }
        return ans;
    }
}