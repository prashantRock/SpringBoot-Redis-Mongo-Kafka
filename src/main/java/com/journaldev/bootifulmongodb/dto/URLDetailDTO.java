package com.journaldev.bootifulmongodb.dto;

/**
 * Created by sukeshgupta on 01/01/20.
 */
public class URLDetailDTO {

    String pageTitle;
    String pageLink;
    String imageCount;

    public URLDetailDTO(String pageTitle, String pageLink, int imageCount){
        this.pageTitle=pageTitle;
        this.pageLink=pageLink;
        this.imageCount=String.valueOf(imageCount);
    }



    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    public String getImageCount() {
        return imageCount;
    }

    public void setImageCount(String imageCount) {
        this.imageCount = imageCount;
    }
}
