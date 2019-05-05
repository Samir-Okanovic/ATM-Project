package samir_okanovic;

import java.util.ArrayList;

import java.util.List;

public class Account extends User {

	private int accountNumber;
	private int password;
	private double balance;
	private List<Account> accountList = new ArrayList<>();
	public String[] Menu = new String[4];

	public Account() {

	}

	public Account(String name, int accountNumber, int password, double balance) {
		super(name);
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Account> getAccountList() {

		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public static void showMenu() {

		String[] menu = new String[4];

		menu[0] = "\n[1] Create new account";

		menu[1] = "[2] List all created accounts";

		menu[2] = "[3] Transfer";

		menu[3] = "[0] Exit";

		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}

	}

	public void listAllAccounts() {

		for (int i = 0; i < accountList.size(); i++) {
			System.out.println(accountList.get(i));
		}

	}

	public boolean checkAccounts(int accountNumber, List<Account> accountList) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}

	public void transfer(int sourceAccountNumber, int targetAccountNumber, double deposit) {

		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getAccountNumber() == sourceAccountNumber) {
				if (accountList.get(i).getBalance() >= 0 && (accountList.get(i).getBalance() - deposit) >= 0) {
					accountList.get(i).setBalance(accountList.get(i).getBalance() - deposit);
				} else {
					System.out.println("Try again!");
					return;
				}
				break;
			}
		}
		for (int j = 0; j < accountList.size(); j++) {
			if (accountList.get(j).getAccountNumber() == targetAccountNumber) {
				accountList.get(j).setBalance(accountList.get(j).getBalance() + deposit);
			}
		}
	}

	public boolean checkNamePass(String name, int password) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getName().equalsIgnoreCase(name)) {
				if (accountList.get(i).getPassword() == password) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%-18s%16s%-18s%16d%-18s%16s%-18s%13.2f", "\nName : ", super.getName(),

				"\nAccount number: ", this.accountNumber, "\nPassword : ", "****", "\nBalance: ", this.balance);

	}
}