import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ListIterator;

public class MusicPlayer{


    private ArrayList<Album> catalogue;
    private LinkedList<Song> playlist;

    public MusicPlayer() {
        this.catalogue = new ArrayList<>();
        catalogue.add(new Album(""));
        this.playlist = new LinkedList<>();
    }

    public boolean loadSongToCatalogue(String albumName, String songName, String duration) {

        Song song = new Song(songName, duration);

        for (Album element : catalogue)
            if (element.getName().toLowerCase().equals(albumName.toLowerCase()))
                return element.addSongToAlbum(song);

        return loadAlbumToCatalogue(albumName, song);
    }

    private boolean loadAlbumToCatalogue(String albumName, Song song) {
        Album newAlbum = new Album(albumName);
        newAlbum.addSongToAlbum(song);
        return catalogue.add(newAlbum);
    }


    private void printMenu() {

        System.out.println("Demo Music Player Menu");
        System.out.println("----------------------");

        System.out.println("Press:" +
                "\n\t0. to exit" +
                "\n\t1. to add song" +
                "\n\t2. to play song" +
                "\n\t3. to play next song" +
                "\n\t4. to play previous song" +
                "\n\t5. to repeat same song" +
                "\n\t6. to remove song" +
                "\n\t7. to show playlist");

    }


    public void playerFunctions() {
        ListIterator<Song> playListIterator = playlist.listIterator();
        boolean flag = true;
        boolean isPlaying = false;
        int option = -1;
        int index;
        do {
            printMenu();
            try {
                option = Input.enterOption(Input.optionList);
            } catch (InputMismatchException ignored) {
            }

            switch (option) {

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);

                case 1:
                    String songName = Input.enterName();

                    index = playListIterator.nextIndex();
                    playListIterator = addSongToPlaylist(songName);
                    if (isPlaying)
                        playListIterator = playlist.listIterator(index);
                    break;

                case 2:
                    if (!playlist.isEmpty()) {
                        showPlaylist();
                        playListIterator = playSong();
                        flag = true;
                        isPlaying = true;
                    } else
                        System.out.println("Playlist is empty.");
                    break;

                case 3:
                    if (!playlist.isEmpty()) {
                        if (isPlaying)
                            flag = playNext(playListIterator, flag);
                        else
                            System.out.println("No song is currently playing.");
                    } else
                        System.out.println("Playlist is empty.");
                    break;

                case 4:
                    if (!playlist.isEmpty()) {
                        if (isPlaying)
                            flag = playPrevious(playListIterator, flag);
                        else
                            System.out.println("No song is currently playing.");
                    } else
                        System.out.println("Playlist is empty.");
                    break;

                case 5:
                    if (!playlist.isEmpty())
                        if (isPlaying)
                            flag = repeatSong(playListIterator, flag);
                        else
                            System.out.println("No song is currently playing.");
                    else
                        System.out.println("Playlist is empty.");
                    break;

                case 6:
                    if (!playlist.isEmpty()) {
                        showPlaylist();

                        index = playListIterator.nextIndex();
                        playListIterator = removeSongFromPlaylist();

                        if (isPlaying) {
                            if (index - 1 == playListIterator.nextIndex())
                                isPlaying = false;

                            if (playListIterator.nextIndex() >= index)
                                playListIterator = playlist.listIterator(index);
                            else if (playListIterator.nextIndex() < index)
                                playListIterator = playlist.listIterator(index - 1);

                        }

                    } else
                        System.out.println("Playlist is empty.");
                    break;

                case 7:
                    showPlaylist();
                    break;

                default:
                    Input.scanner.nextLine();
                    Input.notValidMessage();
            }

            System.out.println(playListIterator.nextIndex());
            Input.continueMessage();

        } while (true);
    }

    private ListIterator<Song> addSongToPlaylist(String songName) {

        boolean flag = false;

        for (Album element : catalogue) {
            if (!element.getName().toLowerCase().equals("")) {
                ArrayList<Song> songs = element.getSongs();
                for (Song song : songs)
                    if (song.getTitle().toLowerCase().equals(songName)) {
                        playlist.add(song);
                        System.out.println("Adding song: " + songName + " Album: " + getAlbumName(songName));
                        flag = true;
                    }
            }
        }
        boolean noAlbum = catalogue.get(0).getSongs().contains(new Song(songName, "0"));
        if (!flag && !noAlbum)
            System.out.println("Song not in catalogue.");
        else if (noAlbum)
            System.out.println("Cannot add song without album.");

        return playlist.listIterator(playlist.size());
    }

    private ListIterator<Song> playSong() {

        int index = Input.enterIndex();
        String songName = playlist.get(index - 1).getTitle();
        System.out.println("Now playing: " + songName + " Album: " + getAlbumName(songName));
        return playlist.listIterator(index);
    }

    private String getAlbumName(String songName) {

        for (Album album : catalogue)
            for (Song song : album.getSongs())
                if (song.getTitle().toLowerCase().equals(songName))
                    return album.getName();
        return "";
    }


    private boolean playNext(ListIterator<Song> playListIterator, boolean flag) {


        if (!flag && playListIterator.hasNext())
            playListIterator.next();

        if (playListIterator.hasNext()) {
            String songName = playListIterator.next().getTitle();
            System.out.println("Now playing: " + songName + " Album: " + getAlbumName(songName));
        } else {
            System.out.println("End of playlist.");
        }
        return true;
    }

    private boolean playPrevious(ListIterator<Song> playListIterator, boolean flag) {


        if (flag && playListIterator.hasPrevious())
            playListIterator.previous();

        if (playListIterator.hasPrevious()) {
            String songName = playListIterator.previous().getTitle();
            System.out.println("Now playing: " + songName + " Album: " + getAlbumName(songName));
        } else
            System.out.println("Start of playlist.");
        return false;
    }

    private boolean repeatSong(ListIterator<Song> playListIterator, boolean flag) {

        Song song = new Song("", "");
        if (flag && playListIterator.hasPrevious()) {
            song = playListIterator.previous();
            flag = false;
        } else if (!flag && playListIterator.hasNext()) {
            song = playListIterator.next();
            flag = true;
        }

        String songName = song.getTitle();
        System.out.println("Now playing: " + songName + " Album: " + getAlbumName(songName));
        return flag;
    }

    private ListIterator<Song> removeSongFromPlaylist() {

        int index;

        do {
            index = Input.enterIndex();
        } while (playlist.size() < index || index <= 0);

        String songName = playlist.get(index - 1).getTitle();
        System.out.println("Removing song: " + songName + " Album: " + getAlbumName(songName));
        playlist.remove(index - 1);
        return playlist.listIterator(index - 1);
    }

    private void showPlaylist() {

        int i = 0;
        System.out.println("Playlist");
        System.out.println("--------");
        for (Song song : playlist) {
            String songName = song.getTitle();
            System.out.println("Song " + ++i + ". " + songName + " Album: " + getAlbumName(songName));
        }
        System.out.println("Playlist has " + i + " songs queued.");
    }


}
