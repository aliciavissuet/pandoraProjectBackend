package hello.mock.repository;

import hello.models.Artist;

import java.util.ArrayList;



public class Artists {
    private static ArrayList<Artist> artists;


    public Artists() {
        this.artists = new ArrayList<>();
    }

    public String addArtist(Artist artist){
        artists.add(artist);
        return "artist added successfully.";
    }

    public  ArrayList<Artist> getArtists() {
        return artists;
    }

//
//
//    @Override
//    public String toString() {
//        ArrayList<String> artistNames = new ArrayList<String>();
//        for(Artist artist:artists){
//            artistNames.add(artist.getName());
//        }
//
//        return artistNames.toString();
//    }
//
//    public String removeArtist(String artistName){
//        for(Artist artist: artists){
//            if(artist.getName().equals(artistName)){
//                artists.remove(artist);
//                return "artist removed successfully";
//            }
//        }
//        return "artist name not found";
//    }

}
