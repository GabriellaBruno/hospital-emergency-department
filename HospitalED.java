/* 
 * Gabriella Bruno, Jordan Boggs, Judah Lamuren
 * Software Engineering Project
 * Title: HospitalED.java
 * Description: uses a hospital emergency department database to select, update, delete, or add
 * 				database includes patient table, patient history table, and procedure table
 * Date: 04/29/26
 */
 
import java.sql.*;
import java.util.Scanner;

public class HospitalED {
   static final String DB_URL = "jdbc:mysql://localhost/PROJECT";
   static final String USER = "*****";
   static final String PASS = "*******";
   
   public static void main(String[] args) {
	   Scanner scanner = new Scanner(System.in);
	   int choice;
	   int tableChoice;
	   int id;
	   int updateChoice;
	   int lastID = 100;
	   
	   System.out.println("Welcome to the Emergency Department Menu");
	   
	   do {
		   System.out.println("What would you like to do:");
		   System.out.println("1 - Select \n2 - Update \n3 - Delete \n4 - Add \n5 - Leave Program");
		   choice = scanner.nextInt();
		   scanner.nextLine();
		   
		   //select option
		   if(choice == 1) {
			   System.out.println("Which table would you like to Select?");
			   System.out.println("1 - Patients \n2 - Paitent History \n3 - Procedures \n4 - Procedure List (view only)");
			   tableChoice = scanner.nextInt();
			   
			   //choose table to select
			   if(tableChoice == 1) {
				   SelectPatient();
				   System.out.println("");
			   } else if (tableChoice == 2) {
				   SelectPatientHistory();
				   System.out.println("");
			   } else if (tableChoice == 3) {
				   SelectProcedure();
				   System.out.println("");
			   } else if (tableChoice == 4){
				   SelectProcedureList();
			   } else {
				   System.out.println("Error. Try again.");
			   }

			 //update option  
		   } else if (choice == 2) {
			   System.out.println("Which table would you like to Update?");
			   System.out.println("1 - Patients \n2 - Paitent History \n3 - Procedures");
			   tableChoice = scanner.nextInt();
			   
			   System.out.println("Enter ID of change:");
			   id = scanner.nextInt();
			   scanner.nextLine();
			   
			   if(tableChoice == 1) {
				   System.out.println("Which variable would you like to Update?");
				   System.out.println("1 - Full Name \n2 - Gender \n3 - Date of Birth \n4 - Height \n5 - Weight \n6 - Insurance \n7 - Address \n8 - Phone Number \n9 - Emergency Contact");
				   updateChoice = scanner.nextInt();
				   
				   if (updateChoice == 1) { //update name
					   System.out.println("Enter new name:");
					   UpdateFullName(id, scanner.nextLine());
					   //scanner.nextLine();

				   } else if (updateChoice == 2) { //update gender
					   System.out.println("Enter new Gender:");
					   UpdateGender(id, scanner.next());
					   
				   } else if (updateChoice == 3) { //update dob
					   System.out.println("Enter new Date of Birth:");
					   UpdateDOB(id, scanner.next());

				   } else if (updateChoice == 4) { //update height
					   System.out.println("Enter new Height:");
                       String height = scanner.next(); 
                       //scanner.nextLine(); 
					   UpdateHeight(id, height);

				   } else if (updateChoice == 5) { //update weight
						System.out.println("Enter new Weight:");
						UpdateWeight(id, scanner.nextInt());
						scanner.nextLine();

				   } else if (updateChoice == 6) { //update insurance
					   System.out.println("Enter new Insurance:");
					   UpdateInsurance(id, scanner.nextLine());
					   
				   } else if (updateChoice == 7) { //update address   
					   System.out.println("Enter new Address:");
					   UpdateAddress(id, scanner.nextLine());
					   
				   } else if (updateChoice == 8) { //update phone num
					   System.out.println("Enter new Phone Number:");
					   UpdatePhoneNum(id, scanner.nextLine());
					   
				   } else if (updateChoice == 9) { //update emergency contact
					   System.out.println("Enter new Emergency Contact (name, relation, phone number):");
					   UpdateEmergencyContact(id, scanner.nextLine());
					   
				   } else {
					   System.out.println("Error. Try again.");
				   }

			   } else if (tableChoice == 2) {
				   System.out.println("Enter new Patient History Date:");
				   UpdatePatientHistory(id, scanner.next());
				   
			   } else if (tableChoice == 3) {
				   System.out.println("Enter new Procedure:");
				   UpdateProcedure(id, scanner.nextLine());
				   
			   } else {
				   System.out.println("Error. Try again.");
			   }
			   
			   
			 //delete option  
		   } else if (choice == 3) {
			   System.out.println("Which table would you like to Delete from?");
			   System.out.println("1 - Patients \n2 - Paitent History \n3 - Procedures");
			   tableChoice = scanner.nextInt();
			  
			   System.out.println("Enter patient ID");
			   id = scanner.nextInt();
			   
			   //choose table to delete from
			   if(tableChoice == 1) {
				   DeletePatient(id);
				   System.out.println("");
			   } else if (tableChoice == 2) {
				   DeletePatientHistory(id);
				   System.out.println("");
			   } else if (tableChoice == 3) {
				   id = scanner.nextInt();
				   DeleteProcedure(id);
				   System.out.println("");
			   } else {
				   System.out.println("Error. Try again.");
			   }
			   
			 //add option  
		   } else if (choice == 4){
			   
			   System.out.println("Enter Full Name:");
			   String name = scanner.nextLine();
					
			   System.out.println("Enter Gender:");
			   String gender = scanner.nextLine();
					
			   System.out.println("Enter DOB:");
			   String dob = scanner.nextLine();
					
			   System.out.println("Enter Height:");
			   String height = scanner.nextLine();
					
			   System.out.println("Enter Weight:");
			   int weight = scanner.nextInt();
			   scanner.nextLine();
			   
			   System.out.println("Enter Address:");
			   String address = scanner.nextLine();
					
			   System.out.println("Enter Phone Number:");
			   String phone = scanner.nextLine();
					
			   System.out.println("Enter Insurance:");
			   String insurance = scanner.nextLine();
					
			   System.out.println("Enter Emergency Contact (name, relation, phone number):");
			   String emergency = scanner.nextLine();

			   System.out.println("Enter Patient History: "); 
			   String patient_history = scanner.nextLine();
				
			   System.out.println("Enter Injury:");
			   String injury = scanner.nextLine();
			   
			   System.out.println("Enter Procedure ID: ");
			   int procedureId = scanner.nextInt(); 
			   scanner.nextLine();
			   
			   System.out.println("Enter Procedure:"); 
			   String procedure = scanner.nextLine();
			   
			   AddPatient(name, gender, dob, height, weight, insurance, address, phone, emergency, patient_history, procedureId, injury, procedure);

			   //exit program
		   } else if (choice == 5){
			   System.out.println("Goodbye.");

			//out of bounds
		   } else {
			   System.out.println("Error. Try again.");
		   }
		   
	   } while (choice != 5);
	   
   }//end main
   
   
   //select methods
   static void SelectPatient() {
	   String QUERY = "SELECT id, full_name, gender, dob, height, weight, insurance, address, phone_num, emergency_contact FROM Patients";

	   // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Full Name: " + rs.getString("full_name"));
            System.out.print(", Gender: " + rs.getString("gender"));
            System.out.print(", Date of Birth: " + rs.getString("dob"));
            System.out.print(", Height: " + rs.getString("height"));
            System.out.print(", Weight: " + rs.getInt("weight"));
            System.out.print(", Insurance: " + rs.getString("insurance"));
            System.out.print(", Address: " + rs.getString("address"));
            System.out.print(", Phone Number: " + rs.getString("phone_num"));
            System.out.println(", Emergency Contact Info: " + rs.getString("emergency_contact"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }//end static
   
   static void SelectPatientHistory() {
	   String QUERY = "SELECT id, patient_history, procedure_id FROM Pt_History";
  
	   // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet pt = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (pt.next()) {
	            // Retrieve by column name
	            System.out.print("ID: " + pt.getInt("id"));
	            System.out.print(", Patient History Date: " + pt.getString("patient_history"));
	            System.out.println(", Procedure ID: " + pt.getInt("procedure_id"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
   }//end static
   
   static void SelectProcedure() {
	   String QUERY = "SELECT id, injury, procedures FROM Procedures"; 
	   // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet p = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (p.next()) {
	            // Retrieve by column name
	            System.out.print("Patient ID: " + p.getInt("id"));
	            System.out.print(", Injury: " + p.getString("injury"));
	            System.out.println(", Procedure: " + p.getString("procedures"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
   }//end static
   
   static void SelectProcedureList() {
	   String QUERY = "SELECT procedure_id, procedures FROM Procedure_List"; 
	   // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet p = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (p.next()) {
	            // Retrieve by column name
	            System.out.print("Procedure ID: " + p.getInt("procedure_id"));
	            System.out.println(", Procedure: " + p.getString("procedures"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
   }//end static
   
   
   //delete methods
   static void DeletePatient(int id) {
	   String QUERY = "DELETE FROM Patients WHERE id=" + id;  
	// Open a connection
	      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {
	         stmt.executeUpdate(QUERY);
	         System.out.println("Patient history deleted successfully.\n");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }//end static
	   
	   static void 	DeletePatientHistory(int id) {
		   String QUERY = "DELETE FROM Pt_History WHERE id=" + id;  
		// Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient history deleted successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void DeleteProcedure(int id) {
		   String QUERY = "DELETE FROM Procedures WHERE id=" + id;  
		// Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Procedure deleted successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static

	   
	   //update methods
	   static void UpdateFullName(int id, String name) {
		   String QUERY = "UPDATE Patients SET full_name='" + name + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's name updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdateGender(int id, String g) {
		   String QUERY = "UPDATE Patients SET gender='" + g + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's gender updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdateDOB(int id, String dob) {
		   String QUERY = "UPDATE Patients SET dob='" + dob + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's date of birth updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdateHeight(int id, String h) {
		   String s = h;
		   s = s.replace("'", "''");
		   
		   String QUERY = "UPDATE Patients SET height='" + s + "' WHERE id=" + id;
		   System.out.println(QUERY);
		   // Open a connection
		   try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			         Statement stmt = conn.createStatement();
			      ) {
			         stmt.executeUpdate(QUERY);
			         System.out.println("Patient's height updated successfully.\n");
			      } catch (SQLException e) {
			         e.printStackTrace();
		      }
	   }//end static

	   static void UpdateWeight(int id, int w) {
		   String QUERY = "UPDATE Patients SET weight=" + w + " WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's weight updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdateInsurance(int id, String i) {
		   String QUERY = "UPDATE Patients SET insurance='" + i + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's insurance updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdateAddress(int id, String a) {
		   String QUERY = "UPDATE Patients SET address='" + a + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's address updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdatePhoneNum(int id, String pn) {
		   String QUERY = "UPDATE Patients SET phone_num='" + pn + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's phone number updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdateEmergencyContact(int id, String ec) {
		   String QUERY = "UPDATE Patients SET emergency_contact='" + ec + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Patient's emergency contact updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdateProcedure(int id, String p) {
		   String QUERY = "UPDATE Procedures SET procedures='" + p + "' WHERE id=" + id;
		   // Open a connection
		      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {
		         stmt.executeUpdate(QUERY);
		         System.out.println("Procedure updated successfully.\n");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	   }//end static
	   
	   static void UpdatePatientHistory(int id, String ph) {
		   String QUERY = "UPDATE Pt_History SET patient_history='" + ph + "' WHERE id=" + id;
		   // Open a connection
		   try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   Statement stmt = conn.createStatement()) {
			   stmt.executeUpdate(QUERY);
		       System.out.println("Patient history updated successfully.\n");
			   } catch (SQLException e) {
				   e.printStackTrace();
			   } 
		}//end static
	   
	   
	   //add method
	   static void AddPatient(String name, String gender, String dob, String height, int weight, String insurance, String address, String phone, String emergency, String patientHistory, int procedureID, String injury, String procedure) {
		   Scanner keyboard = new Scanner(System.in);

		   boolean exists = false;
		   int id;
		   
		   do {
			  System.out.println("Enter Patient ID:");
			  id = keyboard.nextInt();
			  keyboard.nextLine();
			  
			  String checkID = "SELECT id FROM Patients WHERE id=" + id;
			  
			  try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					  Statement stmt = conn.createStatement();
					  ResultSet rs = stmt.executeQuery(checkID);) {
				  if(rs.next()) {
					  exists = true;
					  System.out.println("Error, Patient ID already exists. Try again.");
				  } else {
					  exists = false;
				  }
			  } catch (SQLException e) {
				   e.printStackTrace();
			   }  
			  
		  } while(exists);   
		   
		   String s = height;
		   s = s.replace("'", "''");
		   
		   String sql1 = "INSERT INTO Patients " + "(id, full_name, gender, dob, height, weight, insurance, address, phone_num, emergency_contact) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			   
		   String sql2 = "INSERT INTO Procedures " + "(id, injury, procedures) VALUES (?, ?, ?)";
			  
		   String sql3 = "INSERT INTO Pt_History " + "(id, patient_history, procedure_id) VALUES (?, ?, ?)";
			   
			   try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			   // ---------- Patients ----------
			   try (PreparedStatement ps1 = conn.prepareStatement(sql1)) {
				   ps1.setInt(1, id);
				   ps1.setString(2, name);
				   ps1.setString(3, gender);
				   ps1.setString(4, dob);
				   ps1.setString(5, s);
				   ps1.setInt(6, weight);
				   ps1.setString(7, insurance);
				   ps1.setString(8, address);
				   ps1.setString(9, phone);
				   ps1.setString(10, emergency);
				   ps1.executeUpdate();
			   }
			   // ---------- Procedures ----------
			   try (PreparedStatement ps2 = conn.prepareStatement(sql2)) {
				   ps2.setInt(1, id);
				   ps2.setString(2, injury);
				   ps2.setString(3, procedure);
				   ps2.executeUpdate();
			   }
			   // ---------- Patient History ----------
			   try (PreparedStatement ps3 = conn.prepareStatement(sql3)) {
				   ps3.setInt(1, id);
				   ps3.setString(2, patientHistory);
				   ps3.setInt(3, procedureID);
				   ps3.executeUpdate();
			   }
			   System.out.println("Patient and related records added successfully.\n");
			   } catch (SQLException e) {
				   e.printStackTrace();
			   }
	   }//end static
	   
}//end class
