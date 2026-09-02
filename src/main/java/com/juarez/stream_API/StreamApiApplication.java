package com.juarez.stream_API;

import com.juarez.stream_API.engine.problem.Archer;
import com.juarez.stream_API.engine.problem.BattleEngine;
import com.juarez.stream_API.engine.problem.Mage;
import com.juarez.stream_API.engine.problem.Warrior;
import com.juarez.stream_API.inventory.domain.Customer;
import com.juarez.stream_API.inventory.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringBootApplication
public class StreamApiApplication {

	public static void main(String[] args) {

//		SpringApplication.run(StreamApiApplication.class, args);

//		BattleEngine engine = new BattleEngine();
//
//		var archer = new Archer("Sand", 10);
//		var mage = new Mage("Merl", 8);
//		var warrior = new Warrior("Rex", 12);
//
//		engine.startBattle(archer);
//		engine.startBattle(mage);
//		engine.setHeal(warrior);


		CustomerRepository customerRepo = new CustomerRepository();

		Map<Customer, Long> list = new HashMap<>();

		// saving customers
		customerRepo.save( new Customer(1L, "John",  "john@example.com"), 1L);
		customerRepo.save( new Customer(2L, "Jane", "jane@example.com"), 2L);

		List<Customer> all = customerRepo.findAll();
		System.out.println(all);


	}


}
