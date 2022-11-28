package application;



import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author jwright
 */
public class Contact {
	
    private SimpleStringProperty Nom,Prenom, Telephone,Telephone2, CodePostal, Adresse, Fixe,Departement, Agence, Agence2, Ville, Fonction,Pays;
    
    public Contact() {
    	super();
    }
    
    

	public Contact(String Nom,String Prenom,String Telephone,String Telephone2,String CodePostal,String Adresse,String Fixe,
			String Departement,String Agence,String Agence2,String Ville,String Fonction,String Pays) {
        super();
    	this.Nom = new SimpleStringProperty(Nom);
    	this.Prenom = new SimpleStringProperty(Prenom);
    	this.Adresse = new SimpleStringProperty(Adresse);
    	this.Telephone = new SimpleStringProperty(Telephone);
    	this.Telephone2 = new SimpleStringProperty(Telephone2 );
    	this.CodePostal = new SimpleStringProperty(CodePostal);
        this.Fixe = new SimpleStringProperty(Fixe);
        this.Departement = new SimpleStringProperty(Departement);
        this.Agence = new SimpleStringProperty(Agence);
        this.Agence2 = new SimpleStringProperty(Agence2);
        this.Ville = new SimpleStringProperty(Ville);
        this.Fonction = new SimpleStringProperty(Fonction);
        this.Pays = new SimpleStringProperty(Pays);
    }
    public String getNom() {
        return Nom.get();
    }

    public void setNom(String Nom) {
        this.Nom = new SimpleStringProperty(Nom);
    }

    public String getPrenom() {
        return Prenom.get();
    }

    public void setPrenom(String Prenom) {
        this.Prenom = new SimpleStringProperty(Prenom);
    }
    public String getDepartement() {
        return Departement.get();
    }

    public void setDepartement(String Departement) {
        this.Departement = new SimpleStringProperty(Departement);
    }
    public String getTelephone() {
        return Telephone.get();
    }

    public void setTelephone(String Telephone) {
        this.Telephone = new SimpleStringProperty(Telephone);
    }
    public String getTelephone2() {
        return Telephone2.get();
    }

    public void setTelephone2(String Telephone2) {
        this.Telephone2= new SimpleStringProperty(Telephone2);
    }
    public String getAgence() {
        return Agence.get();
    }

    public void setAgence(String Agence) {
        this.Agence = new SimpleStringProperty(Agence);
    }
    public String getPays() {
        return Pays.get();
    }

    public void setPays(String Pays) {
        this.Pays = new SimpleStringProperty(Pays);
    }
    public String getAgence2() {
        return Agence2.get();
    }

    public void setAgence2(String Agence2) {
        this.Agence2 = new SimpleStringProperty(Agence2);
    }
    public String getVille() {
        return Ville.get();
    }

    public void setVille(String Ville) {
        this.Ville = new SimpleStringProperty(Ville);
    }
    public String toString()
    {
        return String.format("%s %s", Nom, Prenom);
    }
    public String getAdresse() {
		return Adresse.get();
	}

	public void setAdresse(String Adresse) {
		this.Adresse = new SimpleStringProperty(Adresse);
	}

	public String getFonction() {
		return Fonction.get();
	}

	public void setFonction(String Fonction) {
		this.Fonction = new SimpleStringProperty(Fonction);
	}

	public String getCodePostal() {
		return CodePostal.get();
	}

	public void setCodePostal(String CodePostal) {
		this.CodePostal = new SimpleStringProperty(CodePostal);
	}

	public String getFixe() {
		return Fixe.get();
	}

	public void setFixe(String Fixe) {
		this.Fixe = new SimpleStringProperty(Fixe);
	}

}
