package ch10_scalability_memorylimits;

public class ch10_5_WebCrawling {
   /*
    * If you were designing a web crawler, how would you avoid getting into infinite loops?
    */

   // <1> if we picture the web as a graph of links, the process of crawling is to do BFS. An
   // infinite
   // loop will occur when a cycle occurs.
   // <2> to avoid cycle, we need to mark the visited nodes. The problem is to choose the identifier
   // of one page. If we use URL, same domain with different parameters may be considered as
   // different pages, but they actually point to the same page; if we use page content, what if
   // there's
   // dynamic content on the page?
   // <3> to create the identifier by combining URL and page content
   // <4> the crawling process:
   // [1] we have a database to store a list of items which we need to crawl. On each iteration, we
   // select the highest priority page to crawl
   // [2] open up the page and create a signature of the page base on specific subsections of the
   // page and its URL
   // [3] query the database to see whether anything with this signature has been crawled recently.
   // [4] If something with this signature has been crawled, insert this page back into the database
   // at a low priority; otherwise, crawl the page and insert its links into the database

}
