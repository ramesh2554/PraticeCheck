package com.cognizant.truyum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;
@Repository
public interface MenuItemDao extends JpaRepository<MenuItem, Integer> {

}
