package com.carrito.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idProducto")
	private String id;
	
	@Column(name = "nombre")
    private String nombre;


    @Column(name = "precio")
    private Integer precio;
	
	@OneToMany(mappedBy = "producto",
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
	private List<DetalleVenta> detalleVentaList;
	
	
	
	
	
	 public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

////////////////////////////////////VENTA

    

	public List<DetalleVenta> getDetalleVenta() {
		return detalleVentaList;
	}

	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		this.detalleVentaList = detalleVenta;
	}
////////////////////////////////////////////////////////////////////////
///////////////////////////////////DETALLE VENTA/////////////////////////////////////

	public void addVenta(DetalleVenta detalleVenta) {
		detalleVentaList.add(detalleVenta);
        detalleVenta.getProducto();
    }
 

	public void removeVenta(DetalleVenta detalleVenta) {
		detalleVentaList.remove(detalleVenta);
        detalleVenta.setProducto(null);
    }
////////////////////////////////////////////////////////////////////////
}
