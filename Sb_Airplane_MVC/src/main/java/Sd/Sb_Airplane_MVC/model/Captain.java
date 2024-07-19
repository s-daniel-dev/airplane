package Sd.Sb_Airplane_MVC.model;

public class Captain {
	
	private String name;
	private Long flightTime;
	private String firstLocation;
	
	
	
	public Captain(String name, Long flightTime) {
		super();
		this.name = name;
		this.flightTime = flightTime;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(Long flightTime) {
		this.flightTime = flightTime;
	}


	public void addFlightTime(Long flightTime) {
		this.flightTime += flightTime;
		
	}


	public String getFirstLocation() {
		return firstLocation;
	}


	public void setFirstLocation(String firstLocation) {
		this.firstLocation = firstLocation;
	}


	

}
