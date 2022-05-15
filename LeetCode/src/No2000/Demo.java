package No2000;

/**
 * @author ChrisPeng
 * @date 2022/3/11 11:08
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reversePrefix("xyxzxe",'z');
        System.out.println(s);
    }
}

class Solution {
    public String reversePrefix(String word, char ch) {
        char[] split = word.toCharArray();
        int index = -1;
        for (int i = 0; i < split.length; i++) {
            if (split[i] == ch){
                index = i;
                break;
            }
        }
        if (index == -1)
            return word;
        StringBuffer sb = new StringBuffer();
        for (int i = index; i >= 0; i--) {
            sb.append(split[i]);
        }
        if (index == split.length - 1)
            return sb.toString();
        for (int i = index + 1; i < split.length; i++) {
            sb.append(split[i]);
        }
        return sb.toString();
    }
}
