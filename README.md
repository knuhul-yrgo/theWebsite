# theWebsite
A website for discussion with other users in threads, sorted in a plethora of subjects.

------------------------------------------------------------------------

HOW TO DOWNLOAD AND RUN THE PROGRAM

If you want to download all the source-code, you should have Maven and JDK installed.
Download the Git-repo and move into the theWebsite directory.
Then type in the terminal:
mvn clean package
After that to run the created JAR-file:
java -jar ./target/theWebsite-1.0-SNAPSHOT.jar

If you do not have Maven installed, or you just want to run the program without all the source-code,
you can download the JAR-file from this link:
https://github.com/knuhul-yrgo/theWebsite.jar
Then run it with:
java -jar ./theWebsite.jar
NOTICE: You still need to have JDK to run the JAR-file.

------------------------------------------------------------------------

WHAT IS THEWEBSITE?

This program is a forum for creating discussion-threads. It has a SUB-THREAD-COMMENTS structure
where every user creates their personal account that they write their comments from.

It is divided in four classes: Sub, Thread and User which are all tested and contains the
private variables such as names, titles, list of comments, etc. There is also a Main-class that contains the
User Interface.
