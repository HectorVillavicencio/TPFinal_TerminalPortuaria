package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;

public class AlmacenamientoExcedente implements Servicio{
	private double diasExcentes;
	private double precioPorExcedente;
	
	public AlmacenamientoExcedente(double diasExcentes, double precioPorExcedente){
		this.diasExcentes=diasExcentes;
		this.precioPorExcedente=precioPorExcedente;
		
	}
	@Override
	public double costo(Container container) {
		
		return this.diasExcentes*this.precioPorExcedente;
	}
}