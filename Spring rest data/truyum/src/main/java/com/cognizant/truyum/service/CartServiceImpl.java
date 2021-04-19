package com.cognizant.truyum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.UserDao;
import com.cognizant.truyum.exception.ItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cd;
	@Autowired
	private MenuItemDao md;
	@Autowired
	private UserDao ud;
	/**
	 * 
	 * @param id
	 * @param itemId
	 * @return adds the menu item to the user cart and returns success/failure message 
	 * @throws ItemNotFoundException
	 */
	@Override
	public String addCartItem(int id, int itemId) throws ItemNotFoundException {
		log.info("Started add to cart service");
		Optional<MenuItem> m=md.findById(itemId);
		if(m.isPresent()) {
			User u=ud.findById(id).get();
			Cart cart=new Cart(u,m.get());
			cd.save(cart);
			log.info("ended");
			return "Item added Successfully";
		}
		log.info("ended");
		throw new ItemNotFoundException("Item Not Found");
	}
	/**
	 * 
	 * @param userId
	 * @return All menu Items based on user id
	 */
	@Override
	public List<MenuItem> getAllCartItems(int userId) {
		log.info("Started get cart items service");
		List<MenuItem> l=cd.getItems(userId);
		log.info("Ended");
		return l;
	}
	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @return success / failure message after deleting the item from the cart
	 * @throws ItemNotFoundException
	 */
	@Override
	public String removeCartItem(int userId, int itemId) throws ItemNotFoundException {
		log.info("Started delete cart item service");
		Optional<MenuItem> m=md.findById(itemId);
		if(m.isPresent()) {
			cd.deleteFromCart(userId, itemId);
			log.info("Ended");
			return "Item Successfully deleted";
		}
		log.info("Ended");
		throw new ItemNotFoundException("Item Not Found");
	}
}
