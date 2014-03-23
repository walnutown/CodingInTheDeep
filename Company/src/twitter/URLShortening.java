package twitter;

import java.util.Map;

public class URLShortening {
   /**
    * [1] URL shortening is achieved by using an HTTP Redirect on a domain name that is short, which
    * links to the web page that has a long URL.
    * [2] It is especially convenient for messaging technologies such as Twitter, which severely
    * limit the number of characters that may be used in a message.
    * 
    * Explain how to implement URL shortening
    * e.g. http://tinyurl.com/Es60ia
    */

   // SOL
   // [1] Basically, is to create a mapping between long URL and short URL
   // [2] How to ensure that each URL has a unique short URL?
   // we assign an unique ID to each long URL. Thus, in the database, we
   // have three columns: id, long url, short url. id is auto-increment
   // [3] Now the problem becomes how to convert a long integer into a string
   // [4] Suppose we use bases62 in the short url (10 + 26*2=62, 0-9, a-z, A-Z), and length of
   // the identifier string ('Es60ia' in the example short url) is 6
   // [5] It becomes a simple base conversion problem

   // map: 0->0, ... 11->a...37->A
   public String getShortURL(int id, int base, Map<Integer, Character> map) {
      StringBuilder sb = new StringBuilder();
      sb.append("http://tinyurl.com/"); // domain and path
      while (id > 0) {
         int digit = id % base;
         sb.append(map.get(digit));
         id /= base;
      }
      while (sb.length() < 6)
         sb.append('0');
      return sb.reverse().toString();
   }

   // What if this is implemented in distributed system?
   // Create short url
   // We can use consistent hashing to hash a long url(represented by an id) to one server.
   // Consistent hashing here ensures load balanced.
   // Retrieve long url
   // base conversion to get the id of long url, and hash to locate the corresponding server that
   // stores the long url
}
