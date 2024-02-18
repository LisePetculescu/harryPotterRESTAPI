package edu.hogwarts.studentadmin.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String founder;
    @ElementCollection
    private List<String> colours;

    public House(String name, String founder, List<String> colours) {
        this.name = name;
        this.founder = founder;
        this.colours = colours;
    }

    public House() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public List<String> getColours() {
        return colours;
    }

    public void setColours(List<String> colours) {
        this.colours = colours;
    }
}
