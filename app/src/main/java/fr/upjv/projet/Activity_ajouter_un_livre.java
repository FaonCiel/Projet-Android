package fr.upjv.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class Activity_ajouter_un_livre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_un_livre);

    }

    public void lancer_MainActivity(View view) {

        EditText titre = findViewById(R.id.editText_Titre);
        EditText auteur = findViewById(R.id.editText_Auteur);
        EditText pages = findViewById(R.id.editText_NbPage);
        EditText editeur = findViewById(R.id.editText_Editeur);
        EditText prix = findViewById(R.id.editText_Prix);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("titre", titre.getText().toString());
        intent.putExtra("auteur", auteur.getText().toString());
        intent.putExtra("pages", pages.getText().toString());
        intent.putExtra("editeur", editeur.getText().toString());
        intent.putExtra("prix", prix.getText().toString());



        startActivity(intent);
    }
}