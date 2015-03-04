
package org.watson.vcapservices;

import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

/**
 *
 * @author Matti Tahvonen
 */
public abstract class BasicAuthenticationFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("Authorization", getHeader() );
    }

    public abstract String getHeader();

}