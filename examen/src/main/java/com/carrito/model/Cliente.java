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
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCliente")
	private String id;
	
	@Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private String dni;

    @Column(name = "telefono")
    private String telefono;
     

    @Column(name = "email")
    private String email;
	
	@OneToMany(mappedBy = "cliente",
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
	private List<Venta> ventaList;
	
	
	
	
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public List<Venta> getVentaList() {
		return ventaList;
	}

	public void setVentaList(List<Venta> ventaList) {
		this.ventaList = ventaList;
	}

	public void addVenta(Venta venta) {
        ventaList.add(venta);
        venta.getCliente();
    }
 
    public void removeVenta(Venta venta) {
        ventaList.remove(venta);
       
}

}


























