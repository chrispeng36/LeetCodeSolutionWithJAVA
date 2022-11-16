package No1668;

import java.util.Collections;

/**
 * @author ChrisPeng
 * @date 2022/11/3 9:29
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxRepeating(String sequence, String word) {
        int len1 = sequence.length(), len2 = word.length();
        int maxPossibleCount = len1 / len2;
        for (int i = maxPossibleCount; i >= 1; i--) {
            String tempStr = String.join("", Collections.nCopies(i, word));
            if (sequence.contains(tempStr))
                return i;
        }
        return 0;
    }
}
