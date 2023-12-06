package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;

public class AlmacenamientoExcedente implements Servicio{
	private double diasExcentes;
	private int precioPorExcedente;
	
	public AlmacenamientoExcedente(int diasExcentes, int precioPorExcedente){
		this.diasExcentes=diasExcentes;
		this.precioPorExcedente=precioPorExcedente;
		
	}
	@Override
	public double costo(int horas) {
		
		return this.diasExcentes*this.precioPorExcedente;
	}
}