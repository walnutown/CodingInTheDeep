package ch8_ood;

import java.util.ArrayList;
import java.util.List;

public class ch8_4_ParkingLot {
   /*
    * Design a parking lot using object-oriented principles
    * Assumptions:
    * The parking lot has multiple levels. Each level has multiple rows of spots
    * The parking lot can park motorcycles, cars, and buses
    * The parking lot has motorcycle spots, compact spots, and large spots
    * A motor can park in any spot
    * A car can park in single compact or single large spot
    * A bus can park in five large spots that are consecutive and within the same row
    */

   // similar to HandleCalls
   // Models: Vehicle, ParkingSpot; Controller: ParkingController; View: display utilized
   // data of the parking lot
   
   public class ParkingLot{
      public final static int NUM_LEVELS = 5;
      private List<ParkingSpot[][]> levels;
      private int numAvailableSpots;
      private int capacity;
      private int numVehicles;
   }

   abstract class Vehicle { // there's no need for an abstract class to be public, because nobody
                            // will instantiate it
      public final static int MOTOR_MIN_SPOT_SIZE = 1;
      public final static int CAR_MIN_SPOT_SIZE = 2;
      public final static int BUS_MIN_SPOT_SIZE = 3;
      
      public final static int MOTOR_MIN_SPOT_NUM = 1;
      public final static int CAR_MIN_SPOT_NUM = 1;
      public final static int BUS_MIN_SPOT_NUM = 5;
      
      protected int minSpotNum;
      protected String plate;
      protected int minSpotSize;

   }
   
   public class Motor extends Vehicle{
      public Motor(){
         minSpotNum = Vehicle.MOTOR_MIN_SPOT_NUM;
         minSpotSize = Vehicle.MOTOR_MIN_SPOT_SIZE;
      }
      
      public int getMinSpotNumber(){
         return minSpotNum;
      }
      
      public int getMinSpotSize(){
         return minSpotSize;
      }
   }
   
   // public class Car/Bus extends Vehicle
   
   enum SpotType{
      Motor(1), Compact(2), Large(3);
      private int size;
      private SpotType(int size){
         this.size = size;
      }
      
      public int getSize(){
         return size;
      }
   }
   
   public class ParkingSpot{
      public SpotType type;
      private boolean isAvailable;
      
      public ParkingSpot(SpotType type){
         this.type = type;
      }
      
      public SpotType getType(){
         return type;
      }
      
      public boolean isAvailable(){
         return isAvailable;
      }
   }
   
   public class ParkingController{
      
      /**
       * Park vehicle into the parking lot. Return true if succeed.
       */
      public boolean parkVehicle(ParkingLot lot, Vehicle v){
         getAvailableSpots(lot, v);
         // set attributes of the parking lot
         // set status of the parking spots
         return true;
      }
      /**
       * Get the first available spot/spots for the vehicle 
       */
      public ArrayList<ParkingSpot> getAvailableSpots(ParkingLot lot, Vehicle v){
         return null;
      }
      
      
      public void removeVehicle(ParkingLot lot, Vehicle v){
         
      }
   }
   

}
