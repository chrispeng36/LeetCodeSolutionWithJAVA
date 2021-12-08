package No599;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/11/2 9:54
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] arr2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        String[] restaurant = solution.findRestaurant(arr1, arr2);
//        System.out.println(restaurant[0]);
        for (String s : restaurant) {
            System.out.println(s);
        }
//        char a = '1';
    }
}

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //首先将一个数组中的元素全部放到hashmap中
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        int min = Integer.MAX_VALUE;
        //其次遍历另一个数组
//        String[] res = new String[1];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])){
                //找到temp
//                int temp = map.get(list2[i]) + i;
                if ((map.get(list2[i]) + i )< min){
                    //更新
                    list.clear();
                    list.add(list2[i]);
                    min = map.get(list2[i]) + i;
                }else if ((map.get(list2[i]) + i )== min){
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}