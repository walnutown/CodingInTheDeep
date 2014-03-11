package ch6_brainteasers;

public class ch6_5_MinimumDrops {
   /*
    * There is a building of 100 floors. If an egg drops from the Nth floor or above, it will break.
    * If it's dropped from any floor below, it will not break. You're given two eggs. Find N, while
    * minimizing the number of drops for the worst case.
    */

   // SOL
   // the key in this problem is "worst case balancing"
   // if we drop Egg1 every 10 floors, best case total drops will be 1+9=10, worst case will be
   // 10+9=19. The worst case is 19.
   // <1> A perfectly balanced system would be one in which Drops(Egg1) + Drops(Egg2) is always the
   // same, regardless of where Egg1 breaks.
   // <2> We therefore, reduce the number of steps potentially required by Egg2 by one drop each
   // time.
   // <3> X + (X-1) + (X-2) + ...+1=100, X=14
}
