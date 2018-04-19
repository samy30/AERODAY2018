package com.example.user.aeroday2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class joueurAerochallenge extends AppCompatActivity {

    Spinner spinner ;
    Button commencer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur_aerochallenge);
        spinner = (Spinner) findViewById(R.id.spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.players_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        commencer=(Button)findViewById(R.id.commencer2);
        commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(joueurAerochallenge.this,AeroChallenge.class);
                intent.putExtra("joueur",spinner.getSelectedItem().toString());
                startActivity(intent);

            }
        });
    }
}
