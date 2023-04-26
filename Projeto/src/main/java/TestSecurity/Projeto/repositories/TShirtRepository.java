package TestSecurity.Projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TestSecurity.Projeto.entities.TShirt;

import java.util.List;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Long> {

    List<TShirt> findAll();
    List<TShirt> getAllBySize(int size);
    List<TShirt> getAllByColor(int color);

}
