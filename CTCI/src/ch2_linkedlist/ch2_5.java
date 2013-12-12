package ch2_linkedlist;

public class ch2_5 {

   /*
    * Two numbers represented by a linked list in reverse order
    * Add the two numbers and return the sum as a linked list
    */
   public static void main(String[] args) {
      int[] arr1 = new int[]{1,6,2};
      int[] arr2 = new int[]{9,2,8};
      ListNode num1 = new ListNode(arr1);
      ListNode num2 = new ListNode(arr2);
      System.out.println(num1.printList());
      System.out.println(num2.printList());
      System.out.println(addNums(num1, num2).printList());
   }
   
   public static ListNode addNums(ListNode num1, ListNode num2){
      ListNode sum = new ListNode(0);
      ListNode s = sum;
      ListNode p = num1;
      ListNode q = num2;
      int carry = 0;
      while (p != null && q != null){
         s.next = new ListNode((p.val + q.val + carry)%10);
         s = s.next;
         carry = (p.val + q.val + carry)/10;
         p = p.next;
         q = q.next;
      }
      while (p != null){
         s.next = new ListNode((p.val+carry)%10);
         s = s.next;
         carry = (p.val + carry)/10;
         p = p.next;
      }
      while (q != null){
         s.next = new ListNode((q.val+carry)%10);
         s = s.next;
         carry = (q.val + carry)/10;
         q = q.next;
      }
      if (carry > 0){
         s.next = new ListNode(carry);
      }
      return sum.next;
   }
   
   // FOLLOW UP:
   // suppose the digits are stored in forward order

}
