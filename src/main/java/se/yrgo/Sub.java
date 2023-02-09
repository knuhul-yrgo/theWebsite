package se.yrgo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a new sub and has methods to add threads to it and search for existing threads.
 */
public class Sub {
    private String title;
    private List<Thread> threads = new ArrayList<>();

    // Below are constructors and getters
    public Sub(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Thread> getThreads() {
        return threads;
    }
    // Method to add a new thread to our list
    public void addThread(Thread newThread) {
        threads.add(newThread);
    }

    // Like the name says, it's a method that finds a specific thread, if it doesn't exist, throw ThreadNotFoundException
    public Thread findThread(String title) throws ThreadNotFoundException{
        title = title.trim();
        for (int i = 0; i < threads.size(); i++) {
            if (threads.get(i).getTitle().equalsIgnoreCase(title)){
                return threads.get(i);
            }
        }
        throw new ThreadNotFoundException();
    }
}
