package No1656;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/8/16 9:55
 */
public class Main {
    public static void main(String[] args) {

    }
}

class OrderedStream {
    private String[] stream;
    private int ptr;

    public OrderedStream(int n) {
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        ArrayList<String> res = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null){
            res.add(stream[ptr]);
            ++ ptr;
        }
        return res;
    }
}
