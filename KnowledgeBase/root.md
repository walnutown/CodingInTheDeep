Knowledge Base for Concepts related questions in coding interview
===============
##Java
[notes](https://docs.google.com/document/d/1msRFUdvg1z6iNmHqUUI_KVXEWLtODc2JaZH6w2o7o9k/edit?usp=sharing)

##Distributed System & Big Data

[Nootcod3r: Count Occurences](http://n00tc0d3r.blogspot.com/2013/07/big-data-count-occurrences.html)<br>
Given a large number (millons or billons) of records (integers, IPs, URLs, query key words, etc.),
* find out top k most frequent records;
* find out duplicates;
* find out whether a given number x is in the set or not.




##Design Patterns
[oodesign.com](http://www.oodesign.com/)<br>
[Examples of GoF Design Patterns](http://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns/2707195#2707195) <br>
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
  
* Observer: listener
* Decorator: BufferedReader
