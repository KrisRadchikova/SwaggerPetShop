package by.tms.petstoreboot.sample.resources;

import by.tms.petstoreboot.sample.model.User;
import by.tms.petstoreboot.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{userName}")  //Get user by user name
    public User getUserByUserName(User user) {
        return userService.getByUserName(user.getUserName());
    }

/*
    @PutMapping(path = "/{userName") //Updated user
*/

    @DeleteMapping(path = "/{userName}") //Delete user
    public User deleteUserByUserName(User userName) {
        return userService.deleteUser(userName);
    }

   /* @GetMapping(path = "/login") //Logs user into the system

    @GetMapping(path = "/logout") //Logs out current logged in user session*/

    @PostMapping(path = "/create") //create user
    public User createAndSaveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
