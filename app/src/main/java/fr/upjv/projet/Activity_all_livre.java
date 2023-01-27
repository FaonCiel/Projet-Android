package fr.upjv.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Activity_all_livre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_livre);
        TextView textView = findViewById(R.id.textView4);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.clearComposingText();
        getfromtheDB(textView);

    }
    public void getfromtheDB (TextView textView) {
        ServeurSQLite serveurSQLite = new ServeurSQLite(this);
        List<Livre> livres = serveurSQLite.getLivres();
        if (livres.isEmpty()) {
            textView.setText("La base de donnée est vide");
        }
        else {
            for (Livre livre : livres) {
                textView.append(livre.toString());
            }
        }

    }
    public void clearDB(View view) {
        TextView textView = findViewById(R.id.textView4);
        ServeurSQLite serveurSQLite = new ServeurSQLite(this);
        serveurSQLite.clearDB();
        textView.setText("La base de donnée a été vidé");
    }
}