package org.example.entity;

public class Student {
    private String id;
    private String name;

    @Override // это называется аннотация
    public String toString() {
        return "Student {" +
                "'id='" + id + '\'' +
                "'name='" + name + '\'' +
                '}';

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
