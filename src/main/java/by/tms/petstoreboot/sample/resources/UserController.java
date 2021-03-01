package by.tms.petstoreboot.sample.resources;

import by.tms.petstoreboot.sample.model.User;
import by.tms.petstoreboot.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Valid
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() { //Get all users
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/{userName}")  //Get user by user name
    public ResponseEntity<User> getUserByUserName(User user) {
        return new ResponseEntity<>(userService.getByUserName(user.getUserName()), HttpStatus.OK);
    }

     /* @GetMapping(path = "/login") //Logs user into the system

    @GetMapping(path = "/logout") //Logs out current logged in user session*/

    @PostMapping(path = "/create") //create user
    @ResponseStatus(HttpStatus.CREATED)
    public User createAndSaveUser(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping(path = "/{userName") //Updated user
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/{userName}") //Delete user
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserByUserName(User userName) {
        userService.deleteUser(userName);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
