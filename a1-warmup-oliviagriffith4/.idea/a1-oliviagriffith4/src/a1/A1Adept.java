package a1;

import java.util.List;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();
		item[] items = new item[count];

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
			}
			GrandTotal += Total;
			if ((biggest.amount == -1) || (Total >= biggest.amount)) {
				biggest.first = First;
				biggest.last = Last;
				biggest.amount = Total;
				biggest.amount=Math.round(Total*100.0)/100.0;
			}
			if ((smallest.amount == -1) || (Total <= smallest.amount)) {
				smallest.first = First;
				smallest.last = Last;
				smallest.amount = Total;
				smallest.amount=Math.round(Total*100.0)/100.0;

			}
		}
		double average = GrandTotal / NumCustomers;
		String averagestring = String.format("%.2f", average);
		System.out.println("Biggest" + ": " + biggest.first + biggest.last + " (" + biggest.amount + ")");
		System.out.println("Smallest" + ": " +  smallest.first + smallest.last + " (" + smallest.amount + ")");
		System.out.println("Average" + ": " + averagestring);
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