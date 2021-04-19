package com.cognizant.truyum.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menu_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
	@Id
	@Column(name="me_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="me_name")
	private String name;
	@Column(name="me_price", columnDefinition = "decimal", precision = 8, scale = 2)
	private double price;
	@Column(name="me_active")
	private Boolean active;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Column(name="me_date_of_launch")
	private Date dateOfLaunch;
	@Column(name="me_category")
	private String category;
	@Column(name="me_free_delivery")
	private String freeDelivery;
	@JsonIgnore
	@OneToMany(mappedBy = "menuItem", fetch = FetchType.EAGER)
	private List<Cart> carts;
	
	

	

//	@Override
//	public String toString() {
//		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
//				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + ", carts=" + carts + "]";
//	}
//	public boolean equals(MenuItem obj) {
//		if (this.getId() == obj.getId())
//			return true;
//		return false;
//
//	}

}
