package com.library.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.management.entity.Books;

@Repository
public interface BookRepository extends CrudRepository<Books, Long>{

	Iterable<Books> findBynoOfBooksAvailableGreaterThan(int i);

}
