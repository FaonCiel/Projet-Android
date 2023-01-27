package fr.upjv.projet;

public class Livre {

    private String titre;
    private String Auteur;
    private String pages;
    private String editeur;
    private String prix;

    public Livre(String titre, String Auteur, String pages, String editeur, String prix) {
        this.titre = titre;
        this.Auteur = Auteur;
        this.pages = pages;
        this.editeur = editeur;
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", Auteur='" + Auteur + '\'' +
                ", pages='" + pages + '\'' +
                ", editeur='" + editeur + '\'' +
                ", prix='" + prix + '\'' +
                '}';
    }
}
