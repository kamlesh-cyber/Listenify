package listenify;

import java.util.*;

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

        play(playList1);

    }

    public static void play(LinkedList<Song> playList){

        ListIterator<Song> listIterator = playList.listIterator();

        Scanner sc = new Scanner(System.in);

        //validation check
        if(playList.size() == 0){
            return;
        }

        printMenu();
        //automaticly run first song
        System.out.println("Now Playing " + listIterator.next());

        boolean forward = true;
        boolean quit = false;


        while (!quit){
            int choice = sc.nextInt();

            switch (choice){

                case 0:
                    quit = true;
                    break;
                case 1:
                    if(forward==false){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }else{
                        System.out.println("You are the last song");
                    }
                    //to play next song
                    break;
                case 2:
                    if(forward==true){ // already towards right of the last printed value
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }
                    else{
                        System.out.println("You are already at first song.");
                    }
                    //to play previous song
                    break;
                case 3:
                    //to replay the current song
                    if(forward == true){ //Im on the RHS, so I'll print previous
                        System.out.println(listIterator.previous().toString());
                        forward=false;
                    }
                    else{ // forward is false so i'm on lhS

                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    break;
                case 4:
                    printAllSongs(playList);
                case 5:
                    printMenu();
                    break;
                case 6:

                    while(playList.size()>0){
                        System.out.println(listIterator.previous().toString() + " Has been removed ");
                        listIterator.remove();

                        if(playList.size() >=0 && listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else if (playList.size() >=0 && listIterator.hasNext()){
                            System.out.println("Now Playing " + listIterator.next().toString());
                        }
                        else{
                            System.out.println("PlayList is Empty. ");
                            //break;
                        }
                        break;

                    }
                    break;
            }

        }

    }

    public static void printAllSongs(LinkedList<Song> songsList){

        ListIterator<Song> listIterator = songsList.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }

    public static void printMenu(){
        System.out.println("Available options \n press ");
        System.out.println(
                "0 - to quit\n " +
                "1 - to play next song \n" +
                "2 - to play previous song \n" +
                "3 - to replay current song \n" +
                "4 - list of all songs \n" +
                "5 - print all available option \n" +
                "6 - delete current song \n");

    }
}