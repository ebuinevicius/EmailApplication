import java.util.Random;
import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String company = "Apple";
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String emailAddress;
	private String altEmail;

	
	// Constructor to set all instance variable values
	public Email(String firstName, String lastName, Scanner scan) {
		// Set Name Information
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created For: " + firstName + " " + lastName);
		
		// Get Department Information
		department = getDepartmentInfo(scan);
		
		// Set Random Password
		password = randomPassword(defaultPasswordLength);
		System.out.println("Password: " + password);
		
		// Generate Email Address
		emailAddress = createEmail(firstName, lastName, company, department);
	}
	
	// Create email address from credentials
	public String createEmail(String first, String last, String company, String department)  {
		String email;
		if (!department.equals("None"))
			email = first.toLowerCase() + "." + last.toLowerCase() + "@" + 
					company.toLowerCase() + "." + department.toLowerCase() + ".com";
		else
			email = first.toLowerCase() + "." + last.toLowerCase() + "@" + 
					company.toLowerCase() + ".com";
		return email;
	}
	
	// Method displays all of a user's information
	public void displayInfo() {
		System.out.println("ACCOUNT INFORMATION\nName: " + firstName + " " + lastName + "\nCompany: " + 
							company + "\nDepartment: " + department + "\nEmail Address: " + 
							emailAddress +"\nMailbox Capacity: " + mailboxCapacity + "\nPassword: " + password);
	}
	
	
	// Get department info from user and return string of department name
	private String getDepartmentInfo(Scanner scan) {
		System.out.println("Department Selection:\n1. Sales\n2. Accounting\n3. Development\nEnter Your Selection:");
		int deptNum = scan.nextInt();
		if (deptNum == 1) {
			return "Sales";
		}
		else if (deptNum == 2) {
			return "Accounting";
		}
		else if (deptNum ==3) {
			return "Development";
		}
		else {
			return "None";
		}
	}
	

	// Generates a random password of specified length
	private String randomPassword(int length) {
		String passwordPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%";
		Random rand = new Random();
		
		// Array for character values in password
		char[] passChars = new char[length];
		for (int i = 0; i < passChars.length; i ++) {
			passChars[i] = passwordPool.charAt(rand.nextInt(passwordPool.length()));
		}
		return new String(passChars);
		
	}
	
	// Method for user to choose their own password
	public void changePassword(Scanner scan) {
		System.out.println("Enter your desired password: ");
		String pass = scan.next();
		this.password = pass;
		System.out.println("Password updated.");
	}
	
	// MailboxCapacity setter
	public void setMailBoxCapacity(int num) {
		mailboxCapacity = num;
	}
	
	// Setter for alternate email address
	public void setAltEmail(String email) {
		altEmail = email;
	}
	
	
	// Getter Methods
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getDepartment() {
		return department;
	}
}
