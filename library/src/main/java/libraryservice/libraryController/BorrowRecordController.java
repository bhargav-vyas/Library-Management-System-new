package libraryservice.libraryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.ws.rs.Path;
import libraryservice.libraryService.BorrowReordService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowRecordController {

	
		
		@Autowired
		private  BorrowReordService  borrowRecordService;
		
		@PostMapping("/{bookId}/member/{memberId}")
		public BorrowRecordController borrowBook(@PathVariable Long bookId, @PathVariable Long memberId) {
		 return borrowRecordService.borrowBook(bookId,memberId);	
		}

		@GetMapping("/getall")
		public List<BorrowRecordController> getAllBorrowRecord(){
			return borrowRecordService.getAllBorrowRecord();
	}
		 
		@DeleteMapping("/deletbyId /{id}")
		public ResponseEntity<String> deletById(@PathVariable  Long id) {
			borrowRecordService.deletById(id);		
			return  ResponseEntity.ok("Borrow record woth Id " + id +  "has been deleted successfully");
		} 
	}
		
	
	
	
	
	
	

