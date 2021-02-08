package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int NumCustomer = scan.nextInt();
		for (int i=0; i<NumCustomer;i++) {
			String First = scan.next();
			String Last = scan.next();
			int Total = scan.nextInt();
			double FinalTotal = 0;
			for (int n=0; n<Total; n++) {
				int Amount = scan.nextInt();
				String Name = scan.next();
				double Price = scan.nextDouble();
				FinalTotal += Amount * Price;
			}
			String Totalstring = String.format("%.2f", FinalTotal);
			System.out.println(First.charAt(0) + ". " + Last + ": " + Totalstring );
		}
	}
}
