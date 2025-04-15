package org.example.finalexammodule3.model;

public class Student {
    private String id;
    private String name;
    private String classes;

    public Student() {
    }

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public Student(String id, String name, String classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
