package application;

import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Connection.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class AfficherPeri implements Initializable {
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		ActionEvent event=null;
	    Numserie_text.setOnKeyPressed(e ->{
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
	    private Label PeriNums;

	    @FXML
	    private TextField Utilisateur_text;

	    @FXML
	    private TextField Responsable_text;

	    @FXML
	    private TextField Numserie_text;

	    @FXML
	    private ChoiceBox<String> TypeChoice;
	    
	    @FXML
	    private ChoiceBox<String> DepartementChoice;


	    @FXML
	    private ChoiceBox<String> StatutChoice;

	    @FXML
	    private TextField Modele_text;

	    @FXML
	    private ChoiceBox<String> FabricantChoice;

	    @FXML
	    private Button EnregistrerButton;

	    @FXML
	    private Button AnnulerButton;

    @FXML
    void Annuler(ActionEvent event) throws IOException {
    	
    	 Stage stage = (Stage) AnnulerButton.getScene().getWindow();
    	    stage.close();
    }
   

    @FXML
    void Enregistrer(ActionEvent event) throws IOException {
    	
    	String Responsable=Responsable_text.getText();
    	String Utilisateur=Utilisateur_text.getText();
	    String Numserie=Numserie_text.getText();
	    String Modele=Modele_text.getText();
    	Peripherique newPeripherique  = new Peripherique ();
    	newPeripherique .setResponsable(Responsable);
    	newPeripherique .setStatut(StatutChoice.getValue());
    	newPeripherique .setFabricant(FabricantChoice.getValue());
    	newPeripherique .setType(TypeChoice.getValue());
    	newPeripherique .setUtilisateur(Utilisateur);
    	newPeripherique .setDepartement(DepartementChoice.getValue());
    	newPeripherique .setNumserie(Numserie);
    	newPeripherique .setModele(Modele);
       	int st=ConnectionClass.updatePeri(newPeripherique);
       	Peripherique peri=ConnectionClass.trouverPeriparNumserie(Numserie);
                    
       	if(st>0) {
            Alert alert= new Alert(AlertType.INFORMATION);	
            alert.setTitle("Nouveau changement du dispositif");
            alert.setHeaderText("Information");
            alert.setContentText("Les changements sur le dispositif "+Numserie+" sont bien enregistrés");
            alert.showAndWait();
            }else if(!(peri==null) ) {
            	Alert alert= new Alert(AlertType.INFORMATION);	
                alert.setTitle("Nouveau changement du dispositif");
                alert.setHeaderText("Information");
                alert.setContentText("Ce dispositif "+Numserie+" esciste déja");
                alert.showAndWait();
            
            }else {            	
	            	 Alert alert= new Alert(AlertType.ERROR);	
				        alert.setTitle("Nouveau changement du dispositif");
				        alert.setHeaderText("ERREUR");
				        alert.setContentText("Les changements sur le dispositif  "+Numserie+" ne sont pas bien enregistrés.Veuillez réessayer!");    
				        alert.showAndWait();
		            }
       	Stage stage = (Stage) AnnulerButton.getScene().getWindow();
	    stage.close();
	            }       

    @FXML
    void ressourcesPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }

    @FXML
    void logoButton(MouseEvent event) throws IOException  {
    	Stage stage = (Stage) AnnulerButton.getScene().getWindow();
	    stage.close();
    }
    @FXML
    void gotoProfil(ActionEvent event) throws IOException {
   	 Stage stage = (Stage) AnnulerButton.getScene().getWindow();
   	    stage.close();
    	 Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
   	 Stage stage = (Stage) AnnulerButton.getScene().getWindow();
   	    stage.close();
    	 Main m = new Main();
	        m.changeScene("sample.fxml");
    }  
}

