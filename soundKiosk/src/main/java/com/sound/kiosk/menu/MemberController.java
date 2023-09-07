package com.sound.kiosk.menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("main")
	public String main() {
		return "default/main";
	}
	
}