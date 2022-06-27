package No1089;

/**
 * @author ChrisPeng
 * @date 2022/6/17 11:15
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public void duplicateZeros(int[] arr) {
        //给定一个长度固定的整数数组arr，将该数组中出现的每个0都复写一遍
        //将其余的元素向右平移
        int n = arr.length;
        int top = 0;
        int i = -1;

        while (top < n){
            i ++;
            if (arr[i] != 0)
                top ++;
            else
                top += 2;
        }
        int j = n - 1;
        if (top == n + 1){
            arr[j] = 0;
            j --;
            i --;
        }

        while (j >= 0){
            arr[j] = arr[i];
            j --;
            if (arr[i] == 0){
                arr[j] = arr[i];
                j --;
            }
            i --;
        }
    }
}
