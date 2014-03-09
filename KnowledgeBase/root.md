Knowledge Base for Concepts related questions in programming interview
===============
##Java
[notes](https://docs.google.com/document/d/1msRFUdvg1z6iNmHqUUI_KVXEWLtODc2JaZH6w2o7o9k/edit?usp=sharing)

* StringBuffer Vs StringBuilder
  * StringBufer is synchronized, while StringBuilder is not.
  * StringBuilder provides an API compatible with StringBuffer, but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.

##Distributed System & Big Data

[Nootcod3r: Count Occurences](http://n00tc0d3r.blogspot.com/2013/07/big-data-count-occurrences.html)<br>
Given a large number (millons or billons) of records (integers, IPs, URLs, query key words, etc.),
* find out top k most frequent records;
* find out duplicates;
* find out whether a given number x is in the set or not.



##Networking & Protocol
  [What Every Web Developer Should Know About HTTP (OdeToCode Programming Series) - Allen, K. Scott](http://www.amazon.com/Developer-Should-OdeToCode-Programming-Series-ebook/dp/B0076Z6VMI)
* URL -- Uniform Resource Locator
    * schema://host:port/path?query#frag
      * schema: http, https, ftp, etc
      * host: xxx.com
      * url path: /abc/def/109
      * port number: the host use it to listen for http request. The default value is 80
    * url may point to a file on host's file system or disk space (http://xxx.com/a.jpg).
    Yet, sometimes, it doesn't refer to any file on the server(although url is a 'locator'). In this case, when the appplication receives the http request, it will build a web page  by controlling views and model (MVC)
    * query: http://www.google.com/search?q=apple&p=banana
      * everything after ? is known as the query.
      * usually is a name/value pair a=b
    * fragment:http://xxx.com/apple#google
      * fragment is not processed by the server, only used on client-side to identify a specific section of the page (by element's id).
    * url encode: encode **unsafe character**(whiete sapce, ^, etc.) into safe character
      * 'my book ' -> 'my%20book'
* Http transaction
    * request/response
      * build network connection and send http message
    * content type (media type)
      * MIME (Multiple Internet Mail Extension) standards.
      * file extension is the last thing used to check actual content type
    * request type
      * Get/Post; Delete/Put/Head
      * Get, retrieve; Post, form, input
      * Post/Redirect/Get pattern (Post is unsafe, will modify data on the server; while Get is safe)
    * Http Request
      * [method][URL][version]
        [headers]
        [body]
      * in ASCII text
      * there're numerous headers defiend by the Http specification
    * Response Status Code (200/400/500, etc)
    * Response headers: to deal with cache and performance of the web
* State and Security
    * HTTP is a stateless protocol, how to maintain states on the website?
    * Cookie: HTTP State Management Mechanism
      * identify user
      * track user requests
      * cookie only stores a unique user identifier, the user information is stored on the server, not in cookies
      * the UID should be encrypted to avoid security concerns
      * Flags: **HttpOnly**
      * types: Session cookies (exist for a single user); Persistent cookies (needs an **Expires** value)
    * Set-Cookie:
      * name-value pairs
      * size limitation: 4KB
      * Path & Domain: controls the scope using domain and path attritbutes
        * domain: allows a cookie to span sub-domains (e.g., domain: server.com, sub-domain: pic.server.com, file.server.com, etc.)
        * path: restrict a cookie to a specific path.
    *Authentication
      * Basic Authentication -- base 64 encoding
        * encode password on client, and decode on server
      * Digest Authentication
        * Improvement over basic authentication
        * client send a digest of the password, using MD5 hashing
    *Secure HTTP -- HTTPS
      * default port is 443, instead of 80
      * SSL: additional security layer between HTTP and TCP
      * All trafic over HTTPS is encrypted in the request and response, including the HTTP headers and message body.
      * The server is authenticated to the client (through server certificate, no proxy server to redirect webpage)
      * HTTPS doesn't authenticate clients, it's computationally expensive and need more handshakes between the client and the server


##OO Design Patterns
[oodesign.com](http://www.oodesign.com/)<br>
[SO-Examples of GoF Design Patterns](http://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns/2707195#2707195) <br>
[notes](https://docs.google.com/document/d/1tWOAhdr4QG_Y4GTpKjmx-OP6HnKFtnGp0I5KZi12LV0/edit?usp=sharing)
* Creational Patterns
  * Singleton:  java.lang.Runtime
      * how to implement? (private constructor)
      * how to ensure multithread safe? (enum)
  * Abstract Factory / Factory Method
      * Abstract Factory returning the factory itself which in turn can be used to create another abstract/interface type
      * Factory Method returning an implementation of an abstract/interface type
  * Prototype
      * clone() -- deep/shalow clone
  * Builder: java.lang.StringBuilder#append()
      * returning the instance itself
      * implementations of java.lang.Appendable are good examples
      * Builder Vs Factory Method
* Structural Patterns
  * Adapter: java.util.Arrays#asList()
      * In real world we have adapters for power supplies, adapters for camera memory cards, and so on.
  * Decorator:
      * taking an instance of same abstract/interface type which adds additional behaviour
      * All subclasses of java.io.InputStream, OutputStream, Reader and Writer have a constructor taking an instance of same type.
      * java.util.Collections, the checkedXXX(), synchronizedXXX() and unmodifiableXXX() methods
  * Composite
      * There are times when a program needs to manipulate a tree data structure and it is necessary to treat both Branches as well as Leaf Nodes uniformly
      * File System -- folder and file
  * Flyweight
      * returning a cached instance, a bit the "multiton" idea
      * java.lang.Integer#valueOf(int) (also on Boolean, Byte, Character, Short and Long)
      * that's why *Integer.valueOf(int)* is preferred over *new Integer(int)*
  * Facade
      *  internally uses instances of different independent abstract/interface types
      *  wrap a poorly designed collection of APIs with a single well-designed API
      *  make a software library easier to use, understand and test, since the facade has convenient methods for common tasks
      *  [good example from wiki](http://en.wikipedia.org/wiki/Facade_pattern)
* Behavioral Patterns
  * Iterator: All implementations of java.util.Iterator 
      * One of the most common data structures in software development is what is generic called a collection. A collection should provide a way to access its elements without exposing its internal structure
      * An iterator that allows insertion and deletions without affecting the traversal and without making a copy of the aggregate is called a **robust iterator**.
      * **Multithreading Iterator**: all multithreading iterators should be robust iterators.
  * Observer: All implementations of java.util.EventListener
      * invokes a method on an instance of another abstract/interface type, depending on own state
  * Command: All implementations of java.lang.Runnable
      * the Macro represents, at some extent, a command that is built from the reunion of a set of other commands, in a given order. Just as a macro, the Command design pattern encapsulates commands (method calls) in objects 
      * the main advantage of the command design pattern is that it decouples the object that invokes the operation from the one that know how to perform it.
  * Strategy: 
      * java.util.Comparator#compare(), executed by among others Collections#sort().
      * There are common situations when classes differ only in their behavior. For this cases is a good idea to isolate the algorithms in separate classes in order to have the ability to select different algorithms at runtime.
      * the main draw back is that a client must understand how the Strategies differ. Since clients get exposed to implementation issues the strategy design pattern should be used only when the variation in behavior is relevant to them.
  * Chain of Responsibility
      * consisting of a source of command objects and a series of processing objects. Each processing object contains logic that defines the types of command objects that it can handle; the rest are passed to the next processing object in the chain

##Analyze Algorithms -- (from CLRS)
* Analyze in a RAM model, which means that instructions are executed one after another, with no concurrent operations.
* Running time: the numebr of primitive operations or "stpes" executed.
* Worst case, best case and average case. Usually, we use worst case; and sometimes, average case is used (provided that all inputs of a given size are equally likely, we can use a randomized algorithm to achieve this)
* Order of Growth -- rate of growth of the running time
  * We're only concerned about the highest-order term (ignore the lower-order terms), and ignote constant coefficient.
  * e.g. in an^2 + bn + c, we only care about n^2
* Master Theorem
  * calculate the running time of recurrence equation
* big O, upper bound; omega, lower bound
  * The definitions of O-notation and o-notation are similar. The main difference
is that in f(n) = O(g(n)), the bound 0 <= f(n) <= cg(n) holds for some constant c > 0, but in f(n) = O(g(n)), the bound 0 <= f(n) < cg(n) holds for all constants c > 0
  * O(n!) > O(2^n) > O(n^2) > O(n) > O(lgn)
* Solving Recurrences
  * Substitution method (Guess)
    * T(n) = T(n-1) + 1/n, O(n) = lgn
    * T(n) = T(n-1) + lgn, O(n) = nlgn
    * T(n) = T(n-1) + n, O(n) = n^2
  * The recursion-tree method 
  * The master method, works for the recurrences of the form: T(n) = aT(n/b) + f(n)
    * compare f(n) with n^(lgba)
    * polynomially smaller, a is smaller than b by a factor (which is b/a) of n^c for some constant c > 0. e.g. a=n, b=nlgn, b/a=lgn, which is not polynomially small.
  * 



















