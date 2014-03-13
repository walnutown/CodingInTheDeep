package ch8_ood;

import java.util.List;
import java.util.Map;

public class ch8_3_JukeBox {
   /*
    * Design a musical jukebox using object-oriented principles
    * Assume that the jukebox is a computer simulation that closely mirrors physically jukeboxes,
    * and we'll assume that it's free.
    */

   // Models: Song; Controller: AudioPlayer; View: a screen to display what's playing
   public class JukeBox {
      private AudioPlayer player;
      private List<Song> songCollections;

   }

   enum PlayMode {
      SINGLE, SHUFFLE, ORDER
   }

   public class AudioPlayer {
      private PlayMode mode;
      private Map<Integer, Song> playlist;
      private int currentSongId;

      public AudioPlayer(List<Song> songs) {
         initList(songs);
         currentSongId = songs.get(0).getId();
         mode = PlayMode.ORDER;
      }

      public void addSong() {

      }

      public void removeSong() {

      }

      public void play() {
      }

      public void play(int songId) {
         currentSongId = songId;
      }

      public Song getNextSong() {
         Song nextSong = null;
         switch (mode) {
         case ORDER:
            break;
         case SHUFFLE:
            break;
         case SINGLE:
            break;
         default:
            break;
         }
         return nextSong;
      }

      public Song getCurrentSong() {
         return playlist.get(currentSongId);
      }

      public void initList(List<Song> src) {

      }
   }

   public class Song {
      int id;
      String name;
      String genre;
      String artist;

      // ....

      public int getId() {
         return id;
      }
   }
}
