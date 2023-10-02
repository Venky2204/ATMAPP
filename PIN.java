import java.util.Scanner;

public class PIN {
	private int pin;
	Scanner scan = new Scanner(System.in);
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		
		while(pin < 1000 || pin > 9999) {
			System.out.println("Please set a valid pin(Between 1000 & 9999) or press '0' to exit");
			pin = scan.nextInt();
			if(pin == 0) {
				System.exit(0);
			}
		}
		this.pin = pin;
		System.out.println("Pin Accepted");
		
	}
	
	
	
}
