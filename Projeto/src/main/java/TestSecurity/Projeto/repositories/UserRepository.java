package TestSecurity.Projeto.repositories;

import TestSecurity.Projeto.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users getUserByUsername(String username);
    Users getUserById(long id);

}
