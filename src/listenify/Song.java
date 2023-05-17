package listenify;

public class Song {
    public String songTitle;
    public double duration;

    public Song(String songTitle, double duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    //toString is inbuilt fun in java to print obj in nice (clear) way ..
    @Override
    public String toString() {
        return "Printing Song{" +
                "songTitle='" + songTitle + '\'' +
                ", duration=" + duration +
                '}';
    }
}
