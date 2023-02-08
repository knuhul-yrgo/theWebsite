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
        this.title = title;
        this.originalPoster = originalPoster;
    }

    //puts together the commenter's username (from the toString-method)
    //with the comment-text and a timestamp when the comment was written
    public void addComment(User commenter, String text){
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
}
