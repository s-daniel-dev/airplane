package Sd.Sb_Airplane_MVC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sd.Sb_Airplane_MVC.db.Database;
import Sd.Sb_Airplane_MVC.dto.CaptainDto;
import Sd.Sb_Airplane_MVC.dto.CaptainListDto;
import Sd.Sb_Airplane_MVC.dto.FlightDto;
import Sd.Sb_Airplane_MVC.dto.FlightListDto;
import Sd.Sb_Airplane_MVC.dto.RouteDto;
import Sd.Sb_Airplane_MVC.model.Captain;
import Sd.Sb_Airplane_MVC.model.Flight;

@Service
public class AppService {
	
	private Database db;
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}


	public FlightListDto getFlightDtos() {
		
		List<Flight> list = db.getFlights();
		
		FlightListDto dto = convertListToDto(list);

		return dto;
	}


	private FlightListDto convertListToDto(List<Flight> list) {

		FlightListDto flightListDto = null;
		
		if(list != null && list.size() > 0) {
			
			List<FlightDto> flightDtoList = new ArrayList<>();
			
			for(int index = 0; index < list.size(); index++) {
				
				Flight flight = list.get(index);
				
				FlightDto flightDto = new FlightDto(
							flight.getDepCountry(),
							flight.getDepTime(),
							flight.getArrCountry(),
							flight.getArrTime(),
							flight.getFlightNumber(),
							flight.getCaptain()
						);
				
				flightDtoList.add(flightDto);
				
			}
			
			flightListDto = new FlightListDto(flightDtoList);
			
			
		}
	
		
		return flightListDto;
	}



	public CaptainListDto getCaptainDtos(boolean whoGotHomeWithTransfer) {

		
		FlightListDto flightListDto = getFlightDtos();
		
		List<CaptainDto> captainList = new ArrayList<>();
		List<FlightDto> fList = flightListDto.getFlightDtoList();
		
		for(int index = 0; index < fList.size(); index++) {
			
			FlightDto fDto = fList.get(index);
			String name = fDto.getCaptain();
			Long flightTime = fDto.getFlightTime();
			
			if(captainList.size() > 0) {
				
				boolean isSame = false;
				
				
				for(int cIndex = 0; cIndex < captainList.size(); cIndex++) {
					
					CaptainDto captain = captainList.get(cIndex);
					String currentName = captain.getName();
					
					if(name.equals(currentName)) {
						captain.addFlightTime(flightTime);
						isSame = true;
						break;
					}
					
				}
				
				
				if(isSame == false) {
					
					CaptainDto captainDto = new CaptainDto(name, flightTime);
					captainList.add(captainDto);
					
				}
				
				
			}
			else {
				CaptainDto captainDto = new CaptainDto(name, flightTime);
				captainList.add(captainDto);
			}
			
			
		}
		List<Captain> cList = convertDtoListToList(captainList);
		
		if(whoGotHomeWithTransfer == true) {
			captainList = getCaptainListWithTransfer(cList, fList);
		}
		
		CaptainListDto dto = new CaptainListDto(captainList);
		
		return dto;
	}


	private List<Captain> convertDtoListToList(List<CaptainDto> captainList) {

		List<Captain> result = new ArrayList<>();
		
		for(int index = 0; index < captainList.size(); index++) {
			
			CaptainDto cDto = captainList.get(index);
			Captain captain = new Captain(cDto.getName(), cDto.getFlightTime());
			result.add(captain);
			
		}
		
		
		return result;
	}


	private List<CaptainDto> getCaptainListWithTransfer(List<Captain> cList, List<FlightDto> fList) {

		
		
		List<Captain> homeList = new ArrayList<>();
		
		for(int cIndex = 0; cIndex < cList.size(); cIndex++) {
			
			Captain c = cList.get(cIndex);
			String cName =cList.get(cIndex).getName();
			boolean isFirst = true;
			boolean isTransfer = false;
			
			for(int fIndex = 0; fIndex < fList.size(); fIndex++) {
				
				
				String fName = fList.get(fIndex).getCaptain();
				FlightDto fDto = fList.get(fIndex);
				
				if(isFirst == true && cName.equals(fName)) {
					c.setFirstLocation(fDto.getDepCountry());
					isFirst = false;
				}
				else if(cName.equals(fName)) {
					if(isTransfer == true && fDto.getArrCountry().equals(c.getFirstLocation())) {
						homeList.add(c);
					}
					isTransfer = true;
				}
				
				
			}
			
		}
		
		
		List<CaptainDto> cptDtoList = convertListToDtoList(homeList);
		
		
		return cptDtoList;
	}


	private List<CaptainDto> convertListToDtoList(List<Captain> cList) {

		List<CaptainDto> result = new ArrayList<>();
		
		for(int index = 0; index < cList.size(); index++) {
			
			Captain c = cList.get(index);
			CaptainDto cDto = new CaptainDto(c.getName(), c.getFlightTime());
			result.add(cDto);
			
		}
		
		
		return result;
	}


	public RouteDto getRoute(String from, String to) {
		
		FlightListDto fLDto = getFlightDtos();
		List<FlightDto> list = fLDto.getFlightDtoList();
		
		RouteDto routeDto = new RouteDto(list, from, to);
		
	
		
		return routeDto;
	}



}
