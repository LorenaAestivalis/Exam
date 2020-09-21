package com.carrito.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVenta")
	private String id;
	
	@Column(name = "fecha")
    private String fecha;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente") // this is foreign key in comments table
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDetalleVenta") // this is foreign key in comments table
    private DetalleVenta detalleVenta;

    
    
    
    
    
	// ... getters and setters
  
   public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String description) {
		this.fecha = description;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DetalleVenta getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(DetalleVenta detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venta )) return false;
        return id != null && id.equals(((Venta) o).getId());
    }
 
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}




















