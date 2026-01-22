package se.mattiashellman.lexicon.jpalibraryapp.entity;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    List<Author> findByWrittenBooks_Id(int id);

    @Modifying
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :id")
    int updateNameById(@Param("id") int id,
                       @Param("firstName") String firstName,
                       @Param("lastName") String lastName);


    void deleteById(int id);

}