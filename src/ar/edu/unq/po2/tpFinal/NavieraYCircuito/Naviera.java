package ar.edu.unq.po2.tpFinal.NavieraYCircuito;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;

public class Naviera {
	private ArrayList<Circuito> circuitos;
	private ArrayList<Buque> buques;
	private ArrayList<Viaje> viajes;
	
	public Naviera() {
		this.circuitos = new ArrayList<>();
		this.buques = new ArrayList<>();
		this.viajes = new ArrayList<>();
	}
	
	public ArrayList<Circuito> getCircuitos() {
		return circuitos;
	}

	public ArrayList<Buque> getBuques() {
		return buques;
	}

	public void nuevoViaje(Buque buque, Circuito circuito, LocalDateTime fechaSalida) {
		Viaje viaje = new Viaje(circuito, buque, fechaSalida);
		this.viajes.add(viaje);
	}
	
	public void agregarCircuito(Circuito circuito) {
		this.circuitos.add(circuito);
	}
	
	public void agregarBuque(Buque buque) {
		this.buques.add(buque);
	} 
	
	public ArrayList<Viaje> getViajes(){
		return this.viajes;
	}
	
	public void enviarViajeATerminales(Viaje viaje){
		Circuito rotateCircuito = viaje.getCircuito();
		int sumaTiempo = 0;
		for(Tramo tramo: viaje.getCircuito().getTramos()) {
			Viaje viaje1 = new Viaje(rotateCircuito, viaje.getBuque(), viaje.getFechaSalida().plusHours(sumaTiempo));
			tramo.getTerminalInicial().agregarViaje(viaje1);
			sumaTiempo += tramo.getTiempo();
			Collections.rotate(rotateCircuito.getTramos(), -1);
		} 
	} 
}