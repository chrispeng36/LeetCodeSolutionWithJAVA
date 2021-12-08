package No869;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2021/10/28 0:28
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.reorderedPowerOf2(46);
        System.out.println(b);
    }
}
class Solution {
    public boolean reorderedPowerOf2(int n) {
        //将数字进行重新排列，判断是否能是2的幂
//        ArrayList<Integer> cun = new ArrayList<>();
//        while (n != 0){
//            cun.add(n % 10);
//            n /= 10;
//        }
//        Collections.sort(cun);
//        int qis = 1;
//        ArrayList<Integer> item = new ArrayList<>();
//        ArrayList<List<Integer>> dad = new ArrayList<>();
//        while (true){
//            String cd = qis + "";
//            if (cd.length() == cun.size()){
//                int zans = qis;
//                while (zans != 0){
//                    item.add(zans % 10);
//                    zans /= 10;
//                }
//                Collections.sort(item);
//                dad.add(new ArrayList<>(item));
//                item.clear();
//            }
//            else if (cd.length() > cun.size()) break;
//            qis *= 2;
//        }
//        for (int i = 0; i < dad.size(); i++) {
//            if (dad.get(i).equals(cun)) return true;
//        }
//        return false;
        String[] arr = {"1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468",
                "23678", "35566", "011237", "122446", "224588", "0145678", "0122579", "0134449", "0368888",
                "11266777", "23334455", "01466788", "112234778", "234455668", "012356789", "0112344778"};
        char[] chars = (n + "").toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        for (String s1 : arr) {
            if (s1.equals(s))
                return true;
        }
        return false;
    }
}

