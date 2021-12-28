package No1791;

/**
 * @author ChrisPeng
 * @date 2021/12/28 9:02
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{1,2},{2,3},{4,2}};
        int center = solution.findCenter(edges);
        System.out.println(center);
    }
}

class Solution {
    public int findCenter(int[][] edges) {
        //中心节点是与其他节点都会有连接的
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}