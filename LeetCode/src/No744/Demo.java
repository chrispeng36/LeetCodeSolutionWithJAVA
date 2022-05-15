package No744;

/**
 * @author ChrisPeng
 * @date 2022/3/22 16:52
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] arr = {'c','f','f','f','f','g'};
        char target = 'f';
        char c = solution.nextGreatestLetter(arr, target);
        System.out.println(c);
    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        //如果第一个字符就大的话就返回第一个,或者最后一个小于target
        if (letters[0] > target || letters[letters.length - 1] < target)
            return letters[0];
        int start = 0;
        int end = letters.length - 1;
        char minChar = letters[0];
        while (start <= end){
            int middle = (start + end) / 2;
            if (target < letters[middle]){
                //更新
                minChar = letters[middle];
                end = middle - 1;
            }else if (target > letters[middle])
                start = middle + 1;
            else{
                if (middle == letters.length - 1)
                    return letters[0];
                else{
                    //移动到下一个不出现重复的元素为止
                    boolean isVisited = false;
                    for (int i = middle + 1; i < letters.length; i++) {
                        if (letters[i] != letters[middle]) {
                            isVisited = false;
                            return letters[i];
                        }
                    }
                    if (! isVisited) return letters[0];
                }
            }
        }
        return minChar;
    }
}
