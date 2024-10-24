package edu.utsa.cs3443.wsj923_lab4.model;


import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Airship {

    String name;
    String registry;
    String classType;
    ArrayList<Wizard> wizards;


    public Airship (String name, String registry, String classType) {
        this.name = name;
        this.registry = registry;
        this.classType = classType;
        wizards = new ArrayList<>();
    }


    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setRegistry (String registry) {
        this.registry = registry;
    }

    public String getRegistry () {
        return registry;
    }

    public void setClassType (String classType) {
        this.classType = classType;
    }

    public String getClassType () {
        return classType;
    }

    public void addWizard (Wizard wizard) {
        wizards.add(wizard);
    }

    public int getNumberOfWizards () {
        return wizards.size();
    }

    @Override
    public String toString () {
        String airshipObj = getName() + ", " + getClassType() + ", Registry: " + getRegistry() + "\n";
        airshipObj += getNumberOfWizards() + " wizards assigned.\n";

        for (Wizard wizard : wizards) {
            airshipObj += wizard.toString();
        }
        return airshipObj;
    }

}
