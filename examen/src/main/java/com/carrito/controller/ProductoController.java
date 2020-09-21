package com.carrito.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.dao.ProductoDao;
import com.carrito.model.Producto;




@RestController
@RequestMapping("producto")
public class ProductoController {

	@Autowired
	private ProductoDao productoDao ;
	
	public List<Producto> getAllPorveedor(){
		return this.productoDao.findAll();
	}
	

	@GetMapping(value="/consultar")
	public ResponseEntity<List<Producto>> getProducto(){
		List<Producto> proveedores =productoDao.findAll();
		return ResponseEntity.ok(proveedores);
	}
	
	
	@RequestMapping(value="{proveedorId}")
	public ResponseEntity<Producto> getProductoById(@PathVariable("proveedorId") String proveedorId){
		Optional<Producto> optionalProducto = productoDao.findById(proveedorId);// optional nos proteje de un valor null
		if(optionalProducto.isPresent()) {
		return ResponseEntity.ok(optionalProducto.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Producto> createProducto(@RequestBody Producto proveedor){
		Producto newProducto = productoDao.save(proveedor);
		return ResponseEntity.ok(newProducto);
	}

	@DeleteMapping(value="{proveedorId}")
	public ResponseEntity<Void> deleteProducto(@PathVariable("proveedorId") String proveedorId){
		productoDao.deleteById(proveedorId);;
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto proveedor){
		Optional<Producto> optionalProducto= productoDao.findById(proveedor.getId());// optional nos proteje de un valor null
		if(optionalProducto.isPresent()) {
			Producto updateProducto = optionalProducto.get();
			updateProducto.setNombre(proveedor.getNombre());
			productoDao.save(updateProducto);
			return ResponseEntity.ok(updateProducto);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
