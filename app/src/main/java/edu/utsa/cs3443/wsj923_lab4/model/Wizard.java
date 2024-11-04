package edu.utsa.cs3443.wsj923_lab4.model;

public class Wizard {
    String name;
    String role;
    String rank;
    String species;
    String assignment;

    public Wizard (String name, String role, String rank, String species, String assignment) {
        this.name = name;
        this.role = role;
        this.rank = rank;
        this.species = species;
        this.assignment = assignment;
    }

    public Wizard (String name, String role, String rank, String species) {
        this.name = name;
        this.role = role;
        this.rank = rank;
        this.species = species;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setRole (String role) {
        this.role = role;
    }

    public String getRole () {
        return role;
    }

    public void setRank (String rank) {
        this.rank = rank;
    }

    public String getRank () {
        return rank;
    }

    public void setSpecies (String species) {
        this.species = species;
    }

    public String getSpecies () {
        return species;
    }

    public void setAssignment (String assignment) {
        this.assignment = assignment;
    }

    public String getAssignment () {
        return assignment;
    }
    public String toString () {
        String wizardObj = "- " + getName() + " (" + getRank() + ") - " + getRole() + " [" + getSpecies() + "]\n";
        return wizardObj;
    }


}
