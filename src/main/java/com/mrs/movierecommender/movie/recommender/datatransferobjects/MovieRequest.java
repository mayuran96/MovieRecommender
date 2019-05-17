package com.mrs.movierecommender.movie.recommender.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

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
