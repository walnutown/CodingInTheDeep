package twitter;

public class MapReduceMedian {
   /*
    * Given 1000 worker nodes/hosts, 1 coordinator node (4GB RAM) - 10 billion
    * numbers are distributed randomly among the worker nodes.
    * Find the mean
    */
   // <1> map numbers to nodes, 
   // <2> calculate the average of each node
   // <3> reduce the average value to coordinator and calculate the final mean
   
   // FOLLOWUP
   // Find the median
   // <1> Assign each node with a range of numbers
   // e.g. Node#1 - [0,99], Node#2 - [100, 199] ... 
   // <2> map each number to the corresponding node
   // <3> get the size of numbers on each node, the total size of numbers, and the order of median
   // <4> Calculate the node containing the median number
   // <5> QuickSelect the median number
}
