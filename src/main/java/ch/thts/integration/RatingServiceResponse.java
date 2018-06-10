package ch.thts.integration;

import ch.thts.data.Stars;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RatingServiceResponse {
    private Stars stars;
    private String comment;

    @JsonCreator
    public RatingServiceResponse(
            @JsonProperty("stars") Stars stars,
            @JsonProperty("comment") String comment) {
        this.stars=stars;
        this.comment=comment;
    }
}
