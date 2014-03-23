package amazon;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PythagoreanTriple {
   /*
    * A Pythagorean triple consists of three positive integers a, b, and c, such that a*a + b*b = c*c
    * Find all the Pythagorean triples in [1...n]
    */

   // Given the following code, how to optimize it?
   // time: O(n^3)
   public void findPythagoreanTriples(int N) {
      for (int a = 1; a <= N; a++) {
         for (int b = 1; b <= N; b++) {
            for (int c = 1; c <= N; c++) {
               if (a * a + b * b == c * c)
                  System.out.println(a + ", " + b + ", " + c);
            }
         }
      }
   }
   
   // optimized version
   // <1> reduce duplicates, we can get that a<b<c. If a==b, c= sqrt(2*a*a), which obviously is not an integer
   // <2> remove the third loop
   // time: O(n^2)
   public void findPythagoreanTriples2(int N) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i=0; i<=N; i++)
         map.put(i*i, i);
      for (int a = 3; a <= N; a++) {
         for (int b = a + 1; b <= N && (a * a + b * b) <= N * N; b++) {
            if (map.containsKey(a*a + b*b))
               System.out.println(a + ", " + b + ", " + map.get(a*a+b*b));
         }
      }
   }
   
   // optimized version 2
   // similar to 3sum
   // first get an array of square values for each element
   // time: O(n^2)
   public void findPythagoreanTriples3(int N) {
      int[] squares = new int[N+1];
      for (int i=0; i<=N; i++)
         squares[i] = i*i;
      for (int c=N; c>=5; c--){
         int a=3, b=c-1;
         while (a<b){
            if (squares[c] == squares[a] + squares[b]){
               System.out.println(a + ", " + b + ", " + c);
               a++;
               b--;
            }
            else if (squares[c] < squares[a] + squares[b])
               b--;
            else
               a++;
         }
      }
   }
   
   @Test
   public void test(){
      findPythagoreanTriples(50);
      System.out.println("");
      findPythagoreanTriples2(50);
      System.out.println("");
      findPythagoreanTriples3(50);
   }
}
