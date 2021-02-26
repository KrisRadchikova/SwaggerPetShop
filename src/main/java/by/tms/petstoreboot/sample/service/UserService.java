package by.tms.petstoreboot.sample.service;

import by.tms.petstoreboot.sample.model.User;
import by.tms.petstoreboot.sample.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserStorage userStorage;

    public boolean contains(String userName) {
        for (User user : userStorage.getUserList()) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers() {
        return userStorage.getUserList();
    }

    public User getByUserName(String userName) {
        for (User user : userStorage.getUserList()) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null; //следует сделать  сообщение
    }

    public User save(User user) {
        if (userStorage.getUserList().contains(user)) {
            return null;
        }
        userStorage.getUserList().add(user);
        return user;
    }

    public User deleteUser(User user) {
        userStorage.getUserList().remove(user);
        return null;
    }

    @Autowired
    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }
}
