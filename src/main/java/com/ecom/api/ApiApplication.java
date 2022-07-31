package com.ecom.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	public void run(String ...strings) throws Exception{
	
		System.out.println("--- YOUR SERVER STARTED :) ");
	}


}
