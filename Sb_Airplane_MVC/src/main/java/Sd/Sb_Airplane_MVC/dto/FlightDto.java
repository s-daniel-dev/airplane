package Sd.Sb_Airplane_MVC.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightDto {
	
	private String depCountry;
	private LocalDateTime depTime;
	private String arrCountry;
	private LocalDateTime arrTime;
	private String flightNumber;
	private String captain;
	private Long waitingTime;
	
	
	public FlightDto(String depCountry, LocalDateTime depTime, String arrCountry, LocalDateTime arrTime,
			String flightNumber, String captain) {
		super();
		this.depCountry = depCountry;
		this.depTime = depTime;
		this.arrCountry = arrCountry;
		this.arrTime = arrTime;
		this.flightNumber = flightNumber;
		this.captain = captain;
		this.waitingTime = null;
	}


	public String getDepCountry() {
		return depCountry;
	}

	public void setDepCountry(String depCountry) {
		this.depCountry = depCountry;
	}

	public LocalDateTime getDepTime() {
		return depTime;
	}

	public void setDepTime(LocalDateTime depTime) {
		this.depTime = depTime;
	}

	public String getArrCountry() {
		return arrCountry;
	}

	public void setArrCountry(String arrCountry) {
		this.arrCountry = arrCountry;
	}

	public LocalDateTime getArrTime() {
		return arrTime;
	}

	public void setArrTime(LocalDateTime arrTime) {
		this.arrTime = arrTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}
	
	public Long getFlightTime() {
		
		Duration duration = Duration.between(depTime, arrTime);
		Long flightTime = duration.toMinutes();
		return flightTime;
	}
	
	@Override
	public String toString() {
		return "FlightDto [depCountry=" + depCountry + ", depTime=" + depTime + ", arrCountry=" + arrCountry
				+ ", arrTime=" + arrTime + ", flightNumber=" + flightNumber + ", captain=" + captain + "]";
	}


	public Long getWaitingTime() {
		return waitingTime;
	}


	public void setWaitingTime(Long waitingTime) {
		this.waitingTime = waitingTime;
	}


	
}
