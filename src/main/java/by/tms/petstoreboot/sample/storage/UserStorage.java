package by.tms.petstoreboot.sample.storage;

import by.tms.petstoreboot.sample.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserStorage {

    private static final List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }
}
