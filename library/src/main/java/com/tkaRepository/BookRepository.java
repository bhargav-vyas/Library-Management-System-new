package com.tkaRepository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkaEntity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


	Collection<? extends Book> findByAuthorContainingIgnoreCase(String author);

	Collection<? extends Book> findByCategoryContainingIgnoreCase(String category);

	Collection<? extends Book> findByTitleContainingIgnoreCase(String title);

}