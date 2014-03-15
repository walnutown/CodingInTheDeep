Knowledge Base for Concepts related questions in programming interview
===============
##Java
[notes](https://docs.google.com/document/d/1msRFUdvg1z6iNmHqUUI_KVXEWLtODc2JaZH6w2o7o9k/edit?usp=sharing)

* Comparisons:
  * StringBuffer Vs StringBuilder
    * StringBufer is synchronized, while StringBuilder is not.
    * StringBuilder provides an API compatible with StringBuffer, but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.
  * Abstract Class Vs Interface
    * [Official Doc: Abstract Classes Compared to Interfaces](http://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
    * An abstract Class is a class that can not be instantiated. e.g. AbstractMap 
    * A Java Interface type declares methods but does not provide their implementations. e.g. Comparable, Map<K,V>, List<T>
    * Abstract class differs from interface in an important way - they can have instance variable, and they have concrete methods and constructors
    * A class can implement multiple interfaces, while only extend one abstract class
    * All classes in an interface should be public (since they’re all abstract methods); while in an abstract class, you can have different access control to the methods
  * Method Overloading Vs Override
    * Method overriding is a run-time phenomenon that is the driving force behind polymorphism. Implement the inherited method in a different way
      * same signature as the inherited method
      * happens at run time
    * Method overloading is a compile-time phenomenon. There’re two or more methods in the class that has the same method name but different parameters
      * Conditions for method overloading:
        * number of parameters are different in two methods
        * parameter type are different
      * Unqualified for method overloading:
        * change return type
        * change parameter name
      * Overloading happens at compile time, compiler determines whether a given method is correctly overloaded, if not, error

* Private Constructor
  * use cases: Singleton pattern, enum

* TryCatchFinally
  * The finally block always executes when the try block exits.
  * the finally block is a key tool for preventing resource leaks
  * Case that finally will execute:
     * an unexpected exception occurs.  
     * return, continue, or break in try and catch, finally code will execute before return
  * Case that finally will not execute:
     * if the JVM exits while the try or catch code is being executed
     * the thread executing the try or catch code is interrupted or killed
     * forever loop in try or catch

* Java has 8 primitive data types
    * type                                             | default value
    * byte: 2^8                                            | 0 
    * short: 2^16                                          | 0 
    * int:2^32                                             | 0    
    * long: 2^64                                           | 0L
    * float: single-precision 32bit floating point;        | 0.0f
    * double: double-precision 64bit floating point;       | 0.0d
    * boolean:                                             | false
    * char: 16-bit unicode, from \u0000 to \uffff (0-65535)| \u0000

* 'Static' Keyword
    * static method or static instance variable is owned by the class, instead of a specific instance. In other words, static members are shared by all instances.
    * static method cannot be overriden (if you create a method with the same return type and signature, that's called method hiding)
    * static members cannot be accessed by a non-static context
    * Static class, used in nested class, have no reference to instance of the outer class. One use case is if a nested class is used in static method in the outer class, you have to declare the nested class as static

* Interface: 
  * an interface  is similar to a class, but there are several differences
  * all methods in an interface are **abstract**; that is , they have a name, parameters ,and a return type, but they don’t have an implementation.
  * all methods in an interface type are automatically **public**
  * all interface type does not have instance variables, but can have constants (public static final) (why? because instance variable is part of the implementation)
  * use the implements reserved word to indicate that a class implements an interface type.
  * an interface can be implemented by a class or be extended by another interface
  * interface is not part of the class hierarchy, although they work in combination with classes. It provides common features
  * rewrite an interface will cause classes implementing the old interface to break because they don’t implement it anymore. (a class that implements an interface must implement all the methods declared in the interface)



* Nested Class
  * Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are called **static nested classes**. Non-static nested classes are called **inner classes**.

  <pre><code> class OuterClass {
      ...
      static class StaticNestedClass {
          ...
      }
      class InnerClass {
          ...
      }
  }</code></pre>

  * Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private. Static nested classes do not have access to other members of the enclosing class.
  * Compelling reasons for using nested classes include the following:
    * It is a way of logically grouping classes that are only used in one place: If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes their package more streamlined.
    * It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private. By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.
    * It can lead to more readable and maintainable code: Nesting small classes within top-level classes places the code closer to where it is used.
  * when the OuterClass is compiled, two separate files will be generated:
    * OuterClass.class
    * OuterClass$InnerClass.class
  * How to create an inner class object from outside the outer class code
    * OuterClass.InnerClass inner = outClass.new InnerClass();

* Garbage Collector
  * Mark and Sweep algorithm
    * look up the heap memory
    * identify unused objects and delete them
    * unused objects are defined as unreferenced objects (there’s no part in the program that holds a pointer to that object)
  * Reference counting
  * Stop the execution of program while GC
  * Calls finalize() method in an object before the obejct is finally destroyed
  * Can select different GC



* Data Structure
  * Collection, the root interface in the collection hierarchy
    * issues: duplicates, order, synchronize
    * extends Iterable<E>
  * List, is an interface
    * an ordered collection
    * extends Collections<E>
  * Set, a collection that contains no duplicates
    * contain at most one null element
    * extends Collection<E>
  * Vector, a growable array of objects
    * extends AbstractList<E>, implements List<E>, RandomAccess, Cloneable
    * iterator, fail-fast, will throw ConcurrentModificationException if the vector is structurally modified at any time after the iterator is created
    * Synchronized
    * When the array is full, it has to resize to support insertion operation. Thus, the worst case for insertion is O(n)
  * Stack, a class
    * extends Vector<E>
  * Queue, an interface
    * extends Collection<E>
  * LinkedList
    * extends AbstractSequentialList<E>, implements List<E>, Deque<E>, Cloneable
    * permits null
    * can be used as a stack, queue, or double-ended queue
    * Unsynchronized, use Collections.synchronizedList(new LinkedList()), which add mutex to each method (synchronzied(lock);)
  * ArrayList
    * extends AbstractList<E>, implements List<E>, RandomAccess, Cloneable
    * Resizable-array implementation of the List interface.
    * permits null
    * roughly equivalent to Vector, except that it's unsynchronized

* Generics
  * added in J2SE 5.0
  * Adds complie-time type safety (each collection can only have one type of parameter) to the Collections Framework, and eliminates the drudgery of casting. (Compile-time error is easy to detect than run-time error)
  * In the following case, line 2 will fire a complie error. In general, if Foo is a subtype (subclass or subinterface) of Bar, and G is some generic type declaration, it is not the case that G<Foo> is a subtype of G<Bar>. This is probably the hardest thing you need to learn about generics, because it goes against our deeply held intuitions.
  <pre><code>List<String> ls = new ArrayList<String>(); // 1
    List<Object> lo = ls; // 2 
  </code></pre>
  * So what is the supertype of all kinds of collections? It's written Collection<?> (pronounced "collection of unknown"), that is, a collection whose element type matches anything. It's called a **wildcard type**
  * List<? extends Shape> is an example of a **bounded wildcard**. drawAll() will accept lists of any subclass of Shape.
  <pre><code>public void drawAll(List<? extends Shape> shapes) {
    ...
  }
  </code></pre>
  That price to be paid for the flexibility of using wildcards is that it is now illegal to write into shapes in the body of the method. For instance, this is not allowed:
  <pre><code>public void addRectangle(List<? extends Shape> shapes) {
      shapes.add(0, new Rectangle()); // Compile-time error!
  }
  </code></pre>

* instanceof
  * the type comparison operator
  * (obj1 instanceof Parent)
  * for the following code, no error, the output is *Cat Kitty*
  <pre><code>public void testArrayListOfDifferentSubtypes() {
        ArrayList<Animal> an = new ArrayList<Animal>();
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Wangwang");
        an.add(cat);
        an.add(dog);
        for (Animal a : an){
           if (a instanceof Cat)
              System.out.println(a.print());
        }
   }
   abstract class Animal {
        protected String name;

        public String print() {
           return name;
        }
   }
   class Cat extends Animal {
        public Cat(String str) {
           name = "Cat " + str;
        }
   }
   class Dog extends Animal {
        public Dog(String str) {
           name = "Dog " + str;
        }
   }   
  </pre></code>

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

##OO Design
* Use MVC framework to help quickly setup elementary classes
* Note the usage of enum (how to initialize the enum with initial value)

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

##Analyze Running Time -- (from CLRS)
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

##Data Structure -- (from CLRS)
* Dynamic Set
  * Dictionary: a dynamic set that supports insertion, deletion and lookup (test membership in a set)
  * Ordering Set: supports operations like getMin(), getMax(), getPrev(), getNext()
* Stack
  * implementation
    * Array, push(), pop(), peek(), empty(), average O(1) if don't consider overflow
    * LinkedList, push(), pop(), peek(), empty(), all O(1)
* Queue
  * implementation
    * Array, one circular array, two pointers (head/tail)
    * LinkedList, two pointers (head/tail)
* LinkedList
  * when cascade multiple pointers, rememebr to check null. e.g. node.next.next, should check if (node.next==null) in advance
  * Sentinel, a dummy object that allows us to simplify boundary conditions
    * make the code clean, should be used judiciously when the list is small (memory cost)
  * [XOR LinkedList](http://en.wikipedia.org/wiki/XOR_linked_list)
* Binary Search Tree 
  * Query operations: search(), getMin(), getMax(), getPredecessor(), getSuccessor(), worst case O(h) (h is the height of the tree). In a balanced bst, worst case is O(lgn) (n is the number of nodes)
  * Modification operation
    * insertion, O(lgn), pretty trivial
    * deletion, O(lgn), 3 cases
      * has no child
      * has one child
      * has two children
* [Red Black Tree](http://www.geeksforgeeks.org/red-black-tree-set-1-introduction-2/)
  * a self-balancing binary search tree with one extra bit of storage per node: color (either RED or BLACK)
* [AVL tree](http://www.geeksforgeeks.org/avl-tree-set-1-insertion/)
  * a self-balancing binary search tree
  * the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one, rebalancing is done by **tree rotations**(constant time)
  * running time of all basic bst operations are O(lgn)
  * The AVL trees are more balanced compared to Red Black Trees, but they may cause more rotations during insertion and deletion. So if your application involves many frequent insertions and deletions, then Red Black trees should be preferred. And if the insertions and deletions are less frequent and search is more frequent operation, then AVL tree should be preferred over Red Black Tree.
















