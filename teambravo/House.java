package waketech.project.teambravo;

public class House {
	
	private int bedrooms;
	private double familyRoomArea;
	private double livingRoomArea;
	private String style;
	private double plot;
	private static final double BEDROOM_AREA = 300;
	
	public House() {
		this("Unknown", 0, 0, 0, 0);
	}
	
	/**
	 * 
	 * Constructs and initializes a house object with the fields
	 * 
	 * @param newStyle house Style
	 * @param newFamilyArea size of the family room
	 * @param newLivingArea size of the living room
	 * @param newBedrooms number of bedrooms
	 * @param newPlot and the size of the plot
	 */
	public House(
			String newStyle, 
			double newFamilyArea, 
			double newLivingArea, 
			int newBedrooms, 
			double newPlot 
			)
	{
		setStyle(newStyle);
		setFamilyRoomArea(newFamilyArea);
		setLivingRoomArea(newLivingArea);
		setBedrooms(newBedrooms);
		setPlot(newPlot);
	}
	
	public double getTotalArea() 
	{
	 return  ( getBedrooms() 
			 * BEDROOM_AREA) 
			 + getLivingRoomArea() 
			 + getFamilyRoomArea();
	}
	
	
	public String toString() {
		return (  " House Style: " + getStyle() + "|" 
				+ " Bedrooms: " + getBedrooms() + "|" 
				+ " Family room area: " + getFamilyRoomArea() + "|" 
				+ " Living room area: " + getLivingRoomArea() + "|"
				+ " Plot: "+ getPlot() + "|" 
				+ " Square feet: " + getTotalArea() + "\n\n"
				);
	}
	
	public int compareArea(House newHouse) {
		return (int) (this.getTotalArea() - newHouse.getTotalArea());
	}
	

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public double getFamilyRoomArea() {
		return familyRoomArea;
	}

	public void setFamilyRoomArea(double familyRoomArea) {
		this.familyRoomArea = familyRoomArea;
	}

	public double getLivingRoomArea() {
		return livingRoomArea;
	}

	public void setLivingRoomArea(double livingRoomArea) {
		this.livingRoomArea = livingRoomArea;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getPlot() {
		return plot;
	}

	public void setPlot(double plot) {
		this.plot = plot;
	}
	
	

}
