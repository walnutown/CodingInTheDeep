package facebook;

import lib.ListNode;

import org.junit.Test;

public class InterleaveLinkedList {
   /*
    * Given two linkedlists, return the interleaved linkedlist
    * eg,
    * Given
    * 1->2->3->4;
    * 5->6;
    * return 1->5->2->6->3->4;
    */
   
   // Iterative version
   // A easy-to-make bug of this question is to move p pointer after q has been appended to s
   // In that case, p.next is not the next element in list A, but an element in list B
   // time: O(n+m); space: O(1)
   public ListNode interleave(ListNode A, ListNode B){
      ListNode sen = new ListNode(0);
      ListNode s = sen, p = A, q = B;
      while (p!=null && q!=null){
      		s.next = p;
      		p = p.next;         
      		s = s.next;
      		s.next = q;
      		q = q.next;
      		s = s.next;
      }
      if (p!=null)
      	s.next = p;
      if (q!=null)
      	s.next = q;
      return sen.next;
   }
   
   // recursion
   public ListNode interleave2(ListNode A, ListNode B){
      if (A==null && B==null)
         return null;
      if (A!=null && B==null)
         return A;
      if (A==null && B!=null)
         return B;
      B.next = interleave2(A.next, B.next);
      A.next = B;
      return A;
   }

   @Test
   public void test(){
   		int[] A = new int[]{1,2,3,4};
   		int[] B = new int[]{5,6};
   		ListNode a = new ListNode(A);
   		ListNode b = new ListNode(B);
   		System.out.println(a.printList());
   		System.out.println(b.printList());
   		//System.out.println(interleave(a,b).printList());
   		System.out.println(interleave2(a,b).printList());
   }
}
