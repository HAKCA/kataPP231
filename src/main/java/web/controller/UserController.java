package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User addUser(@RequestParam String name, @RequestParam String surname, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setLastName(surname);
        user.setAge(age);
        return userRepository.save(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users")
    public User getUserById(@RequestParam Long id) {
        return userRepository.findById(id).orElse(null);
    }
}