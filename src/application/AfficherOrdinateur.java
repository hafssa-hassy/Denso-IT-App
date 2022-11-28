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


public class AfficherOrdinateur implements Initializable {
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		ActionEvent event=null;
	    Nom_text.setOnKeyPressed(e ->{
			if (e.getCode()== KeyCode.ENTER) {
				try {
					Enregistrer(event);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}		
			}
			});

	    ObservableList<String> groupes = FXCollections.observableArrayList("DG", "IT", "RH", "Finance","Logistique","Qualité","Prod.Tube","Prod.Injection","Prod.Montage","Prod.Maintenance");
	    GroupeChoice.setItems(groupes);
	    ObservableList<String> fabricants = FXCollections.observableArrayList("Hp", "Toshiba","DELL","ASUS");
	    FabricantChoice.setItems(fabricants);
	    ObservableList<String> stockages = FXCollections.observableArrayList("256 GB", "512 GB","1 TB");
	    StockageChoice.setItems(stockages);
	    ObservableList<String> RAM = FXCollections.observableArrayList("4 GB", "8 GB","12 GB","16 GB");
	    RAMChoice.setItems(RAM);
	    ObservableList<String> statuts = FXCollections.observableArrayList("En fonction", "En stock", "Réparation","Détruit");
	    StatutChoice.setItems(statuts);
	    ObservableList<String> types = FXCollections.observableArrayList("Desktop", "Laptop", "Server","Terminal");
	    TypeChoice.setItems(types);
	    ObservableList<String> systems = FXCollections.observableArrayList("Windows7", "Windows10", "Linux", "Mac OS");
	    OSChoice.setItems(systems);
    }
	 @FXML
	    void AjoutNouveauOrdinateur(MouseEvent event) throws IOException,SQLException {
		     Main m = new Main();
	         m.changeScene("nouveauOrdinateur.fxml");
	    }
	 
	 @FXML
	    private TextField Nom_text;

	    @FXML
	    private TextField Utilisateur_text;

	    @FXML
	    private ChoiceBox<String> GroupeChoice;

	    @FXML
	    private TextField UUID_text;

	    @FXML
	    private TextField Numserie_text;

	    @FXML
	    private TextField AdresseIP_text;

	    @FXML
	    private ChoiceBox<String> StatutChoice;

	    @FXML
	    private ChoiceBox<String> FabricantChoice;

	    @FXML
	    private ChoiceBox<String> TypeChoice;

	    @FXML
	    private ChoiceBox<String> RAMChoice;

	    @FXML
	    private TextField Modele_text;

	    @FXML
	    private TextField Affichage_text;

	    @FXML
	    private ChoiceBox<String> OSChoice;

	    @FXML
	    private ChoiceBox<String> StockageChoice;

	    @FXML
	    private TextField Processor_text;
	    
	    @FXML
	    private Label OrdNom;
	    
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
    	
    	String Nom=Nom_text.getText();
    	String Utilisateur=Utilisateur_text.getText();
	    String UUID=UUID_text.getText();
	    String Numserie=Numserie_text.getText();
	    String Processor=Processor_text.getText();
	    String Affichage=Affichage_text.getText();
	    String AdresseIP= AdresseIP_text.getText();
	    String Modele=Modele_text.getText();
    	Ordinateur newOrdinateur = new Ordinateur();
    	 newOrdinateur.setNom(Nom);
    	 newOrdinateur.setGroupe(GroupeChoice.getValue());
  	     newOrdinateur.setStatut(StatutChoice.getValue());
  	     newOrdinateur.setFabricant(FabricantChoice.getValue());
  	     newOrdinateur.setType(TypeChoice.getValue());
  	     newOrdinateur.setOS(OSChoice.getValue());
  	     newOrdinateur.setUtilisateur(Utilisateur);
  	     newOrdinateur.setUUID(UUID);
  	     newOrdinateur.setNumserie(Numserie);
  	     newOrdinateur.setProcessor(Processor);
	     newOrdinateur.setAffichage(Affichage);
	     newOrdinateur.setAdresseIP(AdresseIP);
	     newOrdinateur.setModele(Modele);
       	int st=ConnectionClass.update(newOrdinateur);
        Ordinateur ord=ConnectionClass.trouverOrdparNumserie(Numserie);
        Ordinateur ord1=ConnectionClass.trouverOrdparNom(Nom);
                
       	if(st>0) {
            Alert alert= new Alert(AlertType.INFORMATION);	
            alert.setTitle("Nouveau changement de l'ordinateur");
            alert.setHeaderText("Information");
            alert.setContentText("Les changements sur l'ordinateur "+Nom+" sont bien enregistrés");
            alert.showAndWait();
            }else if(!(ord1==null) || !(ord==null) ) {
            	Alert alert= new Alert(AlertType.ERROR);	
                alert.setTitle("Nouveau changement de l'ordinateur");
                alert.setHeaderText("ERREUR");
                alert.setContentText("L'ordinateur "+Nom+" esciste déja");
                alert.showAndWait();
            
            }else {            	
	            	 Alert alert= new Alert(AlertType.ERROR);	
				        alert.setTitle("Nouveau changement de l'ordinateur");
				        alert.setHeaderText("ERREUR");
				        alert.setContentText("Les changements sur L'ordinateur"+Nom+" ne sont pas bien enregistrés.Veuillez réessayer!");    
				        alert.showAndWait();
		            }
       	Stage stage = (Stage) AnnulerButton.getScene().getWindow();
	    stage.close();
	            }       
    @FXML
    void ordinnateursPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("ordinateurs.fxml");
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
