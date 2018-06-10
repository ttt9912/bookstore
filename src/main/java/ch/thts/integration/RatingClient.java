package ch.thts.integration;

import feign.Param;
import feign.RequestLine;

public interface RatingClient {

    @RequestLine("GET /api/ratings/{id}")
    RatingServiceResponse getRatingById(@Param("id") long id);
}
