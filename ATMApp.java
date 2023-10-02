import java.util.Scanner;

public class ATMApp {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(
				"==============================================================================================");
		System.out.println(
				"................................WELCOME TO ATM................................................");
		System.out.println(
				"==============================================================================================");

		System.out.println("Set PIN between 1000 and 9999(Because this bank accepts only within that limit)");
		System.out.print("Enter Pin : ");
		int pin = scan.nextInt();
		PIN p = new PIN();
		p.setPin(pin);

		TwoStepVerification tSV = new TwoStepVerification();
		System.out.println("Select any one Security Question(Uses if forgot pin)");
		securityQuestions();
		char qOpt = scan.next().charAt(0);
		tSV.setqOpt(qOpt);

		System.out.println("Enter Answer : ");
		scan.nextLine();
		tSV.setAnswer(scan.nextLine());

		char proceed = '1';

		BankBalance b = new BankBalance();

		while (proceed != '0') {

			System.out.println("Select any one option");
			System.out.println("1. Bank balance");
			System.out.println("2. Amount Withdraw");
			System.out.println("3. Amount Deposite");
			System.out.println("4. Forgot Pin");
			char opt = scan.next().charAt(0);
			while (opt < '1' || opt > '4') {
				System.out.println("Enter a valid option or '0' to exit..");
				opt = scan.next().charAt(0);
				if (opt == '0') {
					proceed = '0';
					break;
				}
			}
			int count = 0;
			switch (opt) {
			case '1': {
				System.out.println("Enter Pin to check Bank Balance");
				pin = scan.nextInt();
				verifyPin(pin, p.getPin());
				System.out.println("Balance : " + b.getBankBalance());
				System.out.println("Press any one key to Menu or '0' to exit");
				proceed = scan.next().charAt(0);
				break;
			}
			case '2': {
				System.out.println("Enter Pin to Withdraw Money");
				pin = scan.nextInt();
				verifyPin(pin, p.getPin());
				System.out.print("Enter Amount to be Withdraw : ");
				int withdraw = scan.nextInt();
				b.withdrawAmount(withdraw);
				System.out.println("Amount Debited : " + b.temp + "     Remaining Balance : " + b.getBankBalance());
				System.out.println("Press any one key to Menu or '0' to exit");
				proceed = scan.next().charAt(0);
				break;
			}
			case '3': {
				System.out.println("Enter Pin to Deposite Money");
				pin = scan.nextInt();
				verifyPin(pin, p.getPin());
				System.out.print("Enter Amount to be Deposite: ");
				int depositeAmount = scan.nextInt();
				b.depositeAmount(depositeAmount);
				System.out.println("Amount Credited : " + b.temp + "     Remaining Balance : " + b.getBankBalance());
				System.out.println("Press any one key to Menu or '0' to exit");
				proceed = scan.next().charAt(0);
				break;
			}
			case '4': {
				System.out.println("Select Your Security Question");
				securityQuestions();
				char c = scan.next().charAt(0);
				System.out.print("Enter Answer : ");
				scan.nextLine();
				String s = scan.nextLine();
				count = 0;
				while (tSV.getqOpt() != c || true) {
					if (s.equals(tSV.getAnswer()) && c == tSV.getqOpt()) {
						break;
					}
					count++;
					if (count == 3) {
						System.out.println("Question or Answer does not match");
						attemptsReached();
						return;
					}
					System.out.println("Question or Answer does not match");
					System.out.println(3 - count + " chances left");
					System.out.println("Select Question and enter correct answer or press '0' to exit");
					securityQuestions();
					c = scan.next().charAt(0);
					if (c == '0') {
						System.exit(0);
					}
					scan.nextLine();
					System.out.print("Enter Answer : ");
					s = scan.nextLine();
				}
				System.out.print("Enter new Pin : ");
				p.setPin(scan.nextInt());
				System.out.println("Pin changed");
			}
			}

		}
		scan.close();
	}

	public static void securityQuestions() {

		System.out.println("1. What is your Nick Name?");
		System.out.println("2. What is your Pet Name?");
		System.out.println("3. What is your Favourite Place?");
		System.out.println("4. What is your Favourite Food?");
		System.out.println("5. In what city were you born?");

	}

	public static void verifyPin(int presentPin, int previousPin) {
		int count = 0;
		while (previousPin != presentPin) {
			count++;
			if (count == 3) {
				System.out.println("Invalid Pin");
				attemptsReached();
				return;
			}
			System.out.println("Invalid Pin");
			System.out.println(3 - count + " chances left");
			System.out.print("Re-Enter Pin : ");
			presentPin = scan.nextInt();
		}
	}

	public static void attemptsReached() {
		System.out.println("0 chances left");
		System.out.println("Your card was temporarily blocked...Please re-use after 24 hours..");
		System.out.println(
				"==============================================================================================");
		System.out.println(
				"......................................THANK YOU...............................................");
		System.out.println(
				"==============================================================================================");
	}

}
