public class Main {

    public static void main(String[] args) {

        MusicPlayer musicPlayer = new MusicPlayer();


        musicPlayer.loadSongToCatalogue("", "surfer", "4:30");
        musicPlayer.loadSongToCatalogue("", "rider", "5:30");
        musicPlayer.loadSongToCatalogue("", "walker", "2:30");

        musicPlayer.loadSongToCatalogue("soul", "flyer", "4:30");
        musicPlayer.loadSongToCatalogue("soul", "driver", "5:30");
        musicPlayer.loadSongToCatalogue("sole", "swimmer", "2:30");
        musicPlayer.loadSongToCatalogue("soul", "runner", "4:30");


        musicPlayer.playerFunctions();
    }


}
