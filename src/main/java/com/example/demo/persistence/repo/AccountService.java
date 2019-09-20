package com.example.demo.persistence.repo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.demo.persistence.domain.Account;

@Service
public class AccountService {
	
	@Autowired
	private BankRepo bankRepo;
	@Autowired
	private NumberGenerator numgen;
	@Autowired
	private PrizeGenerator prizeGen;

	public ResponseEntity<Account> createAccount (Account account) {
		account.setAccountNumber(numgen.accNumGenerator(account));
		account.setPrize(prizeGen.prizeCheck(account));
//		System.out.println(account.getPrize());
//		System.out.println(account.getAccountNumber());
		return ResponseEntity.ok(this.bankRepo.save(account));
		
	}
	
	public ResponseEntity<List<Account>> read(){
		return ResponseEntity.ok(this.bankRepo.findAll());
	
	}
	
	public ResponseEntity<Account> updateAccount(Account account, long id) {
		Account toUpdate = this.bankRepo.findById(id).get();
//		System.out.println(toUpdate.getAccountNumber());
		toUpdate.setFirstName(account.getFirstName());
		toUpdate.setLastName(account.getLastName());
//		toUpdate.setAccountNumber(account.getAccountNumber());
		return ResponseEntity.ok(this.bankRepo.save(toUpdate));
	}
	
	public ResponseEntity<Boolean> deleteAccount(Long id) {
		this.bankRepo.deleteById(id);
		return ResponseEntity.ok(this.bankRepo.existsById(id));
	}
	
//	public Long accNumGenerator(Account account) { 
//		if(account.getId()%2 == 0) return (Math.round(Math.random()*1000000));
//		else if(account.getId()%3 == 0)  return (Math.round(Math.random()*100000000));
//		else {
//			int m = (int) Math.pow(10, 10 - 1);
//			return (long) (m + new Random().nextInt(9 * m));
//		}
//	}
	


}
