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


public class NouveauOrd implements Initializable{	
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
	    private TextField Modèle_text;

	    @FXML
	    private TextField Affichage_text;

	    @FXML
	    private ChoiceBox<String> OSChoice;

	    @FXML
	    private ChoiceBox<String> StockageChoice;

	    @FXML
	    private TextField Processor_text;
	    
	    @FXML
	    private Button EnregistrerButton;

	    @FXML
	    private Button AnnulerButton;

   
    @FXML
    void Annuler(ActionEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("ordinateurs.fxml");
	    Nom_text.clear();
	    Utilisateur_text.clear();
	    Processor_text.clear();
	    UUID_text.clear();
	    Modèle_text.clear();
	    Affichage_text.clear();
	    AdresseIP_text.clear();
	    Numserie_text.clear();
	    GroupeChoice.setValue(null);
	    StockageChoice.setValue(null);
	    RAMChoice.setValue(null);
	    StatutChoice.setValue(null);
	    FabricantChoice.setValue(null);
	    TypeChoice.setValue(null);
	    OSChoice.setValue(null);
    }
    @FXML
    void Enregistrer(ActionEvent event) throws IOException {
    	Main m = new Main();
	     m.changeScene("ordinateurs.fxml");
	     String Nom=Nom_text.getText();
	     String Processor=Processor_text.getText();
	     String Affichage=Affichage_text.getText();
	     String AdresseIP= AdresseIP_text.getText();
	     String Utilisateur=Utilisateur_text.getText();
	     String Modele=Modèle_text.getText();
	     String UUID=UUID_text.getText();
	     String Numserie=Numserie_text.getText();     
	     Ordinateur newOrdinateur = new Ordinateur();
	     newOrdinateur.setNom(Nom);
	     newOrdinateur.setGroupe(GroupeChoice.getValue());
	     newOrdinateur.setStatut(StatutChoice.getValue());
	     newOrdinateur.setFabricant(FabricantChoice.getValue());
	     newOrdinateur.setType(TypeChoice.getValue());
	     newOrdinateur.setOS(OSChoice.getValue());
	     newOrdinateur.setStockage(StockageChoice.getValue());
	     newOrdinateur.setRAM(RAMChoice.getValue());
	     newOrdinateur.setUtilisateur(Utilisateur);
	     newOrdinateur.setUUID(UUID);
	     newOrdinateur.setNumserie(Numserie);
	     newOrdinateur.setProcessor(Processor);
	     newOrdinateur.setAffichage(Affichage);
	     newOrdinateur.setAdresseIP(AdresseIP);
	     newOrdinateur.setModele(Modele);
	            int stat=ConnectionClass.saveNew(newOrdinateur);
	            Ordinateur ord=ConnectionClass.trouverOrdparNumserie(Numserie);
	            Ordinateur ord1=ConnectionClass.trouverOrdparNom(Nom);  
	            if (Nom_text.getText() == null || Nom_text.getText().trim().isEmpty() || Numserie_text.getText() == null || Numserie_text.getText().trim().isEmpty()) {
	            	Alert alert= new Alert(AlertType.ERROR);	
	                alert.setTitle("Ajout d'un nouveau ordinateur");
	                alert.setHeaderText("ERREUR");
	                alert.setContentText("Veuillez entrer le nom de l'ordinateur et son numéro de série.");
	                alert.showAndWait();
	            } else if(stat>0) {
		            Alert alert= new Alert(AlertType.INFORMATION);	
		            alert.setTitle("Ajout d'un nouveau ordinateur");
		            alert.setHeaderText("Information");
		            alert.setContentText("L'ordinateur "+Nom+" est bien enregistré");
		            alert.showAndWait(); 
	            }else if(!(ord1==null) || !(ord==null) ) {
	            	Alert alert= new Alert(AlertType.ERROR);	
	                alert.setTitle("Ajout d'un nouveau ordinateur");
	                alert.setHeaderText("ERREUR");
	                alert.setContentText("L'ordinateur "+Nom+" esciste déja");
	                alert.showAndWait();	 	                         	            
	            }else{
	            	 Alert alert= new Alert(AlertType.ERROR);	
				        alert.setTitle("Ajout d'un nouveau ordinateur");
				        alert.setHeaderText("ERREUR");
				        alert.setContentText("L'ordinateur "+Nom+" n'est pas enregistré.Veuillez réessayer!");    
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
