package com.library.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.net.entity.Book;
import com.library.net.exception.BookDuplicateWithIsbException;
import com.library.net.exception.BookNotFoundException;
import com.library.net.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	@Transactional
	public String createBook(Book book) {
		// we need to change logic for ISBN number uniquely identifies a book in the following way:
		//- 2 books with the same title and same author but different ISBN numbers are considered as different books
		//- 2 books with the same ISBN numbers must have the same title and same author
		
		String message ="";
		Book existingBook = bookRepository.getBookDetailsByIsbnAndTitleAndAuthor(book.getIsbn(), book.getTitle(), book.getAuthor());
		if(existingBook!=null) {
			bookRepository.updateBooksTotalCount(existingBook.getTotal()+1, book.getIsbn(), book.getTitle(), book.getAuthor());
			message ="Updating Total Count for book, this book already in library...";
		}else {
			Book b = bookRepository.bookValidateforDuplicateAuthoraAndTitleForIsbn(book.getIsbn());
			if(b!=null) { // can't insert duplicate isbn numbers using below code
				if(!b.getAuthor().equals(book.getAuthor()) || !b.getTitle().equals(book.getTitle()))
				throw new BookDuplicateWithIsbException("Book ALreday Having with Isbn...and same author and same title");
				//this exception need to handle like response object 
			}
			bookRepository.save(book);
			message ="Book saved scuessfully...";
		}
		return message;
	}

	@Override
	public List<Book> getAllBooksFromLibraray() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}
	
	public String requestBook(long id) {
		Book book = bookRepository.findById(id).get();
		if(book.isBorrwer()) {
			return "Book is Borrwed";
		}
		book.setBorrwer(true);
		bookRepository.save(book);
		return "Book saved with Updated as requestBook..";
	}
	
	public Book returnBook(long id) {
		return null;
	}
}
