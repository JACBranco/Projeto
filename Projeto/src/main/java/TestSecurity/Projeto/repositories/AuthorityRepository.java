package TestSecurity.Projeto.repositories;

import TestSecurity.Projeto.entities.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authorities, String> {

    Authorities findAuthorityByAuthority(String authority);

}
