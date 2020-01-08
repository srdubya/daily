package com.swiley.practice.daily;

/*
Implement an LFU (Least Frequently Used) cache. It should be able to be initialized with a cache size n, and contain the
following methods:
        set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then
        it should also remove the least frequently used item. If there is a tie, then the least recently used key should
        be removed.

        get(key): gets the value at key. If no such key exists, return null.

Each operation should run in O(1) time.
/* */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LFUCache<K, T> {

    private final HashMap<K, T> map;
    private final HashMap<K, DoublyLinkedList.Element<K>> dllItemMap;
    private final DoublyLinkedList<K> list;
    private final int size;

    public LFUCache(int size) {
        this.size = size;
        list = new DoublyLinkedList<>();
        dllItemMap = new HashMap<>();
        map = new HashMap<>(size);
    }

    public void set(K key, T value) {
        if (map.containsKey(key)) {
            list.moveToHead(dllItemMap.get(key));
        } else {
            if (map.size() >= size) {
                var removedKey = list.removeTail();
                map.remove(removedKey);
                dllItemMap.remove(removedKey);
            }
            var addedItem = list.add(key);
            dllItemMap.put(key, addedItem);
        }
        map.put(key, value);
    }

    public T get(K key) {
        T ret = null;
        if (map.containsKey(key)) {
            ret = map.get(key);
            list.moveToHead(dllItemMap.get(key));
        }
        return ret;
    }

    public List<T> getAll() {
        var ret = new LinkedList<T>();
        for (var key : list.getAll()) {
            ret.add(map.get(key));
        }
        return ret;
    }
}
