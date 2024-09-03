package com.example.wmp_finalproject;

public class News {
    private String title;
    private String article;
    private String imageUrl;

    public News() {
        // Required empty public constructor for Firestore
    }

    public News(String title, String article, String imageUrl) {
        this.title = title;
        this.article = article;
        this.imageUrl = imageUrl;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

