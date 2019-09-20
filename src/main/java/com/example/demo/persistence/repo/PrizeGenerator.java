package com.example.demo.persistence.repo;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.domain.Account;

@Service
public class PrizeGenerator {
	
	public String prizeCheck(Account account) {
		String prize;
		if(account.getAccountNumber() % 5 ==1) prize = "nothing";
		else if(account.getAccountNumber() % 5 == 2) prize = "100$";
		else prize = "100$";
		return prize;
		
	}

}
