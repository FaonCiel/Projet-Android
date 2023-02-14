package fr.upjv.projet;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LivreHolder extends RecyclerView.ViewHolder {

    private TextView textView_Titre;
    private TextView textView_Auteur;
    private TextView textView_Editeur;
    private TextView textView_Pages;
    private TextView textView_Prix;

    public LivreHolder(@NonNull View itemView) {
        super(itemView);
    textView_Titre = itemView.findViewById(R.id.id_textview_titre);
    textView_Auteur = itemView.findViewById(R.id.id_textview_auteur);
    textView_Editeur = itemView.findViewById(R.id.id_textview_editeur);
    textView_Prix = itemView.findViewById(R.id.id_textview_prix);
    textView_Pages = itemView.findViewById(R.id.id_textview_page);

    }
    public void mettreAjourLigne(Livre unLivre) {
        textView_Titre.setText(unLivre.getTitre());
        textView_Auteur.setText(unLivre.getAuteur());
        textView_Editeur.setText(unLivre.getEditeur());
        textView_Prix.setText(unLivre.getPrix());
        textView_Pages.setText(unLivre.getPages());
    }

}
