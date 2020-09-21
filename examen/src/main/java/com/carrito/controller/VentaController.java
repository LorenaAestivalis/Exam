package com.carrito.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.dao.VentaDao;
import com.carrito.model.Cliente;
import com.carrito.model.Venta;



@RestController
@RequestMapping("venta")
public class VentaController {

	@Autowired
	VentaDao ventaDao;
	
	
	
	@GetMapping(value = "/consulta")
	public ResponseEntity<List<Venta>> getCliente(){
		List<Venta> clientes =ventaDao.findAll();
		return ResponseEntity.ok(clientes);
	}
	

    
    
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<Integer> eliminar(@PathVariable("id") String id){
        int resultado  = 0;
        try{
            //service.eliminar(id);
        	ventaDao.deleteById(id);
            resultado = 1;
        }catch (Exception e){resultado=0;}
        return new ResponseEntity<Integer>(resultado,HttpStatus.OK);
    }
	
	
}
	

