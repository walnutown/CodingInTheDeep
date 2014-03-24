package twitter;

public class SearchNamesInTweets {
   /*
    * Given a list of names. Find whether a particular name occurs inside a given tweet or not. If
    * found return true otherwise false
    * Ex: "Katy Perry","Ronan Keating" given as a list of string.
    * List<String> names;
    * bool findName(String tweet){
    * }
    */

   // refer
   // http://www.ardendertat.com/2011/12/20/programming-interview-questions-23-find-word-positions-in-text/
   // This problem can be described as: given a text file and a word, locate the word in the file.
   // [1] if the query is called only once, this is same to Leetcode/ImplementStrStr. We can use KMP
   // to solve it in O(m+n) running time, m is the length of the word, n is the length of the text
   // file
   // [2] If we have a list of words to query the same file. It's better to so dome pre-processing.
   // We can use inverted index, which is widely used in search engines. Inverted index is
   // implemented by a hashtable, whose key is word, and value is the array of positions.
   // A. One issue is how to parse the words in the text file. We can use regular expression to deal
   // with punctuation, and then convert all words into lowercase.
   // B. Index takes O(n), query takes O(1) runnint time
   // C. requires O(n) space
   // [3] If we have a list of words to query multiple files. We can use Trie!
   // A. trie is more space efficient than map. For example 'author', 'authority', and 'authorize'.
   // Hashtable index uses 6+9+9=24 characters but trie uses only 6+3+2=11, leading to 55%
   // compression.
   // B. query takes O(k) running time, k is the average length of words in text files. Average
   // number of characters in an English word is around 4-5, and most of them are shorter than 15.
   // Which means it’ll generally take around 4-5 operations, and mostly less than 15, to find a
   // word in the trie independent of the number of words stored
}
