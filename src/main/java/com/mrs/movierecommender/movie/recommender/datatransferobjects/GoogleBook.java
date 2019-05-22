package com.mrs.movierecommender.movie.recommender.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBook {
    String kind;
    Item[] items;

}
