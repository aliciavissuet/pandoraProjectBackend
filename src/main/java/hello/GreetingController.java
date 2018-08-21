package hello;

import hello.mock.repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import hello.mock.repository.Hosts;
import hello.models.*;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GreetingController {


    private Users users = new Users();
    private Hosts hosts = new Hosts();
    private Artists artists = new Artists();
    private Festivals festivals = new Festivals();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/user/addFestival")
    public ResponseArrayList addUserFest(@RequestParam(value = "name") String userName,
                                @RequestParam(value = "festivalName") String festivalName) {
        ArrayList<String> festivalNames = new ArrayList<>();
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(userName)) {
                for (Festival festival : festivals.getFestivals()) {
                    if (festival.getFestivalName().equals(festivalName)) {
                        user.addFestival(festival);
                    }
                }
            }
            for (Festival festival2 : user.getFestivalsInterestedIn()) {
                festivalNames.add(festival2.getFestivalName());
            }

        }
        return new ResponseArrayList(0, festivalNames);
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@RequestBody(required = true) User user) {
        users.addUser(user);
        return "Successfully created user";
    }

    @RequestMapping("/users/get")
    public String getUser() {
        ArrayList<String> userNames = new ArrayList<String>();
        for (User user : users.getUsers()) {
            userNames.add(user.getEmail());
        }
        return userNames.toString();

    }

    @RequestMapping(value = "/user/check", method = RequestMethod.GET)
    public Greeting checkUser(@RequestParam(required = true) String name) {
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(name)) {
                return new Greeting(0, "true");
            }
        }
        return new Greeting(0, "false");
    }

    @RequestMapping(value = "/host/check", method = RequestMethod.GET)
    public Greeting checkArt(@RequestParam(required = true) String name) {
        for (Host host : hosts.getHosts()) {
            if (host.getName().equals(name)) {

                return new Greeting(0, "true");
            }
        }
        return new Greeting(0, "false");
    }

    @RequestMapping(value = "/host/add", method = RequestMethod.POST)
    public String addArt(@RequestBody(required = true) Host host) {
        hosts.addHost(host);
        return "successfully added host";

    }

    @RequestMapping("/host/get")
    public String getArt() {
        ArrayList<String> hostNames = new ArrayList<String>();
        for (Host host : hosts.getHosts()) {
            hostNames.add(host.getName());
        }
        return hostNames.toString();

    }

    @RequestMapping(value = "/host/addFestival", method = RequestMethod.POST)
    public Greeting addFest(@RequestParam String name, @RequestBody(required = true) Festival festival) {
        Host host1 = new Host();
        for (Host host:hosts.getHosts()){
            if(host.getEmail().equals(name)){
                host1 = host;
            }
        }

        for(Festival festival1 : festivals.getFestivals()) {
            if (festival1.getFestivalName().equals(festival.getFestivalName())) {
                return new Greeting(0, "failure");
            }
        }
        festival.changeHost(host1);
        System.out.println(host1.getName());
        festivals.getFestivals().add(festival);
        return new Greeting(0, "success");


    }

    @RequestMapping("/host/getFestival")
    public ResponseArrayList getFest(@RequestParam(value = "name") String hostName) {
        ArrayList<String> festivalNames = new ArrayList<String>();

                for (Festival festival : festivals.getFestivals()) {
                    if(festival.getHost().getEmail().equals(hostName)){
                        festivalNames.add(festival.getFestivalName());
                    }

                }
                System.out.println(festivalNames.size());
            return new ResponseArrayList(0, festivalNames);
        }


    @RequestMapping("/listFestivals")
    public ResponseArrayList listFest() {
        ArrayList<String> festivalNames = new ArrayList<String>();
        for (Festival festival:festivals.getFestivals()) {
                festivalNames.add(festival.getFestivalName());
            }

        return new ResponseArrayList(0, festivalNames);
    }


    @RequestMapping("/user/listFestivals")
    public ResponseArrayList listUserFest(@RequestParam(value = "name") String name) {
        ArrayList<String> festivalNames = new ArrayList<String>();
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(name)) {
                for (Festival festival : user.getFestivalsInterestedIn()) {
                    festivalNames.add(festival.getFestivalName());
                }
            }
        }
        return new ResponseArrayList(0, festivalNames);
    }

    @RequestMapping("/user/searchFestivals")
    public Greeting searchFest(@RequestParam(value = "name") String name) {
        for (Festival festival : festivals.getFestivals()) {
            if (festival.getFestivalName().equals(name)) {
                return new Greeting(0, festival.toString());
            }
        }

        return new Greeting(0, "Did not find any matching festivals");
    }

    @RequestMapping("/host/listFestivals")
    public ResponseArrayList listHostFest(@RequestParam(value = "name") String name) {
        ArrayList<String> festivalNames = new ArrayList<String>();
        Host host1 = new Host();
        for(Host host: hosts.getHosts()){
            if(host.getEmail().equals(name)){
                host1 = host;
            }
        }
        for (Festival festival : festivals.getFestivals()) {
            if (festival.getHost().equals(host1)) {
                festivalNames.add(festival.getFestivalName());
            }
        }
        return new ResponseArrayList(0, festivalNames);
    }

    @RequestMapping("/host/viewFestival")
    public ResponseList listHostFest(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "festivalName") String festivalName) {

        for (Festival festival : festivals.getFestivals()) {
            if (festival.getFestivalName().equals(festivalName)) {
                return new ResponseList(festival.festivalInfo());
            }
        }

        String[] emptyString = {"no festival information found"};
        return new ResponseList(emptyString);
    }

    @RequestMapping(value = "/host/addNewArtist")
    public ResponseString checkArtist(@RequestParam(value = "artistName")
            String artistName) {

        for(Artist artist: artists.getArtists()){
            if(artist.getName().equals(artistName)){

                return new ResponseString(0, "artist is already listed in list of artists");
            }
        }

        Artist artist1=new Artist(artistName);
        artists.addArtist(artist1);
        return new ResponseString(0, "artist was added to list of artists");


//        for (Host host : hosts.getHosts()) {
//            System.out.println("1getHosts");
//            if (host.getEmail().equals(hostName)) {
//                System.out.println("1equals host name");
//                for (Festival festival : host.getFestivals()) {
//                    System.out.println("1get festivals");
//                    if (festival.getFestivalName().equals(festivalName)) {
//                        System.out.println("1festival name");
//                        for (Artist artist : festival.getArtistsPlaying()) {
//                            System.out.println("1get artists playing");
//                            if (artist.getName().equals(artistName)) {
//                                String[] validUserArtistExists = {"true", "true"};
//                                return new ResponseList(validUserArtistExists);
//                            }
//                        }
//                        String[] validUserArtistExists = {"true", "false"};
//                        return new ResponseList(validUserArtistExists);
//                    }
//
//                }
//                String[] festivalNotFound = {"false", "true"};
//                return new ResponseList(festivalNotFound);
//            }
//        }
//        String[] validUserArtistExists = {"false", "true"};
//        return new ResponseList(validUserArtistExists);
    }

    @RequestMapping(value = "/artists/viewAll")
    public ResponseArrayList viewAllArtists(){
        ArrayList<String> artistNames = new ArrayList<>();
        for(Artist artist:artists.getArtists()){
            artistNames.add(artist.getName());
        }
        return new ResponseArrayList(0, artistNames);
    }

    @RequestMapping(value = "/host/festival/addArtist")
    public ResponseArrayList addArtist(@RequestParam(value = "hostName") String hostName, @RequestParam(value="festivalName") String festivalName, @RequestParam(value="artistName") String artistName) {
        for (Host host : hosts.getHosts()) {
            System.out.println("get hosts");
            if (host.getEmail().equals(hostName)) {
                System.out.println("equals host name");
                for (Festival festival : festivals.getFestivals()) {
                    System.out.println("get festivals");
                    if (festival.getFestivalName().equals(festivalName)&&festival.getHost().getName().equals(hostName)) {
                        for (Artist artist:artists.getArtists()){
                            if(artist.getName().equals(artistName)){
                                artist.addFestival(festival);
                                festival.addArtist(artist);
                                ArrayList<String> artistNames = new ArrayList<>();
                                for (Artist artist1 : festival.getArtistsPlaying()) {
                                    artistNames.add(artist1.getName());
                                }
                                return new ResponseArrayList(0, artistNames);
                            }

                        }
                    }
                }
            }
        }

        ArrayList<String> emptyString = new ArrayList<>(Arrays.asList("could not retrieve artist list at this time", ""));
        return new ResponseArrayList(0, emptyString);
    }

    @RequestMapping(value = "/host/festival/displayArtists")
    public ResponseArrayList showArtists(@RequestParam(value="hostName")String hostName, @RequestParam(value="festivalName") String festivalName) {

                for (Festival festival : festivals.getFestivals()) {
                    if (festival.getFestivalName().equals(festivalName)&&festival.getHost().getName().equals(hostName)) {
                        ArrayList<String> artistNames = new ArrayList<String>();
                        for (Artist artist : festival.getArtistsPlaying()) {
                            artistNames.add(artist.getName());
                        }
                        return new ResponseArrayList(0, artistNames);
                    }
                }


        ArrayList<String> emptyString = new ArrayList<>(Arrays.asList("could not retrieve artist list at this time", ""));
        return new ResponseArrayList(0, emptyString);
    }

    ;


    @RequestMapping(value = "/addSong", method = RequestMethod.POST)
    public ResponseString addSong(@RequestParam (value="artistName")String artistName,
                                  @RequestBody Song newSong) {
        System.out.println("before for loop");
        for (Artist artist : artists.getArtists()) {
            System.out.println("artist for loop");

            if (artist.getName().equals(artistName)) {
                System.out.println("inside if statement");
                newSong.giveArtist(artist);
                System.out.println("after give artist");
                artist.addSong(newSong);

                return new ResponseString(0,"success");
            }

        }
        return new ResponseString(0,"could not add song");
    }

    @RequestMapping(value = "/host/displayArtistFestivalList")
    public ResponseArrayList getArtistFestivalList(@RequestParam(value="artistName") String artistName) {

        for (Artist artist: artists.getArtists()){
            if (artist.getName().equals(artistName)) {
                ArrayList<String> festivalNames = new ArrayList<String>();
                for (Festival festival:artist.getFestivalsPlayingAt()){
                    festivalNames.add(festival.getFestivalName());
                }
                return new ResponseArrayList(0, festivalNames);
            }
        }
        ArrayList<String> emptyString = new ArrayList<>(Arrays.asList("could not retrieve festival list at this time", ""));
        return new ResponseArrayList(0, emptyString);
    }

    @RequestMapping(value = "/host/artist/displaySongs")
    public ResponseArrayList getArtistSongs(@RequestParam(value="artistName")String artistName){
        for (Artist artist:artists.getArtists()){
            if (artist.getName().equals(artistName)){
                ArrayList<String> songList = new ArrayList<>();
                for (Song song:artist.getSongsByArtist()){
                    songList.add(song.getSongName());
                }
                return new ResponseArrayList(0, songList);
            }
        }
        ArrayList<String> emptyString = new ArrayList<>(Arrays.asList("could not retrieve song list at this time", ""));
        return new ResponseArrayList(0, emptyString);
    }

    @RequestMapping(value = "/user/festival/displayPlaylist")
    public ResponseArrayList getFestivalSongs(@RequestParam(value="festivalName") String festivalName,
                                              @RequestParam(value="userName") String userName){
        for (User user:users.getUsers()){
            if(user.getEmail().equals(userName)){
                for(Festival festival : user.getFestivalsInterestedIn()){
                    if(festival.getFestivalName().equals(festivalName)){
                        ArrayList<String> festivalSongs = new ArrayList<>();
                        for (Artist artist:festival.getArtistsPlaying()){
                            for(Song song:artist.getSongsByArtist()){
                                String newSongName = song.getSongName();
                                festivalSongs.add(newSongName);
                            }
                        }
                        return new ResponseArrayList(0, festivalSongs);
                    }
                }

            }
        }
        ArrayList<String> emptyString = new ArrayList<>(Arrays.asList("could not retrieve playlist at this time", ""));
        return new ResponseArrayList(0, emptyString);
    }
}
