package com.library.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.net.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	@Query(value="select b from Book b where b.isbn=:isbn and b.title=:title and b.author=:author")
	public Book getBookDetailsByIsbnAndTitleAndAuthor(String isbn, String title, String author);
	
	@Modifying
	@Query(value="update Book b set b.total=?1 where b.isbn=?2 and b.title=?3 and b.author=?4")
	public void updateBooksTotalCount(int total, String isbn, String title, String author);
	
	@Query(value="select b from Book b where b.isbn=:isbn")
	public Book bookValidateforDuplicateAuthoraAndTitleForIsbn(String isbn);
}
