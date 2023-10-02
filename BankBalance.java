package ATM;

import java.util.Scanner;

public class BankBalance {
	private int bankBalance = 10000;
	int temp;
	Scanner scan = new Scanner(System.in);

	public int getBankBalance() {

		return bankBalance;
	}

	public void withdrawAmount(int amount) {
		while (amount < 0 || amount > bankBalance) {
			if (amount < 0) {
				System.out.println("Entered Amount is Invalid(Amount less than 0 can't be processed)");
				System.out.println("Enter correct amount to Withdraw or Press '0' to Menu");
			} else {
				System.out.println("Insuffiecient amount in your bank account..");
				System.out.println("Enter correct amount to Withdraw or Press '0' to Menu");
			}
			amount = scan.nextInt();
			if (amount == 0) {
				return;
			}
		}
		temp = amount;
		bankBalance = bankBalance - amount;
	}

	public void depositeAmount(int amount) {
		while (amount < 0 || amount > 100000) {
			if (amount < 0) {
				System.out.println("Entered Amount is Invalid(Amount less than 0 can't be processed)");
				System.out.println("Enter correct amount to Deposite or Press '0' to Menu");
			} else {
				System.out.println("Amount more than 100000 can't be processed..");
				System.out.println("Enter correct amount to Withdraw or Press '0' to Menu");
			}
			amount = scan.nextInt();
			if (amount == 0) {
				return;
			}
		}
		temp = amount;
		bankBalance = bankBalance + amount;

	}

}
