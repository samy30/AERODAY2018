package com.example.user.aeroday2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class resultat2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat2);
        LinearLayout myLayout = (LinearLayout)findViewById(R.id.layout0);

        final TextView result=(TextView)findViewById(R.id.result);
        Button myDetails =(Button)findViewById(R.id.details);

        Intent i = getIntent();
        int somme = i.getIntExtra(HeliBattle.somme,0);
        result.setText(String.valueOf(somme));
        final boolean[] details = i.getBooleanArrayExtra("details");
        final int duree =i.getIntExtra("duree",0);
        final int collision=i.getIntExtra("collision",0);


        myDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(resultat2.this,details2.class);
                myIntent.putExtra("details",details);
                myIntent.putExtra("duree",duree);
                myIntent.putExtra("collision",collision);
                startActivity(myIntent);
            }
        });
    }
}