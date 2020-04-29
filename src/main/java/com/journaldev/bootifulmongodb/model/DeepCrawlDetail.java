package com.journaldev.bootifulmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DeepCrawlDetail {

    @Id
    String uniqueId;
    String deepCrawlURL;

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

}
