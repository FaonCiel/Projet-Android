package fr.upjv.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView3);

        try {
            Intent intent = getIntent();
            String titre = intent.getStringExtra("titre");
            String auteur = intent.getStringExtra("auteur");
            String pages = intent.getStringExtra("pages");
            String editeur = intent.getStringExtra("editeur");
            String prix = intent.getStringExtra("prix");

            Livre livre = new Livre(titre, auteur, pages, editeur, prix);
            textView.setText(livre.toString());

        } catch (Exception e) {
            textView.setText("Pas de livre");
        }



    }

    public void lancer_activitee_saisie(View view) {

        Intent intent = new Intent(this, Activity_ajouter_un_livre.class);
        startActivity(intent);
    }

    public void lancer_MainActivity(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);






    }
}