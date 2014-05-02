package ch6_brainteasers;

public class ch6_5_MinimumDrops {

   /**
    * There is a building of 100 floors. If an egg drops from the Nth floor or above, it will break.
    * If it's dropped from any floor below, it will not break. You're given two eggs. Find N, while
    * minimizing the number of drops for the worst case.
    */

   // Load Balancing
   // if we drop Egg1 every 10 floors, best case total drops will be 1+9=10, worst case will be
   // 10+9=19. The worst case is 19.
   // [1] A perfectly load-balanced system would be one in which Drops(Egg1) + Drops(Egg2) is always
   // the same, regardless of where Egg1 breaks
   // [2] In this case, each time we add one more drop for Egg1, we should reduce one drop of Egg2
   // [3] Thus, Egg1 must start at floor X, then go up by X-1 floors, then X-2... until it gets to
   // 100

}
