package com.goodbooks.bookcatalogue.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bookinfo")
public class BookInfoConfig {
    private String url;
    private String basepath;
    private String resource;

    public String getEndPoint() {
        return url + "/" + basepath + "/" + resource ;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }
}
