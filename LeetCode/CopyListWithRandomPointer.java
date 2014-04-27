/*
  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

  Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// Maintain a map to memoize the nodes that have been copied
// time: O(n); space:O(n)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head ==null)    return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode sen = new RandomListNode(0), p = head, s = sen;
        while (p != null){
            if (!map.containsKey(p))
                map.put(p, new RandomListNode(p.label));
            if (p.random!=null && !map.containsKey(p.random))
                map.put(p.random, new RandomListNode(p.random.label));
            s.next = map.get(p);
            s = s.next;
            s.random = map.get(p.random);
            p = p.next;
        }
        return sen.next;
    }
}