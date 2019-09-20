package com.example.demo.persistence.repo;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.domain.Account;

@Service
public class NumberGenerator {
	public Long accNumGenerator(Account account) {
		
		Random rand = new Random();
		int num = rand.nextInt(3);
		if(num ==0) return (Math.round(Math.random()*1000000));
		else if(num ==1)  return (Math.round(Math.random()*100000000));
		else {
			int m = (int) Math.pow(10, 10 - 1);
			return (long) (m + new Random().nextInt(9 * m));
		}
	}

}
