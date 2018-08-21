package hello.models;

public class Song {
    private String songName;
    private Artist artist;
    private String songAlbum;
    private Long songLength;
    private Long timesPlayed;
    private Long popularity;

//    public Song(String songName, String songAlbum, String songLength) {
//        this.songName = songName;
//        this.artist = null;
//        this.songAlbum = songAlbum;
//        this.songLength = songLength;
//        this.timesPlayed = 0;
//        this.popularity = 0;
//    }

    public String getSongName() {
        return songName;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getSongAlbum() {
        return songAlbum;
    }



    public void setArtist(Artist artist) {
        this.artist = null;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public Long getSongLength() {
        return songLength;
    }

    public void setSongLength(Long songLength) {
        this.songLength = songLength;
    }

    public Long getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(Long timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }

    public void giveArtist(Artist artist){
        this.artist=artist;
    }
}
