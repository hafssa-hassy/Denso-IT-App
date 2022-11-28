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


public class NouveauPeripherique implements Initializable{	
	 @FXML
	    void AjoutNouveauDispositif(MouseEvent event) throws IOException,SQLException {
		     Main m = new Main();
	         m.changeScene("nouveauPeripherique.fxml");
	    }
	  
    @FXML
    private TextField barreRecherche;

    @FXML
    private Button logoutButton;
    @FXML
    private TextField Utilisateur_text;

    @FXML
    private TextField Responsable_text;

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
	    m.changeScene("peripheriques.fxml");
	    Responsable_text.clear();
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
	     m.changeScene("peripheriques.fxml");
	     String Responsable=Responsable_text.getText();
	     String Utilisateur=Utilisateur_text.getText();
	     String Numserie=Numserie_text.getText();
	     String Modele=Modele_text.getText();
	     Peripherique newPeripherique = new Peripherique();
	     newPeripherique.setResponsable(Responsable);
	     newPeripherique .setStatut(StatutChoice.getValue());
	     newPeripherique .setFabricant(FabricantChoice.getValue());
	     newPeripherique .setType(TypeChoice.getValue());
	     newPeripherique .setUtilisateur(Utilisateur);
	     newPeripherique .setNumserie(Numserie);
	     newPeripherique .setDepartement(DepartementChoice.getValue());
	     newPeripherique .setModele(Modele);
	            int stat=ConnectionClass.saveNewPeri(newPeripherique);
	            Peripherique peri=ConnectionClass.trouverPeriparNumserie(Numserie);	               
	            if (Numserie_text.getText() == null || Numserie_text.getText().trim().isEmpty()) {
	            	Alert alert= new Alert(AlertType.ERROR);	
	                alert.setTitle("Ajout d'un nouveau dispositif");
	                alert.setHeaderText("ERREUR");
	                alert.setContentText("Veuillez entrer le numéro de série du dispositif.");
	                alert.showAndWait();
	            }else if(stat>0) {
		            Alert alert= new Alert(AlertType.INFORMATION);	
		            alert.setTitle("Ajout d'un nouveau dispositif");
		            alert.setHeaderText("Information");
		            alert.setContentText("Le dispositif "+Numserie+" est bien enregistré");
		            alert.showAndWait();
	            }else if(!(peri==null) ) {
			            	Alert alert= new Alert(AlertType.ERROR);	
			                alert.setTitle("Ajout d'un nouveau dispositif");
			                alert.setHeaderText("ERREUR");
			                alert.setContentText("Le dispositif "+Numserie+" esciste déja");
			                alert.showAndWait();	           	            
	            }else{
	            	 Alert alert= new Alert(AlertType.ERROR);	
				        alert.setTitle("Ajout d'un nouveau dispositif");
				        alert.setHeaderText("ERREUR");
				        alert.setContentText("Le dispositif "+Numserie+" n'est pas enregistré.Veuillez réessayer!");    
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
   
    ObservableList<String> modèles = FXCollections.observableArrayList("Camerfirma", "Canon", "DELL", "EPSON","HP","IIYAMA");
    FabricantChoice.setItems(modèles);
    ObservableList<String> statuts = FXCollections.observableArrayList("En fonction", "En stock", "Réparation","Détruit");
    StatutChoice.setItems(statuts);
    ObservableList<String> types = FXCollections.observableArrayList("Camera","WebCamera","Micro","Enceintes/Baffles");
    TypeChoice.setItems(types);
    ObservableList<String> groupes = FXCollections.observableArrayList("DG", "IT", "RH", "Finance","Logistique","Qualité","Prod.Tube","Prod.Injection","Prod.Montage","Prod.Maintenance");
    DepartementChoice.setItems(groupes);
    }
    @FXML
    void dispositifsPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("peripheriques.fxml");
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
