package com.example.demo.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.domain.Account;
import com.example.demo.persistence.repo.AccountService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	private AccountService service;

	public BankController(AccountService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount (@RequestBody Account account){
		return this.service.createAccount(account);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Account>> read(){
		return this.service.read();
	}
	
	@PutMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathParam ("id") Long id) {
		return this.service.updateAccount(account, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable ("id") Long id){
		return this.service.deleteAccount(id);
	}

}
