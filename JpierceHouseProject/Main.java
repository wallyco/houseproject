package project.house;
import java.io.FileNotFoundException;


/*
 * @author Joshua Pierce
 */


public class Main {

	public static void main(String[] args){
		Subdivision subdivision = new Subdivision();
		try {
			subdivision.fromDisk();
			Menu menu = new Menu(subdivision);	
			
			while(true) {
				menu.display();
			}
		}catch(FileNotFoundException e) {
			System.out.println("The file does not exist in the directory: " + subdivision.pathToFile());
		}catch(Exception e) {
			System.out.println("Problem loading file");
		}
	}

}
