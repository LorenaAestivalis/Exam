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

import com.carrito.dao.ClienteDao;
import com.carrito.model.Cliente;



@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteDao clienteDao;
	
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getCliente(){
		List<Cliente> clientes =clienteDao.findAll();
		return ResponseEntity.ok(clientes);
	}
	



    @PostMapping (value = "/registrar")
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente){// optional nos proteje de un valor null
    	
		try {
			Cliente newProduct = clienteDao.save(cliente);
    	return ResponseEntity.ok(newProduct);
		}catch(Exception e) {System.out.print("error al registrar");

        return ResponseEntity.notFound().build();
		}

    }
    
    @PutMapping (value = "/actualizar")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente){
        Optional<Cliente> optionalCliente= clienteDao.findById(cliente.getId());// optional nos proteje de un valor null
        if(optionalCliente.isPresent()) {
            Cliente updatecliente = optionalCliente.get();
            updatecliente.setNombre(cliente.getNombre());
            clienteDao.save(updatecliente);
            return ResponseEntity.ok(updatecliente);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<Integer> eliminar(@PathVariable("id") String id){
        int resultado  = 0;
        try{
            //service.eliminar(id);
            clienteDao.deleteById(id);
            resultado = 1;
        }catch (Exception e){resultado=0;}
        return new ResponseEntity<Integer>(resultado,HttpStatus.OK);
    }
	
}
