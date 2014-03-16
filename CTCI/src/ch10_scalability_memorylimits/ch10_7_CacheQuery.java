package ch10_scalability_memorylimits;

public class ch10_7_CacheQuery {
   /**
    * Imagine a web server for a simplified search engine. This system has 100 machines to respond
    * to search queries, which may then call out using processSeaerch (String Query) to another
    * cluster of machines to actually get the result. The machine which responds to a given query is
    * chosen at random, so you can not guarantee that the same machine will always respond to the
    * same request. The method processSearch is very expensive. Design a caching mechanism to cache
    * the results of the most recent queries. Be sure to explain how you would update the cache when
    * data changes.
    */

   // ASSUMPTION:
   // the result for a given query is an ordered list of URLs, each of which has an associated 50
   // characters title and 200 character summary

   // SOL
   // <1> Single machine implementation is a LRUCache

   // <2> Multiple machine implementation
   /*
    * -- to what extent the cache is shared across machines?
    * [1] Each machine has its own cache:
    * PRO: quick;
    * DIS: as query is sent to machine randomly, a high-frequency query may be in cache of machine A
    * or B, but it's sent to machine C, in this case, it's regarded as a fresh query and need an
    * expensive processSearch
    * [2] Each machine has a copy of the cache
    * PRO: avoid the DIS of [1]
    * DIS: sync the cache among different machines is expensive
    * [3] Each machine stores a segment of the cache
    * when machine i needs to look up the results for a query, it would find the machine j of the
    * query using hash (query)%N. Machine j would return the value from its cache or call
    * processSearch(query) to get the results
    */
   /*
    * -- to update the content of queries in the cache
    * set a timeout value for each query. when the query is timeout, remove it from the cache. In
    * this case, each query can be refreshed periodically
    */

   // OPTIMIZATION
   // <1> to the cache solution [3], we can store super-high-frequency queries in cache of multiple
   // machines. That is, when machine i get the result from machine j, it stores the result in its
   // own cache.
   // <2> set different timeout value for queries in the cache. Because some queries should be
   // refreshed more frequently, like news query

}
