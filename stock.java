package gestion_de_stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JTable table_1;
	private DefaultTableModel tablemodel;
	private JTextField textField_5;
		Connection con;
	    Statement stm;
	    ResultSet rst;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock frame = new stock();
					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public stock() {
	 	Base obj = new Base();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodeProduit = new JLabel("Code produit");
		lblCodeProduit.setBounds(55, 43, 100, 14);
		contentPane.add(lblCodeProduit);
		
		textField = new JTextField();
		textField.setBounds(156, 41, 104, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fournisseur");
		lblNewLabel.setBounds(55, 149, 85, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 147, 104, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prix");
		lblNewLabel_1.setBounds(55, 203, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 199, 104, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuantit = new JLabel("Quantité");
		lblQuantit.setBounds(55, 249, 56, 14);
		contentPane.add(lblQuantit);
		
		textField_3 = new JTextField();
		textField_3.setBounds(156, 247, 104, 18);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblDesingation = new JLabel("Desegnation");
		lblDesingation.setBounds(55, 92, 85, 14);
		contentPane.add(lblDesingation);
		
		textField_4 = new JTextField();
		textField_4.setBounds(156, 90, 104, 18);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	    //System.out.println(table_1.getSelectedRow());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 275, 520, 171);
		contentPane.add(scrollPane);
		
		/*columns=new String[] {
				"Check","Code produit", "Desegnation", "Fournisseur", "Prix", "Quantite"
			};
		rows=new Object[][] {
		};*/
	   
		//table = new JTable();
		table_1 = new JTable(tablemodel);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code produit", "Desegnation", "Fournisseur", "Prix", "Quantite"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_1);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")|| textField_3.getText().equals("")|| textField_4.getText().equals("")){
					JOptionPane.showMessageDialog(null, "PLS ENTER ALL DATA");
				}
				else {
					//i=i+1;
				    //list.add(i);

				    Object[] row = {textField.getText(), textField_4.getText(), textField_1.getText() , textField_2.getText(), textField_3.getText() };
				    DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();
				    tablemodel.addRow(row);

				    obj.ajouter(Integer.parseInt(textField.getText()), textField_4.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()));
				    textField.setText("");
				    textField_1.setText("");
				    textField_2.setText("");
				    textField_3.setText("");
				    textField_4.setText("");
		            table_1.getSelectionModel().clearSelection();


			}
			}

		});
		btnAjouter.setBounds(363, 38, 100, 24);
		contentPane.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				   //DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRow()!=-1) {
			       int k = table_1.getSelectedRow();
				   DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();
	               System.out.println(k);
				   obj.supprimer(Integer.parseInt(tablemodel.getValueAt(k, 0).toString()),(String)tablemodel.getValueAt(k, 1),(String)tablemodel.getValueAt(k, 2),Integer.parseInt(tablemodel.getValueAt(k, 3).toString()));
	               tablemodel.removeRow(k);	


				}

				   //obj.supprimer((int)tablemodel.getValueAt(i, 0), (String)tablemodel.getValueAt(i, 1),(String)tablemodel.getValueAt(i, 2),(int)tablemodel.getValueAt(i, 3));
			    /*textField.setText("");
			    textField_1.setText("");
			    textField_2.setText("");
			    textField_3.setText("");
			    textField_4.setText("");*/
			  //Delete Selected Row        
		        //Check if their is a row selected
		       
	               // supprimer la ligne sélectionnée du modèle de table
				/*try {
		       // textField_5.setText(Integer.toString(table_1.getSelectedRow()));

				//int d = Integer.parseInt(textField_5.getText());
				//int x = list.indexOf(d);
				//list.remove(d);
				   
			       DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();
			       int z = table_1.getSelectedRow();
	               tablemodel.removeRow(z);
	               //tablemodel.removeRow(table_1.getSelectedRow());
	               

			       //tablemodel.removeRow(table_1.getSelectedRow());
	               JOptionPane.showMessageDialog(null, "Deleted successfully");}
				catch(Exception e){
					//int d = Integer.parseInt(textField_5.getText());
					System.out.println(e+"index is ");
					//JOptionPane.showMessageDialog(null,e);
					}*/
				

				
			}
		});
		btnSupprimer.setBounds(363, 87, 100, 24);
		contentPane.add(btnSupprimer);
		 //Récupérer la ligne sélectionnée de JTable dans JTextfields
        table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
        @Override
        public void valueChanged(ListSelectionEvent e) {
        	if(table_1.getSelectedRow()!=-1) {
              int k= table_1.getSelectedRow();
			  DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();
			/*  textField.setText((String)tablemodel.getValueAt(k, 0));
              textField_4.setText((String)tablemodel.getValueAt(k, 1));
              textField_1.setText((String)tablemodel.getValueAt(k, 2));
              textField_2.setText((String)tablemodel.getValueAt(k, 3));
              textField_3.setText((String)tablemodel.getValueAt(k, 4));*/

			  

              textField.setText(Integer.toString(Integer.parseInt(tablemodel.getValueAt(k, 0).toString())));
              textField_4.setText((String)tablemodel.getValueAt(k, 1));
              textField_1.setText((String)tablemodel.getValueAt(k, 2));
              textField_2.setText(Integer.toString(Integer.parseInt(tablemodel.getValueAt(k, 3).toString())));
              textField_3.setText(Integer.toString(Integer.parseInt(tablemodel.getValueAt(k, 4).toString())));
			  }

          }
      });
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_1.getSelectedRow() != -1) {
		               //Mettre à jour le formulaire
		               int i = table_1.getSelectedRow();
		               
		               ((DefaultTableModel)table_1.getModel()).setValueAt(textField.getText(), i, 0);
		               ((DefaultTableModel)table_1.getModel()).setValueAt(textField_4.getText(), i, 1);
		               ((DefaultTableModel)table_1.getModel()).setValueAt(textField_1.getText(), i, 2);
		               ((DefaultTableModel)table_1.getModel()).setValueAt(textField_2.getText(), i, 3);
		               ((DefaultTableModel)table_1.getModel()).setValueAt(textField_3.getText(), i, 4);
					    obj.modifier(Integer.parseInt(textField.getText()), textField_4.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()));

		               table_1.getSelectionModel().clearSelection();



				
				}
			}
		});
		btnModifier.setBounds(363, 144, 100, 24);
		contentPane.add(btnModifier);
		
		JButton btnTest = new JButton("Clear");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
			    textField_1.setText("");
			    textField_2.setText("");
			    textField_3.setText("");
			    textField_4.setText("");

			}
		});
		btnTest.setBounds(363, 193, 100, 24);
		contentPane.add(btnTest);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(662, 422, 100, 24);
		contentPane.add(btnExit);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();

		        try{
			 		//Connection con;
				    //Statement stm;
				    ResultSet rst;
				    Statement stm = obj.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		            String query="select * from stock where code_produit='"+textField_5.getText()+"'";
		            rst=stm.executeQuery(query);
		            rst.last();

		            int nbrRow=0;
		            nbrRow=rst.getRow();
		            //System.out.println(nbrRow);

		            if(nbrRow!=0) {
			            tablemodel.setRowCount(0);

			           
			                 int code=rst.getInt(""+ "code_produit");
			                 String desegnation=rst.getString("desegnation");
			                 String fournisseur=rst.getString("fournisseur");
			                 int prix=rst.getInt("prix");
			                 int quantité=rst.getInt("quantité");
			 	             //Object[] row = {code,desegnation,fournisseur,prix,quantité};
			 	   	         tablemodel.addRow(new Object[]{code,desegnation,fournisseur,prix,quantité});

			            }
		            else {
		            	JOptionPane.showMessageDialog(null, "There is no code produit = "+textField_5.getText());}

		        
		         }catch(Exception s){
		         System.out.println("Erreur:"+s);
		         }
				
			}
		});
		btnChercher.setBounds(518, 139, 100, 24);
		contentPane.add(btnChercher);
		
		textField_5 = new JTextField();
		textField_5.setBounds(518, 90, 104, 18);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCodeproduit = new JLabel("Code_produit");
		lblCodeproduit.setBounds(518, 64, 104, 14);
		contentPane.add(lblCodeproduit);
		
		JButton btnActualis = new JButton("Actualisé");
		btnActualis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();

	            tablemodel.setRowCount(0);
	            
	            
	            

				try{

			 		Connection con;
				    Statement stm;
				    ResultSet rst;
			            String query="select * from stock " ;//limit pour limiter la selection 

			            rst=obj.stm.executeQuery(query);
			            //DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();

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
			}
			
		});
		btnActualis.setBounds(363, 239, 100, 24);
		contentPane.add(btnActualis);
		
	     try{

	 		Connection con;
		    Statement stm;
		 ResultSet rst;
	            String query="select * from stock " ;//limit pour limiter la selection 

	            rst=obj.stm.executeQuery(query);
	            DefaultTableModel tablemodel = (DefaultTableModel) table_1.getModel();

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
	}
}
