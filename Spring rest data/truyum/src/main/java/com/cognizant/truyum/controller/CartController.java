package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.ItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/carts")
@Slf4j
public class CartController{
	
	@Autowired
	private CartService cartService;
	
	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @return adds the menu item to the user cart and returns success/failure message 
	 * @throws ItemNotFoundException 
	 */
	//localhost:9090/carts/1/1
	@PostMapping("/{userId}/{menuItemId}")
	public String addCartItem(@PathVariable int userId, @PathVariable int menuItemId) throws ItemNotFoundException {
		log.info("started");
		String s=cartService.addCartItem(userId, menuItemId);
		log.info("ended");
		return s;
	}
	
	/**
	 * 
	 * @param userId
	 * @return All menu Items based on user id 
	 */
	//localhost:9090/carts/1
	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable int userId)  {
		
		log.info("started");
		List<MenuItem> l=cartService.getAllCartItems(userId);
		log.info("ended");
		return l;
	}
	
	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @return success / failure message after deleting the item from the cart
	 * @throws ItemNotFoundException
	 */
	/// localhost:9090/carts/1/1
	@DeleteMapping("{userId}/{menuItemId}")
	public String deleteCartItem(@PathVariable int userId, @PathVariable int menuItemId) throws ItemNotFoundException {
		log.info("started");
		String s=cartService.removeCartItem(userId, menuItemId);
		log.info("ended");
		return s;
	}
}