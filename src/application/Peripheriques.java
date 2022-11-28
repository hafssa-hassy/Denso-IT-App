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



public class Peripheriques implements Initializable {
	
	@FXML
    private TextField barreRecherche;

    @FXML
    private Button logoutButton;

    @FXML
    private Label sessionUser;
    
    //configure the table
    @FXML
    private TableView<Peripherique> TableDispositifs;
   
    @FXML
    private TableColumn<Peripherique, String> ResponsableColumn;

    @FXML
    private TableColumn<Peripherique, String> StatutColumn;

    @FXML
    private TableColumn<Peripherique, String> UtilisateurColumn;

    @FXML
    private TableColumn<Peripherique, String> NumserieColumn;

    @FXML
    private TableColumn<Peripherique, String> ModeleColumn;

    @FXML
    private TableColumn<Peripherique, String> TypeColumn;
    
    @FXML
    private TableColumn<Peripherique, String> DepartementColumn;
    
    @FXML
    private TableColumn<Peripherique, String> FabricantColumn;

    
    ObservableList<Peripherique> list = FXCollections.observableArrayList();

    @FXML
    void AjoutNouveauDispositif(MouseEvent event) throws IOException  {
    	 Main m = new Main();
	     m.changeScene("nouveauPeripherique.fxml");
    }
    @FXML
    void dispositifsPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("peripheriques.fxml");
    }
    @FXML
    void Update(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("peripheriques.fxml");
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
            alert.setTitle("Trouver un dispositif");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Veuillez entrer le numéro de série du dispositif.");
            alert.showAndWait();}
    	else {
    	FXMLLoader loader =new FXMLLoader(getClass().getResource("afficherPeri.fxml"));
    	Parent root=null;
    	try {
    		root=loader.load();
    		
    	}catch (IOException ex) {}
    	    		
    	Scene sc = new Scene(root);
    	Stage second= new Stage();
    	second.setScene(sc);
    	second.setTitle("Trouver un dispositif");
    	second.show();
    	Label PeriNums =(Label) sc.lookup("#PeriNums");
    	TextField Responsable_text=(TextField) sc.lookup("#Responsable_text");
    	TextField Numserie_text=(TextField) sc.lookup("#Numserie_text");
    	TextField Utilisateur_text=(TextField) sc.lookup("#Utilisateur_text");
    	TextField Modele_text=(TextField) sc.lookup("#Modele_text");
    	ChoiceBox<String> StatutChoice=(ChoiceBox) sc.lookup("#StatutChoice");
    	ChoiceBox<String> TypeChoice=(ChoiceBox) sc.lookup("#TypeChoice");
    	ChoiceBox<String> FabricantChoice=(ChoiceBox) sc.lookup("#FabricantChoice");
    	ChoiceBox<String> DepartementChoice=(ChoiceBox) sc.lookup("#DepartementChoice");
        PeriNums.setText(barreRecherche.getText());
    	String Numscherche=PeriNums.getText();
    	Peripherique peri=ConnectionClass.trouverPeriparNumserie(Numscherche);
    	if(peri==null) {
        	Alert alert= new Alert(AlertType.ERROR);	
            alert.setTitle("Trouver un dispositif");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Ce dispositif n'esciste pas");
            alert.showAndWait();}
    	else {
        Numserie_text.setText(peri.getNumserie());
    	Responsable_text.setText(peri.getResponsable());
    	Utilisateur_text.setText(peri.getUtilisateur());
    	DepartementChoice.setValue(peri.getDepartement());
    	StatutChoice.setValue(peri.getStatut());
    	Modele_text.setText(peri.getModele());
    	TypeChoice.setValue(peri.getType());
    	FabricantChoice.setValue(peri.getFabricant());
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
	            String sql="SELECT * FROM peripheriques;";
	            ResultSet rs=statement.executeQuery(sql);
	            while(rs.next()) {
	            	list.add(new Peripherique(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
	               }
	   		connection.close();
			    	
    	}catch(Exception e) {
    		e.printStackTrace();  		
    	}
    	ResponsableColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Responsable"));
    	StatutColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Statut"));
    	UtilisateurColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Utilisateur"));
    	NumserieColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Numserie"));
    	ModeleColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Modele"));   	
    	TypeColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Type"));
    	DepartementColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Departement"));    
    	FabricantColumn.setCellValueFactory(new PropertyValueFactory<Peripherique, String>("Fabricant"));    
    	TableDispositifs.setItems(list);
    	TableDispositifs.setEditable(true);
    	NumserieColumn.setEditable(true);
    	TableDispositifs.getSelectionModel().selectedItemProperty().addListener(
    	            (observable, oldValue, newValue) -> afficherPeri(newValue));

    }
    private void afficherPeri(Peripherique peripherique) {
        if (peripherique != null) {
            // Fill the labels with info from the person object.
        	FXMLLoader loader =new FXMLLoader(getClass().getResource("AfficherPeri.fxml"));
        	Parent root=null;
        	try {
        		root=loader.load();
        		
        	}catch (IOException ex) {}
        	    		
        	Scene sc = new Scene(root);
        	Stage second= new Stage();
        	second.setScene(sc);
        	String numSerie=peripherique.getNumserie();
        	second.setTitle("Afficher le dispositif"+ numSerie);
        	second.show();
        	Label PeriNums =(Label) sc.lookup("#PeriNums");
        	TextField Responsable_text=(TextField) sc.lookup("#Responsable_text");
        	TextField Numserie_text=(TextField) sc.lookup("#Numserie_text");
        	TextField Utilisateur_text=(TextField) sc.lookup("#Utilisateur_text");
        	TextField Modele_text=(TextField) sc.lookup("#Modele_text");
        	ChoiceBox<String> StatutChoice=(ChoiceBox) sc.lookup("#StatutChoice");
        	ChoiceBox<String> TypeChoice=(ChoiceBox) sc.lookup("#TypeChoice");
        	ChoiceBox<String> FabricantChoice=(ChoiceBox) sc.lookup("#FabricantChoice");
        	ChoiceBox<String> DepartementChoice=(ChoiceBox) sc.lookup("#DepartementChoice");
        	PeriNums.setText(numSerie);
        	Peripherique  peri=ConnectionClass.trouverPeriparNumserie(numSerie);
        	Responsable_text.setText(peri.getResponsable());
        	Utilisateur_text.setText(peri.getUtilisateur());   	
        	Numserie_text.setText(peri.getNumserie());      	
        	StatutChoice.setValue(peri.getStatut());
        	Modele_text.setText(peri.getModele());
        	TypeChoice.setValue(peri.getType()); 
        	DepartementChoice.setValue(peri.getDepartement()); 
        	FabricantChoice.setValue(peri.getFabricant()); 
        }
    }    
}