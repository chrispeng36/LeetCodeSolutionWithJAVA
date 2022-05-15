package WeekendContests.FunPlus.Pro3;

import java.util.HashSet;

/**
 * @author ChrisPeng
 * @date 2022/5/1 12:15
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n=nums.length,l=0,r=0,c=0;
        HashSet<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        while(r<n){
            if(nums[r]%p==0){
                k--;
                if(k<0){
                    while(l<r&&nums[l]%p!=0){
                        l++;
                    }
                    l++;
                    k++;
                }
            }
            c+=r-l+1;
            int tl=l,tr=r;
            while(tr>=tl){
                sb.append(nums[tr]+",");
                set.add(sb.toString());
                tr--;
            }
            sb.setLength(0);
            r++;
        }
        return set.size();
    }
}

