package libraryservice.libraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.websocket.server.ServerEndpoint;
import libraryservice.libraryEntity.BookEntity;
import libraryservice.libraryREPOSITORY.BookRepository;

@Service
public class BookService {
		@Autowired
		private BookRepository bookRespsitory;
		
		public List<BookEntity> getAllBooks() {
	        return bookRespsitory.findAll();
	    }

		public BookEntity addnewBooks(BookEntity  bookEntity) {		
			return bookRespsitory.save(bookEntity);
		}

		public BookEntity getBookById(Long id) {
			return bookRespsitory.findById(id).orElse(null);
		}

		public BookEntity updateBook(Long id, BookEntity updateBook) {
			Optional<BookEntity> optionalBook = bookRespsitory.findById(id);
			if(optionalBook.isPresent()) {
				BookEntity book =optionalBook.get();
				book.setTitle(updateBook.getTitle());
				book.setAuthor(updateBook.getAuthor());
				book.setIdbn(updateBook.getIdbn());
				book.setPublishedYear(updateBook.getPublishedYear());
				book.setCategory(updateBook.getCategory());
				book.setAvailableCopies(updateBook.getAvailableCopies());
				return bookRespsitory.save(book);
				
			}
			return null;
		}

		public String deleteBook(Long id) {
			bookRespsitory.deleteById(id);
			return "Book deleted succfully";
		}

		public List<BookEntity> searchBooks (String title,String author, String category){
			List<BookEntity> result =  new ArrayList<>();
			if(title != null && !title.isEmpty()) {
				result.addAll(bookRespsitory.findByTitleContainingIgnoreCase(title));
			}
			if(author != null && !author.isEmpty()) {
				result.addAll(bookRespsitory.findByAuthorContainingIgnoreCase(author));
			}
			if(category !=null && !title.isEmpty()) {
				result.addAll(bookRespsitory.findByCategoryContainingIgnoreCase(category));
			}
			return result;


		}

	}



