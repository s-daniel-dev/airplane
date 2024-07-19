package Sd.Sb_Airplane_MVC.dto;

public class CaptainDto {
	
	private String name;
	private Long flightTime;
	
	
	
	public CaptainDto(String name, Long flightTime) {
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


}
