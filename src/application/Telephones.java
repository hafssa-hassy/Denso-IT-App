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



public class Telephones implements Initializable {
	
	@FXML
    private TextField barreRecherche;

    @FXML
    private Button logoutButton;

    @FXML
    private Label sessionUser;
    
    //configure the table
    @FXML
    private TableView<Telephone> TableTelephones;
   
    @FXML
    private TableColumn<Telephone, String> NumTeleColumn;

    @FXML
    private TableColumn<Telephone, String> StatutColumn;

    @FXML
    private TableColumn<Telephone, String> UtilisateurColumn;

    @FXML
    private TableColumn<Telephone, String> NumserieColumn;

    @FXML
    private TableColumn<Telephone, String> ModeleColumn;

    @FXML
    private TableColumn<Telephone, String> TypeColumn;
    
    @FXML
    private TableColumn<Telephone, String> DepartementColumn;
    
    @FXML
    private TableColumn<Telephone, String> FabricantColumn;

    
    ObservableList<Telephone> list = FXCollections.observableArrayList();

    @FXML
    void AjoutNouveauTelephone(MouseEvent event) throws IOException  {
    	 Main m = new Main();
	     m.changeScene("nouveauTelephone.fxml");
    }
    @FXML
    void telephonesPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("telephones.fxml");
    }
    @FXML
    void Update(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("telephones.fxml");
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
            alert.setTitle("Trouver un téléphone");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Veuillez entrer le numéro du téléphone.");
            alert.showAndWait();}
    	else {
    	FXMLLoader loader =new FXMLLoader(getClass().getResource("afficherTele.fxml"));
    	Parent root=null;
    	try {
    		root=loader.load();
    		
    	}catch (IOException ex) {}
    	    		
    	Scene sc = new Scene(root);
    	Stage second= new Stage();
    	second.setScene(sc);
    	second.setTitle("Trouver un téléphone");
    	second.show();
    	Label TeleNum =(Label) sc.lookup("#TeleNum");
    	TextField NumTele_text=(TextField) sc.lookup("#NumTele_text");
    	TextField Numserie_text=(TextField) sc.lookup("#Numserie_text");
    	TextField Utilisateur_text=(TextField) sc.lookup("#Utilisateur_text");
    	TextField Modele_text=(TextField) sc.lookup("#Modele_text");
    	ChoiceBox<String> StatutChoice=(ChoiceBox) sc.lookup("#StatutChoice");
    	ChoiceBox<String> TypeChoice=(ChoiceBox) sc.lookup("#TypeChoice");
    	ChoiceBox<String> FabricantChoice=(ChoiceBox) sc.lookup("#FabricantChoice");
    	ChoiceBox<String> DepartementChoice=(ChoiceBox) sc.lookup("#DepartementChoice");
        TeleNum.setText(barreRecherche.getText());
    	String Numcherche=TeleNum.getText();
    	Telephone tele=ConnectionClass.trouverTeleparNum(Numcherche);
    	if(tele==null) {
        	Alert alert= new Alert(AlertType.ERROR);	
            alert.setTitle("Trouver un téléphone");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Ce téléphone n'esciste pas");
            alert.showAndWait();}
    	else {
    	NumTele_text.setText(tele.getNumTele());
    	Utilisateur_text.setText(tele.getUtilisateur());
    	DepartementChoice.setValue(tele.getDepartement());
    	Numserie_text.setText(tele.getNumserie());
    	StatutChoice.setValue(tele.getStatut());
    	Modele_text.setText(tele.getModele());
    	TypeChoice.setValue(tele.getType());
    	FabricantChoice.setValue(tele.getFabricant());
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
	            String sql="SELECT * FROM telephones;";
	            ResultSet rs=statement.executeQuery(sql);
	            while(rs.next()) {
	            	list.add(new Telephone(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
	               }
	   		connection.close();
			    	
    	}catch(Exception e) {
    		e.printStackTrace();  		
    	}
    	NumTeleColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("NumTele"));
    	StatutColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("Statut"));
    	UtilisateurColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("Utilisateur"));
    	NumserieColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("Numserie"));
    	ModeleColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("Modele"));   	
    	TypeColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("Type"));
    	DepartementColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("Departement"));    
    	FabricantColumn.setCellValueFactory(new PropertyValueFactory<Telephone, String>("Fabricant"));    
    	TableTelephones.setItems(list);
    	TableTelephones.setEditable(true);
    	NumTeleColumn.setEditable(true);
    	NumserieColumn.setEditable(true);
    	TableTelephones.getSelectionModel().selectedItemProperty().addListener(
    	            (observable, oldValue, newValue) -> afficherTele(newValue));

    }
    private void afficherTele(Telephone telephone) {
        if (telephone != null) {
            // Fill the labels with info from the person object.
        	FXMLLoader loader =new FXMLLoader(getClass().getResource("AfficherTele.fxml"));
        	Parent root=null;
        	try {
        		root=loader.load();
        		
        	}catch (IOException ex) {}
        	    		
        	Scene sc = new Scene(root);
        	Stage second= new Stage();
        	second.setScene(sc);
        	String numTelephone=telephone.getNumTele();
        	String Utilisateur=telephone.getUtilisateur();
        	second.setTitle("Afficher le téléphone de "+ Utilisateur);
        	second.show();
        	Label TeleNum =(Label) sc.lookup("#TeleNum");
        	TextField NumTele_text=(TextField) sc.lookup("#NumTele_text");
        	TextField Numserie_text=(TextField) sc.lookup("#Numserie_text");
        	TextField Utilisateur_text=(TextField) sc.lookup("#Utilisateur_text");
        	TextField Modele_text=(TextField) sc.lookup("#Modele_text");
        	ChoiceBox<String> StatutChoice=(ChoiceBox) sc.lookup("#StatutChoice");
        	ChoiceBox<String> TypeChoice=(ChoiceBox) sc.lookup("#TypeChoice");
        	ChoiceBox<String> FabricantChoice=(ChoiceBox) sc.lookup("#FabricantChoice");
        	ChoiceBox<String> DepartementChoice=(ChoiceBox) sc.lookup("#DepartementChoice");
        	TeleNum.setText(numTelephone);
        	Telephone tele=ConnectionClass.trouverTeleparNum(numTelephone);
        	NumTele_text.setText(tele.getNumTele());
        	Utilisateur_text.setText(tele.getUtilisateur());   	
        	Numserie_text.setText(tele.getNumserie());      	
        	StatutChoice.setValue(tele.getStatut());
        	Modele_text.setText(tele.getModele());
        	TypeChoice.setValue(tele.getType()); 
        	DepartementChoice.setValue(tele.getDepartement()); 
        	FabricantChoice.setValue(tele.getFabricant()); 
        }
    }    
}