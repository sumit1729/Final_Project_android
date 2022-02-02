package com.example.final_project;

public class NewsModal {
    private String newsTitle;
    private String newsDesc;


    public NewsModal(String newsTitle, String newsDesc) {
        this.newsTitle = newsTitle;
        this.newsDesc = newsDesc;
    }


    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }
}
