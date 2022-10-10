package Ali.Pro2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 9/27/2022 4:50 PM
 */
public class Main {
    public static void main(String[] args) {
        String message = "We live at 3234058911296670,not at 0589323411296670.";
        List<Integer> list = findFourCorner(message);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static List<Integer> findFourCorner(String message){
        ArrayList<String> fourCorner = new ArrayList<>();
        fourCorner.add("3234058911296670");
        fourCorner.add("3234058966701129");
        fourCorner.add("3234112905896670");
        fourCorner.add("3234112966700589");
        fourCorner.add("3234667005891129");
        fourCorner.add("3234667011290589");
        fourCorner.add("0589323411296670");
        fourCorner.add("0589323466701129");
        fourCorner.add("0589112932346670");
        fourCorner.add("0589112966703234");
        fourCorner.add("0589667032341129");
        fourCorner.add("0589667011293234");
        fourCorner.add("1129323405896670");
        fourCorner.add("1129323466700589");
        fourCorner.add("1129058932346670");
        fourCorner.add("1129058966703234");
        fourCorner.add("1129667032340589");
        fourCorner.add("1129667005893234");
        fourCorner.add("6670323405891129");
        fourCorner.add("6670323411290589");
        fourCorner.add("6670112932340589");
        fourCorner.add("6670112905893234");
        fourCorner.add("6670058932341129");
        fourCorner.add("6670058911293234");
        int len = message.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (len < 16)
            return res;
        for (int i = 0; i < len - 16; i++) {
            if (fourCorner.contains(message.substring(i, i + 16)))
                res.add(i);
        }
        return res;
    }
}
