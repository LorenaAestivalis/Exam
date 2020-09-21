package com.carrito.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDetalleVenta")
	private String id;
	
	
	
	@OneToMany(mappedBy = "detalleVenta",
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
	private List<Venta> ventaList;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto") // this is foreign key in comments table
    private Producto producto;
	
	
	
/////////////////PRODUCTO////////////////	
	 public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleVenta )) return false;
        return id != null && id.equals(((DetalleVenta) o).getId());
    }
 
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

/////////////////VENTA////////////////
	public List<Venta> getCommentsList() {
		return ventaList;
	}

	public void setCommentsList(List<Venta> ventaList) {
		this.ventaList = ventaList;
	}

	public void addVenta(Venta venta) {
        ventaList.add(venta);
        venta.getDetalleVenta();
    }
 
    public void removeVenta(Venta venta) {
        ventaList.remove(venta);
        venta.setDetalleVenta(null);
    }
}




























