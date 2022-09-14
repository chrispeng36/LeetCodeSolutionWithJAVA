package No146;

import com.sun.source.tree.Tree;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/8/9 15:59
 */
public class Main {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int i1 = lRUCache.get(1);// 返回 1
        System.out.println(i1);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        int i2 = lRUCache.get(2);// 返回 -1 (未找到)
        System.out.println(i2);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        int i3 = lRUCache.get(1);// 返回 -1 (未找到)
        System.out.println(i3);
        int i = lRUCache.get(3);// 返回 3
        System.out.println(i);
        int i4 = lRUCache.get(4);// 返回 4
        System.out.println(i4);
    }
}

class LRUCache {

    int count;//容量
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        //初始化LRU缓存
        this.count = capacity;
    }

    public int get(int key) {
        //如果关键字key存在于缓存中，返回关键字的值，否则返回-1
        if (!cache.containsKey(key))
            return -1;
        //查询也相当于一次使用
        update(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        //存在的话就更新，不存在的话就插入
        //如果插入的操作导致数量超过capacity，去除最久没有使用的
        if (cache.containsKey(key)){
            cache.put(key, value);
            update(key);
            return;
        }
        if (cache.size() >= this.count){
            Integer first = cache.keySet().iterator().next();
            cache.remove(first);
        }
        cache.put(key, value);
    }

    private void update(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
