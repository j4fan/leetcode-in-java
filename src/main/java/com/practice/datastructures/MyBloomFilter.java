package com.practice.datastructures;

public class MyBloomFilter {

    private static byte[] array;
    private static int size;

    public MyBloomFilter(int size) {
        this.size = size;
        array = new byte[size];
    }

    public void add(String key) {
        int key1 = hashcode_1(key);
        int key2 = hashcode_2(key);
        int key3 = hashcode_3(key);

        array[key1 % size] = 1;
        array[key2 % size] = 1;
        array[key3 % size] = 1;

    }

    public boolean check(String key) {
        int key1 = hashcode_1(key);
        int key2 = hashcode_2(key);
        int key3 = hashcode_3(key);

        if (array[key1 % size] == 0 || array[key2 % size] == 0 || array[key3 % size] == 0) {
            return false;
        } else return true;

    }

    /**
     * hash 算法1
     *
     * @param key
     * @return
     */
    private int hashcode_1(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    /**
     * hash 算法2
     *
     * @param data
     * @return
     */
    private int hashcode_2(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++) {
            hash = (hash ^ data.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    /**
     * hash 算法3
     *
     * @param key
     * @return
     */
    private int hashcode_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }

    public static void main(String[] args) {
        MyBloomFilter filter = new MyBloomFilter(100);
        filter.add("hello");
        filter.add("world");
        System.out.println(filter.check("hello"));
        System.out.println(filter.check("hehe"));
    }
}
