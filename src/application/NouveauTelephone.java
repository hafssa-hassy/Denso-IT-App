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


public class NouveauTelephone implements Initializable{	
	 @FXML
	    void AjoutNouveauTelephone(MouseEvent event) throws IOException,SQLException {
		     Main m = new Main();
	         m.changeScene("nouveauTelephone.fxml");
	    }
	  
    @FXML
    private TextField barreRecherche;

    @FXML
    private Button logoutButton;
    @FXML
    private TextField Utilisateur_text;

    @FXML
    private TextField NumTele_text;

    @FXML
    private TextField Numserie_text;

    @FXML
    private ChoiceBox<String> TypeChoice;

    @FXML
    private ChoiceBox<String> StatutChoice;

    @FXML
    private TextField Modele_text;

    @FXML
    private ChoiceBox<String> FabricantChoice;
    
    @FXML
    private ChoiceBox<String> DepartementChoice;

    @FXML
    private Button EnregistrerButton;

    @FXML
    private Button AnnulerButton;
    
    
    @FXML
    void Annuler(ActionEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("telephones.fxml");
	    NumTele_text.clear();
	    Modele_text.clear();
	    Utilisateur_text.clear();	   
	    Numserie_text.clear();	
	    DepartementChoice.setValue(null);	
	    StatutChoice.setValue(null);
	    FabricantChoice.setValue(null);
	    TypeChoice.setValue(null);
	    
    }
    @FXML
    void Enregistrer(ActionEvent event) throws IOException {
    	Main m = new Main();
	     m.changeScene("telephones.fxml");
	     String Num=NumTele_text.getText();
	     String Utilisateur=Utilisateur_text.getText();
	     String Numserie=Numserie_text.getText();
	     String Modele=Modele_text.getText();
	     Telephone newTelephone = new Telephone();
	     newTelephone.setNumTele(Num);
	     newTelephone .setStatut(StatutChoice.getValue());
	     newTelephone .setFabricant(FabricantChoice.getValue());
	     newTelephone .setType(TypeChoice.getValue());
	     newTelephone .setUtilisateur(Utilisateur);
	     newTelephone .setNumserie(Numserie);
	     newTelephone .setDepartement(DepartementChoice.getValue());
	     newTelephone .setModele(Modele);
	            int stat=ConnectionClass.saveNewTele(newTelephone);
	            Telephone tele=ConnectionClass.trouverTeleparNumserie(Numserie);
	            Telephone tele1=ConnectionClass.trouverTeleparNum(Num);   
	            if (NumTele_text.getText() == null || NumTele_text.getText().trim().isEmpty() || Numserie_text.getText() == null || Numserie_text.getText().trim().isEmpty()) {
	            	Alert alert= new Alert(AlertType.ERROR);	
	                alert.setTitle("Ajout d'un nouveau t�l�phone");
	                alert.setHeaderText("ERREUR");
	                alert.setContentText("Veuillez entrer le num�ro du t�l�phone et son num�ro de s�rie.");
	                alert.showAndWait();
	            }else if(stat>0) {
		            Alert alert= new Alert(AlertType.INFORMATION);	
		            alert.setTitle("Ajout d'un nouveau t�l�phone");
		            alert.setHeaderText("Information");
		            alert.setContentText("Le t�l�phone de "+Utilisateur+" est bien enregistr�");
		            alert.showAndWait();
	            }else if(!(tele1==null) || !(tele==null) ) {
			            	Alert alert= new Alert(AlertType.ERROR);	
			                alert.setTitle("Ajout d'un nouveau t�l�phone");
			                alert.setHeaderText("ERREUR");
			                alert.setContentText("Le t�l�phone de "+Utilisateur+" esciste d�ja");
			                alert.showAndWait();	           	            
	            }else{
	            	 Alert alert= new Alert(AlertType.ERROR);	
				        alert.setTitle("Ajout d'un nouveau t�l�phone");
				        alert.setHeaderText("ERREUR");
				        alert.setContentText("Le t�l�phone de "+Utilisateur+" n'est pas enregistr�.Veuillez r�essayer!");    
				        alert.showAndWait();
		            }
	            	
		            }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	ActionEvent event=null;
    StatutChoice.setOnKeyPressed(e ->{
		if (e.getCode()== KeyCode.ENTER) {
			try {
				Enregistrer(event);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}							
		}
		});
   
    ObservableList<String> mod�les = FXCollections.observableArrayList("Sumsung", "Iphone", "Infinix", "Opo");
    FabricantChoice.setItems(mod�les);
    ObservableList<String> statuts = FXCollections.observableArrayList("En fonction", "En stock", "R�paration","D�truit");
    StatutChoice.setItems(statuts);
    ObservableList<String> types = FXCollections.observableArrayList("Fixe", "Portable");
    TypeChoice.setItems(types);
    ObservableList<String> groupes = FXCollections.observableArrayList("DG", "IT", "RH", "Finance","Logistique","Qualit�","Prod.Tube","Prod.Injection","Prod.Montage","Prod.Maintenance");
    DepartementChoice.setItems(groupes);
    }
    @FXML
    void telephonesPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("telephones.fxml");
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
