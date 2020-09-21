package com.carrito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.carrito.model.Cliente;


@Repository
public interface ClienteDao extends JpaRepository<Cliente, String>{
	 
	
	
	}
