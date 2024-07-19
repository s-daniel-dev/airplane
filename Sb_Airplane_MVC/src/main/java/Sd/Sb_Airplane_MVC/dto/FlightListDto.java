package Sd.Sb_Airplane_MVC.dto;

import java.time.LocalDateTime;
import java.util.List;

public class FlightListDto {
	
	private List<FlightDto> flightDtoList;

	public FlightListDto(List<FlightDto> flightDtoList) {
		super();
		this.flightDtoList = flightDtoList;
		sort();
	}

	public List<FlightDto> getFlightDtoList() {
		return flightDtoList;
	}

	public void setFlightDtoList(List<FlightDto> flightDtoList) {
		this.flightDtoList = flightDtoList;
	}

	@Override
	public String toString() {
		return "FlightListDto [flightDtoList=" + flightDtoList + "]";
	}
	
	private void sort() {
		
		for(int index = 0; index < (flightDtoList.size() - 1); index++) {
			
			LocalDateTime ldt1 = flightDtoList.get(index).getDepTime();
			LocalDateTime ldt2 = flightDtoList.get(index + 1).getDepTime();
			FlightDto dto1 = flightDtoList.get(index);
			FlightDto dto2 = flightDtoList.get(index + 1);
			
			
			if(ldt1.isAfter(ldt2)) {
				flightDtoList.set(index, dto2);
				flightDtoList.set(index + 1, dto1);
				index = -1;
			}
				
			
			
		}
		
	}
	
	
	
	

}
