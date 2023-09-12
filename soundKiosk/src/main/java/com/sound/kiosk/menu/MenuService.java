package com.sound.kiosk.menu;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

	@Autowired MenuMapper mapper;
	public ArrayList<MenuDTO> getTotalMenus() {
//		MenuDTO menu = new MenuDTO();
//		menu.MName = "coffee";
//		menu.MPrice = "4000";
		ArrayList<MenuDTO> menus = new ArrayList<>();
		menus = mapper.getTotalMenus();
		return menus;
	}
	
}