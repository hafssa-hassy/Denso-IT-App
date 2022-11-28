package application;

import javafx.event.ActionEvent;

import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import Connection.ConnectionClass;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;



public class Ords implements Initializable {
	
	@FXML
    private TextField barreRecherche;

    @FXML
    private Button logoutButton;

    @FXML
    private Label sessionUser;
    
    //configure the table
    @FXML
    private TableView<Ordinateur> TableOrdinateurs;
   
    @FXML
    private TableColumn<Ordinateur, String> NomColumn;

    @FXML
    private TableColumn<Ordinateur, String> StatutColumn;

    @FXML
    private TableColumn<Ordinateur, String> UtilisateurColumn;

    @FXML
    private TableColumn<Ordinateur, String> NumserieColumn;

    @FXML
    private TableColumn<Ordinateur, String> ModeleColumn;

    @FXML
    private TableColumn<Ordinateur, String> OSColumn;

    @FXML
    private TableColumn<Ordinateur, String> TypeColumn;

    @FXML
    private TableColumn<Ordinateur, String> GroupeColumn;

    @FXML
    private TableColumn<Ordinateur, String> UUIDColumn;
    
    @FXML
    private TableColumn<Ordinateur, String> AffichageColumn;
    
    @FXML
    private TableColumn<Ordinateur, String> StockageColumn;
    
    @FXML
    private TableColumn<Ordinateur, String> RAMColumn;
    
    @FXML
    private TableColumn<Ordinateur, String> ProcessorColumn;
    
    @FXML
    private TableColumn<Ordinateur, String> FabricantColumn;
    
    @FXML
    private TableColumn<Ordinateur, String> AdresseIPColumn;
    
    ObservableList<Ordinateur> list = FXCollections.observableArrayList();

    @FXML
    void AjoutNouveauOrdinateur(MouseEvent event) throws IOException  {
    	 Main m = new Main();
	     m.changeScene("nouveauOrdinateur.fxml");
    }
    @FXML
    void ordinnateursPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("ordinateurs.fxml");
    }
    @FXML
    void Update(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("ordinateurs.fxml");
    }

    @FXML
    void ressourcesPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }
    @FXML
    void Rechercher(MouseEvent event) throws IOException {
    	if (barreRecherche.getText() == null || barreRecherche.getText().trim().isEmpty() ) {
        	Alert alert= new Alert(AlertType.ERROR);	
            alert.setTitle("Trouver un ordinateur");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Veuillez entrer le nom de l'ordinateur.");
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
    	TextField Modele_text=(TextField) sc.lookup("#Modele_text");
    	TextField AdresseIP_text=(TextField) sc.lookup("#AdresseIP_text");
    	TextField Affichage_text=(TextField) sc.lookup("#Affichage_text");
    	TextField Processor_text=(TextField) sc.lookup("#Processor_text");
    	ChoiceBox<String> GroupeChoice=(ChoiceBox) sc.lookup("#GroupeChoice");
    	ChoiceBox<String> StatutChoice=(ChoiceBox) sc.lookup("#StatutChoice");
    	ChoiceBox<String> FabricantChoice=(ChoiceBox) sc.lookup("#FabricantChoice");
    	ChoiceBox<String> TypeChoice=(ChoiceBox) sc.lookup("#TypeChoice");
    	ChoiceBox<String> OSChoice=(ChoiceBox) sc.lookup("#OSChoice");
    	ChoiceBox<String> RAMChoice=(ChoiceBox) sc.lookup("#RAMChoice");
    	ChoiceBox<String> StockageChoice=(ChoiceBox) sc.lookup("#StockageChoice");
    	OrdNom.setText(barreRecherche.getText());
    	String Nomcherche=OrdNom.getText();
    	Ordinateur ord=ConnectionClass.trouverOrdparNom(Nomcherche);
    	if(ord==null) {
        	Alert alert= new Alert(AlertType.ERROR);	
            alert.setTitle("Trouver un ordinateur");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Cet ordinateur n'esciste pas");
            alert.showAndWait();}
    	else {
    	Nom_text.setText(ord.getNom());
    	Utilisateur_text.setText(ord.getUtilisateur());
    	UUID_text.setText(ord.getUUID());
    	Numserie_text.setText(ord.getNumserie());
    	Modele_text.setText(ord.getModele());
    	AdresseIP_text.setText(ord.getAdresseIP());
    	Affichage_text.setText(ord.getAffichage());
    	Processor_text.setText(ord.getProcessor());
    	GroupeChoice.setValue(ord.getGroupe());
    	StatutChoice.setValue(ord.getStatut());
    	FabricantChoice.setValue(ord.getFabricant());
    	RAMChoice.setValue(ord.getRAM());
    	StockageChoice.setValue(ord.getStockage());
    	TypeChoice.setValue(ord.getType());
    	OSChoice.setValue(ord.getOS());
    
    	}
    	barreRecherche.clear();}
    }

    @FXML
    void logoButton(MouseEvent event) throws IOException  {
    	 Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("sample.fxml");
    }
    @FXML
    void gotoProfil(ActionEvent event) throws IOException {
    	 Main m = new Main();
	     m.changeScene("dashboard.fxml");
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	MouseEvent event=null;
    	list.clear();
    	try {
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
    	    
    		ConnectionClass connectionClass=new ConnectionClass();
	        Connection connection=connectionClass.getConnection();
	            Statement statement=connection.createStatement();
	            String sql="SELECT * FROM ordinateurs;";
	            ResultSet rs=statement.executeQuery(sql);
	            while(rs.next()) {
	            	list.add(new Ordinateur(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
	            			rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
	               }
	   		connection.close();
			    	
    	}catch(Exception e) {
    		e.printStackTrace();  		
    	}
    	NomColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Nom"));
    	StatutColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Statut"));
    	UtilisateurColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Utilisateur"));
    	NumserieColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Numserie"));
    	ModeleColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Modele"));
    	 OSColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("OS"));
    	 TypeColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Type"));
    	 GroupeColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Groupe"));
    	 UUIDColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("UUID"));
    	 AdresseIPColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("AdresseIP"));
    	 AffichageColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Affichage"));
    	 RAMColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("RAM"));
    	 StockageColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Stockage"));
    	 FabricantColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Fabricant"));
    	 ProcessorColumn.setCellValueFactory(new PropertyValueFactory<Ordinateur, String>("Processor"));
    	TableOrdinateurs.setItems(list);
    	TableOrdinateurs.setEditable(true);
    	NomColumn.setEditable(true);
    	NumserieColumn.setEditable(true);
    	TableOrdinateurs.getSelectionModel().selectedItemProperty().addListener(
    	            (observable, oldValue, newValue) -> afficherOrd(newValue));

    }
    private void afficherOrd(Ordinateur ordinateur) {
        if (ordinateur != null) {
            // Fill the labels with info from the person object.
        	FXMLLoader loader =new FXMLLoader(getClass().getResource("AfficherOrd.fxml"));
        	Parent root=null;
        	try {
        		root=loader.load();
        		
        	}catch (IOException ex) {}
        	    		
        	Scene sc = new Scene(root);
        	Stage second= new Stage();
        	second.setScene(sc);
        	String nomOrdinateur=ordinateur.getNom();
        	second.setTitle("Afficher l'ordinateur "+ nomOrdinateur);
        	second.show();
        	Label OrdNom =(Label) sc.lookup("#OrdNom");
        	TextField Nom_text=(TextField) sc.lookup("#Nom_text");
        	TextField Numserie_text=(TextField) sc.lookup("#Numserie_text");
        	TextField UUID_text=(TextField) sc.lookup("#UUID_text");
        	TextField Utilisateur_text=(TextField) sc.lookup("#Utilisateur_text");
        	TextField Modele_text=(TextField) sc.lookup("#Modele_text");
        	TextField AdresseIP_text=(TextField) sc.lookup("#AdresseIP_text");
        	TextField Affichage_text=(TextField) sc.lookup("#Affichage_text");
        	TextField Processor_text=(TextField) sc.lookup("#Processor_text");
        	ChoiceBox<String> GroupeChoice=(ChoiceBox) sc.lookup("#GroupeChoice");
        	ChoiceBox<String> StatutChoice=(ChoiceBox) sc.lookup("#StatutChoice");
        	ChoiceBox<String> FabricantChoice=(ChoiceBox) sc.lookup("#FabricantChoice");
        	ChoiceBox<String> TypeChoice=(ChoiceBox) sc.lookup("#TypeChoice");
        	ChoiceBox<String> OSChoice=(ChoiceBox) sc.lookup("#OSChoice");
        	ChoiceBox<String> RAMChoice=(ChoiceBox) sc.lookup("#RAMChoice");
        	ChoiceBox<String> StockageChoice=(ChoiceBox) sc.lookup("#StockageChoice");
        	OrdNom.setText(nomOrdinateur);
        	Ordinateur ord=ConnectionClass.trouverOrdparNom(nomOrdinateur);
        	Nom_text.setText(ord.getNom());
        	Utilisateur_text.setText(ord.getUtilisateur());
        	UUID_text.setText(ord.getUUID());
        	Numserie_text.setText(ord.getNumserie());
        	Modele_text.setText(ord.getModele());
        	AdresseIP_text.setText(ord.getAdresseIP());
        	Affichage_text.setText(ord.getAffichage());
        	Processor_text.setText(ord.getProcessor());
        	GroupeChoice.setValue(ord.getGroupe());
        	StatutChoice.setValue(ord.getStatut());
        	FabricantChoice.setValue(ord.getFabricant());
        	RAMChoice.setValue(ord.getRAM());
        	StockageChoice.setValue(ord.getStockage());
        	TypeChoice.setValue(ord.getType());
        	OSChoice.setValue(ord.getOS());

            
        }
    }    
}

