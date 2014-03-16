package ch10_scalability_memorylimits;

public class ch10_1_QueryDataOnServer {
   /*
    * Imagine you are building some sort of service that will be called by up to 1000 client
    * applications to get simple end-of-day stock price information (open, close, high, low). You
    * may assume that you already have the data, and you can store it in any format you wish. How
    * would you design the client-facing service which provides the information to client
    * application? You are responsible for the development, rollout, and ongoing monitoring and
    * maintenance of the feed. Describe the different methods you considered and why you would
    * recommend your approach. Your service can use any technologies you wish, and can distribute
    * the information to the client applications in any mechanism you choose.
    */

   // SOL1:
   // provide database access to the clients
   // PRO: easy to setup and integrate
   // DIS: security issue caused by client-access; client may get access to some data they
   // shouldn't access; server overhead

   // SOL2:
   // use JSON/XML file to transfer data to clients
   // PRO: readable for both human and machines; easy to scale(we can add more elements to the
   // existing files); easy for client-side backup; restrict client access to specific data
}
