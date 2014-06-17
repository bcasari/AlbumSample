package com.sample.album.common;

public class Item {
    private String mainHeader;
    private String secondaryHeader;
    private String imageUrl;

    public String getMainHeader() {
        return mainHeader;
    }

    public void setMainHeader(String mainHeader) {
        this.mainHeader = mainHeader;
    }

    public String getSecondaryHeader() {
        return secondaryHeader;
    }

    public void setSecondaryHeader(String secondaryHeader) {
        this.secondaryHeader = secondaryHeader;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
