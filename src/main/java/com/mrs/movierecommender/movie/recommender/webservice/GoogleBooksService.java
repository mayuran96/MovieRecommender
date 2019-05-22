package com.mrs.movierecommender.movie.recommender.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrs.movierecommender.movie.recommender.datatransferobjects.GoogleBook;
import com.mrs.movierecommender.movie.recommender.webservice.auth.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GoogleBooksService {
    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(OMDBService.class);
    private String apiKey;

    public GoogleBooksService(){
        apiKey = new Authentication().getAPIKey("google-books");
    }

    public GoogleBook findBook(String subject)
    {
        //https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key=yourAPIKey
        GoogleBook book = null;
        try {
            URI uri = new URI(String.format("https://www.googleapis.com/books/v1/volumes?q=%s&key=%s",subject,apiKey));
            ResponseEntity<String> findBookResponse = restTemplate.getForEntity(uri, String.class);
            GoogleBook googleBook = objectMapper.readValue(findBookResponse.getBody(), GoogleBook.class);

        }
        catch(URISyntaxException | IOException ex)
        {
            logger.error(ex.toString());
        }
        return book;

    }
}
