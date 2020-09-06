package ru.servlets;

import ru.servlets.UserList;

import java.util.List;

public class UserRepository {

    public List<User> findAll() {
        return UserList.getUserList().getList();
    }


    public void save(User user) {
        UserList.getUserList().getList().add(user);
    }
}
