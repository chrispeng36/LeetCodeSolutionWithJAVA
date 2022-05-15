package No937;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/5/3 9:51
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] strings = solution.reorderLogFiles(logs);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //每条日志文件都是空格分隔，第一个字为字母与数字混合的标识符
        //字母日志：除了特殊的标识符，所有字符都是由小写字母组成
        //数字日志：除了标识符外，都是由数字组成
        /**
         * 所有 字母日志 都排在 数字日志 之前。
         * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
         * 数字日志 应该保留原来的相对顺序。
         */
        Arrays.sort(
                logs, (log1, log2) -> {
                    String[] split1 = log1.split(" ", 2);
                    String[] split2 = log2.split(" ",2);
                    boolean isDigit1 = Character.isDigit(split1[1].charAt(0));//判断是字母日志还是数字日志
                    boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                    if (! isDigit1 && ! isDigit2){
                        //两个日志都是字母日志
                        int cmp = split1[1].compareTo(split2[1]);
                        if (cmp != 0) return cmp;//内部内容不相同
                        return split1[0].compareTo(split2[0]);//若内部内容相同则比较标识符
                    }
                    return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                    //如果split1是数字字符，且split2是数字字符返回0，
                    // 如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
                    // 如果split1是字母字符，返回-1，
                }
        );
        return logs;
    }
}