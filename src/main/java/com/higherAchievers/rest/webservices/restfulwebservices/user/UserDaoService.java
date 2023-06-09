package com.higherAchievers.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {
    //TODO Create a static ArrayList
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    //TODO 2 return List of Users
    public List<User> findAll() {
        return users;
    }

    public User save(User user)  {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    //TODO 3 return a specific Users
    public User findOne(int id) {
        if (id <= users.size()) {
            return users.get(id - 1);
        } else return null;
    }

    //TODO 4 deleting a Users
    public void deleteById(int id) {
        if (id <= users.size()) {
            users.remove(id - 1);
        }
    }

}
