package No684;

/**
 * @author ChrisPeng
 * @date 2022/11/10 1:29
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //给定一个连通的无环无向图，加了一条边
        //找出一条可删除的边，删除后可使得一个有n个结点的树
        /**
         * 树中边的数量比节点的数量少1，如果一棵树有n个结点，则有n-1条边
         * 题中的图的边显然是n
         * 树中多了一条边之后就会出现环，因此附加的边即为导致环出现的边
         * 通过并查集查找附加的边，初始时每个节点都属于不同的连通分量
         * 遍历每一条边，判断这条边连接的两个顶点是否属于相同的连通分量
         *      如果两个顶点属于不同的连通分量，说明在遍历到当前边之前，这两个顶点之间不连通，因此当前的边不会导致环的出现，合并这两个顶点的连通分量
         *      如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，因此当前的边导致环出现，为附加的边，将当前的边作为答案返回
         */
        int n = edges.length;
        int[] parent = new int[n + 1];//节点是从1开始计数的
        for (int i = 1; i <= n; i++) {//初始化每个节点都属于不同的分量
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {//遍历二维数组的顶点对
            int[] edge = edges[i];//遍历当前的边
            int node1 = edge[0], node2 = edge[1];//找出边的两个结点
            if (find(parent, node1) != find(parent, node2)) {//因为node1和node2有边相连，所以应该属于同一个分量
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);//1的父节点的所属分量为2父节点
    }

    /**
     * 并查集的查找方法
     * @param parent
     * @param index
     * @return
     */
    public int find(int[] parent, int index){
        if (parent[index] != index){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
