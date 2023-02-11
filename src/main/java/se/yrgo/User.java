package se.yrgo;

import java.util.Date;


// Add properties for type (Guest, Member, Moderator), register date, country
// Add toString()

public class User {
    private String name;
    private String email;
    private Date registerDate;
    private  String country;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        if (null == name || "".equals(name)) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if(email != null && email.contains("@")) {
            this.email = email;
        }else {
            throw new IllegalArgumentException("Missing @");
        }
    }
    public String toString() {
        return name + " (" + email + ")";
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    enum Type {
        GUEST,
        MEMBER,
        MODERATOR
    }

    }





