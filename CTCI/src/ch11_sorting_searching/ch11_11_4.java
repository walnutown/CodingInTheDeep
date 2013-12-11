package ch11_sorting_searching;

public class ch11_11_4 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}

// Imagine you have a 20GB file with one string per line. Explain how you would sort the file.

// split the file into several small chunks, each is below the maximum size of RAM.
// read each chunk to RAM, heap sort, then write back to the disk 
// merge all the chunks, one by one.

// This is known as external sort