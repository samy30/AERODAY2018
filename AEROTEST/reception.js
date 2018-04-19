//window.alert("hello every body");
var tex = document.getElementById("tex");
var texti=document.getElementById("tit") ;
var e = document.getElementById("joueur");
var f = document.getElementById("challenge");


function affiche(){
    var joueur = e.options[e.selectedIndex].value;
    var challenge = f.options[f.selectedIndex].value;
    if(challenge=="Helibattle") {
texti.innerText="Helibattle";
        var firebaseref1 = firebase.database().ref();
        firebaseref1.child("scoresHelibattle").child(joueur).child("details").on('value', function (datasnapshot) {
            if(datasnapshot.val())
            tex.innerHTML = datasnapshot.val();
            else tex.innerText="pas encore enregistrée";
        });
    }

    else {
        texti.innerText="AeroChalenge";
        var firebaseref2 = firebase.database().ref();
        firebaseref2.child("scoresAerochallenge").child(joueur).child("details").on('value', function (datasnapshot) {
            if(datasnapshot.val())
                tex.innerHTML = datasnapshot.val();
            else tex.innerText="pas encore enregistrée";
        });
    }

  }