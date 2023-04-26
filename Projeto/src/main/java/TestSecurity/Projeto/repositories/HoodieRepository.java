package TestSecurity.Projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TestSecurity.Projeto.entities.Hoodie;

import java.util.List;

@Repository
public interface HoodieRepository extends JpaRepository<Hoodie, Long> {

    List<Hoodie> findAll();

    List<Hoodie> getAllBySize(int size);

    List<Hoodie> getAllByColor(int color);

}
