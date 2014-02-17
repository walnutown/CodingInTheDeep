public class Solution {
      public RandomListNode copyRandomList(RandomListNode head) {
         // Note: The Solution object is instantiated only once and is reused by
         // each test case.
         if (head == null)
            return null;
         RandomListNode root = new RandomListNode(head.label);
         RandomListNode r = root;
         HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
         map.put(head, root);
         while (head != null) {
            if (head.next != null) {
               if (!map.containsKey(head.next)) {
                  RandomListNode next = new RandomListNode(head.next.label);
                  map.put(head.next, next);
                  r.next = next;
               }
               else
                  r.next = map.get(head.next);
            }
            if (head.random != null) {
               if (!map.containsKey(head.random)) {
                  RandomListNode random = new RandomListNode(head.random.label);
                  map.put(head.random, random);
                  r.random = random;
               }
               else
                  r.random = map.get(head.random);
            }
            r = r.next;
            head = head.next;
         }
         return root;
      }
   }




   /**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head ==null)    return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dum = new RandomListNode(0), p = head, r = dum;
        while (p != null){
            if (!map.containsKey(p))
                map.put(p, new RandomListNode(p.label));
            if (p.random!=null && !map.containsKey(p.random))
                map.put(p.random, new RandomListNode(p.random.label));
            r.next = map.get(p);
            r = r.next;
            r.random = map.get(p.random);
            p = p.next;
        }
        return dum.next;
    }
}