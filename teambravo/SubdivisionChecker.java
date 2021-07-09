package waketech.project.teambravo;

public class SubdivisionChecker {

	public static void main(String[] args) {
		House h1 = new House();
		h1.setBedrooms(3);
		h1.setFamilyRoomArea(300.5);
		h1.setLivingRoomArea(180.3);
		h1.setStyle("Ranch");
		h1.setPlot(1.0);		
		
		House h2 = new House("Colonial", 200, 300, 1, 0.5);
		House h3 = new House("test", 200, 300, 1, 0.8);
		House h4 = new House("test2", 200, 300, 1, 0.3);
		
		Subdivision subdivision = new Subdivision();
		subdivision.add(h1);
		subdivision.add(h2);
		subdivision.add(h3);
		subdivision.add(h4);
		
		System.out.print(subdivision.newSortByPlot());
	}

}
