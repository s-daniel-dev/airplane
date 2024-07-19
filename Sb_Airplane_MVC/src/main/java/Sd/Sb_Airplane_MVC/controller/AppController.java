package Sd.Sb_Airplane_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Sd.Sb_Airplane_MVC.dto.CaptainListDto;
import Sd.Sb_Airplane_MVC.dto.FlightListDto;
import Sd.Sb_Airplane_MVC.dto.RouteDto;
import Sd.Sb_Airplane_MVC.service.AppService;

@Controller
public class AppController {
	
	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/flights")
	public String showFlights(Model model) {
		
		FlightListDto flightListDto = service.getFlightDtos();
		
		model.addAttribute("flightListDto", flightListDto);
		
		return "flights.html";
	}
	
	@GetMapping("/flights/withtime")
	public String flightsWithFlightTime(Model model) {
		
		FlightListDto flightListDto = service.getFlightDtos();
		
		model.addAttribute("flightListDto", flightListDto);
		
		return "flights.html";
	}
	
	@GetMapping("/pilots")
	public String showCaptains(Model model) {
		
		CaptainListDto captainListDto = service.getCaptainDtos(false);
		
		model.addAttribute("captainListDto", captainListDto);
		
		return "captain.html";
	}
	
	@GetMapping("/homewithtransfer")
	public String whoGotHomeWithTransfer(Model model) {
		
		CaptainListDto captainListDto = service.getCaptainDtos(true);
		
		model.addAttribute("captainListDto", captainListDto);
		
		
		return "transfer.html";
	}
	
	@GetMapping("/flights/rometoamsterdam")
	public String showRomeToAmsterdam(Model model) {
		
		RouteDto routeDto = service.getRoute("Roma", "Amsterdam");
		
		model.addAttribute("routeDto", routeDto);
		
		
		return "route.html";
	}

}
