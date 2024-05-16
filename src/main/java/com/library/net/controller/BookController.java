package com.library.net.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.net.entity.Book;
import com.library.net.service.BookService;

@RequestMapping("v1/api/book")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/create")
	public ResponseEntity<String> registerBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.createBook(book));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllBooksFromLibraray());
	}
}
