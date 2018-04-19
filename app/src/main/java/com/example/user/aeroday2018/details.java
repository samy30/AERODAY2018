package com.example.user.aeroday2018;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;


public class details extends AppCompatActivity {

    String epreuve1 = "\nPoints d'homologation :\n" ;
    String epreuve2 = "\nQuitter la zone de départ :\n" ;
    String epreuve3 = "\nPassage par le trou spatial :\n" ;
    String epreuve4 = "\nTourner autour du vaisseau spatial :\n" ;
    String epreuve5 = "\nAtterrissage d'urgence :\n" ;
    String epreuve6 = "\nEviter les tentacules du Kraken :\n" ;
    String epreuve7 = "\nAtterrissage sur les bateaux :\n" ;
    String epreuve8 = "\nSe stabiliser dans la tempète :\n" ;
    String epreuve9 = "\nAtteindre la zone d'arrivée :\n" ;
    String epreuve10 = "\nPénalités :\n" ;
    String scori ="Score du ";
    String joueur ;

    String cont1="",cont2="",cont3="",cont4="",cont5="",cont6="",cont7="",cont8="",cont9="",cont10="";
    String tosend="";
    String resultat ;
    String topc="";
    Button Bl ;
    TextView score ;
    SpannableStringBuilder str ;
    int sum ;
    final String Newligne=System.getProperty("line.separator");
    DatabaseReference myRef ;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myRef = FirebaseDatabase.getInstance().getReference("scoresHelibattle");
        Bl=(Button)findViewById(R.id.bluetooth);score =(TextView)findViewById(R.id.score);
        Intent i =getIntent();
        sum=i.getIntExtra("sum",0);
        joueur = i.getStringExtra("joueur");
        final boolean[] details = i.getBooleanArrayExtra("details");
        if (details[0]) cont1+=("Hélicoptère conçu par l'équipe participante  : +10 points"+Newligne) ;
        if (details[1]) cont1+=("Présentation d'un dossier technique : conception mécanique  : +10 points"+Newligne) ;
        if (details[2]) cont1+=("Présentation d'un dossier technique : conception électronique  : +10 points"+Newligne) ;
        if (details[3]) cont2+=("Quitter la zone de départ  : +5 points"+Newligne) ;
        if (details[4]) cont3+=("Passage par un cerceau  : +5 points"+Newligne) ;
        if (details[5]) cont3+=("Passage par deux cerceaux  : +15 points"+Newligne) ;
        if (details[6]) cont3+=("Toucher un cerceau : -3 points"+Newligne) ;
        if (details[7]) cont4+=("Effectuer un tour : +5 points"+Newligne) ;
        if (details[8]) cont4+=("Effectuer deux tours : +10 points"+Newligne) ;
        if (details[9]) cont4+=("Effectuer trois tours : +15 points"+Newligne) ;
        if (details[10]) cont4+=("Effectuer quatre tours : +20 points"+Newligne);
        if (details[11]) cont4+=("Effectuer cinq tours : +25 points"+Newligne) ;
        if (details[12]) cont4+=("Toucher le vaisseau ou son support : -3 points"+Newligne) ;
        if (details[13]) cont4+=("Toucher le vaisseau ou son support une deuxième fois : -3 points"+Newligne) ;
        if (details[14]) cont5+=("Atterrissage avant la fin du signal d'urgence : +10 points"+Newligne) ;
        if (details[15]) cont5+=("Rater la limite du temps pour effectuer l'atterrissage : -5 points"+Newligne) ;
        if (details[16]) cont6+=("Passer au-dessous d'une tentacule : +15 points"+Newligne) ;
        if (details[17]) cont6+=("Passer au-dessus d'une tentacule : +7 points"+Newligne) ;
        if (details[18]) cont6+=("Toucher un tentacule : -3 points"+Newligne) ;
        if (details[19]) cont6+=("Toucher un tentacule une deuxième fois : -3 points"+Newligne) ;
        if (details[20]) cont6+=("Toucher un tentacule ne troisième fois : -3 points"+Newligne) ;
        if (details[21]) cont6+=("Dépasser la hauteur limite : -5 points"+Newligne) ;
        if (details[22]) cont7+=("Atterrissage sur un bateau : +5 points"+Newligne) ;
        if (details[23]) cont7+=("Atterrissage sur les deux bateaux : +15 points"+Newligne) ;
        if (details[24]) cont8+=("Stabilisation pour 3 secondes : +5 points"+Newligne) ;
        if (details[25]) cont8+=("Stabilisation pour 5 secondes : +10 points"+Newligne) ;
        if (details[26]) cont8+=("Stabilisation pour 7 secondes : +15 points"+Newligne) ;
        if (details[27]) cont8+=("Stabilisation pour 10 secondes : +20 points"+Newligne) ;
        if (details[28]) cont9+=("Lorsque l'hélicoptère se pose sur la zone d'arrivée : +5 points"+Newligne) ;
        if (details[29]) cont9+=("Hélicoptère a arrivé à destination en premier place : +5 points"+Newligne) ;
        if (details[30]) cont10+=("L'hélicoptère a endommagé la maquette : -10 points"+Newligne) ;
        if (details[31]) cont10+=("Hélicoptère touche un élément ou un décor : -2 points"+Newligne) ;
        if (details[32]) cont10+=("Hélicoptère touche un élément ou un décor une deuxième fois : -2 points"+Newligne) ;
        if (details[33]) cont10+=("Hélicoptère touche un élément ou un décor une troisième fois : -2 points"+Newligne) ;
        if (details[34]) cont10+=("Hélicoptère touche un élément ou un décor une quatrième fois : -2 points"+Newligne) ;
        if (details[35]) cont10+=("Hélicoptère touche un élément ou un décor une cinquième fois : -2 points"+Newligne) ;
        if (details[36]) cont10+=("Hélicoptère effectue un atterrissage hors les zones d'atterrissage : -5 points"+Newligne) ;
        if (details[37]) cont10+=("Hélicoptère effectue un atterrissage hors les zones d'atterrissage une deuxiéme fois : -5 points"+Newligne) ;
        if (details[38]) cont10+=("Hélicoptère effectue un atterrissage hors les zones d'atterrissage une troisiéme fois : -5 points"+Newligne) ;
        if (details[39]) cont10+=("Participant a actionné son hélicoptère avant le départ du challenge : -7 points"+Newligne) ;
        if (details[40]) cont10+=("L'hélicoptére a perturbé le jeu de son adversaire : -10 points"+Newligne) ;

        resultat =sorti(details);
        tosend=epreuve1+cont1+epreuve2+cont2+epreuve3+cont3+epreuve4+cont4+epreuve5+cont5+epreuve6+cont6+epreuve7+cont7+epreuve8+cont8+epreuve9+cont9+epreuve10+cont10 ;






            str = new SpannableStringBuilder(tosend);
            int x=0;
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve1.length()+cont1.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve2.length()+cont2.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve3.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve3.length()+cont3.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve4.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve4.length()+cont4.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve5.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve5.length()+cont5.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve6.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve6.length()+cont6.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve7.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve7.length()+cont7.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve8.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve8.length()+cont8.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve9.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            x+=(epreuve9.length()+cont9.length());
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), x, x+epreuve10.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);




            //toshow=str1+cont1+str2+cont2+str3+cont3+str4+cont4+str5+cont5+str6+cont6+str7+cont7+str8+cont8+str9+cont9+str10+cont10 ;

        TextView myText =(TextView)findViewById(R.id.myText);

            myText.setText(str);
            Integer s = sum;
            score.setText(scori+joueur+" : "+s.toString());
            topc="<b>"+scori+joueur+" : "+s.toString()+"</b>"+"<br>"+"<b>"+epreuve1+"</b>"+"<br>"+cont1+"<br>"+"<b>"+epreuve2+"</b>"+"<br>"+cont2+"<b>"+"<b>"+epreuve3+"</b>"+"<br>"+cont3+"<br>"+"<b>"+epreuve4+"</b>"+"<br>"+cont4+"<br>"+"<b>"+epreuve5+"</b>"+"<br>"+cont5+"<br>"+"<b>"+epreuve6+"</b>"+"<br>"+cont6+"<br>"+"<b>"+epreuve7+"</b>"+"<br>"+cont7+"<br>"+"<b>"+epreuve8+"</b>"+"<br>"+cont8+"<br>"+"<b>"+epreuve9+"</b>"+"<br>"+cont9+"<br>"+"<b>"+epreuve10+"</b>"+"<br>"+cont10 ;


            Bl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addScore();
                }
            });


        }

        String sorti(boolean[] boo){
            String resultat="";
            for(int i=0;i<boo.length;i++){
                if(boo[i]) resultat+='t';
                else resultat+='f';
            }
            return (resultat);

        }
        void addScore(){
            //String id =myRef.push().getKey();
            Score mScore =new Score(topc,sum);
            myRef.child(joueur).setValue(mScore);
            Toast.makeText(details.this,"score added", Toast.LENGTH_LONG).show();
        }
}

