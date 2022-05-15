package No883;

/**
 * @author ChrisPeng
 * @date 2022/4/26 9:31
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int projectionArea(int[][] grid) {
        int up=0,left=0,right=0;
        int n=grid.length,m=grid[0].length;
        for(int i=0;i<grid.length;++i){
            int maxleft=0;
            for(int j=0;j<grid.length;++j){
                if(grid[i][j]!=0)
                    up++;
                maxleft=Math.max(maxleft,grid[i][j]);
            }
            left+=maxleft;
        }
        for(int i=0;i<grid.length;++i){
            int maxright=0;
            for(int j=0;j<grid.length;++j){
                maxright=Math.max(maxright,grid[j][i]);
            }
            right+=maxright;
        }
        return up+left+right;
    }
}