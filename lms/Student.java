package lms;

import java.io.Serializable;

public class Student implements Serializable {
    String firstName, lastName, id;

    public Student(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // getters and setters
}