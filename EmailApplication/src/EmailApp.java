import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Email em1 = new Email("Tim", "Cook", scan);
		em1.changePassword(scan);
		em1.displayInfo();
	}

}
