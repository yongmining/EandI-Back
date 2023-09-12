package com.sound.kiosk.menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	private MenuService menuService;

	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/main")
	public Object menuMain() {
		MenuDTO menu = new MenuDTO();
		menu.MName = "coffee";
		menu.MPrice = "4000";
		return menu;
	}
	
}