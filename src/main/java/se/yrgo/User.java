package se.yrgo;
import java.util.Date;

/**
 * This class creates a new User and has methods to add name and email to it .
 */
public class User {
    private String name;
    private String email;

    /**
     * Constructor of User.
     * User must have name and email and can handle the exception.
     *
     * @param name This User's name.
     *             Should include both first
     *             and last name.
     * @param email This is User's email.
     *              Should include @
     *
     */
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
    /**
     * Gets the first and last name of this User.
     * @return this User's name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the email of this User.
     * @return this User's email.
     */
    public String getEmail() {
        return email;
    }

}





