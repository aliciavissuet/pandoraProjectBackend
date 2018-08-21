package hello.models;

import java.util.ArrayList;

public class Artist {
    private String name;
    private ArrayList<Festival> festivalsPlayingAt = new ArrayList<>();
    private ArrayList<Song> songsByArtist = new ArrayList<>();

    public Artist(String name) {
        this.name = name;
    }

    //    public Artist(String name) {
//        this.name = name;
//        this.festivalsPlayingAt = new ArrayList <Festival>();
//        this.songsByArtist = new ArrayList <Song>();
//
//    }

    public String getName() {
        return name;
    }

    public ArrayList <Festival> getFestivalsPlayingAt() {
        return this.festivalsPlayingAt;

    }

    public ArrayList <Song> getSongsByArtist() {
        return this.songsByArtist;
    }


    public int findFestival(Festival festival) {
        return this.festivalsPlayingAt.indexOf(festival);
    }


    public int findFestival(String festivalName) {
        for (int i=0; i<this.festivalsPlayingAt.size(); i++){
            Festival festival = this.festivalsPlayingAt.get(i);
            if (festival.getFestivalName().equals(festivalName)){
                return i;
            }
        }return -1;
    }


    public boolean addFestival(Festival festival) {
        if (findFestival(festival.getFestivalName())>=0){
            System.out.println("Festival is already in list.");
            return false;
        } festivalsPlayingAt.add(festival);
        System.out.println(festival.getFestivalName()+" was added to "+getName()+"'s concert schedule.");
        return true;
    }

    public boolean removeFestival(Festival festival){
        if (findFestival(festival)<0){
            System.out.println("Festival could not be removed. Festival was not found in list.");
            return false;
        }
        System.out.println(festival.getFestivalName()+" removed from your festival list");
        festivalsPlayingAt.remove(festival);
        return true;
    }

    public void addSong(Song newSong){
//        if(songsByArtist.contains(newSong)){
//            return false;
//        }
        this.songsByArtist.add(newSong);
//        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFestivalsPlayingAt(ArrayList<Festival> festivalsPlayingAt) {
        this.festivalsPlayingAt = new ArrayList<Festival>();
    }

    public void setSongsByArtist(ArrayList<Song> songsByArtist) {
        this.songsByArtist = new ArrayList<Song>();
    }


}

