package com.library.net.service;

import java.util.List;

import com.library.net.entity.Book;

public interface BookService {

	public String createBook(Book book);
	
	public List<Book> getAllBooksFromLibraray();
}
