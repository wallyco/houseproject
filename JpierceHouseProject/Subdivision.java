package project.house;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Subdivision{
    private ArrayList<House> houses = new ArrayList<>();
    
	private String fileName = "subdivision.txt";
	private File file;
    
    public Subdivision(){
    	
    }
    
    public boolean add(House h){ 		
    	try {
	    	this.houses.add(h);
	    	return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public House get(int i) {
    	try {
    		return this.houses.get(i);
    	}
    	catch(Exception e) {
    		System.out.println(i + " is not an index in the list");
    		return null;
    	}
    }
    
    public int size() {
    	return houses.size();
    }
    
    public ArrayList<House> list(){
    	return this.houses;
    }
     
    public boolean toDisk() throws IOException {
    	try(
    		PrintWriter writer = new PrintWriter(fileName);	
    	){
    		for(House index: houses) {
    			writer.write(index.getStyle() + ",");
    			writer.write(index.getFamilyRoomArea() + ",");
    			writer.write(index.getLivingRoomArea() + ",");
    			writer.write(index.getBedrooms() + ",");
    			writer.write(index.getPlot() + "\n");
    		}
    		
    		System.out.println("Write to file at " + pathToFile() + " was SUCCESSFUL");
    		return true;
    	}catch(IOException e) {
    		System.out.println("Write to file at " + pathToFile() + " was UNSUCCESSFUL");
    		return false;
    	}
    }
    
    public boolean fromDisk() throws IOException, FileNotFoundException {
    	file = new File(fileName);
    	try(

    		Scanner reader = new Scanner(file);
    			){
    		String inputLine;
    		while(reader.hasNextLine()) {
    			inputLine = reader.nextLine();
    			String[] splitInput = inputLine.split(",");
    			houses.add(new House(splitInput[0], stringToDouble(splitInput[1]), stringToDouble(splitInput[2]),
    					   stringToInt(splitInput[3]), stringToDouble(splitInput[4])));
    			
    		}
			System.out.println("Subdivision successfully loaded from \"subdivision.txt\"");
    		return true;
    	}catch(FileNotFoundException e) {
    		throw e;
    	}catch(Exception e) {
    		System.out.println("ERROR! There was a problem loading file \n ");
    		return false;
    	}
    }
    
    public File pathToFile() {
    	file = new File(fileName);
    	return file.getAbsoluteFile();
    }
    
    private Double stringToDouble(String in) {
    	return Double.parseDouble(in);
    }
    
    private int stringToInt(String in) {
    	return Integer.parseInt(in);
    }
    
    public void remove(int position) {
    	houses.remove(position);
    }
    
    public void update(int position, House houseToUpdate) {
    	houses.remove(position);
    	houses.add(position, houseToUpdate);
    }
    
    
    public ArrayList<House> listByArea(double floor, double ceiling){
    	ArrayList<House> arrayListToReturn = new ArrayList<House>();
    	
    	for(House indexOf: houses){
    		
    		if(indexOf.getTotalArea() >= floor && indexOf.getTotalArea() <= ceiling) {
    			arrayListToReturn.add(indexOf);
    		}
    	}
		return arrayListToReturn;	
    }
    
    public ArrayList<House> listByPlot(double floor, double ceiling){
    	ArrayList<House> arrayListToReturn = new ArrayList<House>();
    	
    	for(House indexOf: houses) {
    		if(indexOf.getPlot() >= floor && indexOf.getPlot() <= ceiling) {
    			arrayListToReturn.add(indexOf);
    		}
    	}
		return arrayListToReturn;	
    }
    
	public ArrayList<House> listByBedrooms(int floor, int ceiling) {
    	ArrayList<House> sortByHouse = new ArrayList<House>();

		for(House indexOf: houses) {
			if(indexOf.getBedrooms() >= floor && indexOf.getBedrooms() <= ceiling) {
				sortByHouse.add(indexOf);
			}
		}
		return sortByHouse;
   	}
    
    public ArrayList<House> sortByArea(){
    	ArrayList<House> sortByHouse = new ArrayList<House>(houses);
    	ArrayList<House> temp = new ArrayList<House>();

    	for(int i = 0; i < sortByHouse.size(); i++) {
    		int currentMin = sortByHouse.indexOf(sortByHouse.get(i));
    		int newMinIndex = sortByHouse.indexOf(sortByHouse.get(i));

    		for(int j = i + 1; j < sortByHouse.size(); j++) {
     			if(sortByHouse.get(newMinIndex).compareArea(sortByHouse.get(j)) == 1){
    				newMinIndex = sortByHouse.indexOf(sortByHouse.get(j));
    			}		
    		}
    		
    		if(newMinIndex != i) {
    			temp.add(i, sortByHouse.get(currentMin));
    			sortByHouse.set(currentMin, sortByHouse.get(newMinIndex));
    			sortByHouse.set(newMinIndex, temp.get(i));
    		}else {
    			//needed to not produce array index out of bounds
    			temp.add(null);
    		}
    	}
    	
    	return sortByHouse;
    }
    	
	public ArrayList<House> sortByPlot(){
    	ArrayList<House> sortByHouse = new ArrayList<House>(houses);
    	ArrayList<House> temp = new ArrayList<House>();
    	
    	for(int i = 0; i < sortByHouse.size(); i++) {
    		int currentMin = sortByHouse.indexOf(sortByHouse.get(i));
    		int newMinIndex = sortByHouse.indexOf(sortByHouse.get(i));
    		
    		for(int j = i + 1; j < sortByHouse.size(); j++) {
    			if(sortByHouse.get(i).getPlot() > sortByHouse.get(j).getPlot()){
    				newMinIndex = sortByHouse.indexOf(sortByHouse.get(j));
    			}		
    		}
    		
    		if(newMinIndex != i) {
    			temp.add(i, sortByHouse.get(currentMin));
    			sortByHouse.set(currentMin, sortByHouse.get(newMinIndex));
    			sortByHouse.set(newMinIndex, temp.get(i));
    		}else {
    			//needed to not produce array index out of bounds
    			temp.add(null);
    		}
    	}
    	
    	return sortByHouse;	
	}
	
	public ArrayList<House> find(String houseStyle) {
    	ArrayList<House> sortByHouse = new ArrayList<House>();

		for(House index: houses) {
			if(index.getStyle().contains(houseStyle)) {
				sortByHouse.add(index);
			}
		}
		return sortByHouse;
   	}
	
	@Override
	public String toString() {
		List<Object> returnList = Stream.of(houses.toArray()).collect(Collectors.toList());
		return returnList.toString();
	}
}
