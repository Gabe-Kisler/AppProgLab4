package edu.utsa.cs3443.wsj923_lab4;

import android.content.res.AssetManager;
import android.os.Bundle;
import edu.utsa.cs3443.wsj923_lab4.model.Wizard;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.*;
import java.io.*;
import java.util.*;
import android.view.*;

public class AirshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airship);

        String registryToPass;
        String registry = getIntent().getStringExtra("registry");
        String[] registryParts = registry.split(" ");
        registryToPass = registryParts[1];
        Log.e ("registry", "registry : " + registryToPass.trim());

        TextView userRegistry = findViewById(R.id.registry_name);
        userRegistry.setText(registryToPass.trim());

        LinearLayout wizardListLayout = findViewById(R.id.wizard_list);

        ArrayList<Wizard> wizards = loadWizards(registryToPass);

        for (Wizard wizard : wizards) {

            LinearLayout wizardLayout = new LinearLayout(this);
            wizardLayout.setOrientation(LinearLayout.HORIZONTAL);
            wizardLayout.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            wizardLayout.setPadding(20,20,20,20);
            wizardLayout.setGravity(Gravity.CENTER);

            ImageView wizardImage = new ImageView(this);
            wizardImage.setLayoutParams (new LinearLayout.LayoutParams (
                    275,
                    275));
            int imageResource = getResources().getIdentifier(wizard.getName().toLowerCase(), "drawable", getPackageName());
            wizardImage.setImageResource(imageResource);

            if (imageResource == 0) {
                Log.e ("Airship", "img not found for : " + wizard.getName());
            }
            wizardLayout.addView(wizardImage);

            LinearLayout textLayout = new LinearLayout(this);
            textLayout.setOrientation(LinearLayout.VERTICAL);
            textLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1));

            TextView wizardRank = new TextView(this);
            wizardRank.setText(wizard.getRank());
            wizardRank.setTextSize(30);
            textLayout.addView(wizardRank);

            TextView wizardName = new TextView (this);
            wizardName.setText(wizard.getName());
            wizardName.setTextSize(20);
            textLayout.addView(wizardName);

            wizardLayout.addView(textLayout);

            wizardListLayout.addView(wizardLayout);
        }

    }

    public ArrayList<Wizard> loadWizards(String registry) {
        ArrayList<Wizard> wizards = new ArrayList<>();
        AssetManager assets = getAssets();

        try (InputStream i = assets.open("wizards.csv")) {
            Scanner scanner = new Scanner(i);

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(",");

                String name = splitLine[0];
                String role = splitLine[1];
                String rank = splitLine[2];
                String species = splitLine[3];
                String assignment = splitLine[4];

                if (assignment.equals(registry)) {
                    Wizard wizard = new Wizard(name, role, rank, species, assignment);
                    wizards.add(wizard);

                }
            }
        }catch(IOException e){

        }

        return wizards;
    }
}