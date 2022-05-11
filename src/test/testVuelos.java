package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import src.Pasajero;
import src.Vuelo;

public class testVuelos {
 
	@Test
	public void queSePuedaComrarUnPasaje() {
		String nombre = "PIEDRABUENA WALTER";
		Integer dni = 38266294;
		Double saldo= 12554.0;
		Integer numeroVuelo = 2;
		Double precioVuelo= 200.0;
		Integer cantidadMaximaPasajeros= 100;
		
		Pasajero pasajero = new Pasajero (nombre,dni,saldo);
		Vuelo vuelo = new Vuelo (numeroVuelo,precioVuelo,cantidadMaximaPasajeros);
		
		assertTrue(vuelo.comprarPasaje(pasajero));	
	}
	@Test
	public void queNoSePuedaComprar2PasajesAlMismoPasajero() {
		String nombre = "PIEDRABUENA WALTER";
		Integer dni = 38266294;
		Double saldo= 12554.0;
		Integer numeroVuelo = 2;
		Double precioVuelo= 200.0;
		Integer cantidadMaximaPasajeros= 100;
		int cantidadPasajesVendidosEsperados =1;
		Pasajero pasajero = new Pasajero (nombre,dni,saldo);
		Vuelo vuelo = new Vuelo (numeroVuelo,precioVuelo,cantidadMaximaPasajeros);
		
		vuelo.comprarPasaje(pasajero);
		vuelo.comprarPasaje(pasajero);
		assertEquals(cantidadPasajesVendidosEsperados ,vuelo.getPasajerosConPasaje().size());
	}
	@Test 
	public void queHayaDescuentoDelCincoPorcientoParaPasajerosVIP() {
		String nombre = "PIEDRABUENA WALTER";
		Integer dni = 38266294;
		Double saldo= 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo= 200.0;
		Integer cantidadMaximaPasajeros= 100;
		Double saldoRestanteClienteVip=10.0;
		
		Pasajero pasajero = new Pasajero (nombre,dni,saldo);
		pasajero.setEsVip(true);
		
		Vuelo vuelo = new Vuelo (numeroVuelo,precioVuelo,cantidadMaximaPasajeros);
		vuelo.comprarPasaje(pasajero);
		
		assertEquals(saldoRestanteClienteVip,pasajero.getSaldo());
	}
	@Test
	public void queSePuedaAsignarUnAsientoAUnPasajeroDeUnVuelo() {
		String nombre = "PIEDRABUENA WALTER";
		Integer dni = 38266294;
		Double saldo= 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo= 200.0;
		Integer cantidadMaximaPasajeros= 100;
		Integer numeroAsiento = 2;
		Pasajero pasajero = new Pasajero (nombre,dni,saldo);
		Vuelo vuelo = new Vuelo (numeroVuelo,precioVuelo,cantidadMaximaPasajeros);
		vuelo.comprarPasaje(pasajero);
		
		vuelo.asignarAciento(pasajero);
	}
	@Test
	public void queNoSePuedaAsignarElMismoAciento() {
		String nombre = "PIEDRABUENA WALTER";
		Integer dni = 38266294;
		Double saldo= 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo= 200.0;
		Integer cantidadMaximaPasajeros= 100;
		Integer numeroAsiento = 2;
		Pasajero pasajero = new Pasajero (nombre,dni,saldo);
		Vuelo vuelo = new Vuelo (numeroVuelo,precioVuelo,cantidadMaximaPasajeros);
		vuelo.comprarPasaje(pasajero);
		
		vuelo.asignarAciento(pasajero);
		/*la asignacion es por orden de llegada*/
	}
	@Test
	public void queNoSePuedaAsignarAcientoSiElAvionDespego() {
		String nombre = "PIEDRABUENA WALTER";
		Integer dni = 38266294;
		Double saldo= 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo= 200.0;
		Integer cantidadMaximaPasajeros= 100;
		Integer numeroAsiento = 2;
		Pasajero pasajero = new Pasajero (nombre,dni,saldo);
		Vuelo vuelo = new Vuelo (numeroVuelo,precioVuelo,cantidadMaximaPasajeros);
		vuelo.comprarPasaje(pasajero);
		vuelo.setDespego(true);
		vuelo.asignarAciento(pasajero);
		
		int cantidadDePasajerosPretendidoEnElVuelo = 0;
		
		assertEquals(cantidadDePasajerosPretendidoEnElVuelo, vuelo.getAcientosAsignados().size());
	}
	@Test
	public void queSePuedaMostrarLosQueNoPudieronSubirAlAvion() {
		String nombre = "PIEDRABUENA WALTER";
		Integer dni = 38266294;
		Double saldo= 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo= 200.0;
		Integer cantidadMaximaPasajeros= 100;
		Integer numeroAsiento = 2;
		Pasajero pasajero = new Pasajero (nombre,dni,saldo);
		Vuelo vuelo = new Vuelo (numeroVuelo,precioVuelo,cantidadMaximaPasajeros);
		vuelo.comprarPasaje(pasajero);
		vuelo.setDespego(true);
		pasajero.setEsVip(true);
		vuelo.asignarAciento(pasajero);
		
	 System.out.println(vuelo.getPasajerosConPasaje());
		
	}
	

}
