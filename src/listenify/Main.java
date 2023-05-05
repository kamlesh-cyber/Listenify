package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {





        Album album = new Album("Old Hindi Songs","Arijit Singh");

        album.addSongToAlbum("Pachtaoge",4.5);
        album.addSongToAlbum("Mere Dholna Sun", 8.0);
        album.addSongToAlbum("Kesariya", 3.8);
        album.addSongToAlbum("Chunar", 2.7);

        albums.add(album);

        Album album2 = new Album("Hollywood Song", "Billie Elise");

        album2.addSongToAlbum("burry a friend",3.8);
        album2.addSongToAlbum("Bad guy", 3.0);
        album2.addSongToAlbum("I'm not your friend", 4.9);
        album2.addSongToAlbum("bellyache", 2.7);

        albums.add(album2);

        LinkedList<Song> playList1 =  new LinkedList<>();

        albums.get(0).addSongToPlaylist("Pachtaoge",playList1);
        albums.get(0).addSongToPlaylist("Chunar", playList1);
        albums.get(1).addSongToPlaylist("Bad guy", playList1);
        albums.get(1).addSongToPlaylist("Bellyache", playList1);



    }
}