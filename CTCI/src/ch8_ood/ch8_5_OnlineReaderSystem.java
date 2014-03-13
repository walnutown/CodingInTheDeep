package ch8_ood;

import java.util.List;

public class ch8_5_OnlineReaderSystem {
   /*
    * Design the data structure for an online book reader system
    */

   // Models: Book, User; Controller, UserManager, BookManager; View, display the UI
   public class OnlineReaderSystem {
      private UserManager mUserManager;
      private BookManager mBookManager;
      private ReadingView mReadingView;
   }

   public class UserManager {
      private List<User> users;
      
      public void registerUser(){
         
      }
      
      public void loginUser(){
         
      }
   }

   public class BookManager {
      private List<Book> books;

      // findBookByAuthor/findBookByData and other searches
      public Book findBookByName(String name) {
         Book b = null;
         return b;
      }
      
      public void add(){
         
      }
   }
   
   public class ReadingView{
      private User user;
      private Book book;
   }

   public class User {

   }

   public class Book {

   }
}
