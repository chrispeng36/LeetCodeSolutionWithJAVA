package No497;

/**
 * @author ChrisPeng
 * @date 2022/6/9 0:13
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution{
    private int[][] rects;
    private int[] sum;
    public Solution(int[][] rects) {
        this.rects = rects;
        this.sum = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            //可以不按照横轴上的数字来排序，直接按照遍历的每个矩形进行编号放入sum，计算累加和
            int cur = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            if (i == 0)
                this.sum[i] = cur;
            else
                this.sum[i] = this.sum[i - 1] + cur;
        }
    }

    public int[] pick() {
        int x = (int)(Math.random()*(this.sum[this.sum.length-1])+1);
        int idx = -1;
        int left = 0;int right = this.sum.length-1;
        while(left<=right){
            int mid = left + (right-left>>1);
            if(x>(mid==0 ? 0 : this.sum[mid-1]) && x<=this.sum[mid]){
                idx = mid;
                break;
            }else if(x < this.sum[mid]){
                //前面已经判断不在这个区间了。这里可以直接用这个判断了
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        //还原成x,y:
        int temp = x-(idx==0 ? 0 : this.sum[idx-1]);
        int len = this.rects[idx][2] - this.rects[idx][0] + 1;//横轴的长度
        x = this.rects[idx][0] + ((temp-1) % len);
        int y = this.rects[idx][1] + ((temp-1) / len);
        return new int[]{x,y};
    }
}