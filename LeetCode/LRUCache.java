// set/get time: O(1), space: O(n)
// refer to the LinkedHashMap in Java
public class LRUCache {
    private Map<Integer, DoublyLinkedNode> map;
    private int capacity;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, DoublyLinkedNode>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            set(key, map.get(key).value);
            return map.get(key).value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        DoublyLinkedNode node = null;
        if (!map.containsKey(key)){
            node = new DoublyLinkedNode(key, value);
            if (map.size() >= capacity)  removeNode(tail);
            addNode(node);
        } 
        else{
            node = map.get(key);
            node.value = value;     // IMPORTANT here
            if (node != head){
                removeNode(node);
                addNode(node);
            }
        }
    }
    
    public void addNode(DoublyLinkedNode node){
        if (head == null){   
            head = node; head.next = tail;
            tail = node; tail.prev = head;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        map.put(node.key, node);
    }
    
    public void removeNode(DoublyLinkedNode node){
        if (head == tail){
            head = null; tail = null;
            node.prev = null; node.next = null;
        }
        else if (node == tail){
            node.prev.next = null;
            tail = node.prev;
            node.prev = null;
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null; node.next = null;
        }
        map.remove(node.key);
    }
    
    private class DoublyLinkedNode{
        int key; 
        int value;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
        
        DoublyLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
}