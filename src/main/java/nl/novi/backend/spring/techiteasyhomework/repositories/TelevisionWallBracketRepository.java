package nl.novi.backend.spring.techiteasyhomework.repositories;

import nl.novi.backend.spring.techiteasyhomework.models.TelevisionWallBracket;
import nl.novi.backend.spring.techiteasyhomework.models.TelevisionWallBracketKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TelevisionWallBracketRepository extends JpaRepository<TelevisionWallBracket, TelevisionWallBracketKey> {
    Collection<TelevisionWallBracket> findAllByTelevisionId(Long television);
    Collection<TelevisionWallBracket> findAllByWallBracketId(Long wallBracketId);
}
