package Connection;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import application.Ordinateur;
import application.Telephone;
import application.Peripherique;
import application.Contact;

	public class ConnectionClass {
	    public Connection connection;
	    public  Connection getConnection(){


	        String dbName="tutorial";
	        String userName="root";
	        String password="";

	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();

	        connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        return connection;
	    }
	    public static int saveNew (Ordinateur ord) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="INSERT INTO ordinateurs(Nom, Utilisateur, Groupe, UUID, OS, Numserie, Type, Modele, Statut,AdresseIP,Fabricant,RAM,Affichage,Stockage,Processor) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, ord.getNom());
			         stat.setString(2, ord.getUtilisateur());
			         stat.setString(3, ord.getGroupe());
			         stat.setString(4, ord.getUUID());
			         stat.setString(5, ord.getOS());
			         stat.setString(6, ord.getNumserie());
			         stat.setString(7, ord.getType());
			         stat.setString(8, ord.getModele());
			         stat.setString(9, ord.getStatut());
			         stat.setString(10, ord.getAdresseIP());
			         stat.setString(11, ord.getFabricant());
			         stat.setString(12, ord.getRAM());
			         stat.setString(13, ord.getAffichage());
			         stat.setString(14, ord.getStockage());
			         stat.setString(15, ord.getProcessor());
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static int saveNewTele(Telephone tele) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="INSERT INTO telephones(NumTele, Utilisateur, Departement, Numserie, Type, Modele, Statut,Fabricant) VALUES(?,?,?,?,?,?,?,?)";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, tele.getNumTele());
			         stat.setString(2, tele.getUtilisateur());
			         stat.setString(3, tele.getDepartement());
			         stat.setString(4, tele.getNumserie());
			         stat.setString(5, tele.getType());
			         stat.setString(6, tele.getModele());
			         stat.setString(7, tele.getStatut());   
			         stat.setString(8, tele.getFabricant());   
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static int saveNewPeri(Peripherique peri) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="INSERT INTO peripheriques(Responsable, Utilisateur, Departement, Numserie, Type, Modele, Statut,Fabricant) VALUES(?,?,?,?,?,?,?,?)";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, peri.getResponsable());
			         stat.setString(2, peri.getUtilisateur());
			         stat.setString(3, peri.getDepartement());
			         stat.setString(4, peri.getNumserie());
			         stat.setString(5, peri.getType());
			         stat.setString(6, peri.getModele());
			         stat.setString(7, peri.getStatut());   
			         stat.setString(8, peri.getFabricant());   
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static int saveNewContact(Contact cont) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="INSERT INTO contacts(Nom,Prenom, Telephone,Telephone2, CodePostal,"
			            		+ " Adresse, Fixe,Departement, Agence, Agence2, Ville, Fonction,Pays) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, cont.getNom());
			         stat.setString(2, cont.getPrenom());
			         stat.setString(3, cont.getTelephone());
			         stat.setString(4, cont.getTelephone2());
			         stat.setString(5, cont.getCodePostal());
			         stat.setString(6, cont.getAdresse());
			         stat.setString(7, cont.getFixe());   
			         stat.setString(8, cont.getDepartement()); 
			         stat.setString(9, cont.getAgence()); 
			         stat.setString(10, cont.getAgence2()); 
			         stat.setString(11, cont.getVille()); 
			         stat.setString(12, cont.getFonction()); 
			         stat.setString(13, cont.getPays());
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static int update(Ordinateur ord) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="UPDATE ordinateurs SET Nom=?, Utilisateur=?, Groupe=?, UUID=?, OS=?, Numserie=?, Type=?, Modele=?, Statut=?,AdresseIP=?,Fabricant=?,RAM=?,Affichage=?,Stockage=?,Processor=?"
			            		+ " WHERE Numserie=?";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, ord.getNom());
			         stat.setString(2, ord.getUtilisateur());
			         stat.setString(3, ord.getGroupe());
			         stat.setString(4, ord.getUUID());
			         stat.setString(5, ord.getOS());
			         stat.setString(6, ord.getNumserie());
			         stat.setString(7, ord.getType());
			         stat.setString(8, ord.getModele());
			         stat.setString(9, ord.getStatut());
			         stat.setString(10, ord.getAdresseIP());
			         stat.setString(11, ord.getFabricant());
			         stat.setString(12, ord.getRAM());
			         stat.setString(13, ord.getAffichage());
			         stat.setString(14, ord.getStockage());
			         stat.setString(15, ord.getProcessor());
			         stat.setString(16, ord.getNumserie());
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static int updateTele(Telephone tele) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="UPDATE telephones SET NumTele=?, Utilisateur=?, Numserie=?, Type=?, Modele=?, Statut=?, Departement=?, Fabricant=?"
			            		+ " WHERE Numserie=?";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, tele.getNumTele());
			         stat.setString(2, tele.getUtilisateur());
			         stat.setString(3, tele.getNumserie());
			         stat.setString(4, tele.getType());
			         stat.setString(5, tele.getModele());
			         stat.setString(6, tele.getStatut());
			         stat.setString(7, tele.getDepartement());	
			         stat.setString(8, tele.getFabricant());
			         stat.setString(9, tele.getNumserie());
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static int updatePeri(Peripherique peri) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="UPDATE peripheriques SET Responsable=?, Utilisateur=?, Numserie=?, Type=?, Modele=?, Statut=?, Departement=?, Fabricant=?"
			            		+ " WHERE Numserie=?";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, peri.getResponsable());
			         stat.setString(2, peri.getUtilisateur());
			         stat.setString(3, peri.getNumserie());
			         stat.setString(4, peri.getType());
			         stat.setString(5, peri.getModele());
			         stat.setString(6, peri.getStatut());
			         stat.setString(7, peri.getDepartement());	
			         stat.setString(8, peri.getFabricant());
			         stat.setString(9, peri.getNumserie());
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static int updateContact(Contact cont) {
			   int st=0;
			   try {
		    		ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="UPDATE contacts SET Nom=?,Prenom=?, Telephone=?,Telephone2=?, CodePostal=?, Adresse=?, Fixe=?,Departement=?, Agence=?, Agence2=?, Ville=?, Fonction=?,Pays=?"
			            		+ " WHERE Nom=?";
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, cont.getNom());
			         stat.setString(2, cont.getPrenom());
			         stat.setString(3, cont.getTelephone());
			         stat.setString(4, cont.getTelephone2());
			         stat.setString(5, cont.getCodePostal());
			         stat.setString(6, cont.getAdresse());
			         stat.setString(7, cont.getFixe());   
			         stat.setString(8, cont.getDepartement()); 
			         stat.setString(9, cont.getAgence()); 
			         stat.setString(10, cont.getAgence2()); 
			         stat.setString(11, cont.getVille()); 
			         stat.setString(12, cont.getFonction()); 
			         stat.setString(13, cont.getPays());
			         stat.setString(14, cont.getNom());
			          st=stat.executeUpdate();
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return st;
		 }
	    public static Ordinateur trouverOrdparNumserie(String Numserie) {
			   Ordinateur ord= new Ordinateur();
			   try {
				   ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="SELECT * FROM ordinateurs WHERE Numserie=?";  
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, Numserie);
			         ResultSet rst=stat.executeQuery();
			          //ResultSet resultSet=stat.executeQuery(sql);

			            if (rst.next()){
			                 ord.setNom(rst.getString(1));			              
					         ord.setUtilisateur(rst.getString(2));
					         ord.setGroupe(rst.getString(3));
					         ord.setUUID(rst.getString(4));
					         ord.setOS(rst.getString(5));
					         ord.setNumserie(rst.getString(6));
					         ord.setType(rst.getString(7));
					         ord.setModele(rst.getString(8));
					         ord.setStatut(rst.getString(9));
					         ord.setAdresseIP(rst.getString(10));
					         ord.setFabricant(rst.getString(11));
					         ord.setRAM(rst.getString(12));
					         ord.setAffichage(rst.getString(13));
					         ord.setStockage(rst.getString(14));
					         ord.setProcessor(rst.getString(15));	      
			            }			 		            
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return ord;
		 }
	    
	    public static Telephone trouverTeleparNumserie(String Numserie) {
			   Telephone tele= new Telephone();
			   try {
				   ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="SELECT * FROM telephones WHERE Numserie=?";  
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, Numserie);
			         ResultSet rst=stat.executeQuery();
			          //ResultSet resultSet=stat.executeQuery(sql);

			            if (rst.next()){
			            	tele.setNumTele(rst.getString(1));			              
			            	tele.setUtilisateur(rst.getString(2));
			            	tele.setNumserie(rst.getString(3));
					        tele.setType(rst.getString(4));
					        tele.setModele(rst.getString(5));
					        tele.setStatut(rst.getString(6));
			            	tele.setDepartement(rst.getString(7));
			            	tele.setFabricant(rst.getString(8));
			            	
			            }			 		            
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return tele;
		 }
	    public static Peripherique trouverPeriparNumserie(String Numserie) {
			   Peripherique peri= new Peripherique();
			   try {
				   ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            String sql="SELECT * FROM peripheriques WHERE Numserie=?";  
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, Numserie);
			         ResultSet rst=stat.executeQuery();
			          //ResultSet resultSet=stat.executeQuery(sql);

			            if (rst.next()){
			            	peri.setNumserie(rst.getString(1));
			            	peri.setUtilisateur(rst.getString(2));
			            	peri.setResponsable(rst.getString(3));			             			         
			            	peri.setType(rst.getString(4));
			            	peri.setModele(rst.getString(5));
			            	peri.setStatut(rst.getString(6));
			            	peri.setDepartement(rst.getString(7));
			            	peri.setFabricant(rst.getString(8));
			            	
			            }			 		            
			           connection.close();
	   	}catch(SQLException e) {
	   		e.printStackTrace();
	   		} 
			   return peri;
		 }
	    public static Ordinateur trouverOrdparNom(String Nom) {
			   Ordinateur ord= new Ordinateur();
			   try {
				   ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            //Statement statement=connection.createStatement();
			            String sql="SELECT * FROM ordinateurs WHERE Nom=?";  
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, Nom);
			         ResultSet rst=stat.executeQuery();
			          //ResultSet resultSet=stat.executeQuery(sql);

			            if (rst.next()){
			                 ord.setNom(rst.getString(1));			              
					         ord.setUtilisateur(rst.getString(2));
					         ord.setGroupe(rst.getString(3));
					         ord.setUUID(rst.getString(4));
					         ord.setOS(rst.getString(5));
					         ord.setNumserie(rst.getString(6));
					         ord.setType(rst.getString(7));
					         ord.setModele(rst.getString(8));
					         ord.setStatut(rst.getString(9));
					         ord.setAdresseIP(rst.getString(10));
					         ord.setFabricant(rst.getString(11));
					         ord.setRAM(rst.getString(12));
					         ord.setAffichage(rst.getString(13));
					         ord.setStockage(rst.getString(14));
					         ord.setProcessor(rst.getString(15));
			            }			 		            
			           connection.close();
	   	}catch(SQLException e) {
	   		
	   		e.printStackTrace();
	   		} 
			   return ord;
		 }
	    public static Telephone trouverTeleparNum(String Num) {
			   Telephone tele= new Telephone();
			   try {
				   ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            //Statement statement=connection.createStatement();
			            String sql="SELECT * FROM telephones WHERE NumTele=?";  
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, Num);
			         ResultSet rst=stat.executeQuery();
			          //ResultSet resultSet=stat.executeQuery(sql);

			            if (rst.next()){
			            	tele.setNumTele(rst.getString(1));			              
			            	tele.setUtilisateur(rst.getString(2));
			            	tele.setNumserie(rst.getString(3));
					        tele.setType(rst.getString(4));
					        tele.setModele(rst.getString(5));
					        tele.setStatut(rst.getString(6));
			            	tele.setDepartement(rst.getString(7));
			            	tele.setFabricant(rst.getString(8));
			            }			 		            
			           connection.close();
	   	}catch(SQLException e) {
	   		
	   		e.printStackTrace();
	   		} 
			   return tele;
		 }
	    public static Contact trouverContactparNom(String Nom) {
			   Contact cont= new Contact();
			   try {
				   ConnectionClass connectionClass=new ConnectionClass();
			        Connection connection=connectionClass.getConnection();
			            //Statement statement=connection.createStatement();
			            String sql="SELECT * FROM contacts WHERE Nom=?";  
			         PreparedStatement stat=connection.prepareStatement(sql);
			         stat.setString(1, Nom);
			         ResultSet rst=stat.executeQuery();
			          //ResultSet resultSet=stat.executeQuery(sql);
			            if (rst.next()){
			            	cont.setNom(rst.getString(1));			              
			            	cont.setPrenom(rst.getString(2));
			            	cont.setTelephone(rst.getString(3));
			            	cont.setTelephone2(rst.getString(4));
			            	cont.setCodePostal(rst.getString(5));
			            	cont.setAdresse(rst.getString(6));			            	
			            	cont.setFixe(rst.getString(7));
			            	cont.setDepartement(rst.getString(8));
			            	cont.setAgence(rst.getString(9));
			            	cont.setAgence2(rst.getString(10));
			            	cont.setVille(rst.getString(11));
			            	cont.setFonction(rst.getString(12));
			            	cont.setPays(rst.getString(13));
			            }			 		            
			           connection.close();
	   	}catch(SQLException e) {
	   		
	   		e.printStackTrace();
	   		} 
			   return cont;
		 }
	}



