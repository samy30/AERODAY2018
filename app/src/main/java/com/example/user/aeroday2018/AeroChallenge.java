package com.example.user.aeroday2018;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class AeroChallenge extends AppCompatActivity {

    public static final String somme="";
    public boolean[] topass = new boolean[43] ;
    SharedPreferences prefs ;
    Intent in ;
    String joueur ;
    Button coll ;
    int nbrecollision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getApplicationContext().getSharedPreferences("preferencename", MODE_PRIVATE);
        setContentView(R.layout.activity_aero_challenge);
        in=getIntent();
        joueur = in.getStringExtra("joueur");
        ScrollView myScrollView = (ScrollView)findViewById(R.id.scroll);
        LinearLayout myLayout =(LinearLayout)findViewById(R.id.layout0);
        final EditText duree=(EditText)findViewById(R.id.duree);
        final EditText collision=(EditText) findViewById(R.id.collision);
        final ArrayList<CheckBox> myTable = new ArrayList<CheckBox>();
        myTable.add((CheckBox)findViewById(R.id.condition1));
        myTable.add((CheckBox)findViewById(R.id.condition2));
        myTable.add((CheckBox)findViewById(R.id.condition3));
        myTable.add((CheckBox)findViewById(R.id.condition4));
        myTable.add((CheckBox)findViewById(R.id.condition5));
        myTable.add((CheckBox)findViewById(R.id.condition6));
        myTable.add((CheckBox)findViewById(R.id.condition7));
        myTable.add((CheckBox)findViewById(R.id.condition8));
        myTable.add((CheckBox)findViewById(R.id.condition9));
        myTable.add((CheckBox)findViewById(R.id.condition10));
        myTable.add((CheckBox)findViewById(R.id.condition11));
        myTable.add((CheckBox)findViewById(R.id.condition12));
        myTable.add((CheckBox)findViewById(R.id.condition13));
        myTable.add((CheckBox)findViewById(R.id.condition14));
        myTable.add((CheckBox)findViewById(R.id.condition15));
        myTable.add((CheckBox)findViewById(R.id.condition16));
        myTable.add((CheckBox)findViewById(R.id.condition17));
        myTable.add((CheckBox)findViewById(R.id.condition18));
        myTable.add((CheckBox)findViewById(R.id.condition19));
        myTable.add((CheckBox)findViewById(R.id.condition20));
        myTable.add((CheckBox)findViewById(R.id.condition21));
        myTable.add((CheckBox)findViewById(R.id.condition22));
        myTable.add((CheckBox)findViewById(R.id.condition23));
        myTable.add((CheckBox)findViewById(R.id.condition24));
        myTable.add((CheckBox)findViewById(R.id.condition25));
        myTable.add((CheckBox)findViewById(R.id.condition26));
        myTable.add((CheckBox)findViewById(R.id.condition27));
        myTable.add((CheckBox)findViewById(R.id.condition28));
        myTable.add((CheckBox)findViewById(R.id.condition29));
        myTable.add((CheckBox)findViewById(R.id.condition30));
        myTable.add((CheckBox)findViewById(R.id.condition31));
        myTable.add((CheckBox)findViewById(R.id.condition32));
        myTable.add((CheckBox)findViewById(R.id.condition33));
        myTable.add((CheckBox)findViewById(R.id.condition34));
        myTable.add((CheckBox)findViewById(R.id.condition35));
        myTable.add((CheckBox)findViewById(R.id.condition36));
        myTable.add((CheckBox)findViewById(R.id.condition37));
        myTable.add((CheckBox)findViewById(R.id.condition38));
        myTable.add((CheckBox)findViewById(R.id.condition39));
        myTable.add((CheckBox)findViewById(R.id.condition40));
        myTable.add((CheckBox)findViewById(R.id.condition41));
        myTable.add((CheckBox)findViewById(R.id.condition42));
        myTable.add((CheckBox)findViewById(R.id.condition43));

        if(prefs.contains("results2"+joueur+"_size")) {
            topass = loadArray("results2"+joueur, getApplicationContext());
            duree.setText(prefs.getString("duree",""));
           nbrecollision=prefs.getInt("collision",0);

         Integer a=nbrecollision;
            collision.setText(a.toString());
            for(int i=0;i<topass.length;i++) {


                if (topass[i]) myTable.get(i).setChecked(true);
                else myTable.get(i).setChecked(false);
            }
        }

        if(!myTable.get(4).isChecked()){
            for(int i=5;i<myTable.size()-3;i++){
                myTable.get(i).setClickable(false);
            }

        }


        myTable.get(0).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {myTable.get(1).setChecked(false);
                    myTable.get(2).setChecked(false);}
            }
        });

        myTable.get(1).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {myTable.get(0).setChecked(false);
                myTable.get(2).setChecked(false);}
            }
        });

        myTable.get(2).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {myTable.get(0).setChecked(false);
                myTable.get(1).setChecked(false);}
            }
        });

        myTable.get(4).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(!isChecked){
                    for(int i=5;i<8;i++){
                        myTable.get(i).setChecked(false);
                        myTable.get(i).setClickable(false);
                    }
                    myTable.get(10).setChecked(false);
                    myTable.get(10).setClickable(false);

                    for(int i=15;i<8;i++){
                        myTable.get(i).setChecked(false);
                        myTable.get(i).setClickable(false);
                    }
                }
                if(isChecked){
                    for(int i=5;i<8;i++){
                        myTable.get(i).setClickable(true);
                    }
                    myTable.get(10).setClickable(true);

                    for(int i=15;i<8;i++){
                        myTable.get(i).setClickable(true);
                    }
                }
            }
        });

        myTable.get(7).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(10).setChecked(false);
                myTable.get(11).setClickable(false);
                myTable.get(12).setClickable(false);
                myTable.get(13).setClickable(false);
                myTable.get(14).setClickable(false);
                myTable.get(11).setChecked(false);
                myTable.get(12).setChecked(false);
                myTable.get(13).setChecked(false);
                myTable.get(14).setChecked(false);
                myTable.get(8).setClickable(true);
                myTable.get(9).setClickable(true);}

                if(!isChecked){
                    myTable.get(8).setClickable(false);
                    myTable.get(9).setClickable(false);
                }

            }
        });

        myTable.get(10).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(7).setChecked(false);
                myTable.get(8).setClickable(false);
                myTable.get(9).setClickable(false);
                myTable.get(8).setChecked(false);
                myTable.get(9).setChecked(false);
                myTable.get(11).setClickable(true);
                myTable.get(12).setClickable(true);
                myTable.get(13).setClickable(true);
                myTable.get(14).setClickable(true);}

                if(!isChecked){
                    myTable.get(11).setClickable(false);
                    myTable.get(12).setClickable(false);
                    myTable.get(13).setClickable(false);
                    myTable.get(14).setClickable(false);

                }
            }
        });

        myTable.get(15).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(16).setChecked(false);
                myTable.get(17).setChecked(false);
                myTable.get(18).setChecked(false);}
            }
        });
        myTable.get(16).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(15).setChecked(false);
                myTable.get(17).setChecked(false);
                myTable.get(18).setChecked(false);}
            }
        });
        myTable.get(17).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(15).setChecked(false);
                myTable.get(16).setChecked(false);
                myTable.get(18).setChecked(false);}
            }
        });
        myTable.get(18).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {  myTable.get(15).setChecked(false);
                myTable.get(16).setChecked(false);
                myTable.get(17).setChecked(false);}
            }
        });

        myTable.get(20).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(21).setChecked(false);
                myTable.get(22).setChecked(false);}
            }
        });
        myTable.get(21).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {   myTable.get(20).setChecked(false);
                myTable.get(22).setChecked(false);}
            }
        });
        myTable.get(22).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {myTable.get(20).setChecked(false);
                myTable.get(21).setChecked(false);}
            }
        });

        myTable.get(26).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(25).setChecked(false);
            }
        });
        myTable.get(25).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(26).setChecked(false);
            }
        });

        myTable.get(29).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(30).setChecked(false);
            }
        });
        myTable.get(30).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(29).setChecked(false);
            }
        });

        myTable.get(31).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(32).setChecked(false);
                myTable.get(33).setChecked(false);}
            }
        });
        myTable.get(32).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(31).setChecked(false);
                myTable.get(33).setChecked(false);}
            }
        });
        myTable.get(33).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(31).setChecked(false);
                myTable.get(32).setChecked(false);}
            }
        });

        myTable.get(35).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(36).setChecked(false);
                myTable.get(37).setChecked(false);
                myTable.get(38).setChecked(false);}
            }
        });
        myTable.get(36).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(35).setChecked(false);
                myTable.get(37).setChecked(false);
                myTable.get(38).setChecked(false);}
            }
        });
        myTable.get(37).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(35).setChecked(false);
                myTable.get(36).setChecked(false);
                myTable.get(38).setChecked(false);}
            }
        });
        myTable.get(38).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                { myTable.get(35).setChecked(false);
                myTable.get(36).setChecked(false);
                myTable.get(37).setChecked(false);}
            }
        });
        coll =(Button)findViewById(R.id.coll);
        coll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{nbrecollision=Integer.parseInt(collision.getText().toString());}
                catch (Exception e){
                }
                nbrecollision+=1;

                Integer a =nbrecollision;
                //coll.setText(a.toString()+"collisions");
                collision.setText(a.toString());
            }
        });

        Button myButton =(Button)findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int sum=0 ;
                if (myTable.get(0).isChecked()) sum-=20;
                if (myTable.get(1).isChecked()) sum-=50;
                if (myTable.get(2).isChecked()) sum-=70;
                if (myTable.get(3).isChecked()) sum-=10;
                if (myTable.get(4).isChecked()) sum+=5;
                if (myTable.get(5).isChecked()) sum-=3;
                if (myTable.get(6).isChecked()) sum-=3;
                if (myTable.get(8).isChecked()) sum+=15;
                if (myTable.get(9).isChecked()) sum-=5;

                if (myTable.get(11).isChecked()) sum+=50;
                if (myTable.get(12).isChecked()) sum-=5;
                if (myTable.get(13).isChecked()) sum-=5;
                if (myTable.get(14).isChecked()) sum-=10;
                if (myTable.get(15).isChecked()) sum+=10;
                if (myTable.get(16).isChecked()) sum+=5;
                if (myTable.get(17).isChecked()) sum+=30;
                if (myTable.get(18).isChecked()) sum+=15;
                if (myTable.get(19).isChecked()) sum-=5;
                if (myTable.get(20).isChecked()) sum+=30;
                if (myTable.get(21).isChecked()) sum+=15;
                if (myTable.get(22).isChecked()) sum-=5;
                if (myTable.get(23).isChecked()) sum-=5;
                if (myTable.get(24).isChecked()) sum-=10;
                if (myTable.get(25).isChecked()) sum+=30;
                if (myTable.get(26).isChecked()) sum+=15;
                if (myTable.get(27).isChecked()) sum-=5;
                if (myTable.get(28).isChecked()) sum-=10;
                if (myTable.get(29).isChecked()) sum+=30;
                if (myTable.get(30).isChecked()) sum-=10;
                if (myTable.get(31).isChecked()) sum+=20;
                if (myTable.get(32).isChecked()) sum+=30;
                if (myTable.get(33).isChecked()) sum+=50;
                if (myTable.get(34).isChecked()) sum-=5;
                if (myTable.get(35).isChecked()) sum+=30;
                if (myTable.get(36).isChecked()) sum+=15;
                if (myTable.get(37).isChecked()) sum+=5;
                if (myTable.get(38).isChecked()) sum-=5;
                if (myTable.get(39).isChecked()) sum-=5;
                if (myTable.get(40).isChecked()) sum+=70;
                if (myTable.get(41).isChecked()) sum+=20;
                if (myTable.get(42).isChecked()) sum+=10;

                String dures=String.valueOf(duree.getText());
                int dure=0;
                try {dure =Integer.parseInt(dures);
                if(dure<120) sum+=60;
                else sum +=(60-Math.round((dure-120)/2));}
                catch (Exception e){};
                String collisions=String.valueOf(collision.getText());
               //try{nbrecollision = Integer.parseInt(collisions);
                sum-=5*nbrecollision;
               //catch (Exception e){};

                for(int i=0;i<myTable.size();i++){
                    if (myTable.get(i).isChecked()) topass[i]=true;
                    else topass[i]=false;
                }

                storeArray(topass,"results2"+joueur,dures,nbrecollision,getApplicationContext());
                Intent myIntent = new Intent(AeroChallenge.this,resultat2.class);


                myIntent.putExtra(somme,sum);
                myIntent.putExtra("details",topass);
                myIntent.putExtra("duree",dure);
                myIntent.putExtra("collision",nbrecollision);
                myIntent.putExtra("joueur",joueur);
                startActivity(myIntent);
            }
        });
    }

    public boolean storeArray(boolean[] array, String arrayName,String x,int y, Context mContext) {

        //prefs = mContext.getSharedPreferences("preferencename", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);
        editor.putString("duree",x);
        editor.putInt("collision",y);
        for(int i=0;i<array.length;i++)
            editor.putBoolean(arrayName + "_" + i, array[i]);

        return editor.commit();
    }

    public boolean[] loadArray(String arrayName, Context mContext) {


        int size = prefs.getInt(arrayName + "_size", 0);
        boolean array[] = new boolean[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getBoolean(arrayName + "_" + i, false);

        return array;
    }
}
