package ch.thts.integration;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

class ClientFactory {

    static <T> T createClient(String url, Class<T> clazz) {
        return createDefaultClient().target(clazz, url);
    }

    private static Feign.Builder createDefaultClient() {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        return Feign.builder()
                .decoder(new JacksonDecoder(mapper))
                .logger(new Slf4jLogger(ClientFactory.class))
                .logLevel(Logger.Level.FULL);
    }

}
