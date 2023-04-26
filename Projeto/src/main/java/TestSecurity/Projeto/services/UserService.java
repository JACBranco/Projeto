package TestSecurity.Projeto.services;

import TestSecurity.Projeto.entities.Authorities;
import TestSecurity.Projeto.entities.Users;
import TestSecurity.Projeto.repositories.AuthorityRepository;
import TestSecurity.Projeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    public boolean usernameExistsInDB(String username) {
        boolean bool = false;
        if (userRepository.getUserByUsername(username) != null) {
            bool = true;
        }
        return bool;
    }

    public void createUser(String name, String address, String username, String password) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        Users u = new Users();
        u.setName(name);
        u.setAddress(address);
        u.setUsername(username);
        u.setPassword("{bcrypt}" + encodedPassword);
        u.setEnabled(true);

        Authorities a = new Authorities();
        a.setUsername(username);
        a.setAuthority("ROLE_USER");
        a.setUser(u);

        userRepository.save(u);
        authorityRepository.save(a);
    }

}
