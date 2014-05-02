package ch6_brainteasers;

public class ch6_6_ToggleLockers {

   /**
    * There're 100 closed lockers in a hallway. A man begins by opening all 100 lockers. Next, he
    * closes every second lockers. Then, on his third pass, he toggles every third locker (closes it
    * if it's open or opens it if it's closed). This process continues for 100 passes, such that on
    * each pass i, the man toggles every ith locker. After his 100th pass in the hallway, in which
    * he toggles only locker#100, how many lockers are open?
    */

   // SOL:
   // <1> A door n is toggled once for each factor of n, including itself and 1. That is, door 15 is
   // toggled on rounds 1, 3, 5 and 15.
   // <2> A door is left open if the number of factors is odd. They're 1*1, 2*2 .. 10*10
   // <3> Thus, there're 10 lockers open at the end of this process
}
