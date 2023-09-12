package com.sound.kiosk.cart;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.kiosk.menu.MenuDTO;

@RestController
public class CartController {
	
	private CartService cartService;

	@Autowired 
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/customerStatus")
	public void setCustomerStatus() {
		
		cartService.setCustomerStatus();
	}
	
}