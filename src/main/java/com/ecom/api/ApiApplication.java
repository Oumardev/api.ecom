package com.ecom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecom.api.models.Article;
import com.ecom.api.models.Commentaire;
import com.ecom.api.models.User;
import com.ecom.api.services.ArticleService;
import com.ecom.api.services.CommentaireService;
import com.ecom.api.services.UserService;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentaireService commentaireService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	public void run(String ...strings) throws Exception{
	
		System.out.println("---------- CREATE USER ----------");
	}


}
