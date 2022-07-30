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
		User user = new User();
		user.setNom("Backi");
		user.setDateNaissance("19-11-2000");
		user.setTelephone("778143610");

		User savedUser = userService.saveUser(user);
		System.out.println("User created: "+ savedUser);

		System.out.println("---------- CREATE ARTICLE ----------");
		Article article = new Article();
		article.setNom("Ecouteur sans fils");
		article.setPrixUnitaire(Float.parseFloat("1233.34"));
		article.setLibelle("Des écouteurs sans fils");

		Article savedArticle = articleService.saveArticle(article);
		System.out.println("Article created: "+ savedArticle);

		System.out.println("---------- CREATE COMMENTAIRE ----------");
		Commentaire commentaire = new Commentaire();
		commentaire.setIdArticle(article);
		commentaire.setIdUser(user);
		commentaire.setDate("19-11-2000");
		commentaire.setText("Cet article est vraiment cool");

		Commentaire savedCommentaire = commentaireService.saveCommentaire(commentaire);
		System.out.println("Commentaire created: "+ savedCommentaire);

	}


}
