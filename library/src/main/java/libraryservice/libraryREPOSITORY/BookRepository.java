package libraryservice.libraryREPOSITORY;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libraryservice.libraryEntity.BookEntity;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


	Collection<? extends BookEntity> findByAuthorContainingIgnoreCase(String author);

	Collection<? extends BookEntity> findByCategoryContainingIgnoreCase(String category);

	Collection<? extends BookEntity> findByTitleContainingIgnoreCase(String title);

}
