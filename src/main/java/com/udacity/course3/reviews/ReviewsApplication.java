package com.udacity.course3.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);

//		Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/review_DB?useTimezone=true&serverTimezone=UTC", "ginowine", "developer").load();
//		flyway.repair();
//		flyway.migrate();
	}

}