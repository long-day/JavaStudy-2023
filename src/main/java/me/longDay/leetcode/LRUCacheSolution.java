package me.longDay.leetcode;

import java.util.HashMap;

/**
 * @author 君
 * @version 1.0
 * @desc LRU缓存
 * @since 2023-02-27
 */
public class LRUCacheSolution {

}

class LRUCache {
    private final int capacity;
    private int curCapacity;
    private final HashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map= new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {

    }

}