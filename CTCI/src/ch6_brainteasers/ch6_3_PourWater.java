package ch6_brainteasers;

public class ch6_3_PourWater {
   /*
    * We have a five-quart jug, a three-quart jug, and an unlimited supply of water (but no
    * measuring cups). How would you come up with exactly four quarts of water? (Note that the jugs
    * are oddly shaped, such that filling up exactly "half" of the jug would be impossible)
    */
   // SOL
   // <1> fill(5)
   // <2> pour(5, 3)    pour from 5 to 3 until 3 is full or 5 is empty
   // <3> pour(5, 3)    now #3 has 2 quarts
   // <4> fill(5)
   // <5> pour(5,3)     now #3 has 3, 5 has 4
}
