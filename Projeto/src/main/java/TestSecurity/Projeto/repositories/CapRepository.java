package TestSecurity.Projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TestSecurity.Projeto.entities.Cap;

import java.util.List;

@Repository
public interface CapRepository extends JpaRepository<Cap, Long> {

    List<Cap> findAll();

    List<Cap> getAllBySize(int size);

    List<Cap> getAllByColor(int color);

}

