import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public boolean addSongToAlbum(Song newSong) {

        if (!songs.contains(newSong)) {
            songs.add(newSong);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
