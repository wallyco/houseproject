package waketech.project.teambravo;

public class HouseTester {
	public static void main(String[] args){
		House n1 = new House("Beasutfiul", 700, 500, 3, 01);
		House n2 = new House("Beasutfiul", 800, 500, 3, 02);
		House n3 = new House("Colonial ", 20, 30, 4, 02);
		
		Subdivision newSub = new Subdivision();
		newSub.add(n3);
		
		System.out.print(n1.toString());
		System.out.print("\n" + n1.compareArea(n2));
		System.out.println(n3.toString());
		
		System.out.println(newSub.get(0));
	}

}
