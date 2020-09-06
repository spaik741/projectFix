package ru.servlets;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    public List<User> users;
    public static  UserList userList;

    static {
        userList=new UserList();
    }

    public UserList() {
        this.users = new ArrayList<User>();
        users.add(new User("Misha","Bryahchin"));
        users.add(new User("Valeria","Mamonova"));
    }

    public static UserList getUserList(){
        return userList;
    }
    public List<User> getList(){
        return users;
    }

}
