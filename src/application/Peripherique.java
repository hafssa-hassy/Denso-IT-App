package application;

import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author jwright
 */
public class Peripherique {
    private SimpleStringProperty Responsable,Utilisateur,Numserie, Type, Modele, Statut, Departement, Fabricant;
    
    public Peripherique() {
    	super();
    }
    
    public Peripherique(String Numserie, String Utilisateur,String Responsable,String Type,String Modele,String Statut,String Departement, String Fabricant) {
        super();
    	this.Responsable = new SimpleStringProperty(Responsable);
    	this.Departement = new SimpleStringProperty(Departement);
        this.Utilisateur = new SimpleStringProperty(Utilisateur);
        this.Numserie = new SimpleStringProperty(Numserie);
        this.Type = new SimpleStringProperty(Type);
        this.Modele = new SimpleStringProperty(Modele);
        this.Statut = new SimpleStringProperty(Statut);
        this.Fabricant = new SimpleStringProperty(Fabricant);
    }
    public String getResponsable() {
        return Responsable.get();
    }

    public void setResponsable(String Responsable) {
        this.Responsable = new SimpleStringProperty(Responsable);
    }

    public String getUtilisateur() {
        return Utilisateur.get();
    }

    public void setUtilisateur(String Utilisateur) {
        this.Utilisateur = new SimpleStringProperty(Utilisateur);
    }
    public String getDepartement() {
        return Departement.get();
    }

    public void setDepartement(String Departement) {
        this.Departement = new SimpleStringProperty(Departement);
    }
   
    public String getNumserie() {
        return Numserie.get();
    }

    public void setNumserie(String Numserie) {
        this.Numserie = new SimpleStringProperty(Numserie);
    }
    public String getType() {
        return Type.get();
    }

    public void setType(String Type) {
        this.Type = new SimpleStringProperty(Type);
    }
    public String getModele() {
        return Modele.get();
    }

    public void setModele(String Modele) {
        this.Modele = new SimpleStringProperty(Modele);
    }
    public String getStatut() {
        return Statut.get();
    }

    public void setStatut(String Statut) {
        this.Statut = new SimpleStringProperty(Statut);
    }
    public String getFabricant() {
        return Fabricant.get();
    }

    public void setFabricant(String Fabricant) {
        this.Fabricant = new SimpleStringProperty(Fabricant);
    }
    public String toString()
    {
        return String.format("%s %s", Responsable, Utilisateur);
    }
}
