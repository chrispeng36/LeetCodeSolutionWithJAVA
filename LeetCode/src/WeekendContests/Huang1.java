package WeekendContests;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 2022/4/7 19:24
 */
public class Huang1 {
    public static void main(String[] args) {
        SolutionDemo2 demo2 = new SolutionDemo2();
        int i = demo2.count(5, 2, "aabba");
        System.out.println(i);


    }
}
class SolutionDemo1{
    //首先是要输出每个月的结余，然后最后一行输出两个月份
    //第一个表示支出最大的月，第二表示总收入最大的月
    public void problem1(String s){
        //首先给定月份对照表
        LinkedList<String> months = new LinkedList<>();
        months.add("January");months.add("February");months.add("March");
        months.add("April");months.add("May");months.add("June");
        months.add("July");months.add("August");months.add("September");
        months.add("October");months.add("November");months.add("November");
        String[] split = s.split("\n");//长度是24的列表
        double totoal = 0;
        double max_out_month = Double.MAX_VALUE;//总支出最大的
        double max_in_month = Double.MIN_VALUE;//总收入最大
        String month_max_out = "";
        String month_max_in = "";
        for (int i = 1; i < split.length; i+=2) {
            String[] month_i_list = split[i].split(":| ");//空格和：切分
            //数字总是在偶数位置
            double sum_month_i = 0;
            for (int j = 1; j < month_i_list.length; j+=2) {
                if (month_i_list[j].startsWith("-")){
                    double numTemp = 0 - Double.parseDouble(month_i_list[j].split("-")[0]);
                    sum_month_i += numTemp;
                }else if (month_i_list[j].startsWith("+")){
                    double numTemp = Double.parseDouble(month_i_list[j].split("\\+")[0]);
                    sum_month_i += numTemp;
                }
            }
            if (sum_month_i < max_in_month){
                month_max_out = months.get(i / 2);
                max_out_month = sum_month_i;
            }
            if (sum_month_i > max_in_month){
                month_max_in = months.get(i / 2);
                max_in_month = sum_month_i;
            }
            totoal += sum_month_i;
            //这是12行的输出
            if (totoal >= 0)
                System.out.println( months.get(i / 2)  + ":" + "+" + totoal);
            else
                System.out.println("-" + months.get(i / 2) + ":" + "-" + totoal);
        }
        System.out.println(month_max_out + " " + month_max_in);
    }
}

class SolutionDemo2{
    public int count(int n, int k, String s){
        //建立哈希表统计有多少种类的单词
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
//        System.out.println(map.size());
        if (map.size() < k || n < k)
            return 0;//不合理的情况
        //可以完全删除的种类数,删除的是非空连续字串
//        int total_delete = map.size() - k;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> mapTemp = map;
//            int tempLen = mapTemp.size();
            for (int j = i; j < s.length(); j++) {
//                System.out.println("========================");
                mapTemp.put(s.charAt(j),mapTemp.get(s.charAt(j)) - 1);//减一的操作
                if (mapTemp.size() == k){
                    res ++;
                }
                if (mapTemp.get(s.charAt(j)) < 0)
                    break;//出现了不合法的表达，终止
            }
        }
        return res;
    }
}