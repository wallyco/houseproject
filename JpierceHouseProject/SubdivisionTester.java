package project.house;

import java.io.IOException;

public class SubdivisionTester {
	public static void main(String[] args) throws IOException {
		House h1 = new House("Unknown", 0, 0, 0, 0);
		h1.setBedrooms(3);
		h1.setFamilyRoomArea(300.0);
		h1.setLivingRoomArea(180.0);
		h1.setStyle("Ranch");
		h1.setPlot(.2);		
		
		House h2 = new House("Colonial", 200, 300, 1, 0.5);
		
		House h3 = new House("test1", 400, 200, 2, 1.0);
		
		House h4 = new House("test2", 600, 800, 6, 0.6);
		Subdivision subdivision = new Subdivision();
		subdivision.add(h1); 
		subdivision.add(h2);
		subdivision.add(h3);
		subdivision.add(h4);
		
		subdivision.toDisk();


//		Subdivision subdivision = new Subdivision(); Submitted for unit 12
//		subdivision.add(h1); 
//		subdivision.add(h2);
//		subdivision.add(h3);
//		subdivision.add(h4);
//		
//		System.out.println("Sort by area\n" + subdivision.sortByArea());
//		System.out.println("\nSort by plot\n" + subdivision.sortByPlot());
//		System.out.println("\nlist by area\n" + subdivision.listByArea(800, 2500));
//		System.out.println("\nlist by plot\n" + subdivision.listByPlot​(0 , .5));
//		System.out.println("\nlist by bedrooms\n" + subdivision.listByBedrooms(1,3));
//		System.out.println("\nThe original list is not mutated\n" + subdivision.list());		
	}

}
