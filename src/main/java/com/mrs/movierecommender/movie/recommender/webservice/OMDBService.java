package com.mrs.movierecommender.movie.recommender.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrs.movierecommender.movie.recommender.datatransferobjects.Movie;
import com.mrs.movierecommender.movie.recommender.datatransferobjects.MovieRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OMDBService {
    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(OMDBService.class);


    public Movie findMovie(String movieName){
        Movie movie = null;
        try {
            URI uri = new URI(String.format("https://api.themoviedb.org/3/search/movie?" +
                    "api_key=2dfb547730dc75f531f122d2436e6e6c&language=en-US&query=Avengers:+Endgame" +
                    "&page=1&include_adult=false"));
            ResponseEntity<String> findMovieResponse = restTemplate.getForEntity(uri, String.class);
            MovieRequest movieRequest = objectMapper.readValue(findMovieResponse.getBody(), MovieRequest.class);
            Movie[] movieResults = movieRequest.getResults();
            movie = movieResults[0];

        }
        catch(URISyntaxException | IOException ex)
        {
            logger.error(ex.toString());
        }
        return movie;
    }


}
