package TestSecurity.Projeto.services;

import TestSecurity.Projeto.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import TestSecurity.Projeto.entities.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    TShirtRepository tShirtRepository;
    @Autowired
    SweaterRepository sweaterRepository;
    @Autowired
    CapRepository capRepository;
    @Autowired
    HoodieRepository hoodieRepository;

    @Autowired
    AuthorityRepository rolesRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void initTShirts() {

        if (tShirtRepository.findAll().isEmpty()) {

            List<TShirt> tShirts = new ArrayList<>();

            TShirt t1 = new TShirt();
            t1.setPrice(12.99);
            t1.setColor(0);
            t1.setSize(1);
            TShirt t2 = new TShirt();
            t2.setPrice(9.99);
            t2.setColor(1);
            t2.setSize(0);
            TShirt t3 = new TShirt();
            t3.setPrice(10.99);
            t3.setColor(2);
            t3.setSize(2);
            TShirt t4 = new TShirt();
            t4.setPrice(12.99);
            t4.setColor(3);
            t4.setSize(3);
            TShirt t5 = new TShirt();
            t5.setPrice(8.99);
            t5.setColor(4);
            t5.setSize(4);
            TShirt t6 = new TShirt();
            t6.setPrice(12.99);
            t6.setColor(5);
            t6.setSize(5);
            TShirt t7 = new TShirt();
            t7.setPrice(11.99);
            t7.setColor(6);
            t7.setSize(6);

            tShirts.add(t1);
            tShirts.add(t2);
            tShirts.add(t3);
            tShirts.add(t4);
            tShirts.add(t5);
            tShirts.add(t6);
            tShirts.add(t7);

            tShirtRepository.saveAll(tShirts);
        }

    }
    @Override
    public void initSweaters() {

        if (sweaterRepository.findAll().isEmpty()) {

            List<Sweater> sweaters = new ArrayList<>();

            Sweater s1 = new Sweater();
            s1.setPrice(12.99);
            s1.setColor(0);
            s1.setSize(1);
            Sweater s2 = new Sweater();
            s2.setPrice(9.99);
            s2.setColor(1);
            s2.setSize(0);
            Sweater s3 = new Sweater();
            s3.setPrice(10.99);
            s3.setColor(2);
            s3.setSize(2);
            Sweater s4 = new Sweater();
            s4.setPrice(12.99);
            s4.setColor(3);
            s4.setSize(3);
            Sweater s5 = new Sweater();
            s5.setPrice(8.99);
            s5.setColor(4);
            s5.setSize(4);
            Sweater s6 = new Sweater();
            s6.setPrice(12.99);
            s6.setColor(5);
            s6.setSize(5);
            Sweater s7 = new Sweater();
            s7.setPrice(11.99);
            s7.setColor(6);
            s7.setSize(6);

            sweaters.add(s1);
            sweaters.add(s2);
            sweaters.add(s3);
            sweaters.add(s4);
            sweaters.add(s5);
            sweaters.add(s6);
            sweaters.add(s7);

            sweaterRepository.saveAll(sweaters);
        }

    }
    @Override
    public void initCaps() {

        if (capRepository.findAll().isEmpty()) {

            List<Cap> caps = new ArrayList<>();

            Cap c1 = new Cap();
            c1.setPrice(12.99);
            c1.setColor(0);
            c1.setSize(1);
            Cap c2 = new Cap();
            c2.setPrice(9.99);
            c2.setColor(1);
            c2.setSize(0);
            Cap c3 = new Cap();

            c3.setPrice(10.99);
            c3.setColor(2);
            c3.setSize(2);
            Cap c4 = new Cap();
            c4.setPrice(12.99);
            c4.setColor(3);
            c4.setSize(3);
            Cap c5 = new Cap();
            c5.setPrice(8.99);
            c5.setColor(4);
            c5.setSize(4);
            Cap c6 = new Cap();
            c6.setPrice(12.99);
            c6.setColor(5);
            c6.setSize(5);
            Cap c7 = new Cap();
            c7.setPrice(11.99);
            c7.setColor(6);
            c7.setSize(6);

            caps.add(c1);
            caps.add(c2);
            caps.add(c3);
            caps.add(c4);
            caps.add(c5);
            caps.add(c6);
            caps.add(c7);

            capRepository.saveAll(caps);
        }

    }
    @Override
    public void initHoodies() {

        if (hoodieRepository.findAll().isEmpty()) {

            List<Hoodie> hoodies = new ArrayList<>();

            Hoodie c1 = new Hoodie();
            c1.setPrice(12.99);
            c1.setColor(0);
            c1.setSize(1);
            Hoodie c2 = new Hoodie();
            c2.setPrice(9.99);
            c2.setColor(1);
            c2.setSize(0);
            Hoodie c3 = new Hoodie();
            c3.setPrice(10.99);
            c3.setColor(2);
            c3.setSize(2);
            Hoodie c4 = new Hoodie();
            c4.setPrice(12.99);
            c4.setColor(3);
            c4.setSize(3);
            Hoodie c5 = new Hoodie();
            c5.setPrice(8.99);
            c5.setColor(4);
            c5.setSize(4);
            Hoodie c6 = new Hoodie();
            c6.setPrice(12.99);
            c6.setColor(5);
            c6.setSize(5);
            Hoodie c7 = new Hoodie();
            c7.setPrice(11.99);
            c7.setColor(6);
            c7.setSize(6);

            hoodies.add(c1);
            hoodies.add(c2);
            hoodies.add(c3);
            hoodies.add(c4);
            hoodies.add(c5);
            hoodies.add(c6);
            hoodies.add(c7);

            hoodieRepository.saveAll(hoodies);
        }

    }
    @Override
    public void initRoles() {
        if (rolesRepository.findAll().isEmpty()) {

            List<Authorities> rolesList = new ArrayList<>();

            Authorities admin = new Authorities();
            admin.setAuthority("ROLE_ADMIN");
            admin.setUser(userRepository.getUserByUsername("admin"));
            admin.setUsername(userRepository.getUserByUsername("admin").getUsername());
            rolesList.add(admin);

            Authorities user = new Authorities();
            user.setAuthority("ROLE_USER");
            user.setUser(userRepository.getUserByUsername("user"));
            user.setUsername(userRepository.getUserByUsername("user").getUsername());
            rolesList.add(user);

            rolesRepository.saveAll(rolesList);

        }
    }
    @Override
    public void initUsers() {
        if (userRepository.findAll().isEmpty()) {

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            Users u = new Users();
            u.setUsername("admin");
            u.setName("Admin");
            String uPassword = bCryptPasswordEncoder.encode("123123");
            u.setPassword("{bcrypt}"+uPassword);
            u.setAddress("Rua Admin");
            u.setEnabled(true);

            userRepository.save(u);

            Users v = new Users();
            v.setUsername("user");
            v.setName("User");
            String vPassword = bCryptPasswordEncoder.encode("123123");
            v.setPassword("{bcrypt}"+vPassword);
            v.setAddress("Rua User");
            v.setEnabled(true);

            userRepository.save(v);
        }
    }
}
