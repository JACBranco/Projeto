package TestSecurity.Projeto.demo;

import TestSecurity.Projeto.entities.Users;
import TestSecurity.Projeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    UserRepository userRepository;

    public DemoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping ("/users")
    public List<Users> getUsers() {
        List<Users> usersList = userRepository.findAll();
        return usersList;
    }

    @GetMapping ("/users/{id}")
    public Users getUser(@PathVariable long id) {

        if (id > userRepository.findAll().size() || (id<=0)){
            throw new UserNotFoundException("User ID not found - "+id);
        }

        Users users = userRepository.getUserById(id);
        return users;
    }




}
