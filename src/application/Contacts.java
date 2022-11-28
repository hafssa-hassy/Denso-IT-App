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



public class Contacts implements Initializable {
	
	@FXML
    private TextField barreRecherche;

    @FXML
    private Button logoutButton;

    //configure the table
    @FXML
    private TableView<Contact> TableContacts;
   
    @FXML
    private TableColumn<Contact, String> NomColumn;

    @FXML
    private TableColumn<Contact, String> PrenomColumn;

    @FXML
    private TableColumn<Contact, String> TelephoneColumn;

    @FXML
    private TableColumn<Contact, String> AgenceColumn;

    @FXML
    private TableColumn<Contact, String> Telephone2Column;

    @FXML
    private TableColumn<Contact, String> Agence2Column;

    @FXML
    private TableColumn<Contact, String> FixeColumn;

    @FXML
    private TableColumn<Contact, String> FonctionColumn;

    @FXML
    private TableColumn<Contact, String> DepartementColumn;
    
    @FXML
    private TableColumn<Contact, String> AdresseColumn;
    
    @FXML
    private TableColumn<Contact, String> CodePostalColumn;
    
    @FXML
    private TableColumn<Contact, String> VilleColumn;
    
    @FXML
    private TableColumn<Contact, String> PaysColumn;
    
    
    ObservableList<Contact> list = FXCollections.observableArrayList();

    @FXML
    void AjoutNouveauContact(MouseEvent event) throws IOException  {
    	 Main m = new Main();
	     m.changeScene("nouveauContact.fxml");
    }
    @FXML
    void contactsPage(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("contacts.fxml");
    }
    @FXML
    void Update(MouseEvent event) throws IOException {
    	Main m = new Main();
	    m.changeScene("contacts.fxml");
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
            alert.setTitle("Trouver un contact");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Veuillez entrer le nom du contact.");
            alert.showAndWait();}
    	else {
    	FXMLLoader loader =new FXMLLoader(getClass().getResource("AfficherContact.fxml"));
    	Parent root=null;
    	try {
    		root=loader.load();
    		
    	}catch (IOException ex) {}
    	    		
    	Scene sc = new Scene(root);
    	Stage second= new Stage();
    	second.setScene(sc);
    	second.setTitle("Trouver un contact");
    	second.show();
    	Label ContactNom =(Label) sc.lookup("#ContactNom");
    	TextField Nom_text=(TextField) sc.lookup("#Nom_text");
    	TextField Prenom_text=(TextField) sc.lookup("#Prenom_text");
    	TextField Telephone_text=(TextField) sc.lookup("#Telephone_text");
    	TextField Telephone2_text=(TextField) sc.lookup("#Telephone2_text");
    	TextField Fixe_text=(TextField) sc.lookup("#Fixe_text");
    	TextField Adresse_text=(TextField) sc.lookup("#Agence2_text");
    	TextField CodePostal_text=(TextField) sc.lookup("#CodePostal_text");
    	ChoiceBox<String> AgenceChoice=(ChoiceBox) sc.lookup("#AgenceChoice");
    	ChoiceBox<String> Agence2Choice=(ChoiceBox) sc.lookup("#Agence2Choice");
    	ChoiceBox<String> FonctionChoice=(ChoiceBox) sc.lookup("#FonctiontChoice");
    	ChoiceBox<String> VilleChoice=(ChoiceBox) sc.lookup("#VilleChoice");
    	ChoiceBox<String> PaysChoice=(ChoiceBox) sc.lookup("#PaysChoice");
    	ChoiceBox<String> DepartementChoice=(ChoiceBox) sc.lookup("#DepartementChoice");
    	ContactNom.setText(barreRecherche.getText());
    	String Nomcherche=ContactNom.getText();
    	Contact cont=ConnectionClass.trouverContactparNom(Nomcherche);
    	if(cont==null) {
        	Alert alert= new Alert(AlertType.ERROR);	
            alert.setTitle("Trouver un Contact");
            alert.setHeaderText("ERREUR");
            alert.setContentText("Cet Contact n'esciste pas");
            alert.showAndWait();}
    	else {
    	Nom_text.setText(cont.getNom());
    	Prenom_text.setText(cont.getPrenom());
        Telephone_text.setText(cont.getTelephone());
        Telephone2_text.setText(cont.getTelephone2());
    	Fixe_text.setText(cont.getFixe());
    	Adresse_text.setText(cont.getAdresse());
    	CodePostal_text.setText(cont.getCodePostal());
    	AgenceChoice.setValue(cont.getAgence());
    	Agence2Choice.setValue(cont.getAgence2());
    	FonctionChoice.setValue(cont.getFonction());
    	DepartementChoice.setValue(cont.getDepartement());
    	VilleChoice.setValue(cont.getVille());
    	PaysChoice.setValue(cont.getPays());
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
	            String sql="SELECT * FROM contacts;";
	            ResultSet rs=statement.executeQuery(sql);
	            while(rs.next()) {
	            	list.add(new Contact(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
	            			rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
	               }
	   		connection.close();
			    	
    	}catch(Exception e) {
    		e.printStackTrace();  		
    	}
    	NomColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Nom"));
    	PrenomColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Prenom"));
    	TelephoneColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Telephone"));
    	Telephone2Column.setCellValueFactory(new PropertyValueFactory<Contact, String>("Telephone"));
    	AgenceColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Agence"));
    	Agence2Column.setCellValueFactory(new PropertyValueFactory<Contact, String>("Agence2"));
    	 FixeColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Fixe"));
    	 FonctionColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Fonction"));
    	 DepartementColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Departement"));
    	 AdresseColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Adresse"));
    	 CodePostalColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>(" CodePostal"));
    	 VilleColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Ville"));
    	 PaysColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>(" Pays"));
    	TableContacts.setItems(list);
    	TableContacts.setEditable(true);
    	NomColumn.setEditable(true);
    	TableContacts.getSelectionModel().selectedItemProperty().addListener(
    	            (observable, oldValue, newValue) -> afficherCont(newValue));

    }
    private void afficherCont(Contact Contact) {
        if (Contact != null) {
            // Fill the labels with info from the person object.
        	FXMLLoader loader =new FXMLLoader(getClass().getResource("AfficherContact.fxml"));
        	Parent root=null;
        	try {
        		root=loader.load();
        		
        	}catch (IOException ex) {}
        	    		
        	Scene sc = new Scene(root);
        	Stage second= new Stage();
        	second.setScene(sc);
        	String nomContact=Contact.getNom();
        	second.setTitle("Afficher le contact de"+ nomContact);
        	second.show();
        	Label contNom =(Label) sc.lookup("#ContactNom");
        	TextField Nom_text=(TextField) sc.lookup("#Nom_text");
        	TextField Prenom_text=(TextField) sc.lookup("#Prenom_text");
        	TextField Telephone_text=(TextField) sc.lookup("#Telephone_text");
        	TextField Telephone2_text=(TextField) sc.lookup("#Telephone2_text");
        	TextField Fixe_text=(TextField) sc.lookup("#Fixe_text");
        	TextField Adresse_text=(TextField) sc.lookup("#Agence2_text");
        	TextField CodePostal_text=(TextField) sc.lookup("#CodePostal_text");
        	ChoiceBox<String> AgenceChoice=(ChoiceBox) sc.lookup("#AgenceChoice");
        	ChoiceBox<String> Agence2Choice=(ChoiceBox) sc.lookup("#Agence2Choice");
        	ChoiceBox<String> FonctionChoice=(ChoiceBox) sc.lookup("#FonctiontChoice");
        	ChoiceBox<String> VilleChoice=(ChoiceBox) sc.lookup("#VilleChoice");
        	ChoiceBox<String> PaysChoice=(ChoiceBox) sc.lookup("#PaysChoice");
        	ChoiceBox<String> DepartementChoice=(ChoiceBox) sc.lookup("#DepartementChoice");
        	contNom.setText(nomContact);
        	Contact cont=ConnectionClass.trouverContactparNom(nomContact);
        	Nom_text.setText(cont.getNom());
        	Prenom_text.setText(cont.getPrenom());
            Telephone_text.setText(cont.getTelephone());
            Telephone2_text.setText(cont.getTelephone2());
        	Fixe_text.setText(cont.getFixe());
        	Adresse_text.setText(cont.getAdresse());
        	CodePostal_text.setText(cont.getCodePostal());
        	AgenceChoice.setValue(cont.getAgence());
        	Agence2Choice.setValue(cont.getAgence2());
        	FonctionChoice.setValue(cont.getFonction());
        	DepartementChoice.setValue(cont.getDepartement());
        	VilleChoice.setValue(cont.getVille());
        	PaysChoice.setValue(cont.getPays());

            
        }
    }    
}

