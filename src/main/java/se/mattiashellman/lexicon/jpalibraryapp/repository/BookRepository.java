package se.mattiashellman.lexicon.jpalibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mattiashellman.lexicon.jpalibraryapp.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findbyIsbnIgnoreCase(String isbn);

    List<Book> findbyTitleContains(String title);

    List<Book> findByMaxLoanDaysIsLessThan(int Days);


}