//package com.tkaController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tkaEntity.Book;
//import com.tkaService.BookService;
//
//
//
//@RestController
//@RequestMapping("/api/Book")
//
//public class BookController {
//
//	@Autowired
//	private BookService bookService;
//	 // this is checked but check once
//	
//	
//	@GetMapping("/book")
//    public List<Book> getAllBooks() {
//        return bookService.getAllBooks();
//    }
//	// add new book  not checked aip 
//	@PostMapping("/addnewBooks")
//	public Book  addnewBooks(@RequestBody Book book){
//		return bookService.addnewBooks(book);
//	}
//	
//	@GetMapping("/{id}")
//	public Book getBookById(@PathVariable Long id) {
//		return bookService.getBookById(id);
//	}
//	
//	@PutMapping("{id}")
//	public Book  updateBook(@PathVariable Long id, @RequestBody Book book) {
//		return bookService.updateBook(id,book);
//	}
//	@DeleteMapping("/{id}")
//	public String deletBook(@PathVariable Long id) {
//		return bookService.deleteBook(id);
//	}
//	
//	@GetMapping("/search")
//	public List<Book> searchBook(@RequestParam(required =false)String title, @RequestParam(required= false ) String author,@RequestParam(required = false) String category){
//		return bookService.searchBooks(title, author, category);
//
//		
//	}
//}
