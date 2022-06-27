package No522;

/**
 * @author ChrisPeng
 * @date 2022/6/27 9:58
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"hak","fwhioafhw","sqfw"};
        int slength = solution.findLUSlength(arr);
        System.out.println(slength);
    }
}

class Solution {
    public int findLUSlength(String[] strs) {
        //特殊序列：该序列为某字符串独有的子序列，即不能是其他字符串的子序列
        int N = strs.length;
        int ans = -1;
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && isSubStr(strs[i], strs[j])){
                    flag = false;
                    break;
                }
            }
            if (flag) ans = Math.max(ans, strs[i].length());
            flag = true;
        }
        return ans;
    }

    private boolean isSubStr(String str1, String str2){
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()){
            if (str1.charAt(index1) == str2.charAt(index2))
                index1 ++;
            index2 ++;
        }
        return index1 == str1.length();
    }
}