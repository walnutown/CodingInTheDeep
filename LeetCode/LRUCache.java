/*
    Design and implement a data structure for Least Recently Used (LRU) cache. 
    It should support the following operations: get and set.

    get(key) - Get the value (will always be positive) of the
    key if the key exists in the cache, otherwise return -1.

    set(key, value) - Set or insert the value if the key is 
    not already present. When the cache reached its capacity,
    it should invalidate the least recently used item before inserting a new item.
*/

// to get O(1) for lookup operation, we need a hashmap
// to get O(1) for operations of inserting before first node and deleting last node, we need a DoublyListNode

// set/get time: O(1), space: O(n)
// refer to the LinkedHashMap in Java
public class LRUCache {
   public Map<Integer, DoublyListNode> map;
   private DoublyListNode head;
   private int capacity;

   public LRUCache(int capacity) {
      this.capacity = capacity;
      head = null;
      map = new HashMap<Integer, DoublyListNode>();
   }

   public int get(int key) {
      if (map.containsKey(key)) {
         set(key, map.get(key).value);
         return map.get(key).value;
      }
      return -1;
   }

   public void set(int key, int value) {
      if (map.containsKey(key)) {
         DoublyListNode node = map.get(key);
         if (node == head){
            node.value = value; // if node is at the head, only need to update the value
            return;
         }
         else    // node is not at the head, need to set it as the new head
            removeNode(node);
      }
      if (map.size() == capacity)   // check whether the LRU is full
         removeNode(head.prev);
      addNode(new DoublyListNode(key, value));
   }

   public void addNode(DoublyListNode node) {
      if (head == null) {   // note the base case
         node.next = node;
         node.prev = node;
      } else {
         head.prev.next = node;
         node.prev = head.prev;
         head.prev = node;
         node.next = head;
      }
      map.put(node.key, node);
      head = node;    // remember to update head
   }

   public void removeNode(DoublyListNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      map.remove(node.key);
   }

   public class DoublyListNode {
      public int key;
      public int value;
      public DoublyListNode prev;
      public DoublyListNode next;

      public DoublyListNode(int key, int value) {
         this.key = key;
         this.value = value;
         prev = null;
         next = null;
      }
   }
}