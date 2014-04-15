package facebook;

public class CelebrityProblem {
   /*
    * In a party of N people, only one person is known to everyone. Such a person may be present in
    * the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like
    * “does A know B? “. Find the stranger (celebrity) in minimum number of questions.
    */
   
   // http://www.geeksforgeeks.org/the-celebrity-problem/
   // This problem has various versions
   // [1] Given a set obejcts, and a method compareTo(), find the largest object in the set, if not exist
   // reuturn null
   // [2] In a network of persons, there's a relationship between any two persons (A, B), that is
   // A likes B, or B likes A. Find the person that is loved by all the people
   
   // All the versions cen be converted to version[1].
   // Basic idea is to traverse the array two times
   // [1] find the max value M in the array
   // [2] find if M is larger than all other values. This step is necessary as there may be two largest
   // max values, in this case, we return null.
}
