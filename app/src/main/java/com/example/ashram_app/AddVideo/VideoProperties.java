package com.example.ashram_app.AddVideo;

public class VideoProperties {
    private String name;
    private String videourl;
    private String search;
    private String videoClass;

    public VideoProperties(String name, String videourl, String search, String videoClass) {
        this.name = name;
        this.videourl = videourl;
        this.search = search;
        this.videoClass = videoClass;
    }

    public VideoProperties() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getVideoClass() {
        return videoClass;
    }

    public void setVideoClass(String videoClass) {
        this.videoClass = videoClass;
    }


}

