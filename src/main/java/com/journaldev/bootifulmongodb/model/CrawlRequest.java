package com.journaldev.bootifulmongodb.model;

import com.journaldev.bootifulmongodb.util.Enum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class CrawlRequest {

    @Id
    private String uniqueId;

    private String requestURL;
    private String totalImage;
    private String totalLink;
    private String details;
    private String requestURLStatus;

    public CrawlRequest(){}

    public CrawlRequest(String uniqueId, String requestURL, String requestURLStatus){
        this.uniqueId=uniqueId;
        this.requestURL=requestURL;
        this.requestURLStatus=requestURLStatus;
    }

    public CrawlRequest(String uniqueId, String requestURL, String requestURLStatus, String details){
        this.uniqueId=uniqueId;
        this.requestURL=requestURL;
        this.requestURLStatus=requestURLStatus;
        this.details=details;
    }

    public String getTotalImage() {
        return totalImage;
    }

    public void setTotalImage(String totalImage) {
        this.totalImage = totalImage;
    }

    public String getTotalLink() {
        return totalLink;
    }

    public void setTotalLink(String totalLink) {
        this.totalLink = totalLink;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestURLStatus() {
        return requestURLStatus;
    }

    public void setRequestURLStatus(String requestURLStatus) {
        this.requestURLStatus = requestURLStatus;
    }

}
