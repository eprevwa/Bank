package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.persistence.domain.Account;
import com.example.demo.persistence.repo.AccountService;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BankingApplication.class, args);
		AccountService service = ac.getBean(AccountService.class);
		service.createAccount(new Account("L", "K"));
		System.out.println(service.read());
		service.updateAccount(new Account("M","P"), 1L);
		System.out.println(service.read());
		System.out.println("Jenkins test");
		
	}

}
