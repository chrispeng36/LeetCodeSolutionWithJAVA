package No841;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/11/22 11:04
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nums = rooms.size();
        boolean[] visited = new boolean[nums];
        dfs(0, rooms, visited);
        for (int i = 0; i < nums; i++) {
            if (! visited[i]){
                return false;
            }
        }
        return true;
    }

    private void dfs(int start, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[start]) return;
        visited[start] = true;
        for (Integer v : rooms.get(start)) {
            dfs(v, rooms, visited);
        }
    }
}
