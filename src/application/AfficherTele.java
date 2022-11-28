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



public class AfficherTele implements Initializable {
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		ActionEvent event=null;
	    NumTele_text.setOnKeyPressed(e ->{
			if (e.getCode()== KeyCode.ENTER) {
				try {
					Enregistrer(event);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}		
			}
			});

	    ObservableList<String> fabricants = FXCollections.observableArrayList("Sumsung", "Iphone", "Infinix", "Opo");
	    FabricantChoice.setItems(fabricants);
	    ObservableList<String> statuts = FXCollections.observableArrayList("En fonction", "En stock", "Réparation","Détruit");
	    StatutChoice.setItems(statuts);
	    ObservableList<String> types = FXCollections.observableArrayList("Fixe", "Portable");
	    TypeChoice.setItems(types);
	    ObservableList<String> groupes = FXCollections.observableArrayList("DG", "IT", "RH", "Finance","Logistique","Qualité","Prod.Tube","Prod.Injection","Prod.Montage","Prod.Maintenance");
	    DepartementChoice.setItems(groupes);
    }
	 
	 @FXML
	    private Label TeleNum;

	    @FXML
	    private TextField Utilisateur_text;

	    @FXML
	    private TextField NumTele_text;

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
    	
    	String Num=NumTele_text.getText();
    	String Utilisateur=Utilisateur_text.getText();
	    String Numserie=Numserie_text.getText();
	    String Modele=Modele_text.getText();
    	Telephone newTelephone = new Telephone();
    	newTelephone.setNumTele(Num);
    	newTelephone.setStatut(StatutChoice.getValue());
    	newTelephone.setFabricant(FabricantChoice.getValue());
    	newTelephone.setType(TypeChoice.getValue());
    	newTelephone.setUtilisateur(Utilisateur);
    	newTelephone.setDepartement(DepartementChoice.getValue());
    	newTelephone.setNumserie(Numserie);
    	newTelephone.setModele(Modele);
       	int st=ConnectionClass.updateTele(newTelephone);
        Telephone tele=ConnectionClass.trouverTeleparNumserie(Numserie);
        Telephone tele1=ConnectionClass.trouverTeleparNum(Num);                
       	if(st>0) {
            Alert alert= new Alert(AlertType.INFORMATION);	
            alert.setTitle("Nouveau changement du téléphone");
            alert.setHeaderText("Information");
            alert.setContentText("Les changements sur le téléphone de "+Utilisateur+" sont bien enregistrés");
            alert.showAndWait();
            }else if(!(tele1==null) || !(tele==null) ) {
            	Alert alert= new Alert(AlertType.INFORMATION);	
                alert.setTitle("Nouveau changement du téléphone");
                alert.setHeaderText("Information");
                alert.setContentText("Ce téléphone de "+Utilisateur+" esciste déja");
                alert.showAndWait();
            
            }else {            	
	            	 Alert alert= new Alert(AlertType.ERROR);	
				        alert.setTitle("Nouveau changement du téléphone");
				        alert.setHeaderText("ERREUR");
				        alert.setContentText("Les changements sur le téléphone de "+Utilisateur+" ne sont pas bien enregistrés.Veuillez réessayer!");    
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
