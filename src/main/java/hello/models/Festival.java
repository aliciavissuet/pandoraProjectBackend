package hello.models;

import java.util.ArrayList;

public class Festival {
    private String festivalName;
    private String festivalLocation;
    private String festivalDate;
    private Host host;
    private ArrayList<Artist> artistsPlaying = new ArrayList<>();
    private ArrayList<Song> festivalPlayList = new ArrayList<>();



    public String getFestivalName() {
        return festivalName;
    }

    public String getFestivalLocation() {
        return festivalLocation;
    }

    public String getFestivalDate() {
        return festivalDate;
    }

    public ArrayList <Artist> getArtistsPlaying() {
        return artistsPlaying;
    }

    public ArrayList <Song> getFestivalPlayList() {
        return festivalPlayList;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public void setFestivalLocation(String festivalLocation) {
        this.festivalLocation = festivalLocation;
    }

    public void setFestivalDate(String festivalDate) {
        this.festivalDate = festivalDate;
    }

    public void setArtistsPlaying(ArrayList<Artist> artistsPlaying) {
        this.artistsPlaying = new ArrayList<Artist>();
    }

    public void setFestivalPlayList(ArrayList<Song> festivalPlayList) {
        this.festivalPlayList = new ArrayList<Song>();
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = null;
    }
    public void changeHost (Host host){
        this.host=host;
    }

    public boolean addArtist(Artist artist){
        if (findArtist(artist.getName())>=0){
            System.out.println("Artist is already on the list to play.");
            return false;
        } else{
            artistsPlaying.add(artist);
            System.out.println(artist.getName()+" is now scheduled to play at "+getFestivalName());
            return true;
        }
    }

    private int findArtist(Artist artist) {
        return this.artistsPlaying.indexOf(artist);
    }


    private int findArtist(String artistName) {
        for (int i=0; i<artistsPlaying.size(); i++){
            Artist artist = artistsPlaying.get(i);
            if (artist.getName().equals(artistName)){
                return i;
            }
        }return -1;
    }

    public boolean removeArtist(Artist artist){
        if (findArtist(artist)<0){
            System.out.println("Artist could not be removed from festival lineup. Artist was not found in list.");
            return false;
        }
        System.out.println(artist.getName()+" removed from festival lineup");
        artistsPlaying.remove(artist);
        return true;
    }

    public void printArtists(){
        for(int i=0; i<artistsPlaying.size(); i++){
            System.out.println(artistsPlaying.get(i).getName());
        }
    }

    public void addSong(Song song){
        festivalPlayList.add(song);
    }




    @Override
    public String toString() {
        return
                "Festival Name=: " + festivalName + '\'' +
                ", Festival Location: '" + festivalLocation + '\'' +
                ", Festival Date: " + festivalDate + '\'';
    }

    public void removeSong(Song song){
        festivalPlayList.remove(song);
    }

    public String [] festivalInfo() {
        String [] newString= {festivalName, festivalLocation, festivalDate};
        return newString;
    }

    public void addNewArtist(Artist artist){
        artistsPlaying.add(artist);
    }


}
