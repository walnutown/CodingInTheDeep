package ch8_ood;

import java.util.List;

import ch8_ood.ch8_2_HandleCalls.Call;
import ch8_ood.ch8_2_HandleCalls.Employee;

public class CallHandler{
   private static CallHandler instance;
   private final int LEVELS = 3; // 3 levels of employees
   List<List<Employee>> employeeLevels;
   List<List<Call>> callQueues; // queues for each call's rank
   
   private CallHandler(){}
   
   public static CallHandler getInstance(){
      if (instance==null)
         instance = new CallHandler();
      return instance;
   }
   
   /**
    * Get the first available employee who can handle the call
    */
   public Employee getHandlerForCall(Call call){
      for (int i=call.getRank().getValue(); i<LEVELS; i++){
         List<Employee> ems = employeeLevels.get(i);
         for (Employee e: ems){
            if (e.isAvailable())
               return e;
         }
      }
      return null;
   }
   /**
    * Routes the call to an available employee, or saves in a queue if no employee is available
    */
   public void dispatchCall(Call call){
      Employee e = getHandlerForCall(call);
      if (e!=null){
         makeCall(e, call);
      }else{
         callQueues.get(call.getRank().getValue()).add(call);
      }
   }
   
   /**
    * If one employee gets free. Look for a waiting call that employee can serve.
    * @return true if employee is assigned a call; otherwise, false
    */
   public boolean assignCall (Employee e){
      /* Check the queues, starting from the highest rank this employee can serve. */
      for (int i=LEVELS-1;i>=e.getRank().getValue(); i--){
         List<Call> calls = callQueues.get(i);
         if (!calls.isEmpty()){
            makeCall(e, calls.remove(0));
            return true;
         }
      }
      return false;
   }
   
   public void makeCall(Employee e, Call call){
      e.respondCall(call);
      call.setHandler(e);
   }
   
   
   
  
}
