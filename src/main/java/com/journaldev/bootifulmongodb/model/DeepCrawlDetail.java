package com.journaldev.bootifulmongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DeepCrawlDetail {

    String uniqueId;
    String deepCrawlURL;
    String deepCrawlURLTitle;
    String imageCount;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getDeepCrawlURL() {
        return deepCrawlURL;
    }

    public void setDeepCrawlURL(String deepCrawlURL) {
        this.deepCrawlURL = deepCrawlURL;
    }

    public String getDeepCrawlURLTitle() {
        return deepCrawlURLTitle;
    }

    public void setDeepCrawlURLTitle(String deepCrawlURLTitle) {
        this.deepCrawlURLTitle = deepCrawlURLTitle;
    }

    public String getImageCount() {
        return imageCount;
    }

    public void setImageCount(String imageCount) {
        this.imageCount = imageCount;
    }
}
