package ch.thts.rest.adapter;

import ch.thts.business.data.Rating;
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

        log.info("received Rating {}", rating);
        return rating;
    }
}
