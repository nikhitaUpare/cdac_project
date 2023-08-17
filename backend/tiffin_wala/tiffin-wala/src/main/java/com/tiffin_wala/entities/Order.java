package com.tiffin_wala.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.tiffin_wala.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{

	private int quantity;
	
	@CreationTimestamp
	private LocalDateTime dateTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="address_id")
	private List<Tiffin> tiffins;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
		
}
