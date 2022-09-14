package No1023;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/7/14 14:42
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    boolean check(String s1 , String s2){
        int index = 0;
        for(int i = 0; i < s1.length(); i ++){
            if(index<s2.length() && s1.charAt(i) == s2.charAt(index)){
                index ++;
            }else if(s1.charAt(i)>='A' && s1.charAt(i)<='Z'){
                return false;
            }
        }
        //      System.out.println(s1+" "+s2);
        return index == s2.length();
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new LinkedList<>();
        for(String s : queries){
            boolean t = check(s , pattern);
            ans.add(t);
        }
        return ans;
    }
}
