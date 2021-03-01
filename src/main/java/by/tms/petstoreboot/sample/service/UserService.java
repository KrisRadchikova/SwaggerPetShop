package by.tms.petstoreboot.sample.service;

import by.tms.petstoreboot.sample.resources.exceptions.InvalidUserNameOrPasswordSuppliedException;
import by.tms.petstoreboot.sample.resources.exceptions.UserExistsException;
import by.tms.petstoreboot.sample.resources.exceptions.UserNotFoundException;
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
        throw new InvalidUserNameOrPasswordSuppliedException("Invalid userName or password supplied");
    }

    public User add(User user) {
        if (userStorage.getUserList().contains(user)) {
            throw new UserExistsException("This user exists");
        }
        userStorage.getUserList().add(user);
        return user;
    }

    public void deleteUser(User user) {
        userStorage.getUserList().remove(user);
    }

    public User updateUser(User user) {
        for (User u : userStorage.getUserList()){
            if(u.getId() == user.getId()){
                u.setUserName(user.getUserName());
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setEmail(user.getEmail());
                u.setPassword(user.getPassword());
                u.setPhone(user.getPhone());
                u.setUserStatus(user.getUserStatus());
                return u;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    @Autowired
    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }


}
