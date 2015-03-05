package org.watson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Matti Tahvonen
 */
public class CdiConfig {

    private JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();

    @Produces
    private ObjectMapper objectMapper = provider.locateMapper(Object.class,
            MediaType.APPLICATION_JSON_TYPE).configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Produces
    @Dependent
    public Client createJaxRsClient() {
        return ClientBuilder.newBuilder()
                .register(provider)
                .build();
    }

    public void closeClient(@Disposes Client client) {
        client.close();
    }

}
