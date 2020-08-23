public class Song {

    private String title;
    private String duration;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }


    public String getTitle() {
        return title;
    }

    public boolean equals(Object o){

        if(!(o instanceof  Song))
            return false;
        else{
            Song songObject = (Song) o;
            return title.toLowerCase().equals(songObject.title.toLowerCase());
        }
    }
}
