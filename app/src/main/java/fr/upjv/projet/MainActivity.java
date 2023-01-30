package fr.upjv.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView3);
        //addtotheDB(textView);
        //getfromtheDB(textView);

    }
    public void lancer_activitee_saisie(View view) {

        Intent intent = new Intent(this, Activity_ajouter_un_livre.class);
        startActivity(intent);
    }

    public void getfromtheDB (View view) {
        ServeurSQLite serveurSQLite = new ServeurSQLite(this);

        List<Livre> livres = serveurSQLite.getLivres();
        TextView textView = findViewById(R.id.textView3);
        textView.clearComposingText();
        for (Livre livre : livres) {
            textView.append(livre.toString());
        }
    }
    public void addtotheDB (TextView textView) {

            Intent intent = getIntent();
            if (intent == null) {
                textView.setText("Pas de livre");
            }
            else {
                String titre = intent.getStringExtra("titre");
                String auteur = intent.getStringExtra("auteur");
                String pages = intent.getStringExtra("pages");
                String editeur = intent.getStringExtra("editeur");
                String prix = intent.getStringExtra("prix");

                Livre livre = new Livre(titre, auteur, pages, editeur, prix);

                ServeurSQLite serveurSQLite = new ServeurSQLite(this);
                serveurSQLite.ajouter_livre(livre);

            }
    }

    public void lancer_activitee_afficher(View view) {
        Intent intent = new Intent(this, Activity_all_livre.class);
        startActivity(intent);
    }

}
