package se.mattiashellman.lexicon.jpalibraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @Setter
    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Setter
    @Column(length = 50, nullable = false)
    private String password;

    @Setter
    private LocalDate regDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details userDetails;

    @OneToMany(mappedBy = "borrower")
    Set<BookLoan> bookLoans;

    public AppUser(String username, String password, LocalDate reDate, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = reDate;
        this.userDetails = userDetails;
    }

    public boolean addBookLoan(BookLoan bookLoan) {
        if (bookLoan.getBook().isAvailable() && bookLoans.add(bookLoan)) {
            bookLoan.setBorrower(this);
            bookLoan.getBook().setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean removeBookLoan(BookLoan bookLoan) {
        if (bookLoans.remove(bookLoan)) {
            bookLoan.setBorrower(null);
            bookLoan.getBook().setAvailable(true);
            return true;
        }
        return false;
    }
}
