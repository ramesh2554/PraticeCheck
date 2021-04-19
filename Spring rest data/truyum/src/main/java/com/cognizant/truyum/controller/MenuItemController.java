package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.MenuItemException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author konak
 *
 */

@RestController
@Slf4j
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	MenuItemService service;

	/**
	 * @param menuItem
	 * @return {
    "name": "ramesh",
    "price": 100.0,
    "active": false ,
    "dateOfLaunch": "12/12/2020",
    "category": "veg",
    "freeDelivery": "Yes"
    }
	 */
	// insert into menu_item
	// (me_active,me_category,me_date_of_launch,me_free_delivery, me_name,me_price)
	// values(true,"Non-Veg","2020-12-13","No","Burger",20.0);
//localhost:9090/menu-items/add-menu-item-admin
	@PostMapping("/add-menu-item-admin")
	public MenuItem editMenuItem(@RequestBody MenuItem menuItem) {
		log.info("Start");
		service.editMenuItem(menuItem);
		log.info("End");
		return menuItem;
	}

	/*
	 * localhost:9090/menu-items/admin
	 */
	@GetMapping("/admin")
	public List<MenuItem> getAllMenuItems() {
		log.info("Start");
		log.debug("Menu Items : {}" + service.getAllMenuItems());
		return service.getAllMenuItems();
	}
	/*
	 * localhost:9090/menu-items/customer
	 */
	@GetMapping("/customer")
	public List<MenuItem> getAllMenuItemscust() {
		log.info("Start");
		//log.debug("Menu Items : {}" + service.getAllMenuItemsAd);
		return service.getAllMenuItemsAd();
	}

	/*
	 * localhost:9090/menu-items/1
	 */
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id) throws MenuItemException {
		log.info("Start");
		log.debug("Menu Item : {}" + service.getMenuItemById(id));
		return service.getMenuItemById(id);
	}

/*
 * {
    "id": 1,
    "name": "RAMESWARA",
    "price": 110.0,
    "active": false,
    "dateOfLaunch": "05/11/2016",
    "category": "Dry",
    "freeDelivery": "NOOO"
}
 */
	// localhost:9090/menu-items/modify/1
	@PutMapping("/modify/{id}")
	public MenuItem modifyMenuItem(@RequestBody MenuItem menuItem, @PathVariable int id) throws MenuItemException {
		log.info("Start");
		log.debug("Updated Menu Item : {}", menuItem);
		return service.modifyMenuItem(menuItem, id);
	}

}
