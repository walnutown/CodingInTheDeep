package ch6_brainteasers;

public class ch6_1_PillWeight {

   /**
    * You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has pills of weight 1.1
    * grams. Given a scale that provides an exact measurement, how would you find the heavy bottle?
    * You can only use the scale once.
    */
   
   // SOL
   // <1> take one pill from Bottle#1, two pills from Bottle#2, three pills from Bottle#3, and so
   // on.
   // <2> Weigh this mix of pills. If all pills were one gram each, the scale would reach 210 grams
   // ( 1 + 2 + 3 + ... + 20 = 21*20/2=210)
   // <3> Get the bottle number by formula: (weight - 210 grams)/0.1 grams
}
