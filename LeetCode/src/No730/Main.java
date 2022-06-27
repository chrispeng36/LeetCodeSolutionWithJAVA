package No730;

/**
 * @author ChrisPeng
 * @date 2022/6/10 19:45
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int mod = (int) 1e9 + 7;
    public int countPalindromicSubsequences(String s) {
        //给定一个字符串s，返回s中不同的非空回文子序列的个数
        char[] c = s.toCharArray();
        long[][] ans = new long[c.length][c.length];
        for (int i = 0; i < c.length; i++) {
            ans[i][i] = 1;
        }
        for(int d=1;d<c.length;d++){
            for(int i=0;i<c.length-d;i++){
                if(c[i]==c[i+d]){
                    int l=i+1,r=i+d-1;
                    while(c[l]!=c[i]){l++;}
                    while(c[r]!=c[i]){r--;}
                    if(l>r){ans[i][i+d]=ans[i][i+d]=ans[i+1][i+d-1]*2+2;}//说明这俩字母之间没有相同字母
                    else if(l==r){ans[i][i+d]=ans[i+1][i+d-1]*2+1;}//中间只要一个相同字母
                    else{ans[i][i+d]=ans[i+1][i+d-1]*2-ans[l+1][r-1]+mod;}
                }
                else{ans[i][i+d]=ans[i][i+d-1]+ans[i+1][i+d]-ans[i+1][i+d-1]+mod;}
                ans[i][i+d]%=mod;
            }
        }
        return (int)ans[0][c.length-1];
    }
}