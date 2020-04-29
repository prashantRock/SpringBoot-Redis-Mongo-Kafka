package com.journaldev.bootifulmongodb.dto;


public class URLDetail {

    String pageTitle;
    String pageLink;
    String imageCount;

    public URLDetail(String pageTitle, String pageLink, int imageCount){
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

    @Override
    public String toString() {
        return "URLDetail [pageTitle=" + pageTitle + ", pageLink=" + pageLink + ", imageCount=" + imageCount + "]";
    }
}
