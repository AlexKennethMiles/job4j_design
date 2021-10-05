package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75F;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int hk = Objects.hash(key) % table.length;
        if (count >= table.length * LOAD_FACTOR) {
            MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
            for (MapEntry<K, V> kvMapEntry : table) {
                if (kvMapEntry != null) {
                    int newHK = Objects.hash(kvMapEntry.key) & newTable.length - 1;
                    newTable[newHK] = new MapEntry<>(kvMapEntry.key, kvMapEntry.value);
                }
            }
            capacity = newTable.length;
            table = newTable;
        }
        if (table[hk] != null) {
            if ((Objects.hash(table[hk].key) & table.length - 1) == hk) {
                if (table[hk].key.equals(key)) {
                    table[hk].value = value;
                    count++;
                    modCount++;
                    return true;
                }
            }
        } else {
            table[hk] = new MapEntry<K, V>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int hk = Objects.hash(key) & table.length - 1;
        if (table[hk] != null) {
            if ((Objects.hash(table[hk].key) & table.length - 1) == hk) {
                if (table[hk].key.equals(key)) {
                    return table[hk].value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int hk = Objects.hash(key) & table.length - 1;
        if (table[hk] != null) {
            if ((Objects.hash(table[hk].key) & table.length - 1) == hk) {
                if (table[hk].key.equals(key)) {
                    table[hk].key = null;
                    table[hk].value = null;
                    table[hk] = null;
                    count--;
                    modCount++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleMap<?, ?> simpleMap = (SimpleMap<?, ?>) o;
        return capacity == simpleMap.capacity
                && count == simpleMap.count
                && modCount == simpleMap.modCount
                && Arrays.equals(table, simpleMap.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, count, modCount);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int pointer = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                Objects.checkIndex(pointer, capacity);
                return table[pointer] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[pointer++].key;
            }
        };
    }

    private class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
