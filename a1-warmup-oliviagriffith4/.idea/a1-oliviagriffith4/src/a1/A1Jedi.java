package a1;

import java.util.List;
import java.util.Scanner;

public class A1Jedi {

	// private static Object Cus;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();
		item[] items = new item[count];
		// Cus[] Cuss = new Cus [count];

		for (int i = 0; i < count; i++) {
			items[i] = readEntryFromScanner(scan);
		}

		double GrandTotal = 0;

		Cus biggest = new Cus();
		Cus smallest = new Cus();
		biggest.amount = -1;
		smallest.amount = -1;

		int NumCustomers = scan.nextInt();
		for (int j = 0; j < NumCustomers; j++) {
			String First = scan.next();
			String Last = scan.next();
			int CusCount = scan.nextInt();
			double Total = 0;
			for (int t = 0; t < CusCount; t++) {
				int quantity = scan.nextInt();
				String nameofitem = scan.next();
				double Price = finalprice(items, nameofitem);
				Total += quantity * Price;
				updateamount(items, nameofitem, quantity, CusCount);
			}
			GrandTotal += Total;
			if ((biggest.amount == -1) || (Total >= biggest.amount)) {
				biggest.first = First;
				biggest.last = Last;
				biggest.amount = Total;
			}
			if ((smallest.amount == -1) || (Total <= smallest.amount)) {
				smallest.first = First;
				smallest.last = Last;
				smallest.amount = Total;

			}
		}
		for (int i = 0; i < items.length; i++) {
			if (items[i].amountofitem == 0) {
				System.out.println("No customers bought " + items[i].name);
			} else
				System.out.println(items[i].numcus + " customers bought " + items[i].amountofitem + " " + items[i].name);
		}
	}

	static void updateamount(item[] items, String nameofitem, int quantity) {
		for (int a = 0; a < items.length; a++) {
			if (items[a].name.equals(nameofitem)) {
				items[a].amountofitem += quantity;
				items[a].numcus++;
			}
			if (items[a].name.equals(nameofitem) == items[a-1].name.equals(nameofitem))
				items[a].numcus--;
			}
		}

	static double finalprice(item[] items, String name) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].name.equals(name))
				return items[i].price;
		}
		return 0;
	}

	private static int findmaxindex(int[] values) {
		int max = values[0];
		int max_index = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] >= max) {
				max = values[i];
				max_index = i;
			}
		}
		return max_index;
	}

	private static int findminindex(int[] values) {
		int min = values[0];
		int min_index = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] <= min) {
				min = values[i];
				min_index = i;
			}
		}
		return min_index;
	}

	static item readEntryFromScanner(Scanner scan) {
		item e = new item();

		e.name = scan.next();
		e.price = scan.nextDouble();

		return e;
	}

	private static class item {
		String name;
		double price;
		int numcus;
		int amountofitem;
		public item () {
			name = "";
			price = 0.0;
			numcus = 0;
			amountofitem = 0;
		}
	}


	private static class Cus {
		String first;
		String last;
		double amount;
		@Override
		public String toString() {
			return first + " " + last + " " + amount;
		}
	}
}
