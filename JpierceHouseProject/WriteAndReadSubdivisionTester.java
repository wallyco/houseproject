package project.house;

import java.io.IOException;

public class WriteAndReadSubdivisionTester {

	public static void main(String[] args) throws IOException {
		Subdivision subDivision = new Subdivision();
		House house1 = new House(new String("ranch"), 200, 200, 3, 5000);
		House house2 = new House(new String("oneacre"), 100, 120, 1, 43560);
		House house3 = new House(new String("small ranch"), 100, 100, 2, 5000);
		House house4 = new House(new String("verysmall1"), 10, 10, 1, 500);
		House house5 = new House(new String("verysmall2"), 10, 10, 1, 500);
		House house6 = new House(new String("mansion"), 1000, 2010, 7, 50000);
		subDivision.add(house1);
		subDivision.add(house2);
		subDivision.add(house3);
		subDivision.add(house4);
		subDivision.add(house5);
		subDivision.add(house6);

		boolean success = subDivision.toDisk();

		if (success == true) {
			System.out.println("You have written 6 houses to a text file ");
		} else {
			System.out.println("File creation failed");
		}

		Subdivision subDivision2 = new Subdivision();

		boolean successFromDisk = subDivision2.fromDisk();
		if (successFromDisk == true) {
			System.out.println("You have read " + subDivision2.size() + " houses from a text file ");
			System.out.println(subDivision2.toString());
		} else {
			System.out.println("File creation failed");
		}
	}
}
