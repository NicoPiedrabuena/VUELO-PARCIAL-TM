package src;

import java.util.Objects;

public class Pasajero {

	private String nombre;
	private Integer dni;
	private Double saldo;
	private Boolean esVip;

	public Pasajero(String nombre, Integer dni, Double saldo) {
		this.nombre = nombre;
		this.dni = dni;
		this.saldo = saldo;
		this.esVip = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Objects.equals(dni, other.dni);
	}

	public Boolean getEsVip() {
		return esVip;
	}

	public void setEsVip(Boolean esVip) {
		this.esVip = esVip;
	}

	@Override
	public String toString() {
		String result ="";
		if(getEsVip() == true) {
			result+= "nombre= " + nombre + ", dni= " + dni + " CLIENTE VIP" + "\n";
		}else {
			result += "nombre= " + nombre + ", dni= " + dni  + "\n";
		}
		
		return result;
	}
	
	
}
