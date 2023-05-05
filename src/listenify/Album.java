package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList; //songs object will be stored here eg. Song pathan = new Song();...pathan will be stored in list

    //Initialized the songList
    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String songTitle){
        //iterate over the arraylist and
        //match the given songTitle

        for(Song song : songList){
            if((song.songTitle).equals(songTitle)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String songTitle, double duration){
        //check if song is already present we will not add
        //else we will create new song obj and add it to SongList;

        if(findSongInAlbum(songTitle) == true){
            return " Song is already present.";
        }
        else{
            //I need to create song object and add it to songList
            Song newSong = new Song(songTitle, duration);
            songList.add(newSong);
            return "New Song has been added successfully." ;
        }
    }

    public String addSongToPlaylist(int trackNo, LinkedList<Song> playList){
        //TrackNo is a song number in songList
        //TrackNo : 1,2,3,4,5....
        //Indices : 0,1,2,3,4....
        int index = trackNo - 1;

        //checking for validity of index
        if(index>=0 && index < playList.size()){

            Song song = this.songList.get(index);
            playList.add(song);
            return "Song added to the playList." ;
        }
        return "Invalid track number.";
    }

    public String addSongToPlaylist(String songTitle,LinkedList<Song> playList){
        // I need to find out that song with title
        // and put it in the playlist

        //Iterate :
        for(Song song : songList){
            if(song.songTitle.equals(songTitle)){
                playList.add(song);
                return " Song has been added Successfully.";
            }
        }
         return  "Song doesn't exist.";
    }
}
