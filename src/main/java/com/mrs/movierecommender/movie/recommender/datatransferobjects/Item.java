package com.mrs.movierecommender.movie.recommender.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private VolumeInfo volumeInfo;
}
