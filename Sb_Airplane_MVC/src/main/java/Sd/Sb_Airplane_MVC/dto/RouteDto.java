package Sd.Sb_Airplane_MVC.dto;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RouteDto {
	
	private List<List<FlightDto>> listOfLists;

	public RouteDto(List<FlightDto> list, String from, String to) {
		
		
		listOfLists = new ArrayList<>();
		
 		for(int index = 0; index < list.size(); index++) {
			
			FlightDto flight = list.get(index);
			if(flight.getDepCountry().equals(from)) {
				List<FlightDto> routeList = new ArrayList<>();
				routeList.add(flight);
				makeARoute(to, index, routeList, list);
			}
			
		}
		setWaitingTime();
	}

	private void makeARoute(String to, int i, List<FlightDto> routeList, List<FlightDto> list) {

		FlightDto fDto = routeList.get(routeList.size() - 1);
		
		for(int index = i + 1;index < list.size(); index++) {
			
			
			FlightDto nextFDto = list.get(index);
			if(fDto.getArrCountry().equals(nextFDto.getDepCountry()) && fDto.getArrTime().isBefore(nextFDto.getDepTime())) {
				
				routeList.add(nextFDto);
				if(nextFDto.getArrCountry().equals(to)) {
					
					listOfLists.add(routeList);
					List<FlightDto> newRouteList = new ArrayList<>();
					
					for(int rIndex = 0; rIndex < routeList.size() - 1; rIndex++) {
						
						FlightDto dto = routeList.get(rIndex);
						newRouteList.add(dto);
						
					}
					makeARoute(to, index, newRouteList, list);
					break;
				}
				else {
					makeARoute(to, index, routeList, list);
					break;
				}
				
			
				
			}
			
		}
		
	}

	
	
	private void setWaitingTime() {
		
		for(int bigListIndex = 0; bigListIndex < listOfLists.size(); bigListIndex++) {
			
			List<FlightDto> flightDtoList = listOfLists.get(bigListIndex);
			
			for(int index = 0; index < (flightDtoList.size() - 1); index++) {
				
				FlightDto leftDto = flightDtoList.get(index);
				FlightDto rightDto = flightDtoList.get(index + 1);
				
				Duration duration = Duration.between(leftDto.getArrTime(), rightDto.getDepTime());
				Long waitingTime = duration.toMinutes();
				
				rightDto.setWaitingTime(waitingTime);
				
				
			}
			
		}
		
		
		
	}

	public List<List<FlightDto>> getListOfLists() {
		return listOfLists;
	}

	public void setListOfLists(List<List<FlightDto>> listOfLists) {
		this.listOfLists = listOfLists;
	}

	@Override
	public String toString() {
		return "RouteDto [listOfLists=" + listOfLists + "]";
	}
	
	

}
