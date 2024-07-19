package Sd.Sb_Airplane_MVC.dto;

import java.util.List;

public class CaptainListDto {
	
	private List<CaptainDto> captainDtoList;

	public CaptainListDto(List<CaptainDto> captainDtoList) {
		super();
		this.captainDtoList = captainDtoList;
	}

	public List<CaptainDto> getCaptainDtoList() {
		return captainDtoList;
	}

	public void setCaptainDtoList(List<CaptainDto> captainDtoList) {
		this.captainDtoList = captainDtoList;
	}
	
	

}
