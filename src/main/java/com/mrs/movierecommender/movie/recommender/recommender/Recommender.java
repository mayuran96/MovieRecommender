package com.mrs.movierecommender.movie.recommender.recommender;

import com.mrs.movierecommender.movie.recommender.webservice.OMDBService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.GenericItemSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

public class Recommender {
    private Logger logger = LoggerFactory.getLogger(OMDBService.class);

    public void recommendation()
    {
        try {
            URL fileURL = this.getClass().getResource("data.csv");
            File file = new File(fileURL.getPath());
            DataModel model = new FileDataModel(file);
            ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(model);
            GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, itemSimilarity);
            List<RecommendedItem> recommendations = recommender.recommend(1, 1);
            for(RecommendedItem item : recommendations)
            {
                System.out.println(item);
            }
        }
        catch(IOException | TasteException ex)
        {
            logger.info(ex.toString());
        }
    }


}
