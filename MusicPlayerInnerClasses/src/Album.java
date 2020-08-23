import java.util.ArrayList;

public class Album {

    private String name;
    private SongList songs;

    public Album(String name) {
        this.name = name;
        this.songs = new SongList();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs.getSongs();
    }
    public boolean addSongToAlbum(Song newSong){
        return songs.addSongToAlbum(newSong);
    }


    private class SongList {

        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean addSongToAlbum(Song newSong) {

            if (!this.songs.contains(newSong)) {
                this.songs.add(newSong);
                return true;
            }
            return false;
        }

        private ArrayList<Song> getSongs() {
            return this.songs;
        }


    }


}
