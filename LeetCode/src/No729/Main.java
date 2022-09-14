package No729;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/7/5 14:56
 */
public class Main {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        boolean b = calendar.book(47, 50);
        System.out.println(b);
        boolean b1 = calendar.book(33, 41);
        System.out.println(b1);
        boolean b2 = calendar.book(39, 45);
        System.out.println(b2);
        boolean b3 = calendar.book(33, 42);
        System.out.println(b3);
        boolean b4 = calendar.book(25, 32);
        System.out.println(b4);
        boolean b5 = calendar.book(26, 35);
        System.out.println(b5);
        boolean b6 = calendar.book(19, 25);
        System.out.println(b6);
        boolean b7 = calendar.book(3, 8);
        System.out.println(b7);
        boolean b8 = calendar.book(8, 13);
        System.out.println(b8);
        boolean b9 = calendar.book(18, 27);
        System.out.println(b9);
    }
}

class MyCalendar {
    /**
     * 当两个日程安排有一些时间上的交叉时，例如两个日程安排都在同一事件内
     * 就会产生重复预定。
     * 日程可以用一对整数start和end表示，这里的时间是半开区间。
     * [start, end)
     */
    Map<Integer, Integer> calender;
    public MyCalendar() {
        //初始化日历对象
        calender = new HashMap<>();
    }

    public boolean book(int start, int end) {
        //如果可以将日程安排成功添加到日历中而不会产生重复预定
        //返回true
        for (Integer start_day : calender.keySet()) {
            if (end <= start_day || start >= calender.get(start_day))
                continue;
            else
                return false;
        }
        calender.put(start, end);
        return true;
    }
}

