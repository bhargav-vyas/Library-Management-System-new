
package libraryservice.libraryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;

@Entity
@Data
public class BorrwRecordEntity {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "book_id", nullable = false)
	    private BookEntity book; 
	    @ManyToOne
	    @JoinColumn(name = "member_id", nullable = false)
	    private MemberEntity member;
	    private LocalDate borrowDate;
	    private LocalDate returnDate;
	    private boolean returned; 
	    private int availableCopies;    
	}
