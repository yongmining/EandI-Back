package com.sound.kiosk.menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/main")
	public String menuMain() {
		return "menu/menuMain";
	}
	
}