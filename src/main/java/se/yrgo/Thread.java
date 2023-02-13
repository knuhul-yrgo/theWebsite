package se.yrgo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Thread {
    private String title;
    private User originalPoster;
    private List<String> comments = new ArrayList<>();

    public Thread(String title, User originalPoster) {
        if (title.trim().equalsIgnoreCase("")) {
            throw new IllegalArgumentException("Cannot have an empty title");
        }
        this.title = title;
        if (originalPoster == null){
            throw new IllegalArgumentException("Cannot have a null OP");
        }
        this.originalPoster = originalPoster;
    }

    //puts together the commenter's username (from the toString-method)
    //with the comment-text and a timestamp when the comment was written
    public void addComment(User commenter, String text){
        if (commenter == null){
            throw new IllegalArgumentException("Cannot have a null commenter");
        }
        comments.add(commenter + ":\n" + text + "\n" + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).toString());
    }

    public String getTitle() {
        return title;
    }

    //will print the User's name from User's toString-method
    public User getOriginalPoster() {
        return originalPoster;
    }

    public List<String> getComments() {
        return comments;
    }

    public int numberOfComments() {
        return comments.size();
    }
}
