package com.cognizant.truyum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	@Transactional
	@Modifying
	@Query("delete from Cart c where c.user.userId=?1 and c.menuItem.id=?2")
	void deleteFromCart(int userId, int itemId);
	@Query("select i from MenuItem i join Cart c on i.id=c.menuItem.id where c.user.id=?1")
	public List<MenuItem> getItems(int userid);
}
