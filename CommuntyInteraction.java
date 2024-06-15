package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunityInteraction {
    private Map<String, List<Post>> discussions;

    public CommunityInteraction() {
        discussions = new HashMap<>();
    }

    // Post a message to a discussion board
    public void postMessage(String discussionId, String userId, String message) {
        Post newPost = new Post(userId, message);
        if (!discussions.containsKey(discussionId)) {
            discussions.put(discussionId, new ArrayList<>());
        }
        discussions.get(discussionId).add(newPost);
    }

    // Retrieve all posts from a discussion board
    public List<Post> getDiscussions(String discussionId) {
        return discussions.getOrDefault(discussionId, new ArrayList<>());
    }

    // Reply to a specific post in a discussion board
    public void replyToPost(String discussionId, int postId, String userId, String replyMessage) {
        List<Post> discussion = discussions.get(discussionId);
        if (discussion != null && postId < discussion.size()) {
            Post post = discussion.get(postId);
            post.addReply(new Post(userId, replyMessage));
        }
    }

    // Inner class representing a post
    public class Post {
        private String userId;
        private String message;
        private List<Post> replies;

        public Post(String userId, String message) {
            this.userId = userId;
            this.message = message;
            this.replies = new ArrayList<>();
        }

        // Add a reply to the post
        public void addReply(Post reply) {
            replies.add(reply);
        }

        // Getters and Setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<Post> getReplies() {
            return replies;
        }

        public void setReplies(List<Post> replies) {
            this.replies = replies;
        }
    }
}
