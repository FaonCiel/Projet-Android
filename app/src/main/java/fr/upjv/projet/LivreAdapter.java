package fr.upjv.projet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LivreAdapter extends RecyclerView.Adapter<LivreHolder> {
    private List<Livre> lesLivres;

    public LivreAdapter(List<Livre> lesLivres) {
        this.lesLivres = lesLivres;
    }

    @NonNull
    @Override
    public LivreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater monInflater;
        monInflater= LayoutInflater.from(parent.getContext());
        View vue = monInflater.inflate(R.layout.layout_ligne, parent, false);
        return new LivreHolder(vue);
    }

    @Override
    public void onBindViewHolder(@NonNull LivreHolder holder, int position) {
        holder.mettreAjourLigne(lesLivres.get(position));
    }

    @Override
    public int getItemCount() {
        if (lesLivres == null)
            return 0;
        return lesLivres.size();
    }


}
