package waketech.project.teambravo;

public class SubdivisionTester {
	public static void main(String[] args) {
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
		
//		System.out.println(subdivision.get(1).getTotalArea() + " " + subdivision.get(2).getTotalArea());
//		System.out.println(subdivision.get(1).compareArea(h3));
//		System.out.println(subdivision.list());
//		System.out.println(subdivision.size());
		
		//System.out.println(subdivision.get(1));
		System.out.println(subdivision.sortByArea());
		System.out.println(subdivision.listByArea(800, 2500));
		System.out.println(subdivision.sortByPlot());
//		System.out.println(subdivision.list());




//		System.out.println(subdivision.get(0));
		
		//System.out.println(subdivision.toString());
	}

}
