package com.ResturantSystem;

import java.util.*;

public class Resturant {

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		Methods m = new Methods();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter one choice from following...");
			System.out.println("1. Show details of reastuarant");
			System.out.println("2. Add new reastuarant");
			System.out.println("3. Update details of an restuarant");
			System.out.println("4. Delete reastuarant");
			System.out.println("5. Activate or deactivate reastuarant");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				m.searchResturant();
				break;
				
			case 2:
				m.addResturant();
				break;
				
			case 3:
				m.updateDetailsOfResturant();
				break;
				
			case 4:
				m.deleteDetailsOfResturant();
				break;
				
			case 5:
				m.activateDeactivate();
				break;
				
			case 6:
				flag = false;
				System.out.println("Bye...");
				break;

			default:
				System.out.println("enter proper choice");
				break;

			}

		}
	}
}