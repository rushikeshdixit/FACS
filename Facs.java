import java.sql.*;
import java.util.Date;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Facs {
	public static Connection connection=null;
    Statement stmt=null;
    
    public Facs(){} 
    
    
    public static void DBConnection()
    {
        String url = "jdbc:oracle:thin:@localhost:1521:CSE1";
        String dbId="sks8145"; // Replace with Network ID
        String dbPwd="5tv8hVvcpoi";//Replace with Oracle Password
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection=DriverManager.getConnection(url, dbId, dbPwd);
        }
        catch(ClassNotFoundException e) {
            System.out.println("LOADING ERROR:"+e.toString());
        }
        catch(SQLException se) {
            System.out.println("Connection Failed!! Check output console : ");
            se.printStackTrace();
            return;
        }
        
        if (connection != null) {
			System.out.println("Connection Successful! Make your selection");
		} else {
			System.out.println("Connection Not Found!");
		}
    }
    
    public static void main (String args[]) throws IOException {
    	Facs j = new Facs();
    	String choice = "",table="", ID="",colName="";
    	int mainMenu = 0, displayTables = 0, generateReports = 0, updateTables = 0, changeValue=0;
    	int insertIntoTable=0, deleteFromTable=0;
    	Statement check;
    	
    	InputStreamReader iStream = new InputStreamReader(System.in);
    	BufferedReader stdin = new BufferedReader(iStream);
    	
    	do {
    		System.out.println("-------------------------------------------------------------------");
            System.out.println("\n-----------------------------WELCOME-----------------------------\n");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("\n\n Please select from the following options : ");
            System.out.println("\n 1: Display Firm Details");
            System.out.println("\n 2: Generate Reports");
            System.out.println("\n 3: Update Information");
            System.out.println("\n 4: Insert New Information");
            System.out.println("\n 5: Delete Information");
            System.out.println("\n 6: Exit");
            System.out.println("\n\nSelect ->");
            try {
            	choice = stdin.readLine();
            	mainMenu = Integer.parseInt(choice);
            }
            catch(NumberFormatException e1) {
            	System.out.println("Not a valid choice! Choose properly.....");
            }
            
            try {
            	switch(mainMenu) {
	            	case 1:
	            	{
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		
	            		do {
	            			System.out.println("\n 1: Display All Customers: ");
	            			System.out.println("\n 2: Display Enquirers: ");
	            			System.out.println("\n 3: Display Applicants: ");
	            			System.out.println("\n 4: Display Employees: ");
	            			System.out.println("\n 5: Display Branches: ");
	            			System.out.println("\n 6: Display Services: ");
	            			System.out.println("\n 7: Display Visa Statuses: ");
	            			System.out.println("\n 8: Display University Applications: ");
	            			System.out.println("\n 9: Display Classes: ");
	            			System.out.println("\n 10: Display Schedule of Classes: ");
	            			System.out.println("\n 11: Applicant Enrollment Details: ");
	            			System.out.println("\n 12: Employee Ratings: ");
	            			System.out.println("\n 13: Inquiries: ");
	            			System.out.println("\n 14: Exit");
	            			
	            			System.out.println("\n\n Select -> ");
	            			displayTables = Integer.parseInt(input.readLine());
	            			
	            			switch(displayTables) {
	            			case 1:
	            			{
	            				j.displayTableCustomer();
	            				break;
	            			} //End of Case 1 displayTables
	     
	            			case 2:
	            			{
	            				j.displayTableEnquirer();
	            				break;
	            			} //End of Case 2 displayTables
	            			
	            			case 3:
	            			{
	            				j.displayTableApplicant();
	            				break;
	            			}//End of Case 3 displayTables
	            			
	            			case 4:
	            			{
	            				j.displayTableEmployee();
	            				break;
	            			} //End of Case 4 displayTables
	            			
	            			case 5:
	            			{
	            				j.displayTableBranch();
	            				break;
	            			} //End of Case 5 displayTables
	            			
	            			case 6:
	            			{
	            				j.displayTableService();
	            				break;
	            			} //End of Case 6 displayTables
	            			
	            			case 7:
	            			{
	            				j.displayTableVisaRecord();
	            				break;
	            			} //End of Case 7 displayTables
	            			
	            			case 8:
	            			{
	            				j.displayTableUniversityApp();
	            				break;
	            			} //End of Case 8 displayTables
	            			
	            			case 9:
	            			{
	            				j.displayTableTutorClass();
	            				break;
	            			} //End of Case 9 displayTables
	            			
	            			case 10:
	            			{
	            				j.displayTableClassSchedule();
	            				break;
	            			} //End of Case 10 displayTables
	            			
	            			case 11:
	            			{
	            				j.displayTableEnrollsIn();
	            				break;
	            			} //End of Case 11 displayTables
	            			
	            			case 12:
	            			{
	            				j.displayTableRates();
	            				break;
	            			} //End of Case 12 displayTables
	            			
	            			case 13:
	            			{
	            				j.displayTableEnquiresAt();
	            				break;
	            			} //End of Case 14 displayTables
	            			
	            			case 14:
	            			{
	            				break;
	            			} //End of Case 15 displayTables
	            			
	            			default:
	            				System.out.println("Wrong Input....");
	            				break;
	            			}
	            		} while(displayTables != 14);
	            			
	            	break;
	            	} //Case 1 mainMenu end
	            	
	            	case 2:
	            	{
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		
	            		do {
	            			System.out.println("\n 1: Compare Enquiries and Enrollment: ");
	            			System.out.println("\n 2: Enquiries and Enrollment Location Evaluation");
	            			System.out.println("\n 3: Customer's Country Preferences");
	            			System.out.println("\n 4: Individual Services Revenue");
	            			System.out.println("\n 5: Profit Report");
	            			System.out.println("\n 6: Tutor Audit");
	            			System.out.println("\n 7: Counselor's Performance Report");
	            			System.out.println("\n 8: Tutor Class Popularity");
	            			System.out.println("\n 9: VISA Analysis");
	            			System.out.println("\n 10: Exit");
	            			System.out.println("\n\n Select ->");
	            			generateReports = Integer.parseInt(input.readLine());
	            			
	            			switch(generateReports) {
		            			case 1:
		            			{
		            				j.generateReport1();
		            				break;
		            			}
		            			
		            			case 2:
		            			{
		            				j.generateReport2();
		            				break;
		            			}
		            			
		            			case 3:
		            			{
		            				j.generateReport3();
		            				break;
		            			}
		            			
		            			case 4:
		            			{
		            				j.generateReport4();
		            				break;
		            			}
		            			
		            			case 5:
		            			{
		            				j.generateReport5();
		            				break;
		            			}
		            			
		            			case 6:
		            			{
		            				j.generateReport6();
		            				break;
		            			}
		            			
		            			case 7:
		            			{
		            				j.generateReport7();
		            				break;
		            			}
		            			
		            			case 8:
		            			{
		            				j.generateReport8();
		            				break;
		            			}
		            			
		            			case 9:
		            			{
		            				j.generateReport9();
		            				break;
		            			}
		            			
		            			case 10:
		            			{
		            				break;
		            			}
		            			
		            			default:
		            				System.out.println("Wrong Input! .........");
		            				System.out.println("\n\nChoose Again:");
	            			}
	            		}while(generateReports != 10);
	            	break;
	            	} //End of case 2 mainMenu()

	            	case 3:
	            	{
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		
	            		do {
	            			int customerID = 0;
	            			
	            			System.out.println("\n 1: Update Table Customer");
	            			System.out.println("\n 2: Exit");
	            			System.out.println("\n\n Select your choice: ");
	            			updateTables = Integer.parseInt(input.readLine());
	            			
	            			switch(updateTables) {
		            			case 1:
		            			{
		            				table = "F16_12_customer";
		            				ID = "customerID";
		            				
		            				System.out.println("Enter Customer ID: ");
		            				customerID = Integer.parseInt(input.readLine());
		            				
		            				check = connection.createStatement();
		            				ResultSet rs = check.executeQuery("select customerID from " + table + 
		            												" where customerID = " + customerID); 
		            				
		            				String checkCustomer = null;
		            				while(rs.next()) {
		            					checkCustomer = rs.getString(1);
		            				}
		            				if(checkCustomer != null) {
		            								            				
			            				do {
			            					System.out.println(" 1: Update Phone Number ");
			            					System.out.println(" 2: Update State ");
			            					System.out.println(" 3: Update Email ");
			            					System.out.println(" 4: Exit ");
			            					System.out.println("\n\n Select ->");
			            					
			            					changeValue = Integer.parseInt(input.readLine());

			            					switch(changeValue) {
				            				case 1:
				            				{
				            					String phone;
				            					colName = "phone";
				            					System.out.println("\n\nNew Phone: ");
				            					phone = stdin.readLine();
				            					phone.trim();
				            					
				            					j.updateCustomerPhone(table,ID,colName,customerID,phone);
				            					
				            					break;
				            				}	
				            				case 2:
				            				{
				            					String state;
				            					colName = "state";
				            					System.out.println("\n\nNew State: ");
				            					state = stdin.readLine();
				            					state.trim();
				            					
				            					j.updateCustomerState(table,ID,colName,customerID,state);
				            					
				            					break;
				            				}
				            				case 3:
				            				{
				            					String email;
				            					colName = "emailID";
				            					System.out.println("New Email: ");
				            					email = stdin.readLine();
				            					email.trim();
				            					
				            					j.updateCustomerEmail(table,ID,colName,customerID,email);
				            					
				            					break;
				            				}
				            				
				            				case 4:
				            				{
				            					break;
				            				}
			            				
			            				} //Case 1 changeValue switch end 
			            			}while(changeValue != 4);

		            				} else {
		            					System.out.println("\n\nNot a valid customer number");
		            					System.out.println("\nChoose Again:\n\n");
		            				}
		            				
		            						            		
		            				break;
		            		} //updateTable Case1 end
		            				
		            			
		            			case 2:
		            			{
		            				System.out.println("Going back to main menu...........");
		            				System.out.println("\n\n\n\n");
		          
		            				break;
		            			}
	            			}
	            		}while(updateTables != 2);
	            	break;
	            	} //End of case 3 mainMenu()

	            	case 4:
	            	{
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		
	            		do {
	            			System.out.println("\n1: New Customer");
		            		System.out.println("\n2: Exit");
		            		System.out.println("\n\n Select ->");
		            		
		            		insertIntoTable = Integer.parseInt(input.readLine());
		            		
		            		switch(insertIntoTable) {
			            		case 1:
			            		{
			            			int custID, temp_custID, zipCode;
			            			String fName, mName, lName, phone, email, blockNo, street;
			            			String apartment, state, dateofBirth;
			            			
			            			System.out.println("\nNew Customer Number:    ");
			            			temp_custID = Integer.parseInt(input.readLine());
			            			check = connection.createStatement();
		            				ResultSet rs = check.executeQuery("select customerID from F16_12_customer"
		            							+ " where customerID = " + temp_custID); 
		            				
		            				String checkCustomer = null;
		            				while(rs.next()) {
		            					checkCustomer = rs.getString(1);
		            				}
		            				if(checkCustomer == null) {
		            					custID = temp_custID;
		            				} else {
		            					System.out.println("Customer information already present");
		            					break;
		            				}
			            			
			            			
			            			System.out.println("\nFirst Name:             ");
			            			fName = stdin.readLine(); fName.trim();
			            			System.out.println("\nMiddle Name:            ");
			            			mName = stdin.readLine(); mName.trim();
			            			System.out.println("\nLast Name:              ");
			            			lName = stdin.readLine(); lName.trim();
			            			System.out.println("\nDate of Birth:          ");
			            			dateofBirth = stdin.readLine();
			            			
			            			System.out.println("\nPhone Number:           ");
			            			phone = stdin.readLine();
			            			if(phone.length() != 10){
			            				System.out.println("Not enough values");
			            				break;
			            			}
			            			
			            			System.out.println("\nEmail ID:               ");
			            			email = state = stdin.readLine();
			            			System.out.println("\nBlock Number:           ");
			            			blockNo = state = stdin.readLine();
			            			System.out.println("\nStreet:                 ");
			            			street = stdin.readLine();
			            			System.out.println("\nApartment:              ");
			            			apartment = stdin.readLine();
			            			System.out.println("\tState:                  ");
			            			state = stdin.readLine();
			            			System.out.println("\nZIP Code:               ");
			            			zipCode = Integer.parseInt(input.readLine());
			            			
			            			j.insertIntoCustomer(custID,fName,mName,lName,dateofBirth,phone,email,blockNo,
			            					street,apartment,state,zipCode);
			            			
			            			break;
			            		}
			            		
			            		case 2:
			            		{
			            			break;
			            		}
		            		}	
	            		}while(insertIntoTable != 2);
	            	
	            	break;
	            		
	            	} //End of case 4 mainMenu()

	            	case 5:
	            	{
	            		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	            		j.DBConnection();
	            		
	            		do {
	            			System.out.println("\n1: Delete Customer");
		            		System.out.println("\n2: Exit");
		            		System.out.println("\n\nSelect ->");
		            		deleteFromTable = Integer.parseInt(input.readLine());
		            		
		            		switch(deleteFromTable){
			            		case 1:
			            		{
			            			table = "F16_12_customer";
		            				ID = "customerID";
		            				
		            				System.out.println("Enter Customer ID: ");
		            				int customerID = Integer.parseInt(input.readLine());
		            				
		            				check = connection.createStatement();
		            				ResultSet rs = check.executeQuery("select customerID from " + table + 
		            												" where customerID = " + customerID); 
		            				
		            				String checkCustomer = null;
		            				while(rs.next()) {
		            					checkCustomer = rs.getString(1);
		            				}
		            				if(checkCustomer != null) {
		            					
		            					j.deleteFromCustomer(customerID);
		            				} else {
		            					
		            					System.out.println("\nNot a valid customer number");
		            					System.out.println("\nChoose Again:\n\n");
		            				}
		            				
		            						            		
		            				break;
			            		}
			            		
			            		case 2:
			            		{
			            			break;
			            		}
		            		}
	            		}while(deleteFromTable != 2);
	            		
	            	break;
	            	}
	            	
	            	case 6:
	            	{
	            		System.out.println("System Exiting........");
	            		break;
	            	}
	            	
	            	default:
	            	{
	            		System.out.println("Invalid Choice!!");
	            		break;
	            	}
	            		
            	}
            }
            	catch(Exception e) {
            		
            	}
       }while(mainMenu !=6);

    } // end of switch mainMenu

private void displayTableCustomer(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_customer");
		System.out.println("\n\nCustomer Information: ");
		System.out.println("\n\n CUSTOMER_ID FIRST_NAME MIDDLE_NAME LAST_NAME "
				+ "DOB PHONE_NUMBER EMAIL_ID BLOCK STREET APARTMENT STATE ZIP");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) +
								"\t " + rs.getString(3) + "\t " + rs.getString(4) +
								"\t " + rs.getString(5) + "\t " + rs.getString(6) +
								"\t " + rs.getString(7) + "\t " + rs.getString(8) +
								"\t " + rs.getString(9) + "\t " + rs.getString(10) +
								"\t " + rs.getString(11) + "\t " + rs.getString(12)
					);
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableCustomer() method

private void displayTableEnquirer(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_enquirer");
		System.out.println("\n\nCustomer Information: ");
		System.out.println("\n\n ENQUIRER_ID\t COUNTRY_PREFERENCE");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableEnquirer() method

private void displayTableApplicant(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_applicant");
		System.out.println("\n\nCustomer Information: ");
		System.out.println("\n\n APPLICANT_ID EDUCATION_STATUS\t COUNTRY_PREFERENCE\t UNIVERSITY_PREFERENCE");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) +
								"\t " + rs.getString(3) + "\t " + rs.getString(4)
					);
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableApplicant() method

private void displayTableEmployee(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_employee");
		System.out.println("\n\nCustomer Information: ");
		System.out.println("\n\n EMPLOYEE_ID\t FIRST_NAME MIDDLE_NAME LAST_NAME "
				+ "PHONE_NUMBER DESIGNATION MONTHLY_SALARY BRANCH START_DATE END_DATE");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) +
								"\t " + rs.getString(3) + "\t " + rs.getString(4) +
								"\t " + rs.getString(5) + "\t " + rs.getString(6) +
								"\t " + rs.getString(7) + "\t " + rs.getString(8) +
								"\t " + rs.getString(9) + "\t " + rs.getString(10)
					);
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableEmployee() method

private void displayTableBranch(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_branch");
		System.out.println("\n\nCustomer Information: ");
		System.out.println("\n\n BRANCH_ID\t BRANCH_LOCATION\t MANAGER_ID");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) +"\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableBranch() method

private void displayTableService(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_service");
		System.out.println("\n\nServices Available: ");
		System.out.println("\n\n SERVICE_ID\t SERVICE_FEE\t SERVICE_TYPE");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) +"\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableService() method

private void displayTableVisaRecord(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_visaRecord");
		System.out.println("\n\nApplicant's Visa Application Status: ");
		System.out.println("\n\n SERVICE_ID\t INTERVIEW_DATE\t VISA_STATUS");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) +"\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableVisaRecords() method

private void displayTableUniversityApp(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_universityApplication");
		System.out.println("\n\nApplicant's University Application Status: ");
		System.out.println("\n\n SERVICE_ID\t UNIVERSITY_NAME\t  APPLICANT_STATUS");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableUniversityApp() method

private void displayTableTutorClass(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_tutorClass");
		System.out.println("\n\nTutoring Classes: ");
		System.out.println("\n\n SERVICE_ID CLASS_TYPE");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableTutorClass() method

private void displayTableClassSchedule(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_classSchedule");
		System.out.println("\n\nClass Schedule: ");
		System.out.println("\n\n SERVICE_ID\t SECTION\t CLASS_DAY\t CLASS_TIME");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) +
								"\t " + rs.getString(3) + "\t " + rs.getString(4)
					);
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableSchedule() method

private void displayTableEnrollsIn(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_enrollsIn");
		System.out.println("\n\nService Enrollment Details: ");
		System.out.println("\n\n APPLICANT_ID \t BRANCH_ID \t EMPLOYEE_ID \t SERVICE_ID \t APPLICANT_DOJ");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3) 
								+ "\t " + rs.getString(4) + "\t " + rs.getString(5)
					);
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableCustomer() method

private void displayTableRates(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_rates");
		System.out.println("\n\nEmployee Ratings: ");
		System.out.println("\n\n APPLICANT_ID EMPLOYEE_ID RATING");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3)
					);
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableRating() method

private void displayTableEnquiresAt(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM F16_12_enquiresAt");
		System.out.println("\n\nEnquiry Details: ");
		System.out.println("\n\n ENQUIRER_ID BRANCH_ID DATE_OF_ENQUIRY");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3)
					);
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of displayTableEnquiresAt() method

private void generateReport1(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select month_name, "+
										 "nvl(temp_total_enquiries,0) as total_enquiries, "+
										 "total_enrolls "+
										 "from (select monthname, "+
										 "count(enquiries) as temp_total_enquiries "+
										 "from (select to_char(dateofEnquiry, 'Month') as monthname, "+
										 "dateofEnquiry as enquiries "+
										 "from F16_12_enquiresAt) "+
										 "group by monthname), "+
										 "(select month_name as month_name, "+
										 "count(appl_id) as total_enrolls "+
										 "from (select enroll.applicantId as appl_id, "+
										 "to_char(enroll.applicantdoj , 'Month') as month_name "+
										 "from f16_12_enrollsIn enroll) "+
										 "group by month_name) "+
										 "where monthname(+) = month_name ");
		System.out.println("\n\nEnquiry Details: ");
		System.out.println("\n\n MONTH\t TOTAL_ENQUIRIES\t TOTAL_ENROLLMENTS");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport1() method

private void generateReport2(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select nvl(enquirer_state,applicant_state) as cust_state, "+
										 "enquirer_count, "+
										 "applicant_count "+
										 "from (select cust.state as enquirer_state, "+
										 "count(enq.enquirerID) as enquirer_count "+
										 "from F16_12_customer cust, "+
										 "F16_12_enquirer enq "+
										 "where cust.customerID = enq.enquirerID "+
										 "group by state) full outer join "+
										 "(select cust.state as applicant_state, "+
										 "count(app.applicantID) as applicant_count "+
										 "from F16_12_customer cust, "+
										 "F16_12_applicant app "+
										 "where cust.customerID = app.applicantID "+
										 "group by state) "+
										 "on enquirer_state = applicant_state ");
		System.out.println("\n\nEnquiry Details: ");
		System.out.println("\n\n MONTH\t TOTAL_ENQUIRIES\t TOTAL_ENROLLMENTS");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport2() method

private void generateReport3(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select enq_country, "+
										 "total_enquirer, "+
										 "nvl(total_app,0) as total_applicant "+
										 "from (select enq.countryPref as enq_country, "+
										 "count(enq.enquirerID) as total_enquirer "+
										 "from F16_12_enquirer enq "+
										 "group by enq.countryPref "+
										 "order by total_enquirer) full outer join "+
										 "(select app.countryPref as app_country, "+
										 "count(app.applicantID) as total_app "+
										 "from F16_12_applicant app "+
										 "group by app.countryPref "+
										 "order by total_app) "+
										 "on enq_country = app_country "+
										 "order by total_applicant desc ");
		System.out.println("\n\nCountry Preferences Evaluation: ");
		System.out.println("\n\n COUNTRY\t TOTAL_ENQUIRERS\t TOTAL_APPLICANTS");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport3() method

private void generateReport4(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from (select * "+
										 "from (select service.serviceType, "+
												"sum(service.serviceFee) as total_fee "+
												"from f16_12_service service "+
												"group by service.serviceType) "+
												"order by total_fee desc)");
		System.out.println("\n\nRevenue Report of Services: ");
		System.out.println("\n\n SERVICE_TYPE\t REVENUE_GENERATED");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport4() method

private void generateReport5(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select branch_id, income - expense as profit "+
										 "from (select branch_id, "+
											      "sum(service_fee) as income "+
											        "from (select br.branchID as branch_id, "+
											                "br.serviceID branch_service_id "+
											                "from F16_12_enrollsIn br "+
											                "order by serviceID "+
											             "), (select serv.serviceID as service_id, "+
											            "serv.serviceFee as service_fee "+
											            "from F16_12_service serv "+
											        ") "+
											        "where branch_id = service_id "+
											        "group by branch_id), "+
											        "(select branch as exp_branch,sum(monthly_salary) as expense "+
											        "from F16_12_employee "+
											        "group by branch) "+
											        "where branch_id=exp_branch");
		System.out.println("\n\nDisplay profit of the firm according to branches");
		System.out.println("\n\n BRANCH_ID\t PROFIT");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport5() method

private void generateReport6(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select DISTINCT emp_no, emp_name, rating "+
										"from (select emp_no, emp_name, rating "+
												"from (select em.employeeid as emp_no,em.firstname as emp_name "+
												"from F16_12_employee em), "+
												"(select r.employeeid emp_no_rating, avg(r.rating) as rating "+
												"from F16_12_rates r "+
												"group by r.employeeid) "+
												"where emp_no = emp_no_rating), "+
												"(select enroll.employeeID emp, serv.servicetype "+
												"from F16_12_enrollsin enroll, F16_12_service serv "+
												"where serv.servicetype='Tutoring' and serv.serviceID = enroll.serviceID) "+
												"where emp_no = emp ");
		System.out.println("\n\nTutor's Performance Report");
		System.out.println("\n\n EMPLOYEE_ID\t TUTOR\t RATINGS");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t "+ rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport6() method

private void generateReport7(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select emp_no, emp_name, rating "+
										 "from (select emp_no, emp_name, rating "+
												"from (select em.employeeid as emp_no,em.firstname as emp_name "+
												"from F16_12_employee em), "+
												"(select r.employeeid emp_no_rating, avg(r.rating) as rating "+
												"from F16_12_rates r "+
												"group by r.employeeid) "+
												"where emp_no = emp_no_rating), "+
												"(select emp.employeeID empl, emp.designation "+
												"from F16_12_employee emp "+
												"where emp.designation='Counselor') "+
												"where emp_no = empl");
		System.out.println("\n\nCounselor's Rating Evaluation Report: ");
		System.out.println("\n\n EMPLOYEE_NUMBER\t EMPLOYEE_NAME\t RATING");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport7() method

private void generateReport8(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select em.firstname || ' ' || em.lastname as Tutor_Name, "+
										 "tu.classtype, count(en.applicantid) as Total "+
										 "from f16_12_enrollsin en, f16_12_tutorclass tu, f16_12_employee em "+
										 "where en.serviceid=tu.serviceid "+
										 "group by em.firstname,em.lastname, tu.classtype");
		System.out.println("\n\n Tutor Class Popularity");
		System.out.println("\n\n TUTOR_NAME\t CLASS_TYPE\t TOTAL");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport8() method

private void generateReport9(){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select 'ACCEPT:TOTAL' as description, "+
										 "success_count || ':' || total_record as acceptance_rate "+
										 "from (select count(en.applicantid) as success_count "+
										 "from f16_12_enrollsin en, f16_12_visarecord v "+
										 "where en.serviceid=v.serviceid "+
										 "and v.visastatus = 'accept' "+
										 "group by v.visastatus), "+
										 "(select count(*) as total_record "+
										 "from f16_12_visarecord)");
		System.out.println("\n\nVisa Acceptance Ratio: ");
		System.out.println("\n\n DESCRIPTION\t ACCEPTANCE_RATE");
		
		while(rs.next()) {
			System.out.println("\n " + rs.getString(1) + "\t " + rs.getString(2));
		}
		System.out.println("\n\n");
	stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of generateReport9() method

private void updateCustomerPhone(String table, String ID, String colName, int customerID, String phone){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("update " + table + " set " + colName + " = '" + phone + "' where " + 
											ID + " = " + customerID);
		System.out.println(" Customer Phone Number Updated");
		
		ResultSet rs1 = stmt.executeQuery("select * from " + table + " where " + ID + " = " + customerID);
		while(rs1.next()){
			System.out.println("CUSTOMER_ID\t FIRST_NAME\t NEW_PHONE");
			System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(6));
		}
		System.out.println("\n\n");
		stmt.close();	
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of updateCustomerPhone() method

private void updateCustomerState(String table, String ID, String colName, int customerID, String state){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("update " + table + " set " + colName + " = '" + state + "' where " + 
											ID + " = " + customerID);
		System.out.println(" Customer State Updated");
		
		ResultSet rs1 = stmt.executeQuery("select * from " + table + " where " + ID + " = " + customerID);
		while(rs1.next()){
			System.out.println("CUSTOMER_ID\t FIRST_NAME\t NEW_STATE");
			System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(11));
		}
		System.out.println("\n\n");
		stmt.close();	
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of updateCustomerState() method

private void updateCustomerEmail(String table, String ID, String colName, int customerID, String email){
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("update " + table + " set " + colName + " = '" + email + "' where " + 
											ID + " = " + customerID);
		System.out.println(" Customer Email Updated");	
		
		ResultSet rs1 = stmt.executeQuery("select * from " + table + " where " + ID + " = " + customerID);
		while(rs1.next()){
			System.out.println("CUSTOMER_ID\t FIRST_NAME\t NEW_EMAIL");
			System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(7));
		}
		System.out.println("\n\n");
		stmt.close();	
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
} // End of updateCustomerEmail() method

private void insertIntoCustomer(Integer custID, String fName, String mName, String lName, String dateofBirth, 
		String phone, String email, String blockNo, String street, String apartment, String state, 
		Integer zipCode){
		
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("insert into F16_12_customer values ('" + custID + "'," +
													"'" + fName + "'," +
													"'" + mName + "'," +
													"'" + lName + "'," +
													"'" + dateofBirth + "'," +
													"'" + phone + "'," +
													"'" + email + "'," +
													"'" + blockNo + "'," +
													"'" + street + "'," +
													"'" + apartment + "'," +
													"'" + state + "'," +
													"'" + zipCode + "')"
					);
			System.out.println("New Customer Information Inserted!!");
			System.out.println("\n\n");
			stmt.close();
		}
		catch(SQLException e) {
			System.out.println(e.toString());
		}
}

private void deleteFromCustomer(Integer customerID) {
	try{
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("delete from F16_12_customer where customerID = " + customerID);

		ResultSet rs1 = stmt.executeQuery("select * from F16_12_customer where customerID = " + customerID);
		
		String checkCustomer = null;
		while(rs.next()) {
			checkCustomer = rs.getString(1);
		}
		if(checkCustomer != null ){
			System.out.println("Customer Not Deleted Successfully");
			System.out.println("\n\n");
		}
		else {
			System.out.println("Customer Successfully Deleted");
			System.out.println("\n\n");
		}
			
		stmt.close();
	}
	catch(SQLException e) {
		System.out.println(e.toString());
	}
}

} // End of Facs class