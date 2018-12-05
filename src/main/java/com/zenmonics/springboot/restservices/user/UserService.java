package com.zenmonics.springboot.restservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {
    private static List<User> userList = new ArrayList<>();
    private static int userCount = 4;

    static {
        userList.add(new User(1, "Samir", new Date()));
        userList.add(new User(2, "Farha", new Date()));
        userList.add(new User(3, "Safan", new Date()));
        userList.add(new User(4, "Sayan", new Date()));
    }

    public List<User> getAll() {
        return userList;
    }

    public User findById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(++userCount);
        }

        userList.add(user);

        return user;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = userList.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
