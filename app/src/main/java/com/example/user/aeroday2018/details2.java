package com.example.user.aeroday2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class details2 extends AppCompatActivity {
    String epreuve1 = "\nPoints de pré-homologation :\n" ;
    String epreuve2 = "\nQuitter la zone de départ :\n" ;
    String epreuve3 = "\nTraverser l'atmosphère terrestre :\n" ;
    String epreuve4 = "\nSe stabiliser au-dessus de la station d'éspace internationale :\n" ;
    String epreuve5 = "\nTourner autour de la planète VENUS:\n" ;
    String epreuve6 = "\nEffectuer un mouvement de ZIGZAG entre VENUS,MARS et JUPITER:\n" ;
    String epreuve7 = "\nTraverser le trou noir :\n" ;
    String epreuve8 = "\nTourner autour des anneaux de la planète SATURNE :\n" ;
    String epreuve9 = "\nAtterrir sur la zone d'arrivée:la planète SATURNE :\n" ;
    String epreuve10 = "\nRemarques :\n" ;
    String scori ="Score :";

    String cont1="",cont2="",cont3="",cont4="",cont5="",cont6="",cont7="",cont8="",cont9="",cont10="";
    String tosend="";
    Button Bl ;
    DatabaseReference myRef ;
    String resultat ;
    final String Newligne=System.getProperty("line.separator");
    int sum;
    int collision ;
    int duree ;
    TextView resultat2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        myRef = FirebaseDatabase.getInstance().getReference("scoresAerochallenge");
        Bl=(Button)findViewById(R.id.bluetooth);
        resultat2 =(TextView)findViewById(R.id.score);
        Intent i =getIntent();
        final boolean[] details = i.getBooleanArrayExtra("details");
        duree=i.getIntExtra("duree",0);
        sum =i.getIntExtra("somme",0);
        int r;
        Integer duree2=duree;



        if(duree<180) r=36;
        else r=(36-Math.round((duree-180)/5));
        Integer r2=r;
        collision=i.getIntExtra("collision",0);
        Integer collision2=collision;
        Integer collision3=collision*5;
        if (details[0]) cont1+=("Diamétre entre 250mm et 300mm  : -20 points"+Newligne) ;
        if (details[1]) cont1+=("Diamétre entre 150mm et 250mm  : -50 points"+Newligne) ;
        if (details[2]) cont1+=("Diamétre inférieur à 150mm  : -70 points"+Newligne) ;
        if (details[3]) cont1+=("Hélice non protégée  : -10 points"+Newligne) ;
        if (details[4]) cont2+=("quitter la zone de départ  : +5 points"+Newligne) ;
        if (details[5]) cont2+=("Echec du premier essai du vol  : -3 points"+Newligne) ;
        if (details[6]) cont2+=("Toucher un élément du décor : -3 points"+Newligne) ;
        if (details[7]) cont3+=("premier chemain:Support sans ballons :"+Newligne) ;
        if (details[8]) cont3+=("Traverser le support : +15 points"+Newligne) ;
        if (details[9]) cont3+=("Toucher le support : -5 points"+Newligne) ;
        if (details[10]) cont3+=("Deuxiéme chemain: support avec des ballons :"+Newligne);
        if (details[11]) cont3+=("Traverser le support : +50 points"+Newligne) ;
        if (details[12]) cont3+=("Toucher le support : -5 points"+Newligne) ;
        if (details[13]) cont3+=("Toucher un ballon : -5 points"+Newligne) ;
        if (details[14]) cont3+=("Percer un ballon : -10 points"+Newligne) ;
        if (details[15]) cont4+=("Stabilité pendant 7 sec au-dessus de la station d'éspace internationale à une hauteur dépassant 40cm : +10 points"+Newligne) ;
        if (details[16]) cont4+=("Stabilité pendant 5 sec au-dessus de la station d'éspace internationale à une hauteur dépassant 40cm : +5 points"+Newligne) ;
        if (details[17]) cont4+=("Stabilité pendant 7 sec au-dessus de la station d'éspace internationale à une hauteur ne dépassant pas 40cm : +30 points"+Newligne) ;
        if (details[18]) cont4+=("Stabilité pendant 5 sec au-dessus de la station d'éspace internationale à une hauteur ne dépassant pas 40cm : +15 points"+Newligne) ;
        if (details[19]) cont4+=("Toucher la station d'espace internationale : -5 points"+Newligne) ;
        if (details[20]) cont5+=("Faire deux tours : +30 points"+Newligne) ;
        if (details[21]) cont5+=("Faire un seul tour : +15 points"+Newligne) ;
        if (details[22]) cont5+=("Aucun tour : -5 points"+Newligne) ;
        if (details[23]) cont5+=("Toucher la planette VENUS : -5 points"+Newligne) ;
        if (details[24]) cont5+=("Dépasser la hauteur limite(900mm) : -10 points"+Newligne) ;
        if (details[25]) cont6+=("Passer entre 3 planétes : +30 points"+Newligne) ;
        if (details[26]) cont6+=("Passer entre deux planétes : +15 points"+Newligne) ;
        if (details[27]) cont6+=("Toucher une planéte : -5 points"+Newligne) ;
        if (details[28]) cont6+=("Dépasser la hauteur limite(900mm) : -10 points"+Newligne) ;
        if (details[29]) cont7+=("Le drone maintient son équilibre en survolant le ventilateur : +30 points"+Newligne) ;
        if (details[30]) cont7+=("Le drone perd son équilibre : -10 points"+Newligne) ;
        if (details[31]) cont7+=("Le drone traverse seulement le premier cerceau et sort latéralement : +20 points"+Newligne) ;
        if (details[32]) cont7+=("Le drone traverse les deux premiers cerceaux et sort latéralement avant d'atteindre le dernier : +30 points"+Newligne) ;
        if (details[33]) cont7+=("Le drone réussit à traverser les trois cerceaux : +50 points"+Newligne) ;
        if (details[34]) cont7+=("Toucher un élément du trou noir : -5 points"+Newligne) ;
        if (details[35]) cont8+=("Faire 3 tours : +30 points"+Newligne) ;
        if (details[36]) cont8+=("Faire 2 tours : +15 points"+Newligne) ;
        if (details[37]) cont8+=("Faire un tour : +5 points"+Newligne) ;
        if (details[38]) cont8+=("Aucun tour : -5 points"+Newligne) ;
        if (details[39]) cont8+=("Toucher les anneaux ou la planéte en tournant : -5 points"+Newligne) ;
        cont9+=("Durée : "+duree2.toString()+" minutes : +"+r2.toString()+" points"+Newligne);
        if (details[40]) cont10+=("Le drone a été assemblé par le participant : +70 points"+Newligne) ;
        if (details[40]) cont10+=("Le drone a été obtenu par une impression 3D : +20 points"+Newligne) ;
        if (details[40]) cont10+=("Poster technique : +10 points"+Newligne) ;
        cont10+=(collision2.toString()+" collisions avec des objets différents de la map : +"+collision3.toString()+" points"+Newligne);

        tosend=epreuve1+cont1+epreuve2+cont2+epreuve3+cont3+epreuve4+cont4+epreuve5+cont5+epreuve6+cont6+epreuve7+cont7+epreuve8+cont8+epreuve9+cont9+epreuve10+cont10 ;

        SpannableStringBuilder str = new SpannableStringBuilder(tosend);
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

        TextView myText =(TextView)findViewById(R.id.myText);
        resultat=sorti(details);
        myText.setText(str);
        Integer s=sum;
        resultat2.setText(scori+s.toString());
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
        String id =myRef.push().getKey();
        Score2 mScore =new Score2(resultat,sum,collision,duree);
        myRef.child(id).setValue(mScore);
        Toast.makeText(details2.this,"score added", Toast.LENGTH_LONG).show();
    }
}
