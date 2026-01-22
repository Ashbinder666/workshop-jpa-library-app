package se.mattiashellman.lexicon.jpalibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mattiashellman.lexicon.jpalibraryapp.entity.BookLoan;

public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {
}