package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.exception.MenuItemException;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemService {

	List<MenuItem> getAllMenuItems();
	List<MenuItem> getAllMenuItemsAd();
	MenuItem getMenuItemById(int id) throws MenuItemException;
//	MenuItem modifyMenuItem(MenuItem menuItem)throws MenuItemException;
	MenuItem modifyMenuItem(MenuItem menuItem,int id)throws MenuItemException;
	MenuItem editMenuItem(MenuItem menuItem);
	
	
}
