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
        if (count >= table.length * LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(Objects.hash(key)));
        if (table[index] != null) {
            if (indexFor(hash(Objects.hash(table[index].key))) == index) {
                if (table[index].key.equals(key)) {
                    table[index].value = value;
                    count++;
                    modCount++;
                    return true;
                }
            }
        } else {
            table[index] = new MapEntry<K, V>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return (hashCode) ^ (hashCode >> 10);
    }

    private int indexFor(int hash) {
        return hash & table.length - 1;
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        for (MapEntry<K, V> kvMapEntry : table) {
            if (kvMapEntry != null) {
                int newIndex = indexFor(hash(Objects.hash(kvMapEntry.key)));
                newTable[newIndex] = new MapEntry<>(kvMapEntry.key, kvMapEntry.value);
            }
        }
        capacity = newTable.length;
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(Objects.hash(key)));
        if (table[index] != null) {
            if (indexFor(hash(Objects.hash(table[index].key))) == index) {
                if (table[index].key.equals(key)) {
                    return table[index].value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(Objects.hash(key)));
        if (table[index] != null) {
            if (indexFor(hash(Objects.hash(table[index].key))) == index) {
                if (table[index].key.equals(key)) {
                    table[index].key = null;
                    table[index].value = null;
                    table[index] = null;
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
