package No341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/12/27 11:09
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list = new ArrayList<>();
    private int index;

    public void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                add(nestedInteger.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }
    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Integer next() {
        return list.get(index ++);
    }
}
