package com.mrs.movierecommender.movie.recommender.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrs.movierecommender.movie.recommender.datatransferobjects.Movie;
import com.mrs.movierecommender.movie.recommender.datatransferobjects.MovieRequest;
import com.mrs.movierecommender.movie.recommender.webservice.auth.Authentication;
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
    private String apiKey;

    public OMDBService(){
        apiKey = new Authentication().getAPIKey("api_key");
    }

    public Movie findMovie(String movieName){
        Movie movie = null;
        try {
            URI uri = new URI(String.format("https://api.themoviedb.org/3/search/movie?" +
                    "api_key=%s&language=en-US&query=%s", apiKey, movieName));
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
