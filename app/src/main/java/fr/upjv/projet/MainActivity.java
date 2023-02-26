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

       addtotheDB();





    }
    public void lancer_activitee_saisie(View view) {

        Intent intent = new Intent(this, Activity_ajouter_un_livre.class);
        startActivity(intent);
    }
    public void clearDB() {
        ServeurSQLite serveurSQLite = new ServeurSQLite(this);
        serveurSQLite.clearDB();
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
    public void addtotheDB () {

            Intent intent = getIntent();
            if (intent.getStringExtra("titre") == null) {

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
