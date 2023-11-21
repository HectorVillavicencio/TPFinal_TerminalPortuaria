package ar.edu.unq.po2.tpFinal.NavieraYCircuito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import ar.edu.unq.po2.tpFinal.BuqueYContainer.Buque;

public class Viaje {
	private Circuito circuito;
	private Buque buque;
	private LocalDateTime fechaSalida;
	
	public Viaje(Circuito circuito,Buque buque, LocalDateTime fechaSalida){
		this.circuito = circuito;
		this.buque = buque;
		this.fechaSalida =fechaSalida;
	}

	public Circuito getCircuito() {
		return circuito;
	}

	public Buque getBuque() {
		return buque;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public LocalDateTime fechaLlegada(){
        int tiempoTotal = circuito.tiempoTotal();
        return fechaSalida.plusHours(tiempoTotal); 
	}

}
