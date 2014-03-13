package ch8_ood;

import java.util.ArrayList;
import java.util.Random;

public class ch8_1_BlackJack {
   /*
    * Design the data structures for a generic deck of cards. Explain how you would subclass the
    * data structures to implement blackjack.
    */
   
   /*
    * Value of cards:
    * In blackjack, the cards are valued as follows:
    * An Ace can count as either 1 or 11, as explained below.
    * The cards from 2 through 9 are valued at their face value.
    * The 10, Jack, Queen, and King are all valued at 10.
    */

   /*
    * A blackjack, or natural, is a total of 21 in your first two cards. A blackjack is therefore an
    * Ace and any ten-valued card, with the additional requirement that these be your first two
    * cards
    */
   
   // for rules, refer http://www.blackjackinfo.com/blackjack-rules.php

   /*-----------------------------standard deck implementation--------------------------------------*/
   // the deck is a standard 52-card set, like you might see used in a blackjack or poker game.
   public enum Suit {
      Club(0), Diamond(1), Heart(2), Spade(3);
      private int value;

      private Suit(int value) { // note the constructor should be private here. Another example of
                                // private constructor is singleton
         this.value = value;
      }

      public int getValue() {
         return value;
      }

      public Suit getSuitFromValue(int val) {
         switch (val) {
         case 0:
            return Suit.Club;
         case 1:
            return Suit.Diamond;
         case 2:
            return Suit.Heart;
         case 3:
            return Suit.Spade;
         default:
            return null;
         }
      }
   }

   public abstract class Card {
      private boolean available = true;
      /*
       * number or face that's on card - a number 2 through 10,
       * or 11 for Jack, 12 for Queen, 13 for King, or 1 for Ace
       */
      protected int faceValue; // should be protected here, because the subclass will use this
                               // variable
      private Suit suit;

      public Card(int val, Suit s) {
         faceValue = val;
         suit = s;
      }

      public abstract int value(); // make it abstract here because value() don't make much sense
                                   // without a specific game attached to it

      public Suit suit() {
         return suit;
      }

      public boolean isAvailable() {
         return available;
      }

      public void markUnavailable() {
         available = false;
      }

      public void markAvailable() {
         available = true;
      }
   }

   public class Hand<T extends Card> {
      protected ArrayList<T> cards;

      public Hand() {
         cards = new ArrayList<T>();
      }

      public int score() {
         int score = 0;
         for (T card : cards)
            score += card.value();
         return score;
      }

      public void addCard(T card) {
         cards.add(card);
      }
   }

   public class Deck<T extends Card> {  // note the <T extends Card> generics here
      private ArrayList<T> cards;
      private int dealtIndex = 0; // marks first undealt card
      private Random r;

      public Deck(ArrayList<T> deckOfCards) {
         cards = deckOfCards;
         r = new Random(System.currentTimeMillis());
      }

      public void setDeckOfCards(ArrayList<T> deckOfCards) {
         cards = deckOfCards;
      }

      public void shuffle() {
         for (int i = 0; i < cards.size(); i++) {
            int j = rand(0, i - 1);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
         }
      }

      public int remainingCards() {
         return cards.size() - dealtIndex;
      }

      /**
       * Take a hand of cards from the deck and give them to a player
       */
      public T[] dealHand(int number) {
         if (remainingCards() < number)
            return null;
         T[] hand = (T[]) new Card[number];
         int count = 0;
         while (count < number) {
            T card = (T) dealCard();
            if (card != null)
               hand[count++] = card;
         }
         return hand;
      }

      /**
       * Take a card from the deck and give it to a player
       */
      public T dealCard() {
         if (remainingCards() == 0)
            return null;
         T card = cards.get(dealtIndex);
         card.markUnavailable();
         dealtIndex++;
         return card;
      }

      private int rand(int low, int high) {
         return low + r.nextInt(high + 1 - low);
      }
   }

   /*-----------------------------blackjack implementation--------------------------------------*/
   public class BlackJackHand extends Hand<BlackJackCard> {
      /*
       * There're multiple possible scores for a blackjack hand, since aces have multiple values.
       * Return the highest possible score that's under 21, or the lowest score that's over.
       */
      public int score() {
         ArrayList<Integer> scores = possibleScores();
         int minOver = Integer.MAX_VALUE; // min score over 21
         int maxUnder = Integer.MIN_VALUE; // max score under 21
         for (int score : scores) {
            if (score > 21 && score < minOver)
               minOver = score;
            else if (score <= 21 && score > maxUnder)
               maxUnder = score;
         }
         return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
      }

      private ArrayList<Integer> possibleScores() {
         ArrayList<Integer> scores = new ArrayList<Integer>();
         if (cards.size() == 0) {
             return scores;
         }
         for (BlackJackCard card : cards) {
             addCardToScoreList(card, scores);
         }
         return scores;
      }
      
      private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {
         if (scores.size() == 0) {
             scores.add(0);
         } 
         int length = scores.size();
         for (int i = 0; i < length; i++) {
             int score = scores.get(i);
             scores.set(i, score + card.minValue());
             if (card.minValue() != card.maxValue()) {
                 scores.add(score + card.maxValue());
             }
         }
     }

      public boolean busted() {
         return score() > 21;
      }

      public boolean is21() {
         return score() == 21;
      }
      
      public boolean isBlackJack(){
         if (cards.size() != 2) {
            return false;
        }
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard());
      }

   }

   public class BlackJackCard extends Card {
      public BlackJackCard(int c, Suit s) {
         super(c, s);
      }

      public int value() {
         if (isAce())
            return 1;
         else if (faceValue >= 11 || faceValue <= 13)
            return 10;
         else
            return faceValue;
      }

      public int minValue() {
         if (isAce())
            return 1;
         else
            return value();
      }

      public int maxValue() {
         if (isAce())
            return 11;
         else
            return value();
      }

      public boolean isAce() {
         return faceValue == 1;
      }

      public boolean isFaceCard() {
         return faceValue >= 11 && faceValue <= 13;
      }
   }
}
