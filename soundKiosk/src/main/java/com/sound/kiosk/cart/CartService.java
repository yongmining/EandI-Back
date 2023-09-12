package com.sound.kiosk.cart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired CartMapper cartMapper;
	
	public void setCustomerStatus() {
		//cartMapper.setCustomerStatus();
	}
	
}