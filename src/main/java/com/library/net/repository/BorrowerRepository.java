package com.library.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.net.entity.Book;
import com.library.net.entity.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long>{
	
}
