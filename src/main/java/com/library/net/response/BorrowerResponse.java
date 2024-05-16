package com.library.net.response;

import com.library.net.entity.Borrower;

import lombok.Data;

@Data
public class BorrowerResponse {
	
	private long id;
	
	private String name;
	
	private String email;
	
	public BorrowerResponse(Borrower borrower) {
		this.id=borrower.getId();
		this.name=borrower.getName();
		this.email=borrower.getEmail();
	}

}
