package com.cognizant.truyum.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.MenuItemException;
import com.cognizant.truyum.model.MenuItem;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	MenuItemDao menuItemDao;
	@Override
	public List<MenuItem> getAllMenuItems() {
		// TODO Auto-generated method stub
		log.info("started");
		log.debug("Menu Items : {}"+menuItemDao.findAll());
			return menuItemDao.findAll();
		
	}
	
	public List<MenuItem> getAllMenuItemsAd() {
		// TODO Auto-generated method stub
		log.info("started");
//		log.debug("Menu Items : {}"+menuItemDao.findAll());
		List<MenuItem> l=menuItemDao.findAll()
				.stream()
				.filter(o->(o.getDateOfLaunch()
						.before(new Date())&&(o.getActive())))
				.collect(Collectors.toList());
			return l;
		
	}

	@Override
	public MenuItem getMenuItemById(int id) throws MenuItemException {
		// TODO Auto-generated method stub
		log.info("started");
		log.debug("Menu Item : {}"+menuItemDao.findById(id).get());
		return menuItemDao.findById(id)
				.orElseThrow(()->new MenuItemException("Menu Item with the id "+id+" doen't exists"));
	
	}

//	@Override
//	public MenuItem modifyMenuItem(MenuItem menuItem) throws MenuItemException {
//		// TODO Auto-generated method stub
	//  int id =1;
//		log.info("started");
//		Optional<MenuItem> searchMenuItem=menuItemDao.findById(id);
//		MenuItem found=null;
//		
//		if(!searchMenuItem.isPresent()) {
//			throw new MenuItemException("Menu Item with the id "+id+" doen't exists");
//		}
//		log.info("MenuItem with id " + id + " is present");
//		found=searchMenuItem.get();
//		menuItemDao.save(menuItem);
//		log.debug("Updated Menu Item : {}", menuItem);
//		return found;
//	}
	@Override
	public MenuItem modifyMenuItem(MenuItem menuItem,int id) throws MenuItemException {
		// TODO Auto-generated method stub
		log.info("started");
		Optional<MenuItem> searchMenuItem=menuItemDao.findById(id);
		MenuItem found=null;
		
		if(!searchMenuItem.isPresent()) {
			throw new MenuItemException("Menu Item with the id "+id+" doen't exists");
		}
		log.info("MenuItem with id " + id + " is present");
		found=searchMenuItem.get();
		menuItemDao.save(menuItem);
		log.debug("Updated Menu Item : {}", menuItem);
		return found;
	}

	@Override
	public MenuItem editMenuItem(MenuItem menuItem) {
		
		return menuItemDao.save(menuItem);
	}

	
}
