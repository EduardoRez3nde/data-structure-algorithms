package com.datastructure.hastable;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {

    protected int n = 0;
    protected int capacity;
    protected int prime;
    private long scale, shift;

    public AbstractHashMap(int cap, int p) {
        this.capacity = cap;
        this.prime = p;
        final Random rand = new Random();
        this.scale = rand.nextInt(prime - 1) + 1;
        this.shift = rand.nextInt(prime);
    }

    public AbstractHashMap(int cap) { this(cap, 109345121); }

    public AbstractHashMap() { this(17); }

    public int size() { return this.n; }

    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2)
            resize(2 * capacity - 1);
        return answer;
    }

    private int hashValue(K key) {
        return (int) (Math.abs(key.hashCode() * scale + shift) % prime) % capacity;
    }

    private void resize(int newCap) {
        final ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for (Entry<K, V> entry : entrySet())
            buffer.add(entry);
        this.capacity = newCap;
        this.n = 0;
        for (Entry<K, V> entry : buffer)
            put(entry.getKey(), entry.getValue());
    }

    public abstract void createTable();
    public abstract V bucketGet(int hash, K key);
    public abstract V bucketRemove(int hash, K key);
    public abstract V bucketPut(int hash, K key, V value);
}
