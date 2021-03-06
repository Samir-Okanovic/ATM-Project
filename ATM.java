package samir_okanovic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner unos = new Scanner(System.in);

		List<Account> newAccountsList = new ArrayList<>();

		Account newAccount = null;

		Account.showMenu();

		int selectMenu = unos.nextInt();

		do {

			switch (selectMenu) {

			case 1:
				unos.nextLine();

				System.out.print("Enter full name: ");
				String fullName = unos.nextLine();

				int accountNumber = (int) (Math.random() * 900000000 + 100000000);
				System.out.println("Your account number:" + accountNumber);

				int password = (int) (Math.random() * 9000 + 1000);
				System.out.println("Your password: " + password);

				System.out.print("Enter your balance: ");
				double balance = unos.nextDouble();

				newAccount = new Account(fullName, accountNumber, password, balance);

				if (!newAccount.checkAccounts(accountNumber, newAccountsList) && balance > 0) {

					newAccountsList.add(newAccount);

				} else {
					System.out.println("Account number " + accountNumber + " already taken or balance is too low!");
				}
				newAccount.setAccountList(newAccountsList);

				Account.showMenu();

				selectMenu = unos.nextInt();

				break;

			case 2:
				unos.nextLine();

				newAccount.listAllAccounts();

				Account.showMenu();

				selectMenu = unos.nextInt();

				break;

			case 3:
				unos.nextLine();

				System.out.print("Enter full name: ");
				String sender = unos.nextLine();

				System.out.print("Enter your password: ");
				password = Integer.valueOf(unos.nextLine());

				if (!newAccount.checkNamePass(sender, password)) {
					System.out.println("Wrong name or password. Try again: ");
					Account.showMenu();

					selectMenu = unos.nextInt();
					break;
				}

				System.out.print("Enter account number from which to transfer: ");
				int sourceBalance = unos.nextInt();

				System.out.print("Enter account number of recipient: ");
				int targetBalance = unos.nextInt();

				System.out.print("Enter ammount: ");
				double ammount = unos.nextDouble();

				if (newAccount.checkAccounts(sourceBalance, newAccountsList)
						&& newAccount.checkAccounts(targetBalance, newAccountsList)) {

					newAccount.transfer(sourceBalance, targetBalance, ammount);
				} else {
					System.out.println("Try again!");
				}
				Account.showMenu();

				selectMenu = unos.nextInt();

				break;
			}

		} while (selectMenu != 0);
		unos.close();
	}
}
