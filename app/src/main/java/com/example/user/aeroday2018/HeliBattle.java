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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class HeliBattle extends AppCompatActivity {

    public static final String somme="";
    public boolean[] topass = new boolean[41] ;
    SharedPreferences prefs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getApplicationContext().getSharedPreferences("preferencename", MODE_PRIVATE);
        setContentView(R.layout.activity_heli_battle);
        ScrollView myScrollView = (ScrollView)findViewById(R.id.scroll);
        LinearLayout myLayout =(LinearLayout)findViewById(R.id.layout0);
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
        if(prefs.contains("results_size")) {
            topass = loadArray("results", getApplicationContext());
       for(int i=0;i<topass.length;i++) {


            if (topass[i]) myTable.get(i).setChecked(true);
            else myTable.get(i).setChecked(false);
        }
        }



        myTable.get(5).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                myTable.get(4).setChecked(false);
            }
        });

          myTable.get(4).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                  if(isChecked)
                  myTable.get(5).setChecked(false);
              }
          });


          myTable.get(7).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                  if(isChecked){
                      myTable.get(8).setChecked(false);
                      myTable.get(9).setChecked(false);
                      myTable.get(10).setChecked(false);
                      myTable.get(11).setChecked(false);

                  }
              }
          });
        myTable.get(8).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(7).setChecked(false);
                    myTable.get(9).setChecked(false);
                    myTable.get(10).setChecked(false);
                    myTable.get(11).setChecked(false);

                }
            }
        });

        myTable.get(9).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(8).setChecked(false);
                    myTable.get(7).setChecked(false);
                    myTable.get(10).setChecked(false);
                    myTable.get(11).setChecked(false);

                }
            }
        });

        myTable.get(10).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(8).setChecked(false);
                    myTable.get(9).setChecked(false);
                    myTable.get(7).setChecked(false);
                    myTable.get(11).setChecked(false);

                }
            }
        });

        myTable.get(11).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(8).setChecked(false);
                    myTable.get(9).setChecked(false);
                    myTable.get(10).setChecked(false);
                    myTable.get(7).setChecked(false);

                }
            }
        });


        myTable.get(22).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(23).setChecked(false);
            }
        });

        myTable.get(23).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(22).setChecked(false);
            }
        });


        myTable.get(16).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(17).setChecked(false);
            }
        });

        myTable.get(17).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    myTable.get(16).setChecked(false);
            }
        });


        myTable.get(24).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(25).setChecked(false);
                    myTable.get(26).setChecked(false);
                    myTable.get(27).setChecked(false);
                }
            }
        });

        myTable.get(25).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(24).setChecked(false);
                    myTable.get(26).setChecked(false);
                    myTable.get(27).setChecked(false);
                }
            }
        });
        myTable.get(26).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(25).setChecked(false);
                    myTable.get(24).setChecked(false);
                    myTable.get(27).setChecked(false);
                }
            }
        });
        myTable.get(27).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    myTable.get(25).setChecked(false);
                    myTable.get(26).setChecked(false);
                    myTable.get(24).setChecked(false);
                }
            }
        });




        Button myButton = (Button)findViewById(R.id.button6);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum=0 ;
                if (myTable.get(0).isChecked()) sum+=10;
                if (myTable.get(1).isChecked()) sum+=10;
                if (myTable.get(2).isChecked()) sum+=10;
                if (myTable.get(3).isChecked()) sum+=5;
                if (myTable.get(4).isChecked()) sum+=5;
                if (myTable.get(5).isChecked()) sum+=15;
                if (myTable.get(6).isChecked()) sum-=3;
                if (myTable.get(7).isChecked()) sum+=5;
                if (myTable.get(8).isChecked()) sum+=10;
                if (myTable.get(9).isChecked()) sum+=15;
                if (myTable.get(10).isChecked()) sum+=20;
                if (myTable.get(11).isChecked()) sum+=25;
                if (myTable.get(12).isChecked()) sum-=3;
                if (myTable.get(13).isChecked()) sum-=3;
                if (myTable.get(14).isChecked()) sum+=10;
                if (myTable.get(15).isChecked()) sum-=5;
                if (myTable.get(16).isChecked()) sum+=15;
                if (myTable.get(17).isChecked()) sum+=7;
                if (myTable.get(18).isChecked()) sum-=3;
                if (myTable.get(19).isChecked()) sum-=3;
                if (myTable.get(20).isChecked()) sum-=3;
                if (myTable.get(21).isChecked()) sum-=5;
                if (myTable.get(22).isChecked()) sum+=5;
                if (myTable.get(23).isChecked()) sum+=15;
                if (myTable.get(24).isChecked()) sum+=5;
                if (myTable.get(25).isChecked()) sum+=10;
                if (myTable.get(26).isChecked()) sum+=15;
                if (myTable.get(27).isChecked()) sum+=20;
                if (myTable.get(28).isChecked()) sum+=5;
                if (myTable.get(29).isChecked()) sum+=5;
                if (myTable.get(30).isChecked()) sum-=10;
                if (myTable.get(31).isChecked()) sum-=2;
                if (myTable.get(32).isChecked()) sum-=2;
                if (myTable.get(33).isChecked()) sum-=2;
                if (myTable.get(34).isChecked()) sum-=2;
                if (myTable.get(35).isChecked()) sum-=2;
                if (myTable.get(36).isChecked()) sum-=5;
                if (myTable.get(37).isChecked()) sum-=5;
                if (myTable.get(38).isChecked()) sum-=5;
                if (myTable.get(39).isChecked()) sum-=7;
                if (myTable.get(40).isChecked()) sum-=10;

                for(int i=0;i<myTable.size();i++){
                    if (myTable.get(i).isChecked()) topass[i]=true;
                    else topass[i]=false;

                }
                storeArray(topass,"results",getApplicationContext());



                Intent myIntent = new Intent(HeliBattle.this,resultat.class);


                myIntent.putExtra(somme,sum);
                myIntent.putExtra("details",topass);
                startActivity(myIntent);







            }
        });
    }

    public boolean storeArray(boolean[] array, String arrayName, Context mContext) {

        //prefs = mContext.getSharedPreferences("preferencename", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);

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
