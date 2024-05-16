package com.library.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.net.entity.Borrower;
import com.library.net.response.BorrowerResponse;
import com.library.net.service.BorrowerService;

@RequestMapping("v1/api/borrower")
@RestController
public class BorrowerController {

	@Autowired
	private BorrowerService borrowerService;
	
	@PostMapping("/register")
	public ResponseEntity<BorrowerResponse> registerBorrower(@RequestBody Borrower borrower) {
		return ResponseEntity.ok(borrowerService.createBorrower(borrower));
	}

}
