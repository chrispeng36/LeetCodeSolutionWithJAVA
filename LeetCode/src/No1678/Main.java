package No1678;

/**
 * @author ChrisPeng
 * @date 2022/11/7 9:11
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String interpret = solution.interpret("G()()()()(al)");
        System.out.println(interpret);
    }
}

class Solution {
    public String interpret(String command) {
        char[] chars = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < chars.length){
            if (chars[index] == 'G'){
                sb.append('G');
                index += 1;//移到下一位
            }else {
                //只能是左括号
                if (chars[index + 1] == ')'){
                    sb.append('o');
                    index += 2;
                }else {
                    //那就是al
                    sb.append("al");
                    index += 4;
                }
            }
        }
        return sb.toString();
    }
}
