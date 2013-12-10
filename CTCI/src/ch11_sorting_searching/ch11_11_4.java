package ch11_sorting_searching;

public class ch11_11_4 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}

// Imagine you have a 20GB file with one string per line. Explain how you would sort the file.

// split the file into several small parts, each is below the maximum size of RAM.
// read each file to RAM, heap sort, then write back to the disk 
// read root of each file to the RAM, and heap sort, write to output file the root of the heap in RAM 