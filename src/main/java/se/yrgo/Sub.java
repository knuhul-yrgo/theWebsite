package se.yrgo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a new sub and has methods to add threads to it and search for existing threads.
 */
public class Sub {
    private String title;
    private List<Thread> threads = new ArrayList<>();

    // Below are constructors and getters that make sure the title isn't empty
    public Sub(String title) {
        if (title.trim().equalsIgnoreCase("")) {
            throw new IllegalArgumentException();
        }
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
        for (Thread thread : threads) {
            if (thread.getTitle().equalsIgnoreCase(title)) {
                return thread;
            }
        }
        throw new ThreadNotFoundException();
    }

    public int numberOfThread() {
        return threads.size();
    }
}
