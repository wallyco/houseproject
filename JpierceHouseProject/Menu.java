package project.house;

import java.util.Scanner;

public class Menu{
	Subdivision menuSub;
	private Scanner userIn = new Scanner(System.in);
	
	public Menu(Subdivision sub) {
		setSubDivision(sub);
	}
	
	public void display() {
		try {
			System.out.println("Enter a number to execute the menu option");
			System.out.println("[0] to exit");
			System.out.println("[1] Display All Houses in the Subdivision");
			System.out.println("[2] Add a House to the Subdivision");
			System.out.println("[3] Delete a House in the Subdivision");
			System.out.println("[4] Change a House in the Subdivision");
			System.out.println("[5] Filter Subdivision by Total Area and Display");
			System.out.println("[6] Filter Subdivision by Plot Size and Display");
			System.out.println("[7] Sort Subdivision by Total Area and Display");
			System.out.println("[8] Sort Subdivision by Plot Size and Display");
			System.out.println("[9] Save Subdivision to Text File");
			option(userIn.nextInt());
			userIn.nextLine();
		}catch(Exception e) {
			System.out.println("That is not an option... \n");
			userIn.nextLine();
		}
	}
	
	public int option(int option) {
		switch(option) {
		case 0:
			goodbye();
			break;
		case 1:
			optionOne();
			break;
		case 2:
			optionTwo();
			break;
		case 3:
			optionThree();
			break;
		case 4:
			optionFour();
			break;
		case 5:
			optionFive();
			break;
		case 6:
			optionSix();
			break;
		case 7:
			optionSeven();
			break;
		case 8:
			optionEight();
			break;
		case 9:
			optionNine();
			break;
		}
		
		return option;
	}

	
	private void optionOne() {
		System.out.println(this.menuSub.list());
	}
	
	private void optionTwo() {
		String style;
		double family;
		double living;
		int rooms;
		double plot;
		try {
			System.out.println("Enter the house STYLE (One word not spaces)");
			style = userIn.next();
			
			System.out.println("Enter the house's FAMILY ROOM SIZE");
			family = userIn.nextDouble();
			
			System.out.println("Enter the house's LIVING ROOM SIZE");
			living = userIn.nextDouble();
			
			System.out.println("Enter the amount of ROOMS in the house");
			rooms = userIn.nextInt();
			
			System.out.println("Enter the house's PLOT SIZE");
			plot = userIn.nextDouble();
			
			House house = new House(style, family, living, rooms, plot);
			menuSub.add(house);
			
			System.out.println(house.toString() + "was successfully added \n");
			
		}catch(Exception e) {
			System.out.println("Adding the house was unsuccessful \n");
		}
	}
	
	private void optionThree() {
		int position;
		System.out.print("Enter the position corresponding to the house you'd like to delete \n");
		try{
			position = userIn.nextInt();
			this.menuSub.remove(position);
		}catch(Exception e) {
			System.out.println("That position does not exist");
		}
	}
	
	private void optionFour() {
		int option;
		String style;
		try {
			System.out.println("Which house would you like to change, enter the position");
			option = userIn.nextInt();
			
			System.out.println("Enter the updated style");
			style = userIn.next();
			
			menuSub.get(option).setStyle(style);
			
			System.out.println(menuSub.get(option));
			
			}catch(Exception e) {
			System.out.println("Update was unsuccessful");
		}
		
	}
	
	private void optionFive() {
		double min;
		double max;
		try {
			System.out.println("Enter the min number to sort the area by");
			min = userIn.nextDouble();
			
			System.out.println("Enter the max number to sort the area by");
			max = userIn.nextDouble();
			
			System.out.println(menuSub.listByArea(min, max));
			
		}catch(Exception e) {
			System.out.println("list by area failed");
		}
	}
	
	private void optionSix() {
		double min;
		double max;
		try {
			System.out.println("Enter the min number to sort the area by");
			min = userIn.nextDouble();
			
			System.out.println("Enter the max number to sort the area by");
			max = userIn.nextDouble();
			
			System.out.println(menuSub.listByPlot(min, max));

		}catch(Exception e) {
			System.out.println("list by plot failed");
		}
	}
	
	private void optionSeven() {
		try {
			System.out.println(menuSub.sortByArea());
		}catch(Exception e) {
			System.out.println("Problem listing by area");
		}
	}
	
	private void optionEight() {
		try {
			System.out.println(menuSub.sortByPlot());
		}catch(Exception e) {
			System.out.println("Problem listing by plot");
		}
	}
	
	private void optionNine() {
		try {
			menuSub.toDisk();
			System.out.println();
		}catch(Exception e) {
			
		}
	}
	
	private void goodbye(){
		System.out.println("Goodbye");
		userIn.close();
		System.exit(0);
	}
	
	public void setSubDivision(Subdivision sub) {
		 this.menuSub = sub;
	}

}
