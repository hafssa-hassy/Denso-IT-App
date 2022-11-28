package application;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import java.sql.SQLException;
import java.io.IOException;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import Connection.ConnectionClass;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;


public class NouveauContact implements Initializable{	
	 @FXML
	    void AjoutNouveauContact(MouseEvent event) throws IOException,SQLException {
		     Main m = new Main();
	         m.changeScene("nouveauContact.fxml");
	    }
	  
    @FXML
    private TextField barreRecherche;

    @FXML
    private Button logoutButton;
    @FXML
    private TextField Nom_text;

    @FXML
    private TextField Prenom_text;

    @FXML
    private TextField Telephone2_text;

    @FXML
    private TextField Telephone_text;

    @FXML
    private ChoiceBox<String> AgenceChoice;

    @FXML
    private ChoiceBox<String> Agence2Choice;

    @FXML
    private ChoiceBox<String> VilleChoice;

    @FXML
    private ChoiceBox<String> FonctionChoice;

    @FXML
    private ChoiceBox<String> PaysChoice;

    @FXML
    private ChoiceBox<String> DepartementChoice;

    @FXML
    private TextField CodePostal_text;

    @FXML
    private TextField Adresse_text;

    @FXML
    private TextField Fixe_text;
    
    @FXML
    private Button EnregistrerButton;

    @FXML
    private Button AnnulerButton;
    
    
    @FXML
    void Annuler(ActionEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("Contacts.fxml");
	    Nom_text.clear();
	    Prenom_text.clear();
	    Telephone_text.clear();	   
	    Telephone_text.clear();	
	    CodePostal_text.clear();	
	    Adresse_text.clear();
	    Fixe_text.clear();
	    DepartementChoice.setValue(null);	
	    AgenceChoice.setValue(null);
	    Agence2Choice.setValue(null);
	    VilleChoice.setValue(null);
	    FonctionChoice.setValue(null);
	    PaysChoice.setValue(null);  
    }
    @FXML
    void Enregistrer(ActionEvent event) throws IOException {
    	Main m = new Main();
	     m.changeScene("Contacts.fxml");
	     String Nom=Nom_text.getText();
	     String Prenom=Prenom_text.getText();
	     String Telephone2=Telephone2_text.getText();
	     String Telephone=Telephone_text.getText();
	     String Fixe=Fixe_text.getText();
	     String CodePostal= CodePostal_text.getText();
	     String Adresse=Adresse_text.getText();
	     Contact newContact = new Contact();
	     newContact.setNom(Nom);
	     newContact.setPrenom(Prenom);
	     newContact.setTelephone(Telephone);
	     newContact.setTelephone2(Telephone2);
	     newContact.setFixe(Fixe);
	     newContact.setFixe(Fixe);
	     newContact.setCodePostal(CodePostal);
	     newContact.setAdresse(Adresse);
	     newContact .setAgence( AgenceChoice.getValue());
	     newContact .setAgence2( Agence2Choice.getValue());
	     newContact .setVille(VilleChoice.getValue());
	     newContact .setDepartement(DepartementChoice.getValue());
	     newContact .setVille(VilleChoice.getValue());
	     newContact .setFonction(FonctionChoice.getValue());
	     newContact .setPays(PaysChoice.getValue());
	            int stat=ConnectionClass.saveNewContact(newContact);
	            Contact cont=ConnectionClass.trouverContactparNom(Nom);  
	            if (Nom_text.getText() == null || Nom_text.getText().trim().isEmpty() ) {
	            	Alert alert= new Alert(AlertType.ERROR);	
	                alert.setTitle("Ajout d'un nouveau contact");
	                alert.setHeaderText("ERREUR");
	                alert.setContentText("Veuillez entrer le nom du contact.");
	                alert.showAndWait();
	            }else if(stat>0) {
		            Alert alert= new Alert(AlertType.INFORMATION);	
		            alert.setTitle("Ajout d'un nouveau contact");
		            alert.setHeaderText("Information");
		            alert.setContentText("Le contact de "+Nom+" est bien enregistré");
		            alert.showAndWait();
	            }else if(!(cont==null) ) {
			            	Alert alert= new Alert(AlertType.ERROR);	
			                alert.setTitle("Ajout d'un nouveau contact");
			                alert.setHeaderText("ERREUR");
			                alert.setContentText("contact de "+Nom+" esciste déja");
			                alert.showAndWait();	           	            
	            }else{
	            	 Alert alert= new Alert(AlertType.ERROR);	
				        alert.setTitle("Ajout d'un nouveau contact");
				        alert.setHeaderText("ERREUR");
				        alert.setContentText("Le contact de "+Nom+" n'est pas enregistré.Veuillez réessayer!");    
				        alert.showAndWait();
		            }
	            	
		            }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	ActionEvent event=null;
    PaysChoice.setOnKeyPressed(e ->{
		if (e.getCode()== KeyCode.ENTER) {
			try {
				Enregistrer(event);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}							
		}
		});
   
    ObservableList<String> agences = FXCollections.observableArrayList("IAM", "INWI", "Orange");
    AgenceChoice.setItems(agences);
    ObservableList<String> agences2 = FXCollections.observableArrayList("IAM", "INWI", "Orange");
    Agence2Choice.setItems(agences2);
    ObservableList<String> villes = FXCollections.observableArrayList("Casa Blanca","Rabat","Tanger");
    VilleChoice.setItems(villes);    
    ObservableList<String> fonctions = FXCollections.observableArrayList("Directeur","Manager", "Opérateur");
    FonctionChoice.setItems(fonctions);
    ObservableList<String> groupes = FXCollections.observableArrayList("DG", "IT", "RH", "Finance","Logistique","Qualité","Prod.Tube","Prod.Injection","Prod.Montage","Prod.Maintenance");
    DepartementChoice.setItems(groupes);
    ObservableList<String> pays = FXCollections.observableArrayList("Maroc","Italie");
    PaysChoice.setItems(pays);
    }
    @FXML
    void contactsPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("contacts.fxml");
    }

    @FXML
    void ressourcesPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }

    @FXML
    void logoButton(MouseEvent event) throws IOException  {
    	 Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }
    @FXML
    void gotoProfil(ActionEvent event) throws IOException {
    	 Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("sample.fxml");
    }  
    
}
