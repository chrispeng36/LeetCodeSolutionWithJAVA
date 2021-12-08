package No495;

/**
 * @author ChrisPeng
 * @date 2021/11/10 8:21
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={1,4};
        int i = solution.findPoisonedDuration(arr, 2);
        System.out.println(i);
    }
}

class Solution{
    public int findPoisonedDuration(int[] timeSeries,int duration){
        int res = 0;
        int len = timeSeries.length;
        for(int i=1;i<len;i++){
            if(timeSeries[i] >= timeSeries[i-1] + duration){
                res = res + duration;
            }else{
                res = res + (timeSeries[i] - timeSeries[i-1]);
            }
        }
        return res + duration;
    }
}