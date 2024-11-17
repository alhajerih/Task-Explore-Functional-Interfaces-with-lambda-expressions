package Java_Stream.Java_Stream.repository;

import Java_Stream.Java_Stream.entity.GuestSuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity,Long> {
}
