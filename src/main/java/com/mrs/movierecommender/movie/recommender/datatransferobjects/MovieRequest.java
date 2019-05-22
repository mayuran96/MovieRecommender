package com.mrs.movierecommender.movie.recommender.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Arrays;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieRequest {
    private Movie[] results;

    public Movie[] getResults() {
        return results;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "MovieRequest{" +
                "results=" + Arrays.toString(results) +
                '}';
    }
}
