package com.sound.kiosk.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class MenuDTO {
	public String MNum;
	public String MName;
	public String MPrice;
	public String MImg;
	public String MInfo;
	public String MCaNum;
	public String MStatus;
	
}
