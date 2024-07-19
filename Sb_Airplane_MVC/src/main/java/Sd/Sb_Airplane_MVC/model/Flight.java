package Sd.Sb_Airplane_MVC.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "dep_country")
	private String depCountry;
	
	@Column(name = "dep_time")
	private LocalDateTime depTime;
	
	@Column(name = "arr_country")
	private String arrCountry;
	
	@Column(name = "arr_time")
	private LocalDateTime arrTime;
	
	@Column(name = "flight_number")
	private String flightNumber;
	
	@Column(name = "captain")
	private String captain;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Flight [id=" + id + ", depCountry=" + depCountry + ", depTime=" + depTime + ", arrCountry=" + arrCountry
				+ ", arrTime=" + arrTime + ", flightNumber=" + flightNumber + ", captain=" + captain + "]";
	}
	
	

}
