package gestion_de_stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

public class Base {
	
		Connection con;
	    Statement stm;
	    ResultSet rst;

	    Base(){
	    
	    	try{
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root","password");        
	    		stm=con.createStatement();
	    		System.out.println("Connexion bien établie");
		
		}	catch(Exception e) {
				System.out.println("somthing wrong "+e);
		}}
	    public void ajouter(int textField,String textField_4,String textField_1,int textField_2,int textField_3){
	        try{
	            String query="INSERT INTO stock VALUES ("+textField+",'"+textField_4+"','"+textField_1+"',"+textField_2+","+textField_3+")";
	            stm.executeUpdate(query);
	                      
	         }catch(Exception e){
	         System.out.println("Erreur:"+e);
	         }
	    }
	    public Object[] getData_2() {
	    	try{
	    	     String query="select * from login ";
	    	           //limit pour limiter la selection 

	             //rsta=stm.executeQuery(query);

	    	     Statement stmt = con.createStatement();
	    	     ResultSet rsta = stmt.executeQuery(query);
	    	     rsta.next();
	    	     String nom=rsta.getString("nom");
	    	     String pass=rsta.getString("pass");
	    	     Object[] row = {nom,pass};
	    	     return row;


	    	               

	    	        }catch(Exception e){
	    	        System.out.println("Erreur:"+e);
	    	        }
	    	return null;
	    	}
	    int i=0;
	    public void getData(){
	        try{
	        	stock obj=new stock();
	        	
	            String query="select * from stock " ;//limit pour limiter la selection 
	            rst=stm.executeQuery(query);
	            DefaultTableModel tablemodel = (DefaultTableModel) obj.table_1.getModel();

	            while(rst.next()){
	                 int code=rst.getInt(""+ "code_produit");
	                 String desegnation=rst.getString("desegnation");
	                 String fournisseur=rst.getString("fournisseur");
	                 int prix=rst.getInt("prix");
	                 int quantité=rst.getInt("quantité");
	 	             //Object[] row = {code,desegnation,fournisseur,prix,quantité};
	 	   	         tablemodel.addRow(new Object[]{code,desegnation,fournisseur,prix,quantité});

	            }
	            
	 //System.out.println(rst);
	         }catch(Exception e){
	         System.out.println("Erreur:"+e);
	         }
//	        
	    }
	    public void supprimer(int textField,String textField_4,String textField_1,int textField_2){
	        try{
	            String query="DELETE FROM stock where code_produit='"+textField+"' and desegnation='"+textField_4+"' and fournisseur='"+textField_1+"' and prix='"+textField_2+"'" ;
	            stm.executeUpdate(query);
	            System.out.println("etudiant bien supprimé!!");
	                      
	         }catch(Exception e){
	         System.out.println("Erreur:"+e);
	         }
	    }
	    public void modifier(int textField,String textField_4,String textField_1,int textField_2,int textField_3){
	        try{
	            String query="update stock set code_produit='"+textField
	                             +"',desegnation='"+textField_4 
	                             +"',fournisseur='"+textField_1 
	                             +"',prix='"+textField_2
	                             +"',quantité='"+textField_3

	                             + "'Where desegnation='"+textField_4+"' and fournisseur='"+textField_1+"'";
	            stm.executeUpdate(query);
	                      
	         }catch(Exception e){
	         System.out.println("Erreur:"+e);
	         }
	        
	    }
	    public void chercher(String nom){
	        try{
	            String query="select * from stock where code_produit='"+nom+"'";
	            rst=stm.executeQuery(query);
	            rst.last();
	            int nbrRow=0;
	            nbrRow=rst.getRow();
	            System.out.println(nbrRow);
	            if(nbrRow!=0)
	                System.out.println("Etudiant trouvé\t"+nbrRow);
	            else
	                System.out.println("Etudiant non trouvé");
	         }catch(Exception e){
	         System.out.println("Erreur:"+e);
	         }
	    }
	}

