package fr.upjv.projet;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

import java.util.ArrayList;
import java.util.List;

public class ServeurSQLite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "livres.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "livres";
    private static final String COLONNE_ID = "id";
    private static final String COLONNE_TITRE = "titre";
    private static final String COLONNE_AUTEUR = "auteur";
    private static final String COLONNE_PAGES = "pages";
    private static final String COLONNE_EDITEUR = "editeur";
    private static final String COLONNE_PRIX = "prix";
    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_NAME + " (" + COLONNE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLONNE_TITRE + " TEXT NOT NULL, " + COLONNE_AUTEUR + " TEXT NOT NULL, " + COLONNE_PAGES + " TEXT NOT NULL, " + COLONNE_EDITEUR + " TEXT NOT NULL, " + COLONNE_PRIX + " TEXT NOT NULL);";
    public ServeurSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME + ";");
        onCreate(db);
    }
    public void ajouter_livre(Livre livre) {
        SQLiteDatabase db = this.getWritableDatabase();
        String requete = "INSERT INTO " + TABLE_NAME + " (" + COLONNE_TITRE + ", " + COLONNE_AUTEUR + ", " + COLONNE_PAGES + ", " + COLONNE_EDITEUR + ", " + COLONNE_PRIX + ") VALUES ('" + livre.getTitre() + "', '" + livre.getAuteur() + "', '" + livre.getPages() + "', '" + livre.getEditeur() + "', '" + livre.getPrix() + "');";
        db.execSQL(requete);
        db.close();
    }
    public List<Livre> getLivres() {
        SQLiteDatabase db = this.getReadableDatabase();
        String requete = "SELECT * FROM " + TABLE_NAME + ";";

        if (requete == null) {
            return null;
        }
        else{
            Cursor cursor = db.rawQuery(requete, null);


            List<Livre> ListeLivre = new ArrayList<Livre>();

            if (cursor.moveToFirst()) {
                do {
                    Livre livre = new Livre(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                    ListeLivre.add(livre);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
            return (ListeLivre);
        }
    }
    public void clearDB() {
        SQLiteDatabase db = this.getWritableDatabase();
        String requete = "DELETE FROM " + TABLE_NAME + ";";
        db.execSQL(requete);
        db.close();
    }
}
