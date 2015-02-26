package org.watson.vcapservices;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericCredentials {

    private String url;
    private String username;
    private String password;

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password The password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
	public String createAuthorizationHeaderValue() {
		String auth = getUsername() + ":"
				+ getPassword();
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset
				.forName("UTF-8")));
		String authHeader = "Basic " + new String(encodedAuth);
		return authHeader;
	}


}
