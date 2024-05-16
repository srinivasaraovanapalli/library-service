package com.library.net.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name="book", uniqueConstraints={@UniqueConstraint(columnNames = {"isbn" , "title", "author"})})
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	private long id;
	
	@Column(name="isbn", nullable = false)
	private String isbn;

	@Column(name="title", nullable = false)
	private String title;

	@Column(name="author", nullable = false)
	private String author;
	
	@Column(name="isborrower", nullable = false)
	private boolean isBorrwer;
	
	@Column(name="total")
	private int total;

}
