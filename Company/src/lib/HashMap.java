package lib;

import java.util.Map;

/**
 * Basic implementation of a HashMap
 */

/*
 * HashMap is a data structure for quick key-value pairs read and write.
 * <1> Contain no duplicate keys (Java supports 'null' key ); each key can map to at most one value
 * <2> It has average O(1) running time of get()/put(). The worst case of put() is O(n) (when table
 * resize happens)
 * <3> The basic idea is that we use a Entry[] table to store all the key-value pairs. Each bucket
 * in the table is a LinkedList of Entries (to store the values with same hash); each key has
 * a hash value, which is used to calculate the index of the bucket the key-value pair belongs to.
 * <4> hashFunction should balance between two demands: 1.avoid collision; 2. evenly distribute
 * elements among the table.
 * <5> Table resize: mainly decided by Capacity and LoadFactor
 */

/*
 * An instance of HashMap has two parameters that affect its performance: initial capacity and load
 * factor. The capacity is the number of buckets in the hash table, and the initial capacity is
 * simply the capacity at the time the hash table is created. The load factor is a measure of how
 * full the hash table is allowed to get before its capacity is automatically increased. When the
 * number of entries in the hash table exceeds the product of the load factor and the current
 * capacity, the hash table is rehashed (that is, internal data structures are rebuilt) so that the
 * hash table has approximately twice the number of buckets.
 * As a general rule, the default load factor (.75) offers a good tradeoff between time and space
 * costs. Higher values decrease the space overhead but increase the lookup cost (reflected in most
 * of the operations of the HashMap class, including get and put).
 * Ref:
 * http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/HashMap.
 * java#HashMap.%3Cinit%3E%28%29
 */

public class HashMap<K, V> {
   // capacity should be a power of 2
   static final int DEFAULT_INITIAL_CAPACITY = 16;
   static final int MAX_CAPACITY = 1 << 30;
   static final float DEFAULT_LOAD_FACTOR = 0.75f;
   float loaderFactor;
   int threshold;
   Entry[] table;
   int size;

   public HashMap() {
      this.loaderFactor = DEFAULT_LOAD_FACTOR;
      threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
      table = new Entry[DEFAULT_INITIAL_CAPACITY];
   }

   public HashMap(int initialCapacity, float loadFactor) {
      if (initialCapacity < 0 || loadFactor < 0)
         throw new IllegalArgumentException();
      if (initialCapacity > MAX_CAPACITY)
         initialCapacity = MAX_CAPACITY;
      // Find a power of 2 >= initialCapacity
      int capacity = 1;
      while (capacity < initialCapacity)
         capacity <<= 1;
      table = new Entry[initialCapacity];
      this.loaderFactor = loadFactor;
      threshold = (int) (initialCapacity * loadFactor);
   }

   public HashMap(int capacity) {
      this(capacity, DEFAULT_LOAD_FACTOR);
   }

   public int size() {
      return size;
   }

   public int capacity() {
      return table.length;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   // support null key
   public V get(Object key) {
      if (key == null)
         return getForNullKey();
      int hash = hash(key.hashCode());
      for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
         Object k = e.key;
         if (e.hash == hash && (k == key || key.equals(k)))
            return e.value;
      }
      return null;
   }

   public boolean containsKey(Object key) {
      return getEntry(key) != null;
   }

   public V put(K key, V value) {
      if (key == null)
         return putForNullKey(value);
      int hash = hash(key.hashCode());
      int i = indexFor(hash, table.length);
      for (Entry<K, V> e = table[i]; e != null; e = e.next) {
         Object k = e.key;
         if (e.hash == hash && (k == key || key.equals(k))) {
            V oldValue = e.value;
            e.value = value;
            return oldValue;
         }
      }
      addEntry(hash, key, value, i);
      return null;
   }

   public V remove(Object key) {
      Entry<K, V> e = removeEntryForKey(key);
      return (e == null ? null : e.value);
   }

   // capacity should be a power of 2, so if oldCapacity < MAX_CAPACITY, newCapacity=2*oldCapacity
   // is
   // less than MAX_CAPACITY
   void resize(int newCapacity) {
      Entry[] oldTable = table;
      int oldCapacity = oldTable.length;
      if (oldCapacity == MAX_CAPACITY) {
         threshold = Integer.MAX_VALUE;
         return;
      }
      Entry[] newTable = new Entry[newCapacity];
      transfer(newTable);
      table = newTable;
      threshold = (int) (newCapacity * loaderFactor);
   }

   /*-------------------------Helper Functions---------------------------------*/
   static int indexFor(int h, int length) {
      return h & (length - 1);
   }

   public V getForNullKey() {
      for (Entry<K, V> e = table[0]; e != null; e = e.next) {
         if (e.key == null)
            return e.value;
      }
      return null;
   }

   public V putForNullKey(V value) {
      for (Entry<K, V> e = table[0]; e != null; e = e.next) {
         if (e.key == null) {
            V oldValue = e.value;
            e.value = value;
            return oldValue;
         }
      }
      addEntry(0, null, value, 0);
      return null;
   }

   void addEntry(int hash, K key, V value, int bucketIndex) {
      Entry<K, V> e = table[bucketIndex];
      table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
      if (size++ >= threshold)
         resize(2 * table.length);
   }

   final Entry<K, V> removeEntryForKey(Object key) {
      int hash = (key == null) ? 0 : hash(key.hashCode());
      int i = indexFor(hash, table.length);
      Entry<K, V> prev = table[i];
      Entry<K, V> e = prev;
      while (e != null) {
         Entry<K, V> next = e.next;
         Object k = e.key;
         if (e.hash == hash && (k == key || (key != null && e.equals(key)))) {
            size--;
            if (prev == e)
               table[i] = next;
            else
               prev.next = next;
            return e;
         }
         prev = e;
         e = next;
      }
      return e;
   }

   final Entry<K, V> getEntry(Object key) {
      int hash = (key == null) ? 0 : hash(key.hashCode());
      for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
         Object k;
         if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
            return e;
      }
      return null;
   }

   // Applies a supplemental hash function to a given hashCode, which defends against poor quality
   // hash functions.
   // Note: Null keys always map to hash 0, thus index 0.
   static int hash(int h) {
      h ^= (h >>> 20) ^ (h >>> 12);
      return h ^ (h >>> 7) ^ (h >>> 4);
   }

   void transfer(Entry[] newTable) {
      Entry[] src = table;
      int newCapacity = newTable.length;
      for (int j = 0; j < src.length; j++) {
         Entry<K, V> e = src[j];
         if (e != null) {
            src[j] = null;
            do {
               Entry<K, V> next = e.next;
               int i = indexFor(e.hash, newCapacity);
               e.next = newTable[i];
               newTable[i] = e;
               e = next;
            } while (e != null);
         }
      }
   }

   /*-------------------------Inner Class---------------------------------*/
   static class Entry<K, V> implements Map.Entry<K, V> {
      final K key;
      V value;
      Entry<K, V> next;
      final int hash;

      Entry(int h, K k, V v, Entry<K, V> n) {
         value = v;
         next = n;
         key = k;
         hash = h;
      }

      public final K getKey() {
         return key;
      }

      public final V getValue() {
         return value;
      }

      public final int hashcode() {
         return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
      }

      @Override
      public V setValue(V newValue) {
         V oldValue = value;
         value = newValue;
         return oldValue;
      }
   }

}
