package application;


import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Connection.ConnectionClass;


public class Dashboard implements Initializable {
	    	@FXML
		    private Button logoutButton;
		    @FXML
		    private Label sessionUser;

		    @FXML
		    private TextField barreRecherche;
		    
		    
		    @FXML
		    void ContactsButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("contacts.fxml");
		    }

		    @FXML
		    void DemandeITButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("demandeIT.fxml");
		    }

		    @FXML
		    void FAIButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("FAI.fxml");
		    }

		    @FXML
		    void ImprimantesButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("imprimantes.fxml");
		    }

		    @FXML
		    void LicensesButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("licences.fxml");
		    }

		    @FXML
		    void OrdinateursButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("ordinateurs.fxml");
		    }

		    @FXML
		    void PeripheriquesButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("peripheriques.fxml");
		    }

		    @FXML
		    void PortablesButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("telephones.fxml");
		    }

		    @FXML
		    void ProjectsButton(MouseEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("projets.fxml");
		    }
		    @FXML
		    void gotoProfil(ActionEvent event) throws IOException {
		    	 Main m = new Main();
			     m.changeScene("dashboard.fxml");
		    }
		    @FXML
		    void Rechercher(MouseEvent event) throws IOException {
		    	if (barreRecherche.getText() == null || barreRecherche.getText().trim().isEmpty() ) {
		        	Alert alert= new Alert(AlertType.ERROR);	
		            alert.setTitle("Trouver un ordinateur");
		            alert.setHeaderText("ERREUR");
		            alert.setContentText("Veuillez entrer le nom d l'ordinateur.");
		            alert.showAndWait();}
		    	else {
		    	FXMLLoader loader =new FXMLLoader(getClass().getResource("AfficherOrd.fxml"));
		    	Parent root=null;
		    	try {
		    		root=loader.load();
		    		
		    	}catch (IOException ex) {}
		    	    		
		    	Scene sc = new Scene(root);
		    	Stage second= new Stage();
		    	second.setScene(sc);
		    	second.setTitle("Trouver un ordinateur");
		    	second.show();
		    	Label OrdNom =(Label) sc.lookup("#OrdNom");
		    	TextField Nom_text=(TextField) sc.lookup("#Nom_text");
		    	TextField Numserie_text=(TextField) sc.lookup("#Numserie_text");
		    	TextField UUID_text=(TextField) sc.lookup("#UUID_text");
		    	TextField Utilisateur_text=(TextField) sc.lookup("#Utilisateur_text");
		    	ChoiceBox<String> GroupeChoice=(ChoiceBox) sc.lookup("#GroupeChoice");
		    	ChoiceBox<String> StatutChoice=(ChoiceBox) sc.lookup("#StatutChoice");
		    	ChoiceBox<String> ModèleChoice=(ChoiceBox) sc.lookup("#ModèleChoice");
		    	ChoiceBox<String> TypeChoice=(ChoiceBox) sc.lookup("#TypeChoice");
		    	ChoiceBox<String> OSChoice=(ChoiceBox) sc.lookup("#OSChoice");
		    	OrdNom.setText(barreRecherche.getText());
		    	String Nomcherche=OrdNom.getText();
		    	Ordinateur ord=ConnectionClass.trouverOrdparNom(Nomcherche);
		    	if(ord==null) {
		        	Alert alert= new Alert(AlertType.ERROR);	
		            alert.setTitle("rouver un ordinateur");
		            alert.setHeaderText("ERREUR");
		            alert.setContentText("L'ordinateur n'esciste pas");
		            alert.showAndWait();}
		    	else {
		    	Nom_text.setText(ord.getNom());
		    	Utilisateur_text.setText(ord.getUtilisateur());
		    	UUID_text.setText(ord.getUUID());
		    	Numserie_text.setText(ord.getNumserie());
		    	GroupeChoice.setValue(ord.getGroupe());
		    	StatutChoice.setValue(ord.getStatut());
		    	ModèleChoice.setValue(ord.getModele());
		    	TypeChoice.setValue(ord.getType());
		    	OSChoice.setValue(ord.getOS());
		    	
		    	 
		    	}
		    	barreRecherche.clear();}
		    }
		    @FXML
		    void logoButton(MouseEvent event) throws IOException {
		    	 Main m = new Main();
			     m.changeScene("dashboard.fxml");
		    }
		    
		    public void logout(ActionEvent event) throws IOException {
		        Main m = new Main();
		        m.changeScene("sample.fxml");
		    }
		    @Override
		    public void initialize(URL url, ResourceBundle rb) {
		    	MouseEvent event=null;
		    	
		    
		    		barreRecherche.setOnKeyPressed(e ->{
		    			if (e.getCode()== KeyCode.ENTER) {
		    				try {
		    					Rechercher(event); 
		    				}
		    				catch(Exception ex) {
		    					ex.printStackTrace();
		    				}    					  				
		    			}
		    			});
		    	
		    }
}

