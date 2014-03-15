package ch10_scalability_memorylimits;

public class ch10_6_FindDuplicateURLs {
   /**
    * You have 10 billion URLs. How do you detect the duplicate documents? In this case, assume that
    * "duplicate" means that the URLs are identical
    */

   // Assume each URL is an average of 100 characters, and each character is 4 bytes, then this list
   // of 10 billion URLs will take up about 4 TB.

   // It's trivial if we have enough memory, we can use a map to mark the appeared URLs

   // SOL1: one computer with enough disk space
   // <1> split the URLs into 4000 chunks of 1GB each. Each URL u will be stored into a file named
   // <x>.txt where x = hash(u)%4000.
   // <2> traverse each file using hashmap

   // SOL2: multiple machines
   // <1> rather than split the URLs into separate files, we split them into multiple machines
   // <2> find duplicates on each machine and send back the results
   // PRO: parallel, high efficiency
   // DIS: complexity of the system, other machines may not be reliable
}
