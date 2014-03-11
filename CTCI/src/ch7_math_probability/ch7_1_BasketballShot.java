package ch7_math_probability;

public class ch7_1_BasketballShot {

   /**
    * Play two games with basketball hoop
    * Game1: get one shot to make the hoop
    * Game2: get three shots and you have to make at least two of three shots
    * if p is probability of making a particular shot, for which value
    * of p should you pick one game or the other 
    */
   
   // Game1 : P1 = p
   // Game2 : P2 = 3 * p^2 * (1-p) + p^3
   // P1 > P2 =>    p > 3(1-p)p^2 + p^3     =>  (2p-1)(p-1) > 0 => p < 0.5
   // if p=0, p=0.5, p=1, the probability of winning two games are the same
}
