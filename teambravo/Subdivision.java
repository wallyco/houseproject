package waketech.project.teambravo;

import java.util.ArrayList;

public class Subdivision{
    private ArrayList<House> houses = new ArrayList<>();
    
    public Subdivision(){
    	
    }
    
    public boolean add(House h){//TODO this isn't correct  		
    	try {
	    	this.houses.add(h);
	    	return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public House get(int i) {
    	try 
    	{
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
    
    public ArrayList<House> listByArea(double floor,
            double ceiling){
    	ArrayList<House> arrayListToReturn = new ArrayList<House>();
    	
    	for(House indexOf: houses)
    	{
    		if(indexOf.getTotalArea() >= floor 
    		&& indexOf.getTotalArea() <= ceiling)
    		{
    			arrayListToReturn.add(indexOf);
    		}
    	}
		return arrayListToReturn;	
    }
    
    public ArrayList<House> listByPlot​(double floor,
            double ceiling){
    	ArrayList<House> arrayListToReturn = new ArrayList<House>();
    	
    	for(House indexOf: houses) {
    		if(indexOf.getPlot() >= floor && indexOf.getPlot() <= ceiling) {
    			arrayListToReturn.add(indexOf);
    		}
    	}
		return arrayListToReturn;	
    }
    
    public ArrayList<House> sortByArea(){
    	ArrayList<House> sortByHouse = new ArrayList<House>(houses);
    	ArrayList<House> temp = new ArrayList<House>();

    	for(int i = 0; i < sortByHouse.size(); i++) {
    		int currentMin = sortByHouse.indexOf(sortByHouse.get(i));
    		int newMinIndex = sortByHouse.indexOf(sortByHouse.get(i));

    		for(int j = i + 1; j < sortByHouse.size(); j++) {
    			
     			if(sortByHouse.get(newMinIndex).getTotalArea() > sortByHouse.get(j).getTotalArea()){
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
	
	public ArrayList<House> newSortByPlot(){ //Not complete, misses a loop because for each loop is off set -1
    	ArrayList<House> sortByHouse = new ArrayList<House>(houses);
    	ArrayList<House> temp = new ArrayList<House>();
    	
    	for(House index: houses) {
    		double currentMin = index.getPlot();
    		int currentMinIndex = sortByHouse.indexOf(index);
    		int counter = 0;
    		
    		for(int i = sortByHouse.indexOf(index); i < sortByHouse.size(); i++) {
    			if(currentMin < sortByHouse.get(i).getPlot()) {
    				currentMin = sortByHouse.get(i).getPlot();
    				currentMinIndex = sortByHouse.indexOf(i) + 1;
    			}
    		}
    		
    		if(currentMinIndex != counter) {
    			temp.add(counter, sortByHouse.get(counter));
    			sortByHouse.set(counter, sortByHouse.get(currentMinIndex));
    			sortByHouse.set(currentMinIndex, temp.get(counter));
    		}else {
    			//needed to not produce array index out of bounds
    			temp.add(null);
    		}
    		counter++;
    	}	
    	return sortByHouse;
	}
	
	public void find(String houseStyle) {
		for(House index: houses) {
			if(index.getStyle().contains(houseStyle)) {
				System.out.println("works");
			}
		}
   	}

    
}
