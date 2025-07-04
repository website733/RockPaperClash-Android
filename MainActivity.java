package com.kieranstudio.rockpaperclash;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    String[] options = {"Pierre", "Feuille", "Ciseaux"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.resultText);
    }

    public void onChoiceClicked(View view) {
        Button userBtn = (Button) view;
        String userChoice = userBtn.getText().toString();
        String botChoice = options[new Random().nextInt(3)];

        String result = "Vous : " + userChoice + "\nOrdinateur : " + botChoice + "\n";

        if (userChoice.equals(botChoice)) {
            result += "Égalité !";
        } else if (
            (userChoice.equals("Pierre") && botChoice.equals("Ciseaux")) ||
            (userChoice.equals("Feuille") && botChoice.equals("Pierre")) ||
            (userChoice.equals("Ciseaux") && botChoice.equals("Feuille"))
        ) {
            result += "Vous gagnez !";
        } else {
            result += "Vous perdez...";
        }

        resultText.setText(result);
    }
}
