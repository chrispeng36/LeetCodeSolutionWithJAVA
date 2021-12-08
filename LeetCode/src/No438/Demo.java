package No438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/11/28 12:20
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.findAnagrams("cbaebabacd", "abc");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = p.length();
        int[] parr = new int[26];
        //统计p的词频
        for (int i = 0; i < len; i++) {
            parr[p.charAt(i) - 'a'] ++;
        }
        //使用滑动窗口求解
        int[] sarr = new int[26];
        int s1 = s.length();
        int left = 0;
        int right = 0;

        while (right < s1){
            //统计s的词频
            sarr[s.charAt(right) - 'a'] ++;
            if (right - left == len - 1){
                //比较俩字符串是否相等
                if (checkEquals(sarr,parr)){
                    list.add(left);
                }
                //删除左边界的词频
                sarr[s.charAt(left) - 'a'] --;
                //收缩窗口
                left ++;
            }
            right ++;
        }
        return list;
    }
    private boolean checkEquals(int[] arr1,int[] arr2){
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}