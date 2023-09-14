package com.sound.kiosk.payment;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
//	private MenuService menuService;
//
//	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
//	public OrderController(MenuService menuService) {
//		this.menuService = menuService;
//	}
	
	@GetMapping("/cardAccept")
	public String cardAccept() {
	    return "/payment/card_accept";
	}
	
	@GetMapping("/cardInput")
	public String cardInput() {
	    return "/payment/card_input";
	}
	
	@GetMapping("/card")
	public String card() {
	    return "/payment/card";
	}
	
	@GetMapping("/creditsInput")
	public String creditsInput() {
	    return "/payment/credits_input";
	}
	
	@GetMapping("/credits")
	public String credits() {
	    return "/payment/credits";
	}
	
	@GetMapping("/receipt")
	public String receipt() {
	    return "/payment/receipt";
	}
	
	
}