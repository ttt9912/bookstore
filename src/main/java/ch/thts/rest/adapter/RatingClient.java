package ch.thts.rest.adapter;

import feign.Param;
import feign.RequestLine;

public interface RatingClient {

    @RequestLine("GET /api/ratings/{id}")
    RatingServiceResponse getRatingById(@Param("id") long id);
}
