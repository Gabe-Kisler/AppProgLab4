package edu.utsa.cs3443.wsj923_lab4.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fleet {

    String name;
    ArrayList<Airship> airships;

    public Fleet (String name) {
        this.name = name;
        this.airships = new ArrayList<>();
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setAirships (ArrayList<Airship> airships) {
        this.airships = airships;
    }

    public ArrayList<Airship> getAirships () {
        return airships;
    }

    public int getSizeOfFleet () {
        return airships.size();
    }

    public void addAirship (Airship airship) {
        airships.add(airship);
    }


    public void loadAirships (String directoryString) throws FileNotFoundException {
        File directory = new File(directoryString);

        if (!directory.exists()) {
            throw new FileNotFoundException ("directory path does not exist");
        }

        File[] filesInDir = directory.listFiles();
        int fileCount = filesInDir.length;

        for (int i = 0; i < fileCount; i++) {
            File curFile = filesInDir[i];
            String curFileName = curFile.getName();
            String[] airshipInfo = curFileName.replace(".csv", "").split("_");

            String airshipName = airshipInfo[0];
            String airshipReg = airshipInfo[1];
            String airshipType = airshipInfo[2];

            Airship airship = new Airship (airshipName, airshipReg, airshipType);
            addAirship (airship);

            try (Scanner scanner = new Scanner (curFile)) {
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] wizardInfo = line.split(",");

                    String wizardName = wizardInfo[0];
                    String wizardRole = wizardInfo[1];
                    String wizardRank = wizardInfo[2];
                    String wizardSpecies = wizardInfo[3];
                    String wizardAssignment = airshipReg;

                    Wizard wizard = new Wizard (wizardName, wizardRole, wizardRank, wizardSpecies, wizardAssignment);
                    airship.addWizard(wizard);
                }
            }

            catch (Exception e) {
                System.out.println ("An error occurred");
            }

        }
    }

    @Override
    public String toString () {
        String heading = "----------------------------\nCouncil of Wizards Fleet\n------------------------------\n";

        for (Airship airship : airships) {
            heading += airship.toString();
        }

        return heading;

    }

}

