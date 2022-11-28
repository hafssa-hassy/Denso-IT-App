package application;


import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author jwright
 */
public class Telephone {
    private SimpleStringProperty NumTele,Utilisateur,Numserie, Type, Modele, Statut, Departement, Fabricant;
    
    public Telephone() {
    	super();
    }
    
    public Telephone(String NumTele,  String Utilisateur,String Numserie,String Type,String Modele,String Statut,String Departement, String Fabricant) {
        super();
    	this.NumTele = new SimpleStringProperty(NumTele);
    	this.Departement = new SimpleStringProperty(Departement);
        this.Utilisateur = new SimpleStringProperty(Utilisateur);
        this.Numserie = new SimpleStringProperty(Numserie);
        this.Type = new SimpleStringProperty(Type);
        this.Modele = new SimpleStringProperty(Modele);
        this.Statut = new SimpleStringProperty(Statut);
        this.Fabricant = new SimpleStringProperty(Fabricant);
    }
    public String getNumTele() {
        return NumTele.get();
    }

    public void setNumTele(String NumTele) {
        this.NumTele = new SimpleStringProperty(NumTele);
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
        return String.format("%s %s", NumTele, Utilisateur);
    }
}
