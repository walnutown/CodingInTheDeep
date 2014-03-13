package ch8_ood;


public class ch8_2_HandleCalls {
   /*
    * Imagine you have a call center with three levels of employees: respondent, manager, and
    * director. An incoming telephone call must be first allocated to a respondent who is free. If
    * the respondent cannot handle the call, he or she must escalate the call to a manager. If the
    * manager is not free or not be able to handle it, then the call should be escalated to
    * director. Design the classes and data structures for this problem. Implement a method
    * dispatchCall() which assigns a call to the first available employee.
    */

   // in this question, we have 3+1 models (respondent, manager, director, call). They're in an
   // ordered hierarchy and share some fields and methods. Besides, we need a controller to handle
   // the calls.

   /**
    * CallHandler is implemented as a singleton class.
    */
   public class CallHandler {
      // see CallHandler.java
   }

   enum Rank {
      Respondent(0), Manager(1), Director(2);
      private int rank;

      private Rank(int rank) {
         this.rank = rank;
      }

      public int getValue() {
         return rank;
      }
   }
   
   enum CallStatus{
      WAITING_FOR_RESPOND, CALL_COMPLETE,  IN_CALL 
   }

   public class Call {
      private Rank rank; // minimal rank of employee who can handle this call
      private Employee handler; // employee who's handling the call
      private long phoneNumber;  // we can use phone number as the id of the call
      private CallStatus status;

      public Call(long phoneNumber) {
         this.phoneNumber = phoneNumber;
         rank = Rank.Respondent;
         setStatus(CallStatus.WAITING_FOR_RESPOND);
      }

      public Call(long phoneNumber, Rank rank) {
         this.rank = rank;
         this.phoneNumber = phoneNumber;
         setStatus(CallStatus.WAITING_FOR_RESPOND);
      }
      
      public void setStatus(CallStatus s){
         status = s;
      }
      
      public CallStatus getStatus(){
         return status;
      }
      
      public Rank getRank(){
         return rank;
      }

      public void setHandler(Employee e) {
         handler = e;
         setStatus(CallStatus.IN_CALL);
      }
      
      // ignore other getter and setter here

   }

   /**
    * Employee is the superclass for respondent, manager and director.
    * As we don't have to instantiate an Employee directly, it's an abstract class
    */
   public abstract class Employee {
      private Call currentCall;
      protected Rank rank;
      
      public boolean isAvailable(){
         return currentCall==null;
      }
      
      public Rank getRank(){
         return rank;
      }
      
      public void respondCall(Call call){
         currentCall = call;
      }
   }

   public class Respondent extends Employee {
      public Respondent(){
         rank = Rank.Respondent;
      }
   }

   public class Manager extends Employee {
      public Manager(){
         rank = Rank.Manager;
      }
   }

   public class Director extends Employee {
      public Director(){
         rank = Rank.Director;
      }
   }

}
