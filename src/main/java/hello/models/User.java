package hello.models;

import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private ArrayList<Festival> festivalsInterestedIn = new ArrayList<Festival>();

//
//    public User(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.birthMonth = 1;
//        this.birthDay = 1;
//        this.birthYear = 1990;
//        this.festivalsInterestedIn = new ArrayList<Festival>();
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public User createUser(String firstName, String lastName, String email) {
//        return new User(firstName, lastName, email);
//
//    }
//
//
//
//    public int findFestival(Festival festival) {
//
//        return this.festivalsInterestedIn.indexOf(festival);
//    }
//
//
//    public int findFestival(String festivalName) {
//        for (int i=0; i<this.festivalsInterestedIn.size(); i++){
//            Festival festival = this.festivalsInterestedIn.get(i);
//            if (festival.getFestivalName().equals(festivalName)){
//                return i;
//            }
//        }return -1;
//    }
//
//
//    public boolean addFestival(Festival festival) {
//        if (findFestival(festival.getFestivalName())>=0){
//            System.out.println("Festival is already in list.");
//            return false;
//        } festivalsInterestedIn.add(festival);
//        return true;
//    }
//
//    public boolean removeFestival(Festival festival){
//        int indexNumber = findFestival(festival);
//        if (indexNumber>=0){
//            this.festivalsInterestedIn.remove(indexNumber);
//            System.out.println(festival.getFestivalName() + " has been removed from your list of festivals.");
//
//            return true;
//        }
//        System.out.println("error - festival not found - no festival removed.");
//        return false;
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = 1;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = 1;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = 1;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public ArrayList<Festival> getFestivalsInterestedIn() {
        return festivalsInterestedIn;
    }

    public void addFestival(Festival festival){
        this.festivalsInterestedIn.add(festival);
    }
}
