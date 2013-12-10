package ch11_sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ch11_11_7 {

   /*
    * Circus designing largest tower
    */
   public static void main(String[] args) {
      
      Person[] persons = new Person[]{new Person(65,100), new Person(70,150), new Person(56,90), new Person(75,190), new Person(60, 95), new Person(68, 110)};
      Person[] persons1 = new Person[]{new Person(65,100), new Person(70,150), new Person(56,190), new Person(75,190), new Person(60, 95), new Person(68, 110)};
      System.out.println(Arrays.toString(persons1));
      System.out.println(buildTower(persons1).toString());
   }
   
   public static ArrayList<Person> buildTower(Person[] persons){
      ArrayList<Person> tower1 = new ArrayList<Person>();
      Arrays.sort(persons, new WeightComparator());
      tower1.add(persons[0]);
      int i = 1;
      Person prev1 = persons[0];
      while (i < persons.length-1){
         if (prev1.getHeight() < persons[i].getHeight() && persons[i].getHeight() < persons[i+1].getHeight()){
            tower1.add(persons[i]);
            prev1 = persons[i];
         }
         i++;
      }
      if (persons[i].getHeight() > prev1.getHeight())
         tower1.add(persons[i]);
      
      ArrayList<Person> tower2 = new ArrayList<Person>();
      Arrays.sort(persons, new HeightComparator());
      tower2.add(persons[0]);
      int j = 1;
      Person prev2 = persons[0];
      while (j < persons.length-1){
         if (prev2.getWeight() < persons[j].getWeight() && persons[j].getWeight() < persons[j+1].getWeight()){
            tower2.add(persons[j]);
            prev2 = persons[j];
         }
         j++;
      }
      if (persons[j].getWeight() > prev2.getWeight())
         tower2.add(persons[j]);
      return tower1.size() > tower2.size() ? tower1 : tower2;
   }
   
   public static class WeightComparator implements Comparator<Person>{
      public int compare(Person p1, Person p2) {
         return p1.weight - p2.weight;
      }
   }
   
   public static class HeightComparator implements Comparator<Person>{
      public int compare(Person p1, Person p2) {
         return p1.height - p2.height;
      }
   }
   
   
   public static class Person{
      private int height;
      private int weight;
      public Person(int height, int weight){
         this.height = height;
         this.weight = weight;
      }
      
      public int getHeight(){
         return this.height;
      }
      public int getWeight(){
         return this.weight;
      }
      
      public String toString(){
         return "("+ height + "," + weight + ")";
      } 
   }
}

