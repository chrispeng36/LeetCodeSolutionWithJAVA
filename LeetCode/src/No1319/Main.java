package No1319;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/12/16 10:52
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int lineCount = connections.length;
        if (lineCount < n - 1) return -1;

        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.unite(conn[0], conn[1]);
        }

        return uf.setCount - 1;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int n;//图的节点数

    //当前连通分量的数目
    int setCount;

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        //初始化时，每个元素都是一个独立的集合
        //父节点都是本身，size都是1表示连通分量中的结点个数
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findset(int x) {//找到x对应的连通分量
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public boolean unite(int x, int y) {//合并操作
        x = findset(x);
        y = findset(y);
        if (x == y) return false;//说明是同一个连通分量
        if (size[x] < size[y]) {//如果x的连通集数量小于y的，交换x和y
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;//合并y和x
        size[x] += size[y];
        -- setCount;//连通分量少了一个
        return true;
    }

    public boolean connected(int x, int y){
        x = findset(x);
        y = findset(y);
        return x == y;
    }
}