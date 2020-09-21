package com.carrito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, String>{
	 
	
	
	}
