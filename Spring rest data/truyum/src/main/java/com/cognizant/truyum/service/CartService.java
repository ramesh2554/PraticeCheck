package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.ItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public interface CartService {
	
	public String addCartItem(int id,int itemId) throws ItemNotFoundException;
	public List<MenuItem> getAllCartItems(int userId);
	public String removeCartItem(int userId, int itemId) throws ItemNotFoundException;
	
}
