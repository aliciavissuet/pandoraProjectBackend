package hello.models;

import java.util.ArrayList;

public class Host {
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Festival> festivals = new ArrayList<Festival>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(ArrayList<Festival> festivals) {
        this.festivals = festivals;
    }

    public String getName(){
        return email;
    }

    public String addFestival(Festival festival) {
        this.festivals.add(festival);
        return "festival added successfully";
    }

}
