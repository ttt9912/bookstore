package ch.thts.rest.adapter;

import ch.thts.business.data.Stars;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class RatingServiceResponse {
    private Stars stars;
    private String comment;

    @JsonCreator
    public RatingServiceResponse(
            @JsonProperty Stars stars,
            @JsonProperty String comment) {
        this.stars=stars;
        this.comment=comment;
    }
}
