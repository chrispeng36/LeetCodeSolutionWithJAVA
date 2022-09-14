package No731;

import com.sun.source.tree.Tree;

import java.util.TreeMap;

/**
 * @author ChrisPeng
 * @date 2022/7/19 15:43
 */
public class Main {
    public static void main(String[] args) {

    }
}

class MyCalendarTwo {
    //用类来存放日程安排，不会导致三重预定的时候则可以存储这个新的日程安排
    private TreeMap<Integer, Integer> calender;
    public MyCalendarTwo() {
        calender = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calender.put(start, calender.getOrDefault(start, 0) + 1);
        calender.put(end, calender.getOrDefault(end, 0) - 1);
        int active = 0;//活跃的天数
        for (Integer d : calender.values()) {
            //时间线统计日程
            active += d;
            //中途活跃日程大于等于3则返回false
            if (active >= 3){
                //恢复现场
                calender.put(start, calender.get(start) - 1);
                calender.put(end, calender.get(end) + 1);
                if (calender.get(start) == 0)
                    calender.remove(start);
                return false;
            }
        }
        return true;
    }
}
