package ch10_scalability_memorylimits;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ch10_2_LargeScaleGraphSearch {
   /**
    * How would you design the data structures for a very large social network like Facebook or
    * LinkedIn? Describe how you would design an algorithm to show the connection, or path, between
    * two people.
    */

   // we can start from the basic case, instead of handling the large-scale problem directly

   // <1> Basic case: use graph, each node represent a user, and the edge between two nodes
   // represent the connection between two users; use BFS to search the path between two users

   // <2> consider large-scale case: the two users may not exist on the same machine
   /*
    * [1] for each friend (use UserId as identifier), get the MachineId that the friend resides on
    * [2] go to the machine of MachineId
    * [3] on that machine, get the User of UserId
    */
   public class Server {
      // mapping of machineId and machine
      Map<Integer, Machine> machines = new HashMap<Integer, Machine>();
      // mapping of personId and machineId
      Map<Integer, Integer> userToMachineMap = new HashMap<Integer, Integer>();

      public Machine getMachineWithId(int machineId) {
         if (machines.containsKey(machineId))
            return machines.get(machineId);
         return null;
      }

      public int getMachineIdForUser(int userId) {
         if (userToMachineMap.containsKey(userId))
            return userToMachineMap.get(userId);
         return -1;
      }

      public User getUserWithId(int userId) {
         int machineId = getMachineIdForUser(userId);
         if (machineId == -1)
            return null;
         Machine machine = getMachineWithId(machineId);
         return machine.getUserWithId(userId);
      }
   }

   public class User {
      List<Integer> friendIds;
      int userId;
   }

   public class Machine {
      int machineId;
      Map<Integer, User> persons = new HashMap<Integer, User>();

      public User getUserWithId(int userId) {
         if (persons.containsKey(userId))
            return persons.get(userId);
         return null;
      }
   }

   // OPTIMIZATION:
   // <1> how to reduce cost of machine jumps? (jumping from one machine to another is expensive)
   // [1] look up friends on the same machine all at once
   // [2] aggregate similar(same country, city, etc) users in the same machine, because they're likely
   // to be friends
   // [3] traverse the friend with more friends first, because they're more likely to be connected with the target.
   
   // FOLLOWUP
   // [1] what if server fails? what's the affect?
   // [2] how to take advantage of caching?
   // [3] how do you decide when to give up the search?
}
