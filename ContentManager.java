package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;

public class ContentManager {
    private List<Article> articles;
    private List<Video> videos;

    public ContentManager() {
        articles = new ArrayList<>();
        videos = new ArrayList<>();
    }

    // Fetch a list of articles
    public List<Article> fetchArticles() {
        return articles;
    }

    // Add or update an article
    public void updateContent(Article article) {
        // Check if the article already exists
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId().equals(article.getId())) {
                // Update existing article
                articles.set(i, article);
                return;
            }
        }
        // Add new article if it doesn't exist
        articles.add(article);
    }

    // Fetch a list of videos
    public List<Video> getVideos() {
        return videos;
    }

    // Add or update a video
    public void updateContent(Video video) {
        // Check if the video already exists
        for (int i = 0; i < videos.size(); i++) {
            if (videos.get(i).getId().equals(video.getId())) {
                // Update existing video
                videos.set(i, video);
                return;
            }
        }
        // Add new video if it doesn't exist
        videos.add(video);
    }

    // Inner class representing an article
    public class Article {
        private String id;
        private String title;
        private String content;

        public Article(String id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    // Inner class representing a video
    public class Video {
        private String id;
        private String title;
        private String url;

        public Video(String id, String title, String url) {
            this.id = id;
            this.title = title;
            this.url = url;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
