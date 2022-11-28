package application;



import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author jwright
 */
public class Ordinateur {
    private SimpleStringProperty Nom,Utilisateur, Groupe, UUID, OS, Numserie, Type, Modele, Statut ,AdresseIP ,Fabricant ,RAM ,Affichage, Stockage, Processor;
    
    public Ordinateur() {
    	super();
    }
    
    

	public Ordinateur(String Nom,  String Utilisateur,String Groupe,String UUID,String OS,String Numserie,String Type,
    		String Modele,String Statut,String AdresseIP ,String Fabricant ,String RAM ,String Affichage,String Stockage,String Processor) {
        super();
    	this.Nom = new SimpleStringProperty(Nom);
    	this.AdresseIP = new SimpleStringProperty(AdresseIP);
    	this.Fabricant = new SimpleStringProperty(Fabricant);
    	this.RAM = new SimpleStringProperty(RAM);
    	this.Affichage = new SimpleStringProperty(Affichage );
    	this.Stockage = new SimpleStringProperty(Stockage);
        this.Utilisateur = new SimpleStringProperty(Utilisateur);
        this.Groupe = new SimpleStringProperty(Groupe);
        this.UUID = new SimpleStringProperty(UUID);
        this.OS = new SimpleStringProperty(OS);
        this.Numserie = new SimpleStringProperty(Numserie);
        this.Type = new SimpleStringProperty(Type);
        this.Modele = new SimpleStringProperty(Modele);
        this.Statut = new SimpleStringProperty(Statut);
       this.Processor = new SimpleStringProperty(Processor);
    }
    public String getNom() {
        return Nom.get();
    }

    public void setNom(String Nom) {
        this.Nom = new SimpleStringProperty(Nom);
    }

    public String getUtilisateur() {
        return Utilisateur.get();
    }

    public void setUtilisateur(String Utilisateur) {
        this.Utilisateur = new SimpleStringProperty(Utilisateur);
    }
    public String getGroupe() {
        return Groupe.get();
    }

    public void setGroupe(String Groupe) {
        this.Groupe = new SimpleStringProperty(Groupe);
    }
    public String getUUID() {
        return UUID.get();
    }

    public void setUUID(String UUID) {
        this.UUID = new SimpleStringProperty(UUID);
    }
    public String getOS() {
        return OS.get();
    }

    public void setOS(String OS) {
        this.OS = new SimpleStringProperty(OS);
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
    public String toString()
    {
        return String.format("%s %s", Nom, Utilisateur);
    }
    public String getAdresseIP() {
		return AdresseIP.get();
	}

	public void setAdresseIP(String AdresseIP) {
		this.AdresseIP = new SimpleStringProperty(AdresseIP);
	}

	public String getFabricant() {
		return Fabricant.get();
	}

	public void setFabricant(String Fabricant) {
		this.Fabricant = new SimpleStringProperty(Fabricant);
	}

	public String getRAM() {
		return RAM.get();
	}

	public void setRAM(String RAM) {
		this.RAM = new SimpleStringProperty(RAM);
	}

	public String getAffichage() {
		return Affichage.get();
	}

	public void setAffichage(String Affichage) {
		this.Affichage = new SimpleStringProperty(Affichage);
	}

	public String getStockage() {
		return Stockage.get();
	}

	public void setStockage(String Stockage) {
		this.Stockage = new SimpleStringProperty(Stockage);
	}

	public String getProcessor() {
		return Processor.get();
	}

	public void setProcessor(String Processor) {
		this.Processor = new SimpleStringProperty(Processor);
	}
}
