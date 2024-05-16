package com.library.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.net.entity.Borrower;
import com.library.net.repository.BorrowerRepository;
import com.library.net.response.BorrowerResponse;

@Service
public class BorrowerServiceImpl implements BorrowerService {
	
	@Autowired
	private BorrowerRepository borrowerRepository;

	@Override
	public BorrowerResponse createBorrower(Borrower borrower) {
		
		Borrower b = borrowerRepository.save(borrower);
		//we can use setter to set data or we can directly return Borrower Entity to Controller
		return new BorrowerResponse(b);
	}

	

}
