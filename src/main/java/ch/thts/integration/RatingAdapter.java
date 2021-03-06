package ch.thts.integration;

import ch.thts.data.Rating;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RatingAdapter {

    private RatingClient ratingClient;

    public RatingAdapter(String url) {
        ratingClient = ClientFactory.createClient(url, RatingClient.class);
    }

    public Rating getRatingById(long id){
        RatingServiceResponse response = ratingClient.getRatingById(id);
        log.info("received RatingResponse {}", response);

        Rating rating = new Rating();
        rating.setStars(response.getStars());
        rating.setComment(response.getComment());
        return rating;
    }
}
