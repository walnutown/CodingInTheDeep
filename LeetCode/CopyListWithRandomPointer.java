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