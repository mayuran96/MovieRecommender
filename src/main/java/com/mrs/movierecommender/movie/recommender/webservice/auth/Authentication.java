package com.mrs.movierecommender.movie.recommender.webservice.auth;

import com.mrs.movierecommender.movie.recommender.webservice.OMDBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Authentication {
    private Logger logger = LoggerFactory.getLogger(Authentication.class);

    public String getAPIKey(String apiKey)
    {
        String key = null;
        try
        {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("/Users/arjunmayur/Documents/MovieRecommender/secrets/secrets.yml");
        Map<String, Object> secrets = yaml.load(inputStream);
        key = secrets.get(apiKey).toString();

            inputStream.close();
        }
        catch(IOException ex)
        {
            logger.info("Input Stream was not closed: "+ex.toString());
        }
        return key;
    }
}
