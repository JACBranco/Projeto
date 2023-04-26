package TestSecurity.Projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TestSecurity.Projeto.entities.Sweater;

import java.util.List;

@Repository
public interface SweaterRepository extends JpaRepository<Sweater, Long> {

    List<Sweater> findAll();
    List<Sweater> getAllBySize(int size);
    List<Sweater> getAllByColor(int color);

}
