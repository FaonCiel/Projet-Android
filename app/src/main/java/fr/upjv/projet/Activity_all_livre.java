package fr.upjv.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_all_livre extends AppCompatActivity {

    private List<Livre> leslivres;
    private LivreAdapter monAdapter;
    private RecyclerView monRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_livre);

        monRecyclerView = findViewById(R.id.recyclerView);

        leslivres = new ArrayList<>();
        monAdapter = new LivreAdapter(leslivres);


        monRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        monRecyclerView.setAdapter(monAdapter);


        ServeurSQLite serveurSQLite = new ServeurSQLite(this);
       // leslivres.addAll(serveurSQLite.getLivres());
        leslivres.addAll(serveurSQLite.getLivres());
        monAdapter = new LivreAdapter(leslivres);

    }

    public void clear(){
        monRecyclerView.removeAllViews();
        ServeurSQLite serveurSQLite = new ServeurSQLite(this);
        serveurSQLite.clearDB();
    }


}