package hello.mock.repository;

import hello.models.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;


@Service
public class Users {
    private ArrayList<User> users;

    public Users() {
        this.users=new ArrayList<User>();
    }

    public String addUser(User user){
        users.add(user);
        return "artist added successfully";
    }

    public ArrayList<User> getUsers() {
        return users;
    }



}
