package com.mrs.movierecommender.movie.recommender.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
    private String title;
    private String[] authors;
    private String description;
    private Integer averageRating;
    private Integer ratingsCount;
    private ImageLinks imageLinks;

}
