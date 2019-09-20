package com.example.demo;

import static org.junit.Assert.assertEquals;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.persistence.domain.Account;
import com.example.demo.persistence.repo.AccountService;
import com.example.demo.persistence.repo.BankRepo;
import com.example.demo.persistence.repo.NumberGenerator;
import com.example.demo.persistence.repo.PrizeGenerator;

@RunWith(SpringRunner.class)
public class AccountServiceUnitTest {
	
	
	private final Account TESTACC = new Account("S", "A");
	private final Long ID = 1L;
	private final Long ACCNUM = 695695L;
	private final String PRIZE ="100$";
	
	@Before
	public void init() {
		this.TESTACC.setId(ID);
		this.TESTACC.setAccountNumber(ACCNUM);
		this.TESTACC.setPrize(PRIZE);
	}
	
	@Test
	public void createAccount() {
		Mockito.when(this.repo.save(TESTACC)).thenReturn(TESTACC);
		Mockito.when(this.numgen.accNumGenerator(TESTACC)).thenReturn(ACCNUM);
		Mockito.when(this.prizeGen.prizeCheck(TESTACC)).thenReturn(PRIZE);
		
		ResponseEntity<Account> testResponse= ResponseEntity.ok(TESTACC);
		assertEquals(testResponse, this.service.createAccount(TESTACC));
		Mockito.verify(this.repo).save(TESTACC);
	}
	
	@Test
	public void updateAccount() {
		Mockito.when(this.repo.findById(ID)).thenReturn(Optional.of(TESTACC));
		Mockito.when(this.repo.save(this.TESTACC)).thenReturn(TESTACC);
		ResponseEntity<Account> testResponse= ResponseEntity.ok(TESTACC);
		assertEquals(testResponse, this.service.updateAccount(TESTACC,ID));
		Mockito.verify(this.repo).save(TESTACC);
		
	}
	
//	@Test
//	public void deleteAccount() {
//		Mockito.when(this.repo.deleteById(ID)).thenReturn(Optional.of(TESTACC));
//		Mockito.when(this.repo.save(this.TESTACC)).thenReturn(TESTACC);
//		ResponseEntity<Account> testResponse= ResponseEntity.ok(TESTACC);
//		assertEquals(testResponse, this.service.updateAccount(TESTACC,ID));
//		Mockito.verify(this.repo).save(TESTACC);
//		
//	}
	
	@InjectMocks
	private AccountService service;
	
	@Mock
	private BankRepo repo;
	@Mock
	private NumberGenerator numgen;
	@Mock
	private PrizeGenerator prizeGen;
	

}
