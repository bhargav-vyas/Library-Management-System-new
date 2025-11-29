package com.tkaService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkaEntity.Book;
import com.tkaRepository.BookRepository;

import jakarta.websocket.server.ServerEndpoint;
@Service
public class BookService {

	@Autowired
	private BookRepository bookRespsitory;
	
	public List<Book> getAllBooks() {
        return bookRespsitory.findAll();
    }

	public Book addnewBooks(Book  book) {		
		return bookRespsitory.save(book);
	}

	public Book getBookById(Long id) {
		return bookRespsitory.findById(id).orElse(null);
	}

	public Book updateBook(Long id, Book updateBook) {
		Optional<Book> optionalBook = bookRespsitory.findById(id);
		if(optionalBook.isPresent()) {
			Book book =optionalBook.get();
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

	public List<Book> searchBooks (String title,String author, String category){
		List<Book> result =  new ArrayList<>();
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
