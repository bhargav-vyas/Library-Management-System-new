package libraryservice.libraryService;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.tka.Repository.BookRepository;
import com.tka.Repository.BorrowRecordRepository;
import com.tka.Repository.MemberRepository;

import jakarta.persistence.Id;
import libraryservice.libraryController.BorrowRecordController;
import libraryservice.libraryEntity.BookEntity;

@Service
public class BorrowReordService {
		
		@Autowired
		private BookRepository bookRepository;
		@Autowired 
		private BorrowRecordRepository  borrowRecordRepository; 
		 @Autowired
		  private MemberRepository  memberRepository;
		

		public BorrowRecordController borrowBook(Long bookId, Long memberId) {
			BookEntity book = bookRepository.findById(bookId).orElse(null);
			if(book == null ) {
				throw new RuntimeException("Book not found");
				
			}
			
			if(book.getAvailableCopies() <=0) {
				throw new RuntimeException("Book not available");
			}
			Member member = memberRepository.findById(memberId)
		            .orElseThrow(() -> new RuntimeException("Member not found"));
			
			book.setAvailableCopies(book.getAvailableCopies()-1);
			bookRepository.save(book);
			
			
			BorrowRecordController record = new BorrowRecordController();
			record.setBook(book);
			record.setMember(member);
			record.setBorrowDate(LocalDate.now());
			record.setReturnDate(LocalDate.now());
	       
			return borrowRecordRepository.save(record);
		
		}
		
		public List<BorrowRecord> getAllBorrowRecord(){
			return borrowRecordRepository.findAll() ;
			
		}
		public void deletById(Long id) {
			if(borrowRecordRepository.existsById(id)) {
				borrowRecordRepository.deleteById(id);
			} else {
				throw new RuntimeException("Borrow record with Id" + id+ "not found.");
			}
			
		}
	 
	}



