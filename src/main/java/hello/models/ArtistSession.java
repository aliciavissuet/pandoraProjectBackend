package hello.models;

public class ArtistSession{
    private Artist artist;
    private String sessionStart;
    private String sessionEnd;



    public ArtistSession(Artist artist, String sessionStart, String sessionEnd) {
        this.artist = artist;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;

    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(String sessionStart) {
        this.sessionStart = sessionStart;
    }

    public String getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(String sessionEnd) {
        this.sessionEnd = sessionEnd;
    }


    public ArtistSession newArtistSession(Artist artist, String start, String end){
        return new ArtistSession(artist, start, end);
    }

    @Override
    public String toString() {
        return "ArtistSession{" +
                "artist=" + artist.getName() +
                ", sessionStart='" + sessionStart + '\'' +
                ", sessionEnd='" + sessionEnd + '\'' +
                '}';
    }
}