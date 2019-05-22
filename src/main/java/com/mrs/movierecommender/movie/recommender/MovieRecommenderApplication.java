package com.mrs.movierecommender.movie.recommender;

import com.mrs.movierecommender.movie.recommender.datatransferobjects.Movie;
import com.mrs.movierecommender.movie.recommender.webservice.GoogleBooksService;
import com.mrs.movierecommender.movie.recommender.webservice.OMDBService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommenderApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		OMDBService movieService = new OMDBService();
//		Movie movie = movieService.findMovie("Avengers: Endgame");
//		System.out.println(movie.toString());
		GoogleBooksService s = new GoogleBooksService();
		s.findBook("scary");

	}

}
