package nl.novi.backend.spring.techiteasyhomework.repositories;

import nl.novi.backend.spring.techiteasyhomework.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
