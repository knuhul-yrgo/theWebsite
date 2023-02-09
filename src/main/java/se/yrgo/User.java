package se.yrgo;

import java.util.regex.Pattern;

// type (Guest, Member, Moderator), register date, country

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        if (null == userName || "".equals(userName)) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (!Pattern.matches(REGEX_EMAIL, email)) {
            throw new IllegalArgumentException("Incorrect email format");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}



