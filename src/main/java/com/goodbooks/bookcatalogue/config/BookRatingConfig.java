package com.goodbooks.bookcatalogue.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bookrating")
public class BookRatingConfig {

    private String url;
    private String port;
    private String resource;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getEndPoint() {
        return url + ":" + port + "/" + resource ;
    }
}
