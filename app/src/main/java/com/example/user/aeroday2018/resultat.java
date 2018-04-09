package com.example.user.aeroday2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        LinearLayout myLayout = (LinearLayout)findViewById(R.id.layout0);

        final TextView result=(TextView)findViewById(R.id.result);
        Button myDetails =(Button)findViewById(R.id.details);

        Intent i = getIntent();
         int somme = i.getIntExtra(HeliBattle.somme,0);
         result.setText(String.valueOf(somme));
        final boolean[] details = i.getBooleanArrayExtra("details");


        myDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(resultat.this,details.class);
                myIntent.putExtra("details",details);
                startActivity(myIntent);
            }
        });
    }
}
