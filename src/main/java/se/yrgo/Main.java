package se.yrgo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static boolean flgQuit = false;
    static List<Sub> subs = new ArrayList<>();
    static Sub currentSub;
    static boolean flgNoSubject = true;
    static Thread currentThread;
    static boolean flgNoThread = true;
    static List<User> users = new ArrayList<>();
    static boolean flgLoggedIn = false;
    static User loggedInUser;

    public static void main(String[] args) {

        while (!flgQuit){
            if (!flgLoggedIn){
                menuStart();
            }
            else {
                if (flgNoSubject){
                    menuSubject();
                }
                else {
                    if (flgNoThread){
                        menuThread();
                    }
                    else {
                        menuComment();
                    }
                }
            }

        }
        System.out.println("Good bye!");
    }
    public static void menuStart(){
        System.out.println("\nWelcome! What do you want to do?");
        System.out.println("1 - Sign up");
        System.out.println("2 - Log in");
        System.out.println("3 - Quit");
        int choice = getIntFromKeyboard();
        switch (choice) {
            case 1:
                signUpUser();
                break;
            case 2:
                logInUser();
                break;
            case 3:
                flgQuit = true;
                break;
            default:
                System.out.println("Don't know what to do...");

        }

    }
    public static void menuSubject(){
        System.out.println("\n" + loggedInUser + ",what do you want to do?");
        System.out.println("1 - List subjects");
        System.out.println("2 - Add subject");
        System.out.println("3 - Choose subject");
        System.out.println("4 - Log out");
        int choice = getIntFromKeyboard();
        switch (choice) {
            case 1:
                listSubs();
                break;
            case 2:
                addSub();
                break;
            case 3:
                chooseSub();
                break;
            case 4:
                flgLoggedIn = false;
            default:
                System.out.println("Don't know what to do...");
        }
    }

    public static void menuThread(){
        System.out.println("\n" + loggedInUser + ",what do you want to do with " + currentSub.getTitle() + "?");
        System.out.println("1 - List threads");
        System.out.println("2 - Add thread");
        System.out.println("3 - Choose thread");
        System.out.println("4 - Ditch subject");
        int choice = getIntFromKeyboard();
        switch (choice) {
            case 1:
                listThreads();
                break;
            case 2:
                addThread();
                break;
            case 3:
                chooseThread();
                break;
            case 4:
                flgNoSubject= true;
            default:
                System.out.println("Don't know what to do...");
        }
    }
    public static void menuComment(){
        System.out.println("\n" + loggedInUser + ",what do you want to do with " + currentThread.getTitle() + " in " + currentSub.getTitle() + "?");
        System.out.println("1 - List comments");
        System.out.println("2 - Add comment");
        System.out.println("3 - Ditch thread");
        System.out.println("4 - Return");
        int choice = getIntFromKeyboard();
        switch (choice) {
            case 1:
                listComments();
                break;
            case 2:
                addComment();
                break;
            case 3:
                flgNoThread= true;
                break;
            case 4:
                menuSubject();
                break;
            default:
                System.out.println("Don't know what to do...");
        }
    }
    public static int getIntFromKeyboard(){
        int choice = 0;
        boolean done = false;
        while (!done){
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume remaining newline
                done = true;
            }
            catch (Exception exp) {
                System.out.println("Only integers accepted");
                keyboard.nextLine(); // Consume remaining newline
            }
        }
        return(choice);
    }
    public static void signUpUser(){
        System.out.println("User name?");
        String name = keyboard.nextLine();
        System.out.println("User email?");
        String email = keyboard.nextLine();
        User newUser = new User(name,email);
        users.add(newUser);
    }

    public static void logInUser(){
        System.out.println("User name?");
        String name = keyboard.nextLine();
        for (User user : users){
            if (user.getName().equalsIgnoreCase(name)){
                loggedInUser = user;
                flgLoggedIn = true;
            }
        }

    }
    public static void listSubs(){
        System.out.println("\nAvailable subjects:");
        for (Sub sub:subs){
            System.out.println(sub.getTitle());
        }
    }
    public static void addSub(){
        System.out.println("Subject title?");
        String subTitle = keyboard.nextLine();
        try {
            Sub newSub = new Sub(subTitle);
            subs.add(newSub);
        }
        catch (Exception exp) {

        }
    }
    public static void chooseSub(){
        System.out.println("Choose subject?");
        String subject = keyboard.nextLine();
        for (Sub sub : subs){
            if (sub.getTitle().equalsIgnoreCase(subject)){
               currentSub = sub;
                flgNoSubject = false;
            }
        }
    }

    public static void listThreads(){
        List<Thread> threads = currentSub.getThreads();
        System.out.println("\nThreads in " + currentSub.getTitle() + ":");
        for (Thread thread:threads){
            System.out.println(thread.getTitle());
            System.out.println("-----------------------");
        }
    }
    public static void addThread(){
        System.out.println("Thread title?");
        String threadTitle = keyboard.nextLine();
        try {
            Thread newThread = new Thread(threadTitle, loggedInUser);
            currentSub.addThread(newThread);
            currentThread = newThread;
            flgNoThread = false;
            addComment();
        }
        catch (Exception exp) {
            // todo: handle exception
        }

    }
    public static void chooseThread(){
        System.out.println("Choose thread?");
        String wantedThread = keyboard.nextLine();
        try {
            currentThread = currentSub.findThread(wantedThread);
            flgNoThread = false;
        }
        catch (Exception exp) {
            // todo: handle exception
        }
    }
    public static void listComments(){
        List<String> comments = currentThread.getComments();
        System.out.println("\nComments in " + currentThread.getTitle() + ":");
        for (String comment: comments){
            System.out.println(comment);
            System.out.println("-----------------------");
        }
    }
    public static void addComment(){
        System.out.println("Comment?");
        String newComment = keyboard.nextLine();
        try {
            currentThread.addComment(loggedInUser,newComment);
        }
        catch (Exception exp) {
            // todo: handle exception
        }
    }
}
