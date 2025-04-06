package com.datastructure.hastable;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {

    public boolean isEmpty() { return size() == 0; }

    protected static class MapEntry<K, V> implements Entry<K, V> {

        private K key;
        private V value;

        protected MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return value;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        protected V value(V v) {
            V oldValue = this.value;
            this.value = v;
            return oldValue;
        }
    }

    private class KeyIterator implements Iterator<K> {

        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }
    }

    private class KeyIterable implements Iterable<K> {

        @Override
        public Iterator<K> iterator() { return new KeyIterator(); }
    }

    @Override
    public Iterable<K> keySet() { return new KeyIterable(); }

    private class ValueIterator implements Iterator<V> {

        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() { return entries.hasNext(); }

        @Override
        public V next() { return entries.next().getValue(); }
    }

    private class ValueIterable implements Iterable<V> {

        @Override
        public Iterator<V> iterator() { return new ValueIterator(); }
    }

    @Override
    public Iterable<V> values() { return new ValueIterable(); }
}
