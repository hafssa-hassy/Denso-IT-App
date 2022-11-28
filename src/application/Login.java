package application;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Connection.ConnectionClass;

public class Login implements Initializable {

	    @FXML
	    private Button connexionButton;
	    @FXML
	    private Label wronglogin;
	    @FXML
	    private TextField username;
	    @FXML
	    private PasswordField password;
	    @FXML
	    private Button annulerButton;
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    password.setOnKeyPressed(e ->{
			if (e.getCode()== KeyCode.ENTER) {
				try {
					checkLogin();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
					
				
			}
			});
	    }
	    public void userLogIn(ActionEvent event) throws IOException,SQLException {
	        checkLogin();

	    }
	    public void annulerLogin(ActionEvent event) throws IOException {
	        backtoLogin();

	    }
	    private void checkLogin() throws IOException,SQLException {
	    	
	    				Main m = new Main();
	    		        ConnectionClass connectionClass=new ConnectionClass();
	    		        Connection connection=connectionClass.getConnection();
	    		            Statement statement=connection.createStatement();
	    		           // String sql1="INSERT INTO userauth VALUES('hafssa','123') ";
	    			       // statement.executeUpdate(sql1);

	    		            String sql="SELECT * FROM userauth WHERE username = '"+username.getText()+"' AND password = '"+password.getText()+"';";
	    		            ResultSet resultSet=statement.executeQuery(sql);

	    		            if (resultSet.next()){
	    		                wronglogin.setText("Connected");
	    		                m.changeScene("dashboard.fxml");
	    		            }else if(username.getText().isEmpty() && password.getText().isEmpty()) {
	    			            wronglogin.setText("Veuillez entrer votre nom d'utilisateur et votre mot de passe");
	    		            }
	    		            else {
	    			            wronglogin.setText("Nom d'utilisateur ou mot de passe incorrect!");
	    			        }
	    			
	            
	    }
	    
	      /* if(username.getText().toString().equals("hafssahassy") && password.getText().toString().equals("123")) {
	            wronglogin.setText("Success!");
	            ConnectionClass connectionClass=new ConnectionClass();
		        Connection connection=connectionClass.getConnection();
		        
		        String sql="INSERT INTO user VALUES ('"+username.getText()+"')";
		        Statement statement=connection.createStatement();
		        statement.executeUpdate(sql);
		        
		        
		        
	            m.changeScene("dashboard.fxml");
	        }

	        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
	            wronglogin.setText("Veuillez entrer votre nom d'utilisateur et votre mot de passe");
	        }


	        else {
	            wronglogin.setText("Nom d'utilisateur ou mot de passe incorrect!");
	        }*/
	    
	    private void backtoLogin() throws IOException {
	    	 Main m = new Main();
	    	 m.changeScene("Sample.fxml");
	    	
	    	}

	    }

